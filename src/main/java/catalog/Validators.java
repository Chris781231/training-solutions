package catalog;

import java.util.List;

public class Validators {

    private Validators() {
    }

    public static boolean isBlank(String str) {
        return str == null || str.isBlank();
    }

    public static boolean isEmpty(List<String> strList) {
        return strList == null || strList.isEmpty();
    }
}
