class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        LinkedList<Integer> list[] = new LinkedList[numCourses];

        for(int i=0; i<numCourses; i++){
            list[i] = new LinkedList<>();
        }

        int[] dip = new int[numCourses];

        for(int i=0; i<prerequisites.length; i++){
            list[prerequisites[i][1]].add(prerequisites[i][0]);
            dip[prerequisites[i][0]]++;

        }
        Queue<Integer> que = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(dip[i] == 0) que.add(i);
        }

        int count=0;
        while(!que.isEmpty()){
            int course = que.poll();
            count++;
            for(int c: list[course]){
                dip[c]--;
                if(dip[c] == 0) que.add(c);
            }

        }

        return (numCourses==count);
    }
}