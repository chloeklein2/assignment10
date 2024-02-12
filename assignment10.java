import java.util.Random;
import java.util.Arrays;
public class assignment10 {
   public static int[] createrandomArray(int n) {
    int[] arr =new int[n];
    Random random= new Random();
    for (int i=0; i<n; i++){
        arr[i] =random.nextInt(100);
    }
    return arr;
   }
   public static void mergesort(int[] arr, int left, int right){
        
        if (right- left>1){
            int mid =(left+right) /2;
            mergesort(arr,left,mid);
            mergesort(arr,mid,right);
            merge(arr,left,mid,right);
        }
   }
    public static void merge(int[] arr, int left, int mid, int right){
        int[] leftArr=Arrays.copyOfRange(arr,left,mid);
        int[] rightArr=Arrays.copyOfRange(arr, mid, right);
        int i=0,j=0;
        for(int k= left; k<right; k++){
            if(i==leftArr.length){
                arr[k]=rightArr[j++];
            }
            else if (j==rightArr.length){
                arr[k]=leftArr[i++];
            }
            else if(leftArr[i]<rightArr[j]){
                arr[k]=leftArr[i++];
            }
            else{
                arr[k]=rightArr[j++];
            }
        }
    }
    public static void mergesort(int[] arr){
        mergesort(arr,0,arr.length);
    }
    public static boolean isSorted(int[] arr){
        for(int i=1; i<arr.length;i++){
            if (arr[i-1]>arr[i]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] arr = createrandomArray(10);
        System.out.println("original array:");
        System.out.println(Arrays.toString(arr));
        mergesort(arr);
        System.out.println("sorted array:");
        System.out.println(Arrays.toString(arr));
    }
    
}