# Algorithm

> Java

**문자열 입력**

- BufferedReader, StringTokenizer ...

- ```java
  BufferedReader br = new BufferReader(new InputStreamReader(System.in));
  String s = br.readLine();
  StringTokenizer st = new StringTokenizer(s);
  String word = st.nextToken();
  int number = Integer.parseInt(st.nextToken());
  …
  ```

**문자열 출력**

- BufferedWriter, StringBuilder ...

- ```java
  BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  StringBuilder sb = new StringBuilder();
  sb.append(“A”);
  sb.append(“B”);
  bw.write(String.valueOf(sb));
  bw.flush();
  bw.close();
  …
  ```

**문자열 다루기**

- split, substring, CharAt, toCharArray ...

- ```java
  String.substring(start)
  String.substring(start, end)
  …
  ```

**자료구조**

- Stack

- ```java
  import java.util.Stack;
  
  Stack<T> stack = new Stack<T>();
  stack.push(item);
  stack.peek();
  stack.pop();
  stack.size();
  …
  ```

- HashSet

- ```java
  import java.util.Set;
  import java.util.HashSet;
  
  Set<T> set = new HashSet<T>();
  set.add(item);
  boolean isContain = set.contains(item);
  …
  ```

- HashMap

- ```java
  import java.util.HashMap;
  
  HashMap<K, V> map = new HashMap<K, V>();
  map.put(key, value);
  boolean isContain = map.containsKey(key);
  …
  ```

