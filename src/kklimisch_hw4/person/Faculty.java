/*
 * Kristen Klimisch
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package person;

import enums.Building;
import enums.FacultyType;

/**
 * <p>The <strong>Faculty</strong> class holds information about a faculty member.</p>
 * <ul>
 * <li><strong>first name:</strong> first name of the faculty</li>
 * <li><strong>last name:</strong> last name of the faculty</li>
 * <li><strong>suid:</strong> SeattleU identification number</li>
 * <li><strong>status:</strong> the status of the faculty (see PersonStatus enum)</li>
 * <li><strong>faculty type:</strong> the type of faculty (see FacultyType enum)</li>
 * <li><strong>office:</strong> includes building (i.e. ENGR) and room number (i.e 504)</li>
 * <li><strong>email:</strong> the school (i.e. SU) email address</li>
 * </ul>
 * <p>For example, faculty <strong>Sheila Oh</strong></p>
 * <ul>
 * <li><strong>first name:</strong> Sheila</li>
 * <li><strong>last name:</strong> Oh</li>
 * <li><strong>suid:</strong> 100013</li>
 * <li><strong>status:</strong> ACTIVE</li>
 * <li><strong>faculty type:</strong> SEN_INSTRUCT</li>
 * <li><strong>office (building/room):</strong> ENGR 504</li>
 * <li><strong>email:</strong> ohsh@seattleu.edu</li>
 * </ul>
 * 
 * @author Kristen Klimisch
 * @version 1.0
 */
public class Faculty extends Person{

    // The following fields are included in the Person superclass:
    // -first name
    // - last name
    // - SUID
    // - status

    private FacultyType facultyType;
    private String office;
    private String email;

    /**
     * Constructor for faculty.
     * @param firstName   The first name of the faculty
     * @param lastName    The last name of the faculty
     */
    public Faculty(String firstName, String lastName) {
        super(firstName, lastName);
    }

    /**
     * Set method for faculty's email.
     *
     * @param email The email address
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Set method for the faculty's Faculty Type.
     *
     * @param type - one of the defined options in the Faculty Type enumerator.
     */
    public void setFacultyType(FacultyType type){
         this.facultyType = type;
    }

    /**
     * Set method for the faculty's office.
     *
     * @param bldg - one of the defined buildings in the Building enumerator.
     * @param room - the room number
     */
    public void setOffice(Building bldg, int room) {
        office = bldg + " " + room;
    }

    /**
     * Method to create a String representation of all the fields in the Student object.
     * String is formatted to match the desired output of the Registration System.
     *
     * @return String representation of the Faculty object
     */
    @Override
    public String toString() {
        String facultyString = "Faculty: Name=" + super.getFirstName() + " " +
                               super.getLastName() + ", " +
                               "SUID=" + super.getSuid() + ", " +
                               "Email=" + email + ", " +
                               "Status=" + super.getStatus() + ", " +
                               "Type=" + facultyType + ", " +
                               "Office=" + office;
        return facultyString;
    }
}
