import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class ReverseWords {

    public static void main(String[] args) {
        String sample = "hello I am Chitti Speed 1 Zeta Byte Memory 1 PetaByte";
//        System.out.println(reverseString1(sample));
//        System.out.println(reverseString2(sample));
//        System.out.println(reverseString3(sample));
        System.out.println(reverseWord(sample));
    }

    private static String reverseWord(String origin) {
        String[] words = origin.split(" ");
        StringBuilder reversed = new StringBuilder();
        for(int i =0 ;i < words.length; i++) {
            reversed.append(reverseString1(words[i]));
            reversed.append(" ");
        }
        return reversed.toString();
    }
    private static String reverseString1(String fromString) {
        if(fromString == null || fromString.isEmpty()) return fromString;
        System.out.println("Method1");
        StringBuilder stringBuilder = new StringBuilder();
        Instant instant = Instant.now();
        long startTime = TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());;
        for(int i= fromString.length() -1; i>=0; i--){
            stringBuilder.append(fromString.charAt(i));
        }
        long endTime = TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());;
        long diff = endTime - startTime;
        System.out.println("Time: " + diff + "millis");
        return stringBuilder.toString();
    }

    private static String reverseString2(String fromString) {
        if(fromString == null || fromString.isEmpty()) return fromString;
        System.out.println("Method2");
        StringBuilder stringBuilder = new StringBuilder(fromString);
        StringBuilder stringBuilder2 = new StringBuilder(fromString);
        long startTime = System.currentTimeMillis();
        stringBuilder2 = stringBuilder.reverse();
        long endTime = System.currentTimeMillis();
        long diff = endTime - startTime;
        System.out.println("Time: " + diff + "millis");
        return stringBuilder2.toString();
    }

    private static String reverseString3(String fromString) {
        if(fromString == null || fromString.isEmpty()) return fromString;
        System.out.println("Method3");
        StringBuilder stringBuilder = new StringBuilder();
        long startTime = System.currentTimeMillis();
        char[] characters = fromString.toCharArray();
        for(int i=characters.length -1; i >=0; i--) {
            stringBuilder.append(characters[i]);
        }
        long endTime = System.currentTimeMillis();
        long diff = endTime - startTime;
        System.out.println("Time: " + diff + "millis");
        return stringBuilder.reverse().toString();
    }
}
