package com.home;

public class Task4 {
    public static void main(String[] args) {
        Task4 task4 = new Task4();
        int[] nums1 = {2};
        int[] nums2 = {};

        System.err.println(task4.findMedianSortedArrays(nums1,nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int [] arr = createOneArr(nums1,nums2);
        int leftIndex = 0;
        int rightIndex = 0;
        if(arr.length%2==0){
            leftIndex = arr.length/2-1;
            rightIndex = arr.length/2;
        }else{
             leftIndex = (int) Math.floor( arr.length/2);
             rightIndex = (int) Math.ceil( arr.length/2);
        }

        return (arr[leftIndex]+arr[rightIndex])*0.5;
    }

    private int[] createOneArr(int[] nums1, int[] nums2) {
        int size = nums1.length+nums2.length;
        int result [] = new int[size];
        int n = 0; int m = 0;
        for (int i = 0; i <result.length ; i++) {
            if (n < nums1.length && m < nums2.length) {
                if (nums1[n] <= nums2[m]) {
                    result[i] = nums1[n++];
                } else {
                    result[i] = nums2[m++];
                }
            }else if(n < nums1.length){
                result[i] = nums1[n++];
            } else {
                result[i] = nums2[m++];
            }
        }
        return result;
    }
}
