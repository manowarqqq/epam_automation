import java.util.Random;
import java.util.concurrent.*;

public class Run {

    /*
        Автостоянка. Доступно несколько машиномест.
        На одном месте может находиться только один автомобиль.
        Если все места заняты, то автомобиль не станет ждать больше определенного времени и уедет на другую стоянку.
     */


    public static void main(String[] args) {
        Random rand = new Random();
        ExecutorService executor = Executors.newFixedThreadPool(20);
        Parking parking = new Parking();

        for (int i = 0; i < 100; i++) {
            executor.submit(() -> {
                try {
                    Car car = new Car();
                    Thread.sleep(rand.nextInt(1000));
                    parking.enterToParking(car);
                    Thread.sleep(rand.nextInt(30000));
                    parking.leaveParking(car);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



