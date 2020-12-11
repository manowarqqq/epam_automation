package utils;

import customExceptions.EmptyFacultyException;
import customExceptions.EmptyGroupException;
import customExceptions.EmptyUniversityException;
import customExceptions.StudentDoesntHaveLesson;
import entity.Faculty;
import entity.Group;
import entity.Student;
import entity.University;
import enumerations.Lesson;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.OptionalDouble;

public class MarkUtils {

    public static Double getAverageMark(Lesson lesson, Group group) throws EmptyGroupException, StudentDoesntHaveLesson {
        List<Student> students = group.getStudentList();
        List<Integer> marksBylesson = new ArrayList<>();
        for (Student student : students) {
            marksBylesson.add(student.getMarks().get(lesson));
        }
        return marksBylesson.stream().mapToInt(x -> x).average().orElse(-1);
    }

    public static Double getAverageMark(Lesson lesson, Faculty faculty) throws StudentDoesntHaveLesson, EmptyFacultyException, EmptyGroupException {
        List<Group> groups = faculty.getGroups();
        List<Student> students = new ArrayList<>();
        for (Group group : groups) {
            students = group.getStudentList();
        }
        List<Integer> marksBylesson = new ArrayList<>();
        for (Student student : students) {
            marksBylesson.add(student.getMarks().get(lesson));
        }
        return marksBylesson.stream().mapToInt(x -> x).average().orElse(-1);
    }

    public static Double getAverageMark(Lesson lesson, University university) throws StudentDoesntHaveLesson, EmptyFacultyException, EmptyGroupException, EmptyUniversityException {
        List<Faculty> faculties = university.getFaculties();
        List<Group> groups = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        List<Integer> marksByless = new ArrayList<>();
        for (Faculty faculty : faculties) {
            groups.addAll(faculty.getGroups());
        }
        for (Group group : groups) {
            students.addAll(group.getStudentList());
        }

        for (Student student : students) {
            marksByless.add(student.getMarks().get(lesson));
        }
        return marksByless.stream().filter(Objects::nonNull).mapToInt(x -> x).average().orElse(-1);
    }


    public static Double getAverageMark(Student student) throws StudentDoesntHaveLesson {
        return student.getMarks().values().stream().mapToInt(x -> x).average().orElse(-1);


    }
}
