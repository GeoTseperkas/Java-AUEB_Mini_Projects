package gr.aueb.testbed.week2;

/**
 * Assume we have an array of n integers. Then the maximum sum subarray
 * is the contiguous one subarray (contiguous subarray - potentially empty)
 * with the largest sum. Design a linear algorithm (with O(n) complexity) to solve
 * above problem.
 * For example, if we have the array {−2, 1, −3, 4, −1, 2, 1, −5, 4}
 * then the contiguous submatrix with the maximum sum is {4, −1, 2, 1},
 * whose sum is 6.
 */

public class JavaMiniPr5 {

    public static void main(String[] args) {
        int[]arr = {-2,1,-3,4,-1,2,1,-5,4};


        maxSubArraySum(arr);


    }


    static void maxSubArraySum(int[] array) {

        int max = Integer.MIN_VALUE;
        int maxi = 0;
        int start = 0;
        int end = 0;
        int s = 0;

        for (int i = 0; i < array.length; i++) {
            maxi += array[i];
            if (max < maxi) {
                max = maxi;
                start = s;
                end = i;
            }
            if (maxi < 0) {
                maxi = 0;
                s = i + 1;
            }
        }
        System.out.print("Maximum subarray: ");
        for(int i = start; i <= end; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
        System.out.printf("Max subarray Sum: %d",max);
    }




}
