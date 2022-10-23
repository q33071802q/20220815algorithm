package design.chainresponsibility.application;

public class GeneralManager extends Handler {
    @Override
    String handleFeeRequest(String user, double fee) {
        String str = "";
        if (fee >= 1000) {
            if ("张三".equals(user)) {
                str = "成功：总经理同意" + user + "的聚餐费用,全额为" + fee + "元";
            } else {
                str = "失败：总经理不同意" + user + "的聚餐费用，金额为" + fee + "元";
            }
        } else {
            if (getSuccessor() != null) {
                return getSuccessor().handleFeeRequest(user, fee);
            }
        }
        return str;
    }
}
