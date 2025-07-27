class Solution {
    int i=0;
    public String countOfAtoms(String formula) {
    
        HashMap<String, Integer> map = counting(formula);

        TreeMap<String, Integer> sortedMap = new TreeMap<>(map);

        StringBuilder sb = new StringBuilder();

        for(Map.Entry<String, Integer> entry : sortedMap.entrySet()){
            sb.append(entry.getKey());
            if(entry.getValue() > 1){
                sb.append(entry.getValue());
            }
        }

        return sb.toString();

    }

    public HashMap<String, Integer> counting(String formula){
        HashMap<String, Integer> map = new HashMap<>();
        while(i<formula.length()){
            char ch = formula.charAt(i);
            if(ch == '('){
                i++;
                HashMap<String, Integer> innerMap =counting(formula);

                int multiplier = parseNum(formula);
                for(String atom: innerMap.keySet()){
                    int updateCount = innerMap.get(atom)*multiplier;
                    map.put(atom, map.getOrDefault(atom, 0) + updateCount);
                }

            } else if(ch == ')'){
                i++;
                return map;
            } else{
                String atom = parseAtom(formula);
                int count =parseNum(formula);
                
                map.put(atom, map.getOrDefault(atom, 0) + count);
            }
            
        }
        return map;
        
    }

    private int parseNum(String formula){
        int num =0;

        while(i<formula.length() && Character.isDigit(formula.charAt(i))){
            num = num*10 + (formula.charAt(i++)- '0');
        }

        return (num == 0) ? 1 : num;
    }

    private String parseAtom(String formula){
        StringBuilder atom = new StringBuilder();
        atom.append(formula.charAt(i++));
        while(i<formula.length() && Character.isLowerCase(formula.charAt(i))){
            atom.append(formula.charAt(i++));
        }
        return atom.toString();
    }
}