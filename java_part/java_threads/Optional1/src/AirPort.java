import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class AirPort {
    private static AirPort airPort = new AirPort();
    private Semaphore semaphore = new Semaphore(3);

    private AirPort() {
    }

    static AirPort getAirport() {
        return airPort;
    }

    void working(Plane plane) {
        try {
            semaphore.acquire();
            System.out.println("Plane " + plane.getId() + " moving to runway");
            System.out.println("The runway applied the plane " + plane.getId());
            TimeUnit.SECONDS.sleep(3);
            System.out.println("Plane " + plane.getId() + " took off ");
            System.out.println("The runway is free");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

}
