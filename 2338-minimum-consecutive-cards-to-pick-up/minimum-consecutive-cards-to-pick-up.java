class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = cards.length;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            if(map.containsKey(cards[i])){
                int prev = map.get(cards[i]);
                min = Math.min(min, i-prev+1);
            }
            map.put(cards[i], i);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}