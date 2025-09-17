class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int currentNum = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                currentNum = currentNum * 10 + (c - '0'); // build full number
            } else if (c == '[') {
                countStack.push(currentNum);
                stringStack.push(currentString);
                currentNum = 0;
                currentString = new StringBuilder();
            } else if (c == ']') {
                int repeatTimes = countStack.pop();
                StringBuilder decoded = stringStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    decoded.append(currentString);
                }
                currentString = decoded;
            } else {
                currentString.append(c);
            }
        }

        return currentString.toString();
    }
}
