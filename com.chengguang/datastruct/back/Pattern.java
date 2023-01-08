package datastruct.back;

/**
 * 正则表达式匹配
 *
 * 回溯法 大部分情况下 都用来解决广义的搜索问题
 */
public class Pattern {
    private boolean matched = false;
    private char[] pattern;
    /**
     * 正则表达式长度
     */
    private int plan;

    public Pattern(char[] pattern, int plan) {
        this.pattern = pattern;
        this.plan = plan;
    }

    /**
     * @param text 文本串
     * @param tlen 长度
     * @return
     */
    public boolean match(char[] text, int tlen) {
        matched = false;
        rmatch(0, 0, text, tlen);
        return matched;
    }

    /**
     *
     * @param ti 文本串匹配的位置
     * @param pj 正则表达式匹配的位置
     * @param text 字符串文本
     * @param tlen 文本串的长度
     */
    private void rmatch(int ti, int pj, char[] text, int tlen) {
        if (matched) {
            return;
        }
        if (pj == plan) { //正则匹配结束了
            if (ti == tlen) { //文本匹配也结束了
                matched = true;
            }
            return;
        }
        if (pattern[pj] == '*') { //* 通配符 匹配任意多个字符
            for (int k = 0; k <= tlen - ti; ++k) {
                rmatch(ti + k, pj + 1, text, tlen);
            }
        } else if (pattern[pj] == '?') { //？匹配零个或一个任意字符
            rmatch(ti, pj + 1, text, tlen);
            rmatch(ti + 1, pj + 1, text, tlen);
        } else if (ti < tlen && pattern[pj] == text[ti]) {
            rmatch(ti+1,pj+1,text,tlen);
        }
    }
}
