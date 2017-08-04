package app.serialize;

public interface Serializer {

    <T> String serialize(T t, String fileName);

    <T> String deserialize(Class<T> clazz, String fileName)
}
