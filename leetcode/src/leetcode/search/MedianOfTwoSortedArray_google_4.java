package leetcode.search;

public class MedianOfTwoSortedArray_google_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n=nums2.length;
		if (m < n) return findMedianSortedArrays(nums2, nums1);	// Make sure A2 is the shorter one.
		
		if (n == 0) return ((double)nums1[(m-1)/2] + (double)nums1[m/2])/2;  // If A2 is empty
		
		int l = 0, h = n * 2;
		while (l <= h) {
			int mid2 = (l + h) / 2;   // Try Cut 2 
			int mid1 = m + n - mid2;  // Calculate Cut 1 accordingly
			double L1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1-1)/2];	// Get L1, R1, L2, R2 respectively
			double L2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(mid2-1)/2];
			double R1 = (mid1 == m * 2) ? Integer.MAX_VALUE : nums1[(mid1)/2];
			double R2 = (mid2 == n * 2) ? Integer.MAX_VALUE : nums2[(mid2)/2];
			
			if (L1 > R2) l = mid2 + 1;		// A1's lower half is too big; need to move C1 left (C2 right)
			else if (L2 > R1) h = mid2 - 1;	// A2's lower half too big; need to move C2 left.
			else return (Math.max(L1,L2) + Math.min(R1, R2)) / 2;	// Otherwise, that's the right cut.
		}
		return -1;
    }
}
