class Solution {
    public int totalNumbers(int[] digits) {
        Set<String> resultSet = new HashSet<>();
        boolean[] used = new boolean[digits.length];
        dfs("", used, digits, resultSet);
        return resultSet.size();
    }

    public void dfs(String number, boolean[] used, int[] digits, Set<String> resultSet) {
        if (number.length() == 3) {
            int num = Integer.parseInt(number);
            if (num%2 == 0 && number.charAt(0) != '0') {
                resultSet.add(number);
            }
            return;
        }

        for (int i = 0; i < digits.length; i++) {
            if (used[i] == true)
                continue;
            if (number.length() == 0 && digits[i] == 0)
                continue;
            used[i] = true;
            dfs(number + digits[i], used, digits, resultSet);
            used[i] = false;
        }
    }
}