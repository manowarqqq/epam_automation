import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Plane {
    private static final AtomicInteger count = new AtomicInteger(0);
    private  final int id;

    Plane() {
        this.id = count.incrementAndGet();
    }

    public  int getId() {
        return this.id;
    }
 }
