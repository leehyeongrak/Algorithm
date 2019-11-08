class Solution {
  public int solution(String dartResult) {
      int answer = 0;
      String[] stringNumbers = dartResult.split("[SDT][\\#]*[\\*]*");
      String[] operators = dartResult.split("\\d{1,2}[\\#]*[\\*]*");

      int[] numbers = new int[3];
      for (int i = 0; i < 3; i++) {
          String strNum = stringNumbers[i];
          numbers[i] = Integer.parseInt(strNum);
      }

      for (int i = 0; i < 3; i++) {
          String operator = operators[i+1];
          char opr = operator.charAt(0);
          int number = numbers[i];

          if (opr == 'D') {
              numbers[i] = number*number;
          } else if (opr == 'T') {
              numbers[i] = number*number*number;
          }

          if (operator.length() == 2) {
              char opt = operator.charAt(1);

              if (opt == '*') {
                  if (i == 0) {
                      numbers[i] = numbers[i]*2;
                  } else {
                      numbers[i-1] = numbers[i-1]*2;
                      numbers[i] = numbers[i]*2;
                  }
              } else {
                  numbers[i] = -numbers[i];
              }
          }
      }

      for (int number: numbers) {
          answer += number;
      }

      return answer;
  }
}
