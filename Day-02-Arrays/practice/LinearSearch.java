public class LinearSearch{
    public static void main(String[] args) {
        int[] arr = {12, 7, 25, 9, 18};
        int target = 25;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target){
                System.out.println("Element found at index: " + i);
                return;
            }
        }
    }
}