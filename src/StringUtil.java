import java.util.*;
import java.util.stream.Collectors;

public class StringUtil {
    public static List<String> getUniqueSortedWords(String input) {

        String normaInput = input.replaceAll("[,.!\"«»]",  "").toLowerCase();

        List<String> words = Arrays.asList(normaInput.split("\\s+"));
        Set<String> uniqueWordsSet = new HashSet<>(words);
        return uniqueWordsSet.stream()
                .sorted(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.toList());
    }



    public static void main(String[] args) {
        String testString = "Тестовая строка для удаления слов, которые повторяются. \"строка\" для удаления!";
        System.out.println( StringUtil.getUniqueSortedWords(testString));
    }
}

