import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class Parking {


    private BlockingQueue<Car> parkingQueue = new ArrayBlockingQueue<>(10);



    void enterToParking(Car car) {
        if (parkingQueue.remainingCapacity() > 0) {
            parkingQueue.add(car);
            System.out.println(car.toString() + "The car on the parking; Total cars:" + parkingQueue.size());
        } else {
            System.out.println(car.toString() + "Parking is full, going back; Total cars: " + parkingQueue.size());
        }

    }


    void leaveParking(Car car) {
        if (parkingQueue.contains(car)) {
            parkingQueue.remove(car);
            System.out.println(car.toString() + "Leave the parking; Total cars:" + parkingQueue.size());

        }

    }
}

