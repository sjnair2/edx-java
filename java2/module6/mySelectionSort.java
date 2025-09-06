package java2.module6;

import java.util.Random;
import java.util.Arrays;

public class mySelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Random rand=new Random();
        for (int i=0; i<arr.length; i++){
            arr[i]=rand.nextInt(100);
        }
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] sort(int[] arr){
        int minIndex, temp;
        for (int i=0; i<arr.length-1; i++){
            minIndex=i;
            for (int j=i+1; j<arr.length; j++){
                if (arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }
            temp=arr[i];
            arr[i]=arr[minIndex];
            arr[minIndex]=temp;
        }
        return arr;
    }
}
