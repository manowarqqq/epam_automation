public class Runner {
//    Задание. Создать консольное приложение, удовлетворяющее следующим требованиям:
//    Каждый класс должен иметь отражающее смысл название и информативный состав.
//    Использовать возможности ООП: классы, наследование, полиморфизм, инкапсуляция.
//    Наследование должно применяться только тогда, когда это имеет смысл.
//    При кодировании должны быть использованы соглашения об оформлении кода java code convention.
//    Классы должны быть грамотно разложены по пакетам
//    Консольное меню должно быть минимальным.
//    Для хранения параметров инициализации можно использовать файлы.
//  5. Звукозапись. Определить иерархию музыкальных композиций. Записать на диск сборку.
//    Подсчитать продолжительность.
//    Провести перестановку композиций диска на основе принадлежности к стилю.
//    Найти композицию, соответствующую заданному диапазону длины треков.


    public static void main(String[] args) {
        Disk  assembly =new Disk(CompositionData.getCompositionData());
        System.out.println(assembly.getTotalDuration());
        System.out.println(assembly.getDisksCompostionsName());
        assembly.sortByStyle();
        System.out.println(assembly.getDisksCompostionsName());
        System.out.println(assembly.getCompositionFromDurationRange(3.0,4.0));
    }
}