package program.common.dummydata;

import com.github.javafaker.Faker;
import program.common.ConfigCommon;

/**
 * use com.github.javafaker library
 */
public class CharacterDummy {

    private static Faker faker = new Faker();

    public static String[] strArrayName() {
        int N = ConfigCommon.getNumberOfArray();
        String[] array = new String[N];
        for (int i = 0; i < N; i++) {
            array[i] = faker.name().name();
        }
        return array;
    }

    public static String[] strArrayCity() {
        int N = ConfigCommon.getNumberOfArray();
        String[] array = new String[N];
        for (int i = 0; i < N; i++) {
            array[i] = faker.country().capital();
        }
        return array;
    }

}
