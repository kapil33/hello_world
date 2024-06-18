package gfg.interviews.druva;

/**
 *
 * String decompression. A compressed string is given a2b3c5 which will decompress to “aabbbcccc”, an index is given.
 * Eg:6. You need to return character from a decompressed string at that index. Answer:c. return -1 if you cannot find character
 *
 */

public class DecompressedString {

    private char deCompress(String s, int index){

        for(int i=0; i<s.length()-1; i+=2){
            //index -= s.charAt(i+1)-48;
            index -= Character.getNumericValue(s.charAt(i+1));

            if(index < 0)
                return s.charAt(i);
        }

        return new Character('1');
    }

    public static void main(String[] args){
        DecompressedString ds = new DecompressedString();

        char result = ds.deCompress("a2b3c5", 10);

        System.out.println("Compressed string is: " +  "a2b3c5");
        System.out.println("Character at index 6 is: " +  result);
    }
}
