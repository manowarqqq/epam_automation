package java_exceptions.utils;

import java_exceptions.exceptions.EmptyFacultyException;
import java_exceptions.exceptions.EmptyGroupException;
import java_exceptions.exceptions.EmptyUniversityException;
import java_exceptions.exceptions.StudentDoesntHaveLesson;
import java_exceptions.entity.Faculty;
import java_exceptions.entity.Group;
import java_exceptions.entity.Student;
import java_exceptions.entity.University;
import java_exceptions.enumerations.Lesson;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MarkUtils {

    public static Double getAverageMarkInGroup(Lesson lesson, Group group) throws EmptyGroupException, StudentDoesntHaveLesson {
        List<Student> students = group.getStudentList();
        List<Integer> marksBylesson = new ArrayList<>();
        for (Student student : students) {
            marksBylesson.add(student.getMarks().get(lesson));
        }
        return marksBylesson.stream().mapToInt(x -> x).average().orElse(-1);
    }

    public static Double getAverageMarkOnFaculty(Lesson lesson, Faculty faculty) throws StudentDoesntHaveLesson, EmptyFacultyException, EmptyGroupException {
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

    public static Double getAverageMarkInUniversity(Lesson lesson, University university) throws StudentDoesntHaveLesson, EmptyFacultyException, EmptyGroupException, EmptyUniversityException {
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

}
