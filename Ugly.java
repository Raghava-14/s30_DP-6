//Time = O(n), input number
//Space = O(n)

class Solution {
    public int nthUglyNumber(int n) {
        // Create an array to store the first n ugly numbers
        int[] ugly = new int[n];
        // The first ugly number is 1
        ugly[0] = 1;
        // Create variables to keep track of the current indices and factors for 2, 3, and 5
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        
        // Iterate from the second ugly number to the nth ugly number
        for (int i = 1; i < n; i++) {
            // Find the minimum of the current factors for 2, 3, and 5
            int min = Math.min(Math.min(factor2, factor3), factor5);
            // Set the ith ugly number to the minimum factor
            ugly[i] = min;
            
            // If the minimum factor is equal to the current factor for 2, increment the index for 2 and update the factor
            if (factor2 == min) {
                factor2 = 2 * ugly[++index2];
            }
            // If the minimum factor is equal to the current factor for 3, increment the index for 3 and update the factor
            if (factor3 == min) {
                factor3 = 3 * ugly[++index3];
            }
            // If the minimum factor is equal to the current factor for 5, increment the index for 5 and update the factor
            if (factor5 == min) {
                factor5 = 5 * ugly[++index5];
            }
        }
        
        // Return the nth ugly number
        return ugly[n-1];
    }
}
