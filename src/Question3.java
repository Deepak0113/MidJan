import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Question3 {
    static int findSubsequence(String[] words, String[] checks){
        Set<Character> set = new HashSet<>();
        for(String check: checks){
            for(Character c : check.toCharArray()){
                set.add(c);
            }
        }

        int result =0;
        Set<Character> hs;

        for(String word: words){
            hs=new HashSet<>(set);
            for(int i =0;i<word.length()&& hs.size()>0;i++){
                if(hs.contains(word.charAt(i))){
                    hs.remove(word.charAt(i));
                }
            }
            if(hs.size()==0){
                result++;
            }
        }


        return result;
    }

    public static void main(String[] args) {
        String[] x = {"ceo","alco","caaeio","ceai","acoeaaco"};
        String[] y={"ec","oc","ceo"};
        System.out.println(findSubsequence(x,y));
    }
}
