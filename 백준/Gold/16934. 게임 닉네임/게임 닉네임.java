import java.util.*;
import java.io.*;

public class Main {

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        TrieNode trieNode = new TrieNode();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            trieNode.insert(br.readLine());
        }

        System.out.println(sb);
    }

    static class TrieNode {
        Map<Character, TrieNode> child = new HashMap<>();
        int endCount = 0;

        void insert(String s) {
            TrieNode trie = this;
            StringBuilder builder = new StringBuilder();
            boolean isEnd = false;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (!isEnd) {
                    if (trie.child.containsKey(c)) {
                        builder.append(c);
                    } else {
                        builder.append(c);
                        isEnd = true;
                    }
                }

                trie.child.putIfAbsent(c, new TrieNode());
                trie = trie.child.get(c);

                if (i == s.length() - 1) {
                    trie.endCount++;
                }
            }

            if (isEnd) {
                sb.append(builder).append("\n");
            } else {
                sb.append(s).append(trie.endCount == 1 ? "" : trie.endCount).append("\n");
            }
        }


    }

}