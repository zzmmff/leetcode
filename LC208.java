/**
 * 定义前缀树
 */
public class LC208 {
    
}


class Trie {

    public boolean isEnd;//是否结尾

    public Trie[] trieList; //前缀数组

    public Trie() {
        trieList = new Trie[26];// 英文字母数量
        isEnd = false;
    }
    
    public void insert(String word) {
        Trie node = this;
        char[] charArray = word.toCharArray();
        for (char c : charArray) {
            int index = c - 'a';
            if (node.trieList[index] == null) {
               node.trieList[index] = new Trie();
            }
            node = node.trieList[index];
        }
        node.isEnd = true; //最后一个字母
    }
    
    public boolean search(String word) {
        Trie searchPrefix = searchPrefix(word);
        return searchPrefix != null && searchPrefix.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Trie searchPrefix(String prefix) {
        Trie node = this;
        char[] charArray = prefix.toCharArray();
        for (char c : charArray) {
            int index = c - 'a';
            if (node.trieList[index] == null)
                return null;
            node = node.trieList[index];
        }
        return node;
    }
}