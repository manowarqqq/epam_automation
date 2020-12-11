package entity;

import customExceptions.EmptyFacultyException;
import entity.Group;
import enumerations.FacultyName;
import enumerations.GroupName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Faculty {

    private FacultyName facultyName;
    private List<Group> groups;

    public Faculty(FacultyName facultyName) {
        this.facultyName = facultyName;
        setGroups();
    }

    private void setGroups() {
        if (groups == null) {
            groups = new ArrayList<>();
            List<GroupName> groupNames = Arrays.stream(GroupName.values()).filter(g -> g.getFacultyName().equals(this.facultyName)).collect(Collectors.toList());
            for (GroupName groupName : groupNames) {
                Group group = new Group(groupName, this.facultyName);
                groups.add(group);
            }
        }
    }


    public List<Group> getGroups() throws EmptyFacultyException {
        if (groups == null || groups.size() == 0) {
            throw new EmptyFacultyException("Faculty " + this.facultyName + " can't be empty");
        }
        return groups;
    }


    public Group getGroupByName(GroupName name) {
        for (Group group : groups) {
            if (group.getGroupName().equals(name)) {
                return group;
            }
        }
        return null;
    }


    public FacultyName getFacultyName() {
        return facultyName;
    }

    @Override
    public String toString() {
        return "Entity.Faculty{" +
                "facultyName=" + facultyName +
                ", groups=" + groups +
                '}';
    }
}
