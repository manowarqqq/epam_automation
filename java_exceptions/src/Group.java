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
    }

    public List<Student> addStudentToGroup(Student student){
        studentList.add(student);
        return studentList;
    }

    public List<Student> removeStudentFromGroup(Student student){
        studentList.removeIf(student1 -> student.equals(student) );
        return studentList;
    }


}
