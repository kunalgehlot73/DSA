public class LC_852_peakIndexMountainArray {

    public static int peakIndexInMountainArray(int[] arr) {
        int low = 1;
        int high = arr.length - 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (arr[mid] < arr[mid + 1]) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 4, 3, 2, 1 };
        System.out.println(peakIndexInMountainArray(arr));
    }
}
