package abac;

public class Main {
    public static void main(String[] args) {
        User user = new User("alice", "HR", "manager");
        Resource resource = new Resource("report123", "HR");
        Action action = Action.READ;
        Environment environment = new Environment("business_hours", "office");

        PolicyEngine policyEngine = new PolicyEngine();
        AccessControlPoint acp = new AccessControlPoint(policyEngine);

        boolean accessGranted = acp.requestAccess(user, resource, action, environment);
        System.out.println("Access granted: " + accessGranted);
    }
}