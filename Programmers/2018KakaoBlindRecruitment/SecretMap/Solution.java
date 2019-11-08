class Solution {
  public String[] solution(int n, int[] arr1, int[] arr2) {
      String[] answer = new String[n];
      int[][] map1 = new int[n][n];
      int[][] map2 = new int[n][n];
      int[][] map3 = new int[n][n];

      for (int i = 0; i < n; i++) {
          int number = arr1[i];
          for (int j = n-1; j >= 0; j--) {
              if (number == 0) {
                  map1[i][j] = 0;
              } else {
                  map1[i][j] = number%2;
                  number = number/2;
              }
          }
      }

      for (int i = 0; i < n; i++) {
          int number = arr2[i];
          for (int j = n-1; j >= 0; j--) {
              if (number == 0) {
                  map2[i][j] = 0;
              } else {
                  map2[i][j] = number%2;
                  number = number/2;
              }
          }
      }

      for (int i = 0; i < n; i++) {
          String st = "";
          for (int j = 0; j < n; j++) {
              if (map1[i][j] == 1 || map2[i][j] == 1) {
                  st = st + "#";
              } else {
                  st = st + " ";
              }
          }
          answer[i] = st;
      }

      return answer;
  }
}
