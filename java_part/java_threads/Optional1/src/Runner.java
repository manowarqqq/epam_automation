import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*    В аэропорту есть 5 взлетно-посадочных полос. Самолету требуется 3 минуты чтобы выйти на полосу, набрать скорость и взлететь. После этого полоса свободна для вылета следующего самолета. Реализовать симуляцию вылета 10 самолетов используя все доступные полосы. 1 минуту реально времени заменить на 1 секунду в симуляции. Вывести в консоль информацию о следующих событиях:
    Самолет начал выход на полосу
    Самолет взлетел
    Полоса "приняла" самолет
    Полоса освободилась
*/

public class Runner {

    public static void main(String[] args) {
        AirPort airPort =AirPort.getAirport();
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i =0; i<10;i++) {
            executorService.submit(() -> {
                airPort.working(new Plane());
            });
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
