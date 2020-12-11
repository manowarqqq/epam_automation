package enumerations;

public enum Lesson {


    MATHS("Mathematics"), ENGLISH("English"), PHISYCS("Phisycs");

    private String name;


    Lesson(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Lessons{" +
                "name='" + name + '\'' +
                '}';
    }
}
