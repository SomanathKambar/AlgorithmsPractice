import java.util.HashMap;
import java.util.Map;

public class XLSheetColumNameArrangement {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        int counter =0 ;
        for(char ch= 'A'; ch <= 'Z'; ++ ch) {
            map.put(String.valueOf(ch),++counter);
        }

        System.out.println(map);

        String input = "ZY";
        System.out.println(getFaceValue(input, map));

    }

    public static int getFaceValue(String value,Map<String, Integer> map) {
        String[] input = value.split("");
        int result = 0;
        for(int i=0; i<input.length;i++){
            if(map.containsKey(input[i])) {
                if(i == 0) {
                    result = map.get(input[i]);
                    result = (result * 26);
                } else {
                    result = result + (map.get(input[i]));
                }
            }
        }
        return  result;
    }

}

