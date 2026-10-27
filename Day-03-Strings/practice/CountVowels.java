public class CountVowels {
    public static void main(String[] args){
        String str="Hello World";
        int cnt=0;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U'){
                cnt++;
            }
        }
        System.out.println("Input: "+str);
        System.out.println("Vowels Count: "+cnt);   
    }
}
