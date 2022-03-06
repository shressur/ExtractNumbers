import java.util.List;
/*
Extract numbers from jumbled number letters
input: "iorowtneezn"
output: 029
*/
public class ExtractNumbers {
    public static void main(String[] args) {

        String testStr = "onetwonineo";
        int output = NumberExtractor(testStr);
        System.out.println(output);

    }

    //extraction can be done in two ways:
    //1. find first match, if match found then start from the beginning
    //2. go through the entire characters and find the match then start from the beginning again
    //these two approach might result two different results
    //example: onetwonineo => might match to 1, 1, 2 as well as to 1,  2, 9
    private static int NumberExtractor(String str){
        List<String> list = List.of("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
        boolean isFound = true;
        String result = "";
        String tempStr = str;
        for(int i=0; i<list.size(); i++){
            for(char chr:list.get(i).toCharArray()){
                if(!tempStr.contains(""+chr)){
                    isFound = false;
                }
            }
            if(isFound){
                for(char c:list.get(i).toCharArray()){
                    tempStr = tempStr.replaceFirst(""+c, "");
                }
                result += list.indexOf(list.get(i));
                i = 0;  //recursion: lower number is matched first
            }
            isFound = true;
        }
        return Integer.parseInt(result);
    }
}
