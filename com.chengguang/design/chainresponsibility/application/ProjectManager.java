package design.chainresponsibility.application;

public class ProjectManager extends Handler {

    @Override
    String handleFeeRequest(String user, double fee) {
        String str = "";
        if (fee < 500) {
            if ("张三".equals(user)) {
                str = "成功：项目经理同意" + user + "的聚餐费用,全额为" + fee + "元";
            } else {
                str = "失败：项目经理不同意" + user + "的聚餐费用，金额为" + fee + "元";
            }
        } else {
            if (getSuccessor() != null) {
                return getSuccessor().handleFeeRequest(user, fee);
            }
        }
        return str;
    }
}
