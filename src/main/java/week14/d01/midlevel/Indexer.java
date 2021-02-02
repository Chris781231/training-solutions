package week14.d01.midlevel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Indexer {

    public Map<Character, List<String>> index(List<String> names) {
        Map<Character, List<String>> result = new TreeMap<>();

        for (String name : names) {
            char key = name.charAt(0);
            if (!result.containsKey(key)) {
                result.put(key, new ArrayList<>());
            }
            List<String> nameList = result.get(key);
            nameList.add(name);
            result.put(key, nameList);
        }

        return result;
    }
}
