import customExceptions.EmptyGroupException;
import customExceptions.IllegalMarkArgumentEsception;
import customExceptions.StudentDoesntHaveLesson;
import entity.Group;
import entity.Student;
import entity.University;
import enumerations.FacultyName;
import enumerations.GroupName;
import enumerations.Lesson;

import java.util.List;
import java.util.Random;

public class Runner {

    private static void mockExam(Lesson lesson, Group group) {
        Random rand = new Random();
        List<Student> list = null;
        try {
            list = group.getStudentList();
        } catch (EmptyGroupException e) {
            e.printStackTrace();
        }
        assert list != null;
        for (Student student : list) {
            try {
                student.setMark(lesson, (1 + rand.nextInt(10 - 1)));
            } catch (IllegalMarkArgumentEsception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        University university = new University("GGTU");
        mockExam(Lesson.ENGLISH, university.getFacultyByName(FacultyName.MTF).getGroupByName(GroupName.D_21));
        mockExam(Lesson.ENGLISH, university.getFacultyByName(FacultyName.MTF).getGroupByName(GroupName.D_31));
        mockExam(Lesson.ENGLISH, university.getFacultyByName(FacultyName.MSF).getGroupByName(GroupName.R_11));
        mockExam(Lesson.ENGLISH, university.getFacultyByName(FacultyName.MSF).getGroupByName(GroupName.R_21));
        mockExam(Lesson.ENGLISH, university.getFacultyByName(FacultyName.EF).getGroupByName(GroupName.E_41));
        System.out.println(university.toString());

        try {
            System.out.println(university.getFacultyByName(FacultyName.MSF).getGroupByName(GroupName.R_11).getStudentList().get(0).getMarks());
        } catch (StudentDoesntHaveLesson | EmptyGroupException studentDoesntHaveLesson) {
            studentDoesntHaveLesson.printStackTrace();
        }


    }

}

