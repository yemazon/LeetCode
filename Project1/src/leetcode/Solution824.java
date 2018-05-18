package leetcode;

public class Solution824 {
    public String toGoatLatin(String S) {
        if (S == null || S.length() == 0) {
            return "";
        }
        String[] split = S.split(" ");
        StringBuilder result = new StringBuilder();
        int counter = 1;
        for(String each : split) {
            if (each.charAt(0) == 'a' || each.charAt(0) == 'e' || each.charAt(0) == 'i' || each.charAt(0) == 'o' || each.charAt(0) == 'u' || each.charAt(0) == 'A' || each.charAt(0) == 'E' || each.charAt(0) == 'I' || each.charAt(0) == 'O' || each.charAt(0) == 'U') {
                result.append(each);
                result.append("ma");
                for (int i = 0; i < counter; i++) {
                    result.append("a");
                }
                counter++;
                result.append(" ");
            } else {
                result.append(transferNonVowel(each));
                for (int i = 0; i < counter; i++) {
                    result.append("a");
                }
                counter++;
                result.append(" ");
            }
        }
        result.deleteCharAt(result.length()-1);
        return result.toString();
    }

    private String transferNonVowel(String input) {
        char[] result = input.toCharArray();

        char[] newChar = new char[result.length];
        for (int i = 0; i < input.length() - 1; i++) {
            newChar[i] = result[i + 1];
        }
        newChar[result.length - 1] = result[0];

        String processed = new String(newChar);
        return processed + "ma";
    }
}
