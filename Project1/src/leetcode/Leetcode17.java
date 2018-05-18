package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode17 {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        result = getList(digits.substring(0,1));

        for (int i = 1; i < digits.length(); i++) {
            result = listMultiple(result, getList(digits.substring(i,i+1)));
        }

        return result;
    }

    private List<String> listMultiple(List<String> input1, List<String> input2) {
        List<String> result = new ArrayList<>();

        if (input1 == null || input2 == null) {
            return result;
        }

        if (input1.size() != 0 && input2.size() == 0) {
            return input1;
        }

        if (input2.size() != 0 && input1.size() == 0) {
            return input2;
        }

        for (String elementFirst : input1) {
            for (String elementSecond : input2) {
                result.add(elementFirst + elementSecond);
            }
        }
        return result;
    }

    private List<String> getList(String digit) {
        List<String> result = new ArrayList<>();

        if (digit == null || digit.length() != 1 ) {
            return result;
        }

        if (digit.equals("2")) {
            result.add("a");
            result.add("b");
            result.add("c");
            return result;
        }

        if (digit.equals("3")) {
            result.add("d");
            result.add("e");
            result.add("f");
            return result;
        }

        if (digit.equals("4")) {
            result.add("g");
            result.add("h");
            result.add("i");
            return result;
        }

        if (digit.equals("5")) {
            result.add("j");
            result.add("k");
            result.add("l");
            return result;
        }

        if (digit.equals("6")) {
            result.add("m");
            result.add("n");
            result.add("o");
            return result;
        }

        if (digit.equals("7")) {
            result.add("p");
            result.add("q");
            result.add("r");
            result.add("s");
            return result;
        }

        if (digit.equals("8")) {
            result.add("t");
            result.add("u");
            result.add("v");
            return result;
        }

        if (digit.equals("9")) {
            result.add("w");
            result.add("x");
            result.add("y");
            result.add("z");
            return result;
        }

        return result;
    }
}
