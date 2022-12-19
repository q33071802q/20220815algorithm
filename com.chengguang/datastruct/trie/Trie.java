package datastruct.trie;

/**
 * 原理挺简单
 * 构造一个多叉树结构 用哈希表26个位置存放对应的树
 * 字符串的字符数组每个元素都根据asc码获取对应的位置
 * 构建好后 时间复杂度为节点的个数 也就是字符串的长度
 * 而与多少个字符串没有关系O（k）
 */
public class Trie {
    /**
     * 存储无意义字符
     */
    private TrieNode root = new TrieNode('/');

    /**
     * 往Trie树中插入一个字符串
     *
     * @param text
     */
    public void insert(char[] text) {
        TrieNode p = root;
        for (int i = 0; i < text.length; ++i) {
            int index = text[i] - 'a';
            if (p.children[index] == null) {
                TrieNode newNode = new TrieNode(text[i]);
                p.children[index] = newNode;
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }

    /**
     * 在trie树中查找一个字符串
     * @param pattern
     * @return
     */
    public boolean find(char[] pattern) {
        TrieNode p = root;
        for (int i = 0; i < pattern.length; ++i) {
            int index = pattern[i]-'a';
            if (p.children[index] == null){
                return false;
            }
            p = p.children[index];
        }
        if (p.isEndingChar){
            return true;
        }else {
            /**
             * 不能完全匹配 只是前缀
             */
            return false;
        }
    }
}

class TrieNode {
    public char data;
    public TrieNode[] children = new TrieNode[26];
    public boolean isEndingChar = false;

    public TrieNode(char data) {
        this.data = data;
    }
}
