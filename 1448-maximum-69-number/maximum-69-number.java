class Solution {
    // public int maximum69Number (int number) {
    //     String a = String.valueOf(number);
    //     int[] num = new int[a.length()];
    //     for(int i=0; i<a.length(); i++){
    //         num[i] = a.charAt(i) - '0';
    //     }

    //     int max = Integer.MIN_VALUE;
    //     for(int i=0; i<num.length; i++){
    //         if(num[i] == 6){
    //             num[i] = 9;
    //             break;
    //         }
    //     }
    //     int result =0;
    //     for(int i=0; i<num.length; i++){
    //         result = (result*10) + num[i];
    //     }

    //     return result;
    // }
    public int maximum69Number (int number) {
        StringBuilder sb = new StringBuilder(String.valueOf(number));
        for(int i=0; i<sb.length(); i++){
            if(sb.charAt(i) == '6') {
                sb.setCharAt(i, '9');
                break;
            }
        }

        return Integer.parseInt(sb.toString());
    }
}