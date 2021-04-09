package ru.geekbrains.tests;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    int[] testArray1 = {1, 2, 4, 4, 2, 3, 4, 1, 7};
	    validateSkippingUntilLastFour(testArray1, new int[]{1, 7}, false);
	    int[] testArray2 = {1, 2, 3};
	    validateSkippingUntilLastFour(testArray2, new int[]{}, true);
        int[] testArray3 = {1, 2, 3, 4};
        validateSkippingUntilLastFour(testArray3, new int[]{}, false);
        int[] testArray4 = {4, 1, 2, 3};
        validateSkippingUntilLastFour(testArray4, new int[]{1,2,3}, false);
        int[] testArray5 = {};
        validateSkippingUntilLastFour(testArray5, new int[]{}, true);
        int[] testArray6 = {4, 4, 4, 4};
        validateSkippingUntilLastFour(testArray6, new int[]{}, false);
    }

    static void validateSkippingUntilLastFour(int[] input, int[] expected, boolean expectException) {
        System.out.println("---- Starting test\ninput: " + Arrays.toString(input) + "\nexpected: " + (expectException ? "exception" : Arrays.toString(expected)));
        try {
            int[] result = skippingUntilLastFour(input);
            if (expectException) {
                System.out.println("---- Test failed, expected exception.");
                return;
            }
            if (Arrays.equals(result, expected)) {
                System.out.println("---- Test succeeded.");
            } else {
                System.out.println("---- Test failed,\nexpected: " + Arrays.toString(expected) + "\nresult: " + Arrays.toString(result));
            }
        } catch (RuntimeException e) {
            if (expectException) {
                System.out.println("---- Test succeeded.");
            } else {
                System.out.println("---- Test failed, unexpected exception.");
            }
        }
    }

    static int[] skippingUntilLastFour(int[] arr) throws RuntimeException {
        Integer lastFourIndex = null;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4) {
                lastFourIndex = i;
            }
        }
        if (lastFourIndex != null) {
            return Arrays.copyOfRange(arr, lastFourIndex + 1, arr.length);
        } else {
            throw new RuntimeException("Input array do not contain 4 at all!");
        }
    }

    static boolean hasOneAndFour(int[] arr) {
        boolean hasOne = false;
        boolean hasFour = false;
        for (Integer i : arr) {
            if (i == 1) {
                hasOne = true;
            }
            if (i == 4) {
                hasFour = true;
            }
            if (hasOne && hasFour) {
                break;
            }
        }

        return hasOne && hasFour;
    }
}
