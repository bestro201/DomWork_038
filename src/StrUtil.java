import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class StrUtil {

        public static Character getFirstUniqueChar(String string) {
            Set<Character> uniqueChars = new LinkedHashSet<>();
            Set<Character> duplicateChars = new HashSet<>();

            for (char c : string.toCharArray()) {
                if (Character.isLetter(c)) {
                    if (!duplicateChars.contains(c)) {
                        if (!uniqueChars.add(c)) {
                            uniqueChars.remove(c);
                            duplicateChars.add(c);
                        }
                    }
                }
            }

            return uniqueChars.stream().findFirst().orElse(null);
        }

        public static void main(String[] args) {
            String string = "abcdefj ab,cdf,";
            Character uniqueChar = getFirstUniqueChar(string);
            if (uniqueChar != null) {
                System.out.println("Найденная буква - "+uniqueChar);
            } else {
                System.out.println("Нет отличающихся букв");
            }
        }
    }

