import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Model {
    BMW,AUDI,RENO,MERSEDES,FORD,KIO,OPEL;

    private static final List<Model> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static Model randomModel()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
