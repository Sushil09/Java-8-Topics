//package com.sjsushil09.coreJava.ParkisngSpace;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//import org.junit.jupiter.api.Test;
//
//public class MainTest {
//    @Test
//    public void testUnequalArraysOddAndEven() {
//        int[] nums1 = {1, 3};
//        int[] nums2 = {2, 4, 6};
//        Main Main = new Main();
//        double expectedMedian = 3.0;
//        double actualMedian = Main.findMedianSortedArrays(nums1, nums2);
//        assertEquals(expectedMedian, actualMedian, 0.001); // Allow for floating-point precision
//    }
//
////    @Test
////    public void testNegativeNumbers() {
////        int[] nums1 = {-5, 3, 6};
////        int[] nums2 = {-12, -1};
////        Main Main = new Main();
////        double expectedMedian = -1.5;
////        double actualMedian = Main.findMedianSortedArrays(nums1, nums2);
////        assertEquals(expectedMedian, actualMedian, 0.001);
////    }
//
////    @Test
////    public void testDuplicateValues() {
////        int[] nums1 = {1, 2, 3, 3};
////        int[] nums2 = {2, 2, 4};
////        Main Main = new Main();
////        double expectedMedian = 2.5;
////        double actualMedian = Main.findMedianSortedArrays(nums1, nums2);
////        assertEquals(expectedMedian, actualMedian, 0.001);
////    }
//
//    @Test
//    public void testLargeArrays() {
//        int size = 10000;
//        int[] nums1 = new int[size];
//        int[] nums2 = new int[size];
//        // Fill arrays with sorted values...
//
//        Main Main = new Main();
//        double expectedMedian = // Calculate expected median...
//        double actualMedian = Main.findMedianSortedArrays(nums1, nums2);
//        assertEquals(expectedMedian, actualMedian, 0.001);
//    }
//
//
//}