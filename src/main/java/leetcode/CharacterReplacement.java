package leetcode;

public class CharacterReplacement {

    public int characterReplacement(String s, int k){
        if(s.length() <= k)
            return s.length();

        int left=0, right=0, mostFreqLetterCount=0, maxLength = Integer.MIN_VALUE;
        int[] count = new int[26];

        while(right < s.length()){
            mostFreqLetterCount = Math.max(mostFreqLetterCount, ++count[s.charAt(right) - 'A']);

            while(right-left+1-mostFreqLetterCount > k){
                count[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right-left+1);
            right++;
        }

        return maxLength;
    }

    public static void main(String[] args){
        CharacterReplacement cr = new CharacterReplacement();
        System.out.println("Result is: " + cr.characterReplacement("ABBB", 2));
        System.out.println("Result is: " + cr.characterReplacement("ABBBA", 2));
    }

}
