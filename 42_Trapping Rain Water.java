public class Solution {
    public int trap(int[] height) {
        int totalRain = 0;
        int subRain = 0;
        
        int currentStone = 0;
        int tempStone = 0;
        
        int minDiff;
        int width = height.length;
        int highest = 0;
        boolean innerRevert = false;

        // Set the minDiff to the largest possible gap
        // so that it won't be rejected for unexpected result
        for (int i = 0; i < width; i++) {
            if (height[i] > highest) {
                highest = height[i];
            }
        }
        minDiff = highest;

        // currentStone will loop from the head to tail
        // NOTE:    since the inner loop will be initialized as currentStone+1, 
        //          the outter loop has to check 1 less for not getting  into infinite loop
        while (currentStone < width - 1) {
            for (int i = currentStone + 1; i < width; i++) {
                if (height[currentStone] > height[i]) {
                    subRain = subRain + (height[currentStone] - height[i]);
                    if ((height[currentStone] - height[i]) <= minDiff) {
                        minDiff = (height[currentStone] - height[i]);
                        tempStone = i;
                    }
                    
                    innerRevert = true;

                } else {
                    totalRain += subRain;
                    subRain = 0;
                    currentStone = i;
                    minDiff = highest;
                    innerRevert = false;
                }
            }

            if (innerRevert) {
                subRain = 0;
                height[currentStone] = height[tempStone];
                for (int j = currentStone; j < tempStone; j++) {
                    subRain += (height[currentStone] - height[j]);
                }
                totalRain += subRain;
                subRain = 0;

                currentStone = tempStone;
                innerRevert = false;
                minDiff = highest;
            }
        }
        return totalRain;
    }
}