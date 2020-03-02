import java.util.Objects;

public class Student {

    private String firstName;
    private String secondName;
    private Sex sex;
    private int age;



    public Student(String firstName, String secondName, Sex sex, int age) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.sex = sex;
        this.age = age;
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
}
