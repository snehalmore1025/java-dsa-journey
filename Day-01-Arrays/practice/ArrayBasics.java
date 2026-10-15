public class ArrayBasics{
    public static void main(String[] args){
        int arr[]={12,5,27,8,19};
        int sum=0;
        int max=arr[0];
        int min=arr[0];
        for(int i=0;i<arr.length;i++){
            sum=sum+arr[i];
            if(arr[i]>max){
                max=arr[i];
            }
            if(arr[i]<min){
                min=arr[i];
            }
        }
        System.out.println("Array length: "+arr.length);
        System.out.println("Sum: "+sum);
        System.out.println("Maximum element: "+max);
        System.out.println("Minimum element: "+min);
    }
}
