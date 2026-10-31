class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            char ch = magazine.charAt(i);
            int index = ch - 'a';
            freq[index]++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            int index = ch - 'a';
            if (freq[index] == 0) {
                return false;
            }
            freq[index]--;
        }
        return true;
    }
}