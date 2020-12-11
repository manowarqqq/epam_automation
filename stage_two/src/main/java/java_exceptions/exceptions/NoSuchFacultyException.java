package java_exceptions.exceptions;

import java.util.function.Supplier;

public class NoSuchFacultyException extends Exception  {

    public NoSuchFacultyException(String message) {
        super(message);
    }

}
