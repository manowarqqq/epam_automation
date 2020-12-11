package java_exceptions.entity;

import java_exceptions.exceptions.EmptyUniversityException;
import java_exceptions.enumerations.FacultyName;
import java_exceptions.exceptions.NoSuchFacultyException;

import java.util.ArrayList;
import java.util.List;

public class University {

    private String name;
    private List<Faculty> faculties;


    public University(String name) {
        this.name = name;
        setFaculty();
    }


    private void setFaculty() {
        if (faculties == null) {
            faculties = new ArrayList<>();
            FacultyName[] facultyNames = FacultyName.values();
            for (FacultyName facultyName : facultyNames) {
                Faculty facultie = new Faculty(facultyName);
                faculties.add(facultie);
            }
        }
    }


    public List<Faculty> getFaculties() throws EmptyUniversityException {
        if (faculties == null || faculties.size() == 0) {
            throw new EmptyUniversityException("Entity.University can't be empty");
        }
        return faculties;
    }

    public Faculty getFacultyByName(FacultyName name) throws NoSuchFacultyException {
        for (Faculty faculty : faculties) {
            if (faculty.getFacultyName().equals(name)) {
                return faculty;
            }
        }
       throw new NoSuchFacultyException("Faculty " + name + " not present");
    }


    @Override
    public String toString() {
        return "Entity.University{" +
                "name='" + name + '\'' +
                ", faculties=" + faculties +
                '}';
    }
}
