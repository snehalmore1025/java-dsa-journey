public class StringReverse{
    public static void main(String[] args){
        String str="hello";
        String reverse="";
        for(int i=0;i<str.length();i++){
            reverse=str.charAt(i)+reverse;
        }
        System.out.println("Input: "+str);
        System.out.println("Reversed: "+reverse);
    }
}