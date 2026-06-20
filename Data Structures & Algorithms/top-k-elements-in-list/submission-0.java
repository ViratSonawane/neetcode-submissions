class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer , Integer> map = new HashMap<>();
        int[] result = new int[k];
        int arrptr = 0;
        
        for(int val : nums){
            map.put(val , map.getOrDefault(val , 0) + 1);
        }   

       // Correct Syntax: Notice the square brackets [nums.length + 1] at the end
        ArrayList<Integer>[] bucket = (ArrayList<Integer>[]) new ArrayList[nums.length + 1];

        for(int i = 0; i < bucket.length; i++){
            bucket[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer , Integer> entry : map.entrySet()){
            bucket[entry.getValue()].add(entry.getKey());
        }
        
        for(int i = bucket.length - 1; i >= 0; i--){
            if(bucket[i].isEmpty()){
                continue;
            }

            for(int val : bucket[i]){
                result[arrptr++] = val;
                k--;
                if(k == 0) return result;
            }
        }
        
        return result;
    }
}
