package impl;

import interfaces.Storage;
import model.StorNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StorageImpl implements Storage<StorNode> {
    private StorNode parent = new StorNode("parentNode", "start", "parent");
    private Map<String, String> namesToPath = new HashMap<>();

    public StorageImpl() {
        parent.setContent("parentNode");
        parent.setJsonPath("start");
        parent.setName("dad");
        parent.setNextNodes(new HashSet<>());
    }

    @Override
    // Должно быть определено кокнретное поведение
    public void add(StorNode entity) {
        String name = entity.getName();
        String path = parent.getJsonPath() + "." + name;
        namesToPath.put(name, path);
        entity.setJsonPath(path);
        parent.getNextNodes().add(entity);
    }

    @Override
    public StorNode getByName(String name) {
        String path = namesToPath.get(name);
        return getByPath(path);
    }

    @Override
    public StorNode getByPath(String path) {
        String[] split = path.split("\\.");
        // 0 не смотрим так как это будет начало
        // Путь всегда будет начинаться со start
        Set<StorNode> nextNodes = parent.getNextNodes();
        StorNode currentNode = null;
        for (int i = 1; i < split.length; i++) {
            final String s = split[i];
            if (i == 1) {
                currentNode = nextNodes.stream()
                        .filter(e -> e.getName().equals(s))
                        .findFirst()
                        .get();
            } else {
                currentNode = currentNode
                        .getNextNodes()
                        .stream()
                        .filter(e -> e.getName().equals(s))
                        .findFirst()
                        .get();
            }

        }
        return currentNode;
    }

    @Override
    public void addByPath(StorNode entity, String jsonPathIn) {
        StorNode storNodeByPath = getByPath(jsonPathIn);
        String name = entity.getName();
        String path = storNodeByPath.getJsonPath() + "." + name;
        entity.setJsonPath(path);
        namesToPath.put(name, path);
        storNodeByPath.getNextNodes().add(entity);
    }

    @Override
    public StorNode getParent() {
        return parent;
    }


}
