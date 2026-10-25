public class FrequencyCount {
    public static void main(String[] args) {
       int[] arr = {2, 5, 2, 7, 2, 5};
       int target = 2;
       int cnt=0;
       for (int i=0;i<arr.length;i++){
        if(arr[i]==target){
            cnt++;
        }
       }
       System.out.println("Frequency of " + target + " is: " + cnt);
    }
}