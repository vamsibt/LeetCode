class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        LinkedList<Integer> list[]=new LinkedList[numCourses];
        for (int i=0;i<numCourses;i++){
            list[i]=new LinkedList<>();
        }
        int dip[]=new int[numCourses];
        for (int i=0;i<prerequisites.length;i++){
            list[prerequisites[i][1]].add(prerequisites[i][0]);
            dip[prerequisites[i][0]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for (int i=0;i<numCourses;i++){
            if (dip[i]==0) q.add(i);
        }
        int c=0;
        while(!q.isEmpty()){
            int crnt=q.poll();
            c++;
            for (int i:list[crnt]){
                dip[i]--;
                if (dip[i]==0){
                    q.add(i);
                }
            }
        }
        return (numCourses==c);
    }
}
