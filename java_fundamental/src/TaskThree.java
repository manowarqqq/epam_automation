import java.util.Scanner;

public class TaskThree {

    //3.     Вывести заданное количество случайных чисел с переходом и без перехода на новую строку

    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        System.out.println("Введите колличество чисел");
        int value=scan.nextInt();
        for(int i=value;i>0;i--) {
            //с переходом на новую строку
            System.out.println((int)(Math.random()*10000));

            // без перехода на новую строку
                System.out.print((int)(Math.random()*10000)+ " ");
        }
        scan.close();
    }

}