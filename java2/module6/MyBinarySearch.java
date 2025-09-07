package java2.module6;

import java.util.Arrays;
import java.util.Random;

public class MyBinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Random rand=new Random();
        for (int i=0; i<arr.length; i++){
            arr[i]=rand.nextInt(100);
        }
        System.out.println(Arrays.toString(arr));
        mySelectionSort.sort(arr);
        System.out.println(Arrays.toString(arr));
        search(arr,arr[2]);
    }

    public static void search(int[] arr, int val, int start, int end){
        if (end-start==1){
            if (arr[start]==val)
                System.out.println("Found "+val+" at index "+start);
            else
                System.out.println(val+" not found!");
            return;
        }
        int mid=(end-start)/2;
        if (arr[mid]==val){
            System.out.println("Found "+val+" at index "+mid);
        }
        else if (val<arr[mid]){
            search(arr, val, start, mid-1);
        }
        else {
            search(arr,val,mid+1,end);
        }
    }

    public static void search(int[] arr, int val){
        search(arr,val,0,arr.length-1);
    }
}
