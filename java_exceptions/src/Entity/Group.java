package Entity;

import CustomExceptions.EmptyGroupException;
import Data.StudentData;
import Entity.Student;
import Enumerations.FacultyName;
import Enumerations.GroupName;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private List<Student> studentList;
    private GroupName groupName;
    private FacultyName facultyName;

    public Group(List<Student> studentList, GroupName groupName, FacultyName facultyName) {
        this.studentList = studentList;
        this.groupName = groupName;
        this.facultyName = facultyName;
    }

    public Group(GroupName groupName, FacultyName facultyName) {
        this.groupName = groupName;
        this.facultyName = facultyName;
        setStudents();
    }

    public void setStudents() {
        if (studentList == null) {
            studentList = new ArrayList<>();
for(int i = 0; i< StudentData.getStudentsData().size(); i++) {
    if(StudentData.getStudentsData().get(i).getGroupName().equals(this.groupName)) {
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
        if(studentList==null || studentList.size()==0) {
            throw  new EmptyGroupException("Entity.Group can't be empty");
        }
        studentList.removeIf(s -> s.equals(student));
        return studentList;
    }

    public GroupName getGroupName() {
        return groupName;
    }

    public List<Student> getStudentList() throws EmptyGroupException {
        if(studentList==null || studentList.size()==0) {
            throw  new EmptyGroupException("Entity.Group can't be empty");
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
