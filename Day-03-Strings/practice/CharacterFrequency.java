public class CharacterFrequency {
    public static void main(String[] args) {
        String str = "banana";
        int[] freq = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int index = ch - 'a';

            freq[index]++;
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                char ch = (char) ('a' + i);
                System.out.println(ch + ": " + freq[i]);
            }
        }
    }
}
