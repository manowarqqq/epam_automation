import CustomExceptions.EmptyGroupException;
import CustomExceptions.StudentDoesntHaveLesson;
import Entity.University;
import Enumerations.FacultyName;
import Enumerations.GroupName;
import Enumerations.Lesson;

public class Runner {


    public static void main(String[] args)  {

        University university = new University("GGTU");
        Exam englishExam = new Exam(Lesson.ENGLISH, university.getFacultyByName(FacultyName.MTF).getGroupByName(GroupName.D_21));
        englishExam = new Exam(Lesson.ENGLISH, university.getFacultyByName(FacultyName.MTF).getGroupByName(GroupName.D_31));
        englishExam = new Exam(Lesson.ENGLISH, university.getFacultyByName(FacultyName.MSF).getGroupByName(GroupName.R_11));
        englishExam = new Exam(Lesson.ENGLISH, university.getFacultyByName(FacultyName.MSF).getGroupByName(GroupName.R_21));
        englishExam = new Exam(Lesson.ENGLISH, university.getFacultyByName(FacultyName.EF).getGroupByName(GroupName.E_41));
        System.out.println(university.toString());

        try {
            System.out.println(university.getFacultyByName(FacultyName.MSF).getGroupByName(GroupName.R_11).getStudentList().get(0).getMarks());
        } catch (StudentDoesntHaveLesson | EmptyGroupException studentDoesntHaveLesson) {
            studentDoesntHaveLesson.printStackTrace();
        }




    }

}
