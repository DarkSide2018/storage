package interfaces;

public interface Storage<T> {
    void add(T entity);
    T getByName(String name);
    T getByPath(String path);
    void addByPath(T entity, String jsonPath);
    T getParent();

}
