/*
 * Kristen Klimisch
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package person;

import enums.PersonStatus;

/**
 * The Person class can be used to implement Person objects, which contain the
 * shared attributes of the Student and Faculty objects: a first name, last name,
 * an SUID, and a status of active or inactive. The Person class is the superclass
 * for the Student and Faculty classes.
 *
 * Note: I didn't include a toString method for the Person class because it can't
 * be invoked in the Student and Faculty subclasses' toString() methods.
 * The Student and Faculty subclasses' toString() methods insert the
 * student's or faculty's email between their name & SUID and their status,
 * so the Student and Faculty subclasses just invoke the get() methods for
 * the Person superclass' fields so that they can create a String representation
 * with the desired format.
 *
 * @author Kristen Klimisch
 * @version 1.0
 */
public class Person {
    private String firstName;
    private String lastName;
    private static int instanceCounter = 100000; // Start at 100000 to replicate Sample Output
    private int suid = 0;
    private PersonStatus status;

    /**
     * Constructor for the Person class. Accepts the first name
     * and last name of the person as input parameters and then
     * assigns the person their SUID and a person status of "Active."
     * @param firstName
     * @param lastName
     */
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        suid = instanceCounter;
        instanceCounter++;
        status = PersonStatus.ACTIVE;
    }

    /**
     * Get method for the person's first name.
     * @return the person's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Get method for the person's last name.
     * @return the person's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * get method for the person's SUID.
     * @return the person's SUID.
     */
    public int getSuid() {
        return suid;
    }


    /**
     * get method for the person's Person Status.
     * @return
     */
    public PersonStatus getStatus() {
        return status;
    }
}

