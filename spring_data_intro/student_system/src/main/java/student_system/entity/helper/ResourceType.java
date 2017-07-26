package student_system.entity.helper;

/**
 * Created by tobieski on 7/26/2017.
 */
public enum  ResourceType {
    VIDEO("video"),
    DOCUMENT("document"),
    BOOK("book");

    private String name;

    ResourceType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
