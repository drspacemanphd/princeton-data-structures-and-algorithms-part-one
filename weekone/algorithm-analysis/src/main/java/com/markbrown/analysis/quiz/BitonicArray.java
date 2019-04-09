package com.markbrown.analysis.quiz;

public class BitonicArray {

    public boolean doesNumberExist(int[] arr, int target) {

        int maxNumIndex = getMax(arr, (arr.length - 1) / 2);
        boolean isTargetInLeftPart = isTargetInLeftPart(arr, target, 0, maxNumIndex);
        boolean isTargetInRightPart = isTargetInRightPart(arr, target, maxNumIndex, arr.length - 1);
        return isTargetInLeftPart || isTargetInRightPart;
    }

    private boolean isTargetInLeftPart(int[] arr, int target, int start, int end) {
        int midIndex = (start + ((end - start) / 2));
        if (arr[midIndex] == target) return true;
        else if (midIndex == start || midIndex == end) return false;
        else if (arr[midIndex] > target) return isTargetInLeftPart(arr, target, start, midIndex);
        else return isTargetInLeftPart(arr, target, midIndex, end);
    }

    private boolean isTargetInRightPart(int[] arr, int target, int start, int end) {
        int midIndex = (start + ((end - start) / 2));
        if (arr[midIndex] == target) return true;
        else if (midIndex == start || midIndex == end) return false;
        else if (arr[midIndex] > target) return isTargetInRightPart(arr, target, midIndex, end);
        else return isTargetInRightPart(arr, target, start, midIndex);
    }

    private int getMax(int[] arr, int startIndex) {
        System.out.println(startIndex);
        if ((startIndex <= 0 || startIndex >= arr.length - 1) || (arr[startIndex] > arr[startIndex - 1] && arr[startIndex] > arr[startIndex + 1])) {
            return startIndex;
        } else if (arr[startIndex + 1] > arr[startIndex] ) {
            return getMax(arr, startIndex + (((arr.length - 1) - startIndex) / 2));
        } else {
            return getMax(arr, startIndex - (((arr.length - 1) - startIndex) / 2));
        }
    }
}