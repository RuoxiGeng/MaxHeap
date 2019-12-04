import java.util.*;
import java.util.PriorityQueue;

class Solution2 {

    public List<Integer> topKFrequent(int[] nums, int k){

        TreeMap<Integer, Integer> map = new TreeMap<>();
        //频次映射
        for(int num : nums){
            if(map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }

        //代替匿名类 拉姆达表达式
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> map.get(a) - map.get(b)
        );
        for(int key: map.keySet()){
            if(pq.size() < k)
                pq.add(key);
            else if(map.get(key) > map.get(pq.peek())){
                pq.remove();
                pq.add(key);
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while(!pq.isEmpty())
            res.add(pq.remove());
        return res;
    }
}
