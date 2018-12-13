package model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


public class StorNode {
    private String name;
    private String jsonPath;
    private String content;
    private Set<StorNode> nextNodes;

    public StorNode(String content) {
       name = UUID.randomUUID().toString().substring(0, 4);
       nextNodes = new HashSet<>();
       this.content = content;
    }

    public StorNode(String name, String jsonPath, String content) {
        nextNodes = new HashSet<>();
        this.name = name;
        this.jsonPath = jsonPath;
        this.content = content;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJsonPath() {
        return jsonPath;
    }

    public void setJsonPath(String jsonPath) {
        this.jsonPath = jsonPath;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Set<StorNode> getNextNodes() {
        return nextNodes;
    }

    public void setNextNodes(Set<StorNode> nextNodes) {
        this.nextNodes = nextNodes;
    }

    @Override
    public String toString() {
        return "StorNode{" +
                "name='" + name + '\'' +
                ", jsonPath='" + jsonPath + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
