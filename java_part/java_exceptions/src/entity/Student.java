package entity;

import customExceptions.IllegalMarkArgumentEsception;
import customExceptions.StudentDoesntHaveLesson;
import enumerations.GroupName;
import enumerations.Lesson;
import enumerations.Sex;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Student {

    private String firstName;
    private String secondName;
    private Sex sex;
    private int age;
    private GroupName groupName;

    private Map<Lesson, Integer> marks;


    public Student(String firstName, String secondName, Sex sex, int age, GroupName groupName) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.sex = sex;
        this.age = age;
        this.groupName = groupName;
        this.marks = new HashMap<>();
    }

    public void setMark(Lesson lesson, Integer mark) throws IllegalMarkArgumentEsception {
        if (mark > 0 && mark <= 10) {
            this.marks.put(lesson, mark);
        } else throw new IllegalMarkArgumentEsception("Incorrect Mark by student " + this.firstName + " in " + lesson);
    }

    GroupName getGroupName() {
        return groupName;
    }

    public Map<Lesson, Integer> getMarks() throws StudentDoesntHaveLesson {
        if (marks.size() > 0) {
            return marks;
        } else throw new StudentDoesntHaveLesson("Student " + this.firstName + " has to have at least one lesson");

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                firstName.equals(student.firstName) &&
                secondName.equals(student.secondName) &&
                sex == student.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, sex, age);
    }

    @Override
    public String toString() {
        return "Entity.Student{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", groupName=" + groupName +
                ", marks=" + marks +
                '}';
    }
}
