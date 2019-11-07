class Solution {
    static int targetNumber;
    static int length;
    static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        targetNumber = target;
        length = numbers.length;
        int sum = 0;
        int count = 0;

        dfs(numbers, count, sum);
        return answer;
    }

    public void dfs(int[] arr, int count, int sum) {
        if (count == length) {
            if (sum == targetNumber) {
                answer ++;
                return;
            }
            else {
                return;
            }
        }
        dfs(arr, count+1, sum+arr[count]);
        dfs(arr, count+1, sum-arr[count]);
        return;
    }
}
