package gr.aueb.testbed.week2;

import java.util.Arrays;

/**
 * Write two methods that involve copying two-dimensional arrays.
 * A int[][] shallowCopy(int[][] arr) method that copies a two-dimensional array but
 * only the base array values that are references to the arrays that are
 * elements of the main table. And one method int[][] deepCopy(int[][] arr).
 * Write a main that shows why shallow copy does not work as we would like,
 * since by changing an element of an array of two for example copies, it changes
 * the element in the other table as well, since basically it is a single sheared
 * element (after a shallow copy has been made).
 * Also show the case of deep copy. Show that it works as we would like.
 * That is, the data changes do not affect each copy, which are now
 * independent.
 */

public class JavaMiniPr6 {

    public static void main(String[] args) {

        int[][]arr1 = {{1, 2}, {3,4}};
        int[][]arr2 = makeShallow(arr1);
        int[][]arr3 = deepCopy(arr1);

        arr2[0][0] = 100; // shallow copy testcase - arr1 also changes

        for (int i = 0; i < arr2.length; i++){
            System.out.println(arr2[i][0]+" "+arr2[i][1]);
        }
        System.out.println("Arr2 testcase results");
        System.out.println();


        arr3[0][0] = 200; // deep copy testcase - arr1 stays intact

        for (int i = 0; i < arr3.length; i++){
            System.out.println(arr3[i][0]+" "+arr3[i][1]);
        }
        System.out.println("Arr3 testcase results");
        System.out.println();


        for (int i = 0; i < arr1.length; i++){
            System.out.println(arr1[i][0]+" "+arr1[i][1]);
        }
        System.out.println("Original Array testcase results");
        System.out.println();
    }

    public static int[][] makeShallow(int[][] arr){
        return arr;
    }

    public static int[][] deepCopy(int[][] original) {
        if (original == null) {
            return null;
        }

        final int[][] result = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            result[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return result;
    }
}
