import java.util.Arrays;
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {2, 9, 5, 4, 8, 1, 6};

        System.out.println(Arrays.toString(arr));

        int minIndex;
        int temp;
        for (int i=0; i<arr.length-1; i++){
            minIndex = i;
            for (int j=i; j<arr.length; j++){
                if (arr[j]<arr[minIndex])
                    minIndex=j;
            }
            if (minIndex!=i){
                temp=arr[i];
                arr[i]=arr[minIndex];
                arr[minIndex]=temp;
            }
            System.out.println(Arrays.toString(arr));
        }
    }
}
