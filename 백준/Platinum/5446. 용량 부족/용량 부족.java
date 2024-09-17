import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        
        while(t-- > 0) {
            solve();
        }
        
        bw.flush();
        bw.close();
        br.close();
    }

    static void solve() throws IOException {
        int n1 = Integer.parseInt(br.readLine());
        Trie trie = new Trie();
        Set<String> wilds = new HashSet<>();
        
        for(int i = 0; i < n1; i++) {
            trie.addWord(br.readLine());
        }
        
        int n2 = Integer.parseInt(br.readLine());
        for(int i = 0; i < n2; i++) {
            trie.setExcept(br.readLine());
        }
        
        for(int i = 0; i < n1; i++) {
            wilds.add(trie.checkWild(trie.words.get(i)));
        }
        
        if(!trie.root.isExcept) {
            bw.write("1\n");
        } else {
            bw.write(wilds.size() + "\n");
        }
    }
}

class Trie {
    TrieNode root;
    List<String> words;
    
    Trie() {
        root = new TrieNode();
        words = new ArrayList<>();
    }
    
    void addWord(String word) {
        words.add(word);
        TrieNode node = root;
        for(char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
    }
    
    void setExcept(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()) {
            TrieNode child = node.children.get(c);
            if(child == null) break;
            node.isExcept = true;
            child.isExcept = true;
            node = child;
        }
    }
    
    String checkWild(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            node = node.children.get(word.charAt(i));
            if(!node.isExcept) {
                return word.substring(0, i+1) + "*";
            }
        }
        return word;
    }
}

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isExcept;
    
    TrieNode() {
        children = new HashMap<>();
        isExcept = false;
    }
}