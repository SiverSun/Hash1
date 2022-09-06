import java.util.HashMap;
import java.util.Map;

public class Main {
    protected static String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    public static void main(String[] args) {
        char[] simbols = text.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for (Character currentSimbol : simbols) {
            if (currentSimbol != ' ') {
               map.merge(currentSimbol, 1, (currentValue, defaultValue)-> ++ currentValue);
            }
        }
        Map.Entry<Character, Integer> maxSimbol = getMaxSimbol(map);
        Map.Entry<Character, Integer> minSimbol = getMinSimbol(map);
        System.out.printf("Чаще всего встречается символ: %c количество: %d\n", maxSimbol.getKey(), maxSimbol.getValue());
        System.out.printf("Реже всего встречается символ: %c количество: %d\n", minSimbol.getKey(), minSimbol.getValue());

    }
    private static Map.Entry<Character, Integer> getMaxSimbol(Map<Character, Integer>map){
    int maxCount = -1;
    Map.Entry<Character, Integer> result = null;
    for (Map.Entry<Character, Integer> currentEntry: map.entrySet()) {
        if (currentEntry.getValue()> maxCount){
            result = currentEntry;
            maxCount = currentEntry.getValue();
        }
    }
    return result;
    }
    private static Map.Entry<Character, Integer> getMinSimbol(Map<Character, Integer>map){
        int minCount = Integer.MAX_VALUE;
        Map.Entry<Character, Integer> result = null;
        for (Map.Entry<Character, Integer> currentEntry: map.entrySet()){
            if (currentEntry.getValue()<minCount){
                result = currentEntry;
                minCount = currentEntry.getValue();
            }
        }
        return result;
    }
}