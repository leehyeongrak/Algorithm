class Solution {
    static int answer;
    static String targetWord;
    public int solution(String begin, String target, String[] words) {
        answer = 0;
        targetWord = target;
        boolean[] visited = new boolean[words.length];

        dfs(words, begin, 0, visited);

        return answer;
    }

    public void dfs(String[] words, String current, int count, boolean[] visited) {
        if (current.equals(targetWord)) {
            if (answer == 0 || count < answer) {
                answer = count;
            }
        }

        for (int i = 0; i < words.length; i++) {
            char[] currentChars = current.toCharArray();
            if(visited[i] == false) {
                String word = words[i];
                char[] wordChars = word.toCharArray();
                int matched = 0;
                for (int j = 0; j < currentChars.length; j++) {
                    if (currentChars[j] == wordChars[j]) {
                        matched ++;
                    }
                }
                if (matched == (currentChars.length - 1)) {
                    visited[i] = true;
                    dfs(words, word, count+1, visited);
                    visited[i] = false;
                }
            }
        }
    }
}
