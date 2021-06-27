package maps;

import java.util.EnumMap;
import java.util.Map;

/**
 * key is enum , value is object normal
 * EnumMap < k extend Enum, v object >
 */
public class EnumMaps {
    public static void main(String[] args) {
        Map<Day, String> mapEnum = new EnumMap<Day, String>(Day.class);
        mapEnum.put(Day.Friday, "start work 8:00");
        mapEnum.put(Day.Saturday, "start work 18:00");
        mapEnum.put(Day.Monday, "start work 23:00");
        mapEnum.put(Day.Tuesday, "start work 6:00");
        System.out.println(mapEnum);
    }

}

enum Day {
    Monday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday,
    Sunday;

    Day() {
    }
}