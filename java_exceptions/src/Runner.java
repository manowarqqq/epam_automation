public class Runner {
    public static void main(String[] args) {
        Group firstGroup=new Group(GroupName.D_21,FacultyName.MTF);
        firstGroup.addStudentToGroup(new Student("Victor","Bystrov", Sex.MALE,31));
        firstGroup.addStudentToGroup(new Student("Petr","Petrev", Sex.MALE,22));


    }

}
