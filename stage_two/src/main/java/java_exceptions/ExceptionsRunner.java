package java_exceptions;

import java_exceptions.entity.Faculty;
import java_exceptions.exceptions.*;
import java_exceptions.entity.Group;
import java_exceptions.entity.Student;
import java_exceptions.entity.University;
import java_exceptions.enumerations.FacultyName;
import java_exceptions.enumerations.GroupName;
import java_exceptions.enumerations.Lesson;
import java_exceptions.utils.MarkUtils;


import java.util.List;
import java.util.Random;

public class ExceptionsRunner {

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
        try {
            University university = new University("GGTU");
            Student testStudent = university.getFacultyByName(FacultyName.MTF).getGroupByName(GroupName.D_21).getStudentByName("Petrov", "Petr");
            Faculty MTF = university.getFacultyByName(FacultyName.MTF);
            Group D21 = university.getFacultyByName(FacultyName.MTF).getGroupByName(GroupName.D_21);
            mockExam(Lesson.ENGLISH, university.getFacultyByName(FacultyName.MTF).getGroupByName(GroupName.D_21));
            mockExam(Lesson.ENGLISH, university.getFacultyByName(FacultyName.MTF).getGroupByName(GroupName.D_31));
            mockExam(Lesson.ENGLISH, university.getFacultyByName(FacultyName.MSF).getGroupByName(GroupName.R_11));
            mockExam(Lesson.ENGLISH, university.getFacultyByName(FacultyName.MSF).getGroupByName(GroupName.R_21));
            mockExam(Lesson.MATHS, university.getFacultyByName(FacultyName.EF).getGroupByName(GroupName.E_41));

            System.out.println(MarkUtils.getAverageMarkInUniversity(Lesson.ENGLISH, university));
            System.out.println(MarkUtils.getAverageMarkOnFaculty(Lesson.ENGLISH, MTF));
            System.out.println(MarkUtils.getAverageMarkInGroup(Lesson.ENGLISH, D21));
            System.out.println(testStudent.getAverageMark());

        } catch (StudentDoesntHaveLesson | EmptyGroupException | EmptyUniversityException | NoSuchFacultyException | NoSuchGroupException | EmptyFacultyException | NoSuchStudentException exception) {
            exception.printStackTrace();
        }
    }

}

