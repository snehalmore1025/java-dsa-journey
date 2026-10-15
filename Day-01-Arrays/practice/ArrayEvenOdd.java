public class ArrayEvenOdd{
    public static void main(String[] args){
        int arr[]={12, 5, 27, 8, 19, 4};
        int evenCount=0;
        int oddCount=0;
        for (int i=0;i<arr.length;i++){
            if(arr[i]%2==0){
                evenCount++;
            } 
            else{
                oddCount++;
            }
        }
        System.out.println("Total elements: " + arr.length);
        System.out.println("Even numbers: " + evenCount);
        System.out.println("Odd numbers: " + oddCount);
    }
}
