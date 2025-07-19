class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();

        if(!expression.contains("+") && !expression.contains("-") && !expression.contains("*")){
            result.add(Integer.parseInt(expression));
            return result;
        }

        for(int i=0; i<expression.length(); i++){
            char c = expression.charAt(i);
            if(c == '+' || c == '-' || c == '*' ){
                List<Integer> Left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> Right = diffWaysToCompute(expression.substring(i+1, expression.length()));

                for(int left : Left){
                    for(int right : Right){
                        if(c == '-') result.add(left-right);
                        else if(c == '+') result.add(left+right);
                        else if(c == '*') result.add(left*right);
                    }
                }
            }
        }

        return result;

    }
}