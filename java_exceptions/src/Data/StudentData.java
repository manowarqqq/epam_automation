package Data;

import Entity.Student;
import Enumerations.GroupName;
import Enumerations.Sex;

import java.util.ArrayList;
import java.util.List;

public class StudentData {


    public static List<Student> getStudentsData(){
        List<Student> list=new ArrayList<>();
        list.add(new Student("Petrov","Petr", Sex.MALE,22,GroupName.D_21));
        list.add(new Student("Semenov","Semen",Sex.MALE,18,GroupName.E_41));
        list.add(new Student("Semenova","Sveta",Sex.FEMALE,19,GroupName.R_21));
        list.add(new Student("Gricuk","Grigory",Sex.MALE,18,GroupName.D_21));
        list.add(new Student("Chemezov","Anton",Sex.MALE,17,GroupName.D_31));
        list.add(new Student("Tinuk","Tatiana",Sex.FEMALE,20,GroupName.R_21));
        list.add(new Student("Stasuk","Dmitry",Sex.MALE,22,GroupName.E_41));
        list.add(new Student("Andreev","Andrey",Sex.MALE,24,GroupName.D_31));
        list.add(new Student("Bolsun","Semen",Sex.MALE,25,GroupName.R_11));
        list.add(new Student("Timchenko","Alex",Sex.MALE,20,GroupName.E_41));
        list.add(new Student("Vanin","Anton",Sex.MALE,22, GroupName.R_11));
        return list;
    }
}
