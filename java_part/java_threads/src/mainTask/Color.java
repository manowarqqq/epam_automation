package mainTask;

import java.util.List;
import java.util.Random;

public enum Color {

    YELLOW, WHITE, BLACK, RED, GREEN, BROWN;

    private static final List<Color> VALUES =
            List.of(values());
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static Color randomColor() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
