package student_system.entity.helper;


public enum ContentType {
    PDF("pdf"),
    ZIP("zip"),
    RAR("rar");

    private String name;

    ContentType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
