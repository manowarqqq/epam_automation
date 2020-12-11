package customExceptions;

public class StudentDoesntHaveLesson extends Exception {
    public StudentDoesntHaveLesson(String message) {
        super(message);
    }
}
