import CustomExceptions.EmptyGroupException;
import CustomExceptions.IllegalMarkArgumentEsception;
import Entity.Group;
import Entity.Student;
import Enumerations.Lesson;

import java.util.List;
import java.util.Random;

public class Exam {

    public  Exam(Lesson lesson, Group group)  {
        Random rand=new Random();
        List<Student> list= null;
        try {
            list = group.getStudentList();
        } catch (EmptyGroupException e) {
            e.printStackTrace();
        }
        for(Student student:list) {
           try {
               student.setMark(lesson, (1+rand.nextInt(10-1)));
           } catch (IllegalMarkArgumentEsception e) {
               e.printStackTrace();
           }

       }
    }
}
