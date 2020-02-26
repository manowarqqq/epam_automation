public class TaskFour {

    //Ввести целые числа как аргументы командной строки, подсчитать их сумму (произведение) и вывести результат на консоль.

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i < args.length; i++) {
            int temp = Integer.parseInt(args[i]);
            sum += temp;
        }
        System.out.println("SUM = " + sum);
    }
}