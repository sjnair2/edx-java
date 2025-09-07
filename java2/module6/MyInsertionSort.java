package java2.module6;

import java.util.Arrays;
import java.util.Random;

public class MyInsertionSort {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Integer[] arr = new Integer[10];
        Random rand=new Random();
        for (int i=0; i<arr.length; i++){
            arr[i]=rand.nextInt(100);
        }
        System.out.println(Arrays.toString(arr));
        sort((Comparable[])arr);
        System.out.println(Arrays.toString(arr));
    }
    public static <T extends Comparable<T>> void sort(T[] arr){
        T temp;
        for (int i=0; i<arr.length-1; i++){
            for (int j=i; j>=0; j--){
                if (arr[j].compareTo(arr[j+1])<0)
                    break;
                temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
            }
        }
    }
}
