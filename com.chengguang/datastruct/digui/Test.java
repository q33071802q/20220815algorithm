package datastruct.digui;

import java.util.HashMap;
import java.util.Map;

/**
 * 试图弄清楚整个递归过程
 * 是一个思维误区
 *
 * 遇到递归 抽象成一个递推公式 不用想一层层的调用关系 不要试图用人脑分解递归的每个步骤
 *
 * 递归都可以改成迭代循环
 * 不过没有意义 复杂度还是没有改变
 *
 * 递归调试
 *
 * 打日志 结合条件断点调试
 *
 * 稳定排序
 */
public class Test {

    /**
     * 递归找到最终推荐人
     * 不能工作 递归深 堆栈溢出问题 限制递归深度解决
     * 脏数据 无限递归   自动检测A-B-C-A这种环的存在
     * @param actorId
     * @return
     */
    public long findRootReferrerId(long actorId){
        Long referrerId = selectSqlById(actorId);
        if (referrerId==null) return actorId;
        return findRootReferrerId(actorId);
    }

    private Long selectSqlById(long actorId) {
        return null;
    }

    public int fXun(int n) {
        int ret = 1;
        for (int i = 2; i <= n; i++) {
            ret = ret + 1;
        }
        return ret;
    }

    public int fTwoXun(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int ret = 0;
        int pre = 2;
        int prepre = 1;
        for (int i = 3; i <= n; i++) {
            ret = pre + prepre;
            prepre = pre;
            pre = ret;
        }
        return ret;
    }

    /**
     * 走台阶问题
     * 总共n 走一步或者走两步 有多少种走法
     * 第一次走一步 剩下n-1步走法
     * 第一次走两步 剩下n-2步走法
     */
    Map<Integer, Integer> map = new HashMap<>();

    public int fNew(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        if (map.containsKey(n)) {
            System.out.println(map);
            return map.get(n);
        }
        int ret = f(n - 1) + f(n - 2);
        map.put(n, ret);
        return ret;
    }

    /**
     * 走台阶问题
     * 总共n 走一步或者走两步 有多少种走法
     * 第一次走一步 剩下n-1步走法
     * 第一次走两步 剩下n-2步走法
     */
    public int f(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return f(n - 1) + f(n - 2);
    }

    int depth = 0;

    public int d(int n) {
        depth++;
        if (depth > 1000) System.out.println(1 / 0);
        if (n == 1) return 1;
        return d(n - 1) + 1;
    }

    public static void main(String[] args) {
        Test test = new Test();
//        System.out.println(test.fNew(50));

//        System.out.println(test.d(1000));

        System.out.println(test.fTwoXun(5));
    }
}
