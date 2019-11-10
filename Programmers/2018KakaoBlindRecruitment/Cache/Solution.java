import java.util.*;

class Solution {
    static ArrayList<String> cache;
    static int size;
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        size = cacheSize;
        cache = new ArrayList<String>();


        for (String item: cities) {
            String city = item.toUpperCase();
          if (cache.contains(city)) {
              answer += cacheHit(city);
          } else {
              answer += cacheMiss(city);
          }
        }
        return answer;
    }

    public int cacheHit(String city) {
        int index = cache.indexOf(city);
        cache.remove(index);
        cache.add(city);

        return 1;
    }

    public int cacheMiss(String city) {
        if (cache.size() < size) {
            cache.add(city);
        } else if (cache.size() == size) {
            if (size == 0) {
                return 5;
            }
            cache.remove(0);
            cache.add(city);
        }

        return 5;
    }
}
