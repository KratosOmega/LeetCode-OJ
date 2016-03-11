import java.util.ArrayList;

public class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] origOrder = s.split("\\s+");
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