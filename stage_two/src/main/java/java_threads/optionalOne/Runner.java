package main.java.java_threads.optionalOne;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*    � ��������� ���� 5 �������-���������� �����. �������� ��������� 3 ������ ����� ����� �� ������, ������� �������� � ��������.
      ����� ����� ������ �������� ��� ������ ���������� ��������. ����������� ��������� ������ 10 ��������� ��������� ��� ��������� ������.
      1 ������ ������� ������� �������� �� 1 ������� � ���������. ������� � ������� ���������� � ��������� ��������:
      ������� ����� ����� �� ������
      ������� �������
      ������ "�������" �������
      ������ ������������
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
