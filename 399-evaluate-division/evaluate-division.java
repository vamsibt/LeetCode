class Solution {

    class Edge{
        String des;
        double weight;

        Edge(String _des, double _weight){
            des = _des;
            weight = _weight;
        }
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        int n_eq = equations.size();
        HashMap<String, List<Edge>> map = new HashMap<>();

        for(int i=0; i<n_eq; i++){
            String src = equations.get(i).get(0);
            String des = equations.get(i).get(1);
            double k = values[i];

            Edge edg_src = new Edge(des, k);
            Edge edg_des = new Edge(src, 1/k);

            //src-des
            List<Edge> neigh;
            if(!map.containsKey(src)){
                neigh = new ArrayList<>();
            } else{
                neigh = map.get(src);
            }
            neigh.add(edg_src);
            map.put(src, neigh);


            //des-src
            List<Edge> neigh_;
            if(!map.containsKey(des)){
                neigh_ = new ArrayList<>();
            } else{
                neigh_ = map.get(des);
            }
            neigh_.add(edg_des);
            map.put(des, neigh_);
        }


        int n = queries.size();
        double[] result = new double[n];

        for(int i=0; i<n; i++){
            String src = queries.get(i).get(0);
            String des = queries.get(i).get(1);
            if(!map.containsKey(src) || !map.containsKey(des)){
                result[i] = -1.0;
                continue;
            }

            HashSet<String> visited = new HashSet<>();

            result[i] = dfs(src, des, visited, map);


        }

        return result;
    }

    public double dfs(String src, String des, HashSet<String> visited, HashMap<String, List<Edge>> map){
        if (src.equals(des)) return 1.0;
        visited.add(src);

        for(Edge e :  map.get(src)){
            if(e.des.equals(des)){
                return e.weight;
            }
            if(!visited.contains(e.des)){
                double result = dfs(e.des, des, visited, map);
                if(result != -1){
                    return e.weight*result;
                }
            }
        }
        return -1.0;
    }
}