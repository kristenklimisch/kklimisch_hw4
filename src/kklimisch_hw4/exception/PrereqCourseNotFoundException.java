/*
 * Kristen Klimisch
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package exception;

/**
 * This exception is thrown when a user attempts to add a prerequisite that is
 * not in the Registration System.
 *
 * @author Kristen Klimisch
 * @version 1.0
 */
public class PrereqCourseNotFoundException extends Exception {

    public PrereqCourseNotFoundException(String msg) {
        super(msg);
    }

    public PrereqCourseNotFoundException() {
        this("The section code and course number entered for the prerequisite course \n" +
                "does not match any course in the Registration System.");
    }
}
