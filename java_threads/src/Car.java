
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Car implements Runnable {
    private Model name;
    private Color color;
    public static BlockingQueue parking = new ArrayBlockingQueue<Car>(10);
    Random rand = new Random();


    public Car() {
        this.name = Model.randomModel();
        this.color = Color.randomColor();

    }

    public  void  enterToParking() {

        if (parking.remainingCapacity() > 0) {
            parking.add(this);
            System.out.println(this.toString() + "Заехал на стоянку; машин на стоянке: " + parking.size());
        }
        try {
            Thread.sleep(rand.nextInt(60000));
            parking.add(this);
            System.out.println(this.toString() + "Заехал на стоянку; машин на стоянке: " + parking.size());
        } catch (IllegalStateException | InterruptedException e) {
            System.out.println(this.toString() + "Стоянка полная, уехал; машин на стоянке: " + parking.size());
        }

    }


    public  void leavePrking() {
        if (parking.contains(this)) {
            try {
                Thread.sleep(rand.nextInt(60000));
                parking.remove(this);
                System.out.println(this.toString() + "Выехал со стоянки; машин на стоянке:" + parking.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("????");
            }
        }


    }

    @Override
    public String toString() {
        return "Car{" +
                "name=" + name +
                ", color=" + color +
                '}';
    }

    @Override
    public void run() {
        this.enterToParking();
        this.leavePrking();
    }
}
