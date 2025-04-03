package abac;

public class PolicyEngine {
    public boolean evaluateAccess(User user, Resource resource, Action action, Environment environment) {
        // 示例策略：用户必须在工作时间内访问资源，且用户部门和资源敏感性等级应匹配
        if (action == Action.READ && environment.getTimeOfDay().equals("business_hours")) {
            return user.getDepartment().equals(resource.getSensitivityLevel());
        }
        return false;
    }
}