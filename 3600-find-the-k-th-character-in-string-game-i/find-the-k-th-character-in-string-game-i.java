class Solution {
    // public char kthCharacter(int k) {
    //     String word = "a";

    //     while(word.length() <= k){
    //         StringBuilder sb = new StringBuilder();
    //         for(char ch: word.toCharArray()){
    //             sb.append((ch== 'z') ? 'a': (char)(ch+1));
    //         }

    //         word = word+sb.toString();
    //     }

    //     return word.charAt(k-1);
    // }

    public char kthCharacter(int k){
        String word = "a";

        word = recursive(word, k);

        return word.charAt(k-1);

    }

    public String recursive(String word, int k){
        if(word.length() >= k) return word;

        StringBuilder sb = new StringBuilder();
        for(char ch : word.toCharArray()){
            sb.append((ch == 'z') ? 'a' : (char)(ch+1));
        }

        return recursive(word+sb.toString(), k);
    }
}