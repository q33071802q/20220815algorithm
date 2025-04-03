package abac;

// User属性
public class User {
    private String username;
    private String department;
    private String role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User() {
    }

    public User(String username, String department, String role) {
        this.username = username;
        this.department = department;
        this.role = role;
    }
// 构造函数、getter 和 setter
}





