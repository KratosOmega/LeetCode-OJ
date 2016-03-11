import java.util.ArrayList;

public class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        // .trim() is the 1st key point in order to solve this problem
        // .trim() helps get rid of the whitespaces before and after the string
        // if the whitespaces exist when during later loop, there will be errors
        String[] origOrder = s.split("\\s+");
        // \\s+ is used for 1 or more whitespaces, tabs, and lines patterns detection
        ArrayList<String> revertedOrder = new ArrayList<String>();
        String finalString = "";

        for (int i = origOrder.length - 1; i >= 0; i--) {
            revertedOrder.add(origOrder[i]);
        }

        for (int i = 0; i < revertedOrder.size(); i++) {

            if (i == revertedOrder.size() - 1) {
                finalString = finalString + revertedOrder.get(i);
            } else {
                finalString = finalString + revertedOrder.get(i) + " ";
            }
        }
        return finalString;
    }
}
