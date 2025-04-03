package abac;

// Resource属性
public class Resource {
    private String resourceId;
    private String sensitivityLevel;

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getSensitivityLevel() {
        return sensitivityLevel;
    }

    public void setSensitivityLevel(String sensitivityLevel) {
        this.sensitivityLevel = sensitivityLevel;
    }

    public Resource() {
    }

    public Resource(String resourceId, String sensitivityLevel) {
        this.resourceId = resourceId;
        this.sensitivityLevel = sensitivityLevel;
    }
// 构造函数、getter 和 setter
}