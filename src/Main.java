import java.util.HashMap;
import java.util.Map;

public class Main {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        HashMap<Integer, String> passportsAndNames = new HashMap<>();
        HashMap<Integer, String> passportsAndNames2 = new HashMap<>();

        passportsAndNames.put(212133, "Лидия Аркадьевна Бубликова");
        passportsAndNames.put(162348, "Иван Михайлович Серебряков");
        passportsAndNames.put(8082771, "Дональд Джон Трамп");

        passportsAndNames2.put(917352, "Алексей Андреевич Ермаков");
        passportsAndNames2.put(925648, "Максим Олегович Архаров");


        passportsAndNames.putAll(passportsAndNames2);
        System.out.println(passportsAndNames);


        for (Map.Entry entry: passportsAndNames.entrySet()) {
            System.out.println(entry);
            System.out.println(entry.getKey());
        }

    }
}
