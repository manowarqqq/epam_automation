package java_threads.mainTask;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;


class Parking {

    Random rand = new Random();
    static BlockingQueue<Car> parkingQueue = new ArrayBlockingQueue<>(10);

    void enterAndLeaveParking(Car car) throws InterruptedException {
        parkingQueue.add(car);
        System.out.println(car.toString() + "The car on the parking; Total cars:" + parkingQueue.size());
        Thread.sleep(rand.nextInt(30000));
        parkingQueue.remove(car);
        System.out.println(car.toString() + "Leave the parking; Total cars:" + parkingQueue.size());

    }

}

