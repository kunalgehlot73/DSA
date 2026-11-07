import java.util.Arrays;
class QuickSort {
    public static void quickSort(int[] arr, int st, int end){
        if (st > end) return;
        int pivot = partitiion(arr, st, end);
        quickSort(arr, st, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }
    public static int partitiion(int[] arr, int st, int end){
        int pivot = arr[end];
        int i = st - 1;
        for (int j = st; j <= end - 1; j++) {
            if(arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = arr[end];
        arr[end] = temp;
        return i;

    }
    public static void main(String[] args) {
        int[] arr = { 5, 2, 8, 1, 3, 7, 6, 4 };
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}