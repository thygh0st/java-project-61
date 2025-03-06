package hexlet.code;

public class Utils {
    public static int generateNumber(int min, int max) {
        // [min, max)
        // Math.random(), чтобы был создан 1 инстанс Random (отладка с seed будет проще)
        return (int) Math.floor(Math.random() * (max - min)) + min;
    }
}
