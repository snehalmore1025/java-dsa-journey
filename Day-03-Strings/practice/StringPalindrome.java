public class StringPalindrome {
    public static void main(String[] args) {
        String str = "madam";
        int left=0;
        int right=str.length()-1;
        while(left<right){
            if(str.charAt(left)!=str.charAt(right)){
                System.out.println("Input: "+str);
                System.out.println("Not Palindrome.");
                return;
            }
            left++;
            right--;
        }
        System.out.println("Input: "+str);
        System.out.println("Is Palindrome.");
    }
}
