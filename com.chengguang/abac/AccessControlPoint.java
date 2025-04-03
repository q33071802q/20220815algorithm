package abac;

public class AccessControlPoint {
    private PolicyEngine policyEngine;

    public AccessControlPoint(PolicyEngine policyEngine) {
        this.policyEngine = policyEngine;
    }

    public boolean requestAccess(User user, Resource resource, Action action, Environment environment) {
        // 收集属性并调用策略引擎进行决策
        return policyEngine.evaluateAccess(user, resource, action, environment);
    }
}