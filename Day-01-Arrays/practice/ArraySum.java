public class ArraySum {
    public static void main(String[] args) {
        int arr[]={12, 5, 27, 8, 19};
        int sum=0;
        for(int i=0;i<arr.length;i++) {
            sum=sum + arr[i];
        }
        System.out.println("Sum of array: " +sum);
    }
} 
