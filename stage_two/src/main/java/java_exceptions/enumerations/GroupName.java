package java_exceptions.enumerations;

public enum GroupName {
    D_21(FacultyName.MTF), D_31(FacultyName.MTF), R_11(FacultyName.MSF), R_21(FacultyName.MSF), E_41(FacultyName.EF);

    private FacultyName facultyName;

    GroupName(FacultyName facultyName) {
        this.facultyName = facultyName;
    }

    public FacultyName getFacultyName() {
        return facultyName;
    }
}
