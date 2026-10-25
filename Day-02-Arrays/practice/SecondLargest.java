public class SecondLargest {
    public static void main(String[] args) {
        int[] arr = {12, 35, 1, 10, 34, 35};
        int largest=arr[0];
        int secondLargest=0;
        for (int i=0;i<arr.length;i++){
            if(arr[i]>largest){
                largest=arr[i];
            }
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]>secondLargest && arr[i]<largest){
                secondLargest=arr[i];
            }
        }
        System.out.println("Second Largest Element is: " + secondLargest);
    }
}