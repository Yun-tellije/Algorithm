import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    static Set<String> resultSet;
    static char[][] arr;
    static TrieNode trie;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());

        trie = new TrieNode();

        for (int i = 0; i < w; i++) {
            trie.insert(br.readLine());
        }

        br.readLine();

        int b = Integer.parseInt(br.readLine());
        for (int B = 0; B < b; B++) {
            arr = new char[4][4];
            visit = new boolean[4][4];
            resultSet = new HashSet<>();

            for (int i = 0; i < 4; i++) {
                String s = br.readLine();
                for (int j = 0; j < 4; j++) {
                    arr[i][j] = s.charAt(j);
                }
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (trie.isInitWord(arr[i][j])) {
                        visit[i][j] = true;
                        search(i, j, "" + arr[i][j]);
                        visit[i][j] = false;
                    }
                }
            }

            List<String> resultList = new ArrayList<>(resultSet);
            Collections.sort(resultList);

            int max = 0;
            int index = 0;
            int score = 0;

            for (int i = 0; i < resultList.size(); i++) {
                int len = resultList.get(i).length();

                score += getScore(len);

                if (max < len) {
                    max = len;
                    index = i;
                }
            }

            if (B != b - 1)
                br.readLine();

            sb.append(score).append(" ").append(resultList.get(index)).append(" ").append(resultList.size()).append("\n");
        }

        System.out.println(sb);
    }

    static class TrieNode {
        Map<Character, TrieNode> childNode =  new HashMap<>();
        boolean isEnd;

        public void insert(String str) {
            TrieNode curNode = this;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                curNode.childNode.putIfAbsent(c, new TrieNode());
                curNode = curNode.childNode.get(c);

                if (i == str.length() - 1) {
                    curNode.isEnd = true;
                }
            }
        }

        public boolean isInitWord(char init) {
            TrieNode trieNode = this;

            for (char c : trieNode.childNode.keySet()) {
                if (init == c) return true;
            }
            return false;
        }

        public boolean contains(String word, boolean flag) {
            if (word.length() > 8) return false;

            TrieNode trieNode = this;

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                TrieNode node = trieNode.childNode.get(c);
                if (node == null) return false;

                trieNode = node;
            }

            if (flag) return trieNode.isEnd;

            return true;
        }
    }


    static void search(int x, int y, String str) {
        if (trie.contains(str, true)) {
            resultSet.add(str);
        }

        for (int d = 0; d < 8; d++) {
            int cx = x + dx[d];
            int cy = y + dy[d];

            if (!isIn(cx, cy) || visit[cx][cy]) continue;

            String next = str + arr[cx][cy];
            if (trie.contains(next, false)) {
                visit[cx][cy] = true;
                search(cx, cy, next);
                visit[cx][cy] = false;
            }
        }
    }

    static boolean isIn(int x, int y) {
        return x >= 0 && x < 4 && y >= 0 && y < 4;
    }

    static int getScore(int len) {
        if (len < 3) return 0;
        else if (len < 5) return 1;
        else if (len < 6) return 2;
        else if (len < 7) return 3;
        else if (len < 8) return 5;
        else return 11;
    }
}