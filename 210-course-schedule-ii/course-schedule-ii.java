class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        LinkedList<Integer> edges[] = new LinkedList[numCourses];
        for(int i =0; i<numCourses; i++){
            edges[i] = new LinkedList<>();
        }
        int[] dip = new int[numCourses];
        for(int i=0; i<prerequisites.length; i++){
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
            dip[prerequisites[i][0]]++;
        }

        Queue<Integer> que = new LinkedList<>();
        int[] result = new int[numCourses];
        int j=0;
        for(int i= 0; i< numCourses; i++){
            if(dip[i] == 0){
                que.add(i);
                result[j] = i;
                j++;
            }
        }
        int c = 0;
        while(!que.isEmpty()){
            int crnt=que.poll();
            c++;
            for (int i:edges[crnt]){
                dip[i]--;
                if (dip[i]==0){
                    que.add(i);
                    result[j] = i;
                    j++;
                }
            }
        }

        if(c== numCourses){
            return result;
        } else{
            int[] a = {};
            return a;
        }
    }
}