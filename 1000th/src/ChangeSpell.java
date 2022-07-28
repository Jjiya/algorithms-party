import java.util.HashMap;
import java.util.Map;

public class ChangeSpell implements Solution{
    final private Map<String, String> SPELLING_TO_NUMBER = new HashMap<String, String>() {
        {
            put("zero", "0");
            put("one", "1");
            put("two", "2");
            put("three", "3");
            put("four", "4");
            put("five", "5");
            put("six", "6");
            put("seven", "7");
            put("eight", "8");
            put("nine", "9");
        }
    };
    ChangeSpell() { run(this); }

    @Override
    public void process() {
        String s = "one4seveneight";
        solution(s);
    }

    public int solution(String s) {
        for(Map.Entry<String, String> ent : SPELLING_TO_NUMBER.entrySet()){
            if(s.contains(ent.getKey())){
                s = s.replace(ent.getKey(), ent.getValue());
            }
        }
        System.out.println(s);
        return Integer.parseInt(s);
    }
}
