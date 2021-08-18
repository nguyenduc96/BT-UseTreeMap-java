import java.util.Map;
import java.util.TreeMap;

public class CountWord {
    public static final char SPACE = ' ';
    public static final char TAB = '\t';
    public static final char BREAK_LINE = '\n';

    public static void main(String[] args) {
        String string = "hello! i'm Duc"
                + "      \n I from Vinh Phuc";
        System.out.println("---------------------------------");
        System.out.println(string);
        System.out.println("---------------------------------");
        System.out.println("Liệt kê số lần xuất hiện của các từ: ");
        Map<String, Integer> wordMap = countWords(string);
        for (String key : wordMap.keySet()) {
            System.out.print(key + " " + wordMap.get(key) + "\n");
        }
    }

    public static void addWord(Map<String, Integer> wordMap, StringBuilder stringBuilder) {
        String word = stringBuilder.toString();
        if (word.length() == 0){
            return;
        }else if(wordMap.containsKey(word)){
            int count = wordMap.get(word) +1;
            wordMap.put(word, count);
        }else {
            wordMap.put(word, 1);
        }
    }

    public static Map<String, Integer> countWords(String input) {
        Map<String, Integer> wordMap = new TreeMap<>();
        if (input == null) {
            return  wordMap;
        }else {
            int size = input.length();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < size; i++) {
                if (input.charAt(i) != SPACE && input.charAt(i) != TAB && input.charAt(i) != BREAK_LINE){
                    stringBuilder.append(input.charAt(i));
                }else {
                   addWord(wordMap, stringBuilder);
                   stringBuilder = new StringBuilder();
                }
            }
            addWord(wordMap, stringBuilder);
        }
        return wordMap;
    }
}
