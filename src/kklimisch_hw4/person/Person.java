package person;

import enums.PersonStatus;

/**
 * The Person class can be used to implement Person objects, which contain the
 * shared attributes of the Student and Faculty objects: a first name, last name,
 * an SUID, and a status of active or inactive. The Person class is the superclass
 * for the Student and Faculty classes.
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
     * assigns the person their SUID.
     * @param firstName
     * @param lastName
     */
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        suid = instanceCounter;
        instanceCounter++;
    }

    /**
     * get method for the person's full name.
     * @return the person's full name in String format.
     */
    public String getFullName(){
        return firstName + " " + lastName;
    }

    /**
     * get method for the person's SUID.
     * @return the person's SUID.
     */
    public int getSuid() {
        return suid;
    }

    /**
     * Set method for the person's Person Status.
     * @param status
     */
    public void setStatus (PersonStatus status) {
        this.status = status;
    }

    /**
     * get method for the person's Person Status.
     * @return
     */
    public PersonStatus getStatus() {
        return status;
    }
}

