import java.util.concurrent.*;

public class Run {

    /*
    Автостоянка. Доступно несколько машиномест.
    На одном месте может находиться только один автомобиль.
     Если все места заняты, то автомобиль не станет ждать больше определенного времени и уедет на другую стоянку.
     */


    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor= Executors.newFixedThreadPool(20);
        for(int i=0;i<20;i++) {

            executor.submit(new Car());
        }
        executor.shutdown();
        executor.awaitTermination(1,TimeUnit.DAYS);

    }


}