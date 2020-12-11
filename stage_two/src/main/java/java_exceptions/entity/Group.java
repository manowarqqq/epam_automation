package java_exceptions.entity;

import java_exceptions.exceptions.EmptyGroupException;
import java_exceptions.data.StudentData;
import java_exceptions.enumerations.FacultyName;
import java_exceptions.enumerations.GroupName;
import java_exceptions.exceptions.NoSuchFacultyException;
import java_exceptions.exceptions.NoSuchStudentException;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Group {
    private List<Student> studentList;
    private GroupName groupName;
    private FacultyName facultyName;

    public Group(List<Student> studentList, GroupName groupName, FacultyName facultyName) {
        this.studentList = studentList;
        this.groupName = groupName;
        this.facultyName = facultyName;
    }

    Group(GroupName groupName, FacultyName facultyName) {
        this.groupName = groupName;
        this.facultyName = facultyName;
        setStudents();
    }

    private void setStudents() {
        if (studentList == null) {
            studentList = new ArrayList<>();
            for (int i = 0; i < StudentData.getStudentsData().size(); i++) {
                if (StudentData.getStudentsData().get(i).getGroupName().equals(this.groupName)) {
                    this.studentList.add(StudentData.getStudentsData().get(i));
                }
            }
        }
    }

    public List<Student> addStudentToGroup(Student student) {
        studentList.add(student);
        return studentList;
    }

    public List<Student> removeStudentFromGroup(Student student) throws EmptyGroupException {
        if (studentList == null || studentList.size() == 0) {
            throw new EmptyGroupException("Group " + this.groupName + " is empty");
        }
        studentList.removeIf(s -> s.equals(student));
        return studentList;
    }

    public Student getStudentByName(String firstName, String secondName) throws NoSuchStudentException, EmptyGroupException {
        return getStudentList().stream().filter(student -> student.getFirstName().equals(firstName) && student.getSecondName().equals(secondName))
                .findFirst().orElseThrow(() -> new NoSuchStudentException("Student " + firstName + " " + secondName + " not present"));
    }

    GroupName getGroupName() {
        return groupName;
    }

    public List<Student> getStudentList() throws EmptyGroupException {
        if (studentList == null || studentList.size() == 0) {
            throw new EmptyGroupException("Group " + this.groupName + " can't be empty");
        }
        return studentList;
    }

    @Override
    public String toString() {
        return "Entity.Group{" +
                "studentList=" + studentList +
                ", groupName=" + groupName +
                ", facultyName=" + facultyName +
                '}';
    }
}
