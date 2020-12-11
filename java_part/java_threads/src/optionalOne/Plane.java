package optionalOne;

import java.util.concurrent.atomic.AtomicInteger;

public class Plane {
    private static final AtomicInteger count = new AtomicInteger(0);
    private final int id;

    Plane() {
        this.id = count.incrementAndGet();
    }

    int getId() {
        return this.id;
    }
}
