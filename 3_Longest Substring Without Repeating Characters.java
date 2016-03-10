public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Fields
        char[] list = s.toCharArray();
        ArrayList<Character> tempList;
        int startPonint = 0;
        int nextOne = startPonint + 1;
        int max = 1;
        int updateMax = 0;
        boolean plusPlus = true;


        if (list.length == 0) {
            return 0;
        }
        if (list.length == 1) {
            return 1;
        }

        while (nextOne < list.length) {
            // Loop restarts here
            plusPlus = true;
            max = 1;
            // Restart counting the max length
            for (int x = startPonint; x < nextOne; x++) {
                if (list[x] != list[nextOne]) {
                    max++;
                    // As long as no duplication, max++;
                } else {
                    startPonint = x + 1;
                    nextOne = startPonint + 1;
                    plusPlus = false;
                    updateMax = updateMax > max ? updateMax : max;
                    break;
                    // Founded duplication:
                    // Reset startPoint to the duplicated index's next
                    // Reset the nextOne to be startPoint+1
                    // Update the final max;
                }
            }
            if(plusPlus){
                nextOne++;
            }
            updateMax = updateMax > max ? updateMax : max;
        }
        return updateMax;
    }
}