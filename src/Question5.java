import java.util.HashMap;
import java.util.LinkedHashMap;

public class Question5 {
    static void getCountCharacters(String inputString, String refString){
        LinkedHashMap<Character, Integer> countMap = new LinkedHashMap<>();
        int refStringLength = refString.length();
        int inputStringLength = inputString.length();
        char ch;

        for(int i=0; i<refStringLength; i++){
            ch = refString.charAt(i);
            if(!countMap.containsKey(ch)){
                countMap.put(ch, 0);
            }
        }

        for(int i=0; i<inputStringLength; i++){
            ch = inputString.charAt(i);
            if(countMap.containsKey(ch)){
                countMap.put(ch, countMap.get(ch)+1);
            }
        }

        for(Character key: countMap.keySet()){
            System.out.print(key+":"+countMap.get(key)+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        getCountCharacters("Hello World", "hel");
        getCountCharacters("Hello World", "hell");
        getCountCharacters("Hello World", "l");
        getCountCharacters("Hello World", "");
        getCountCharacters("Hello World", "helzq");
        getCountCharacters("", "hel");
    }
}
