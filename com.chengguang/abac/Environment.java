package abac;

// Environment属性
public class Environment {
    private String timeOfDay;
    private String location;

    public String getTimeOfDay() {
        return timeOfDay;
    }

    public void setTimeOfDay(String timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Environment() {
    }

    public Environment(String timeOfDay, String location) {
        this.timeOfDay = timeOfDay;
        this.location = location;
    }

    // 构造函数、getter 和 setter
}