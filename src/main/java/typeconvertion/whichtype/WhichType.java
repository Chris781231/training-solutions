package typeconvertion.whichtype;

import java.util.ArrayList;
import java.util.List;

public class WhichType {

    public List<Type> whichType(String s) {
        List<Type> suitableTypes = new ArrayList<>();

        for (Type type : Type.values()) {
            if (type.getMinValue() <= Long.parseLong(s) && type.getMaxValue() >= Long.parseLong(s)) {
                suitableTypes.add(type);
            }
        }

        return suitableTypes;
    }
}
