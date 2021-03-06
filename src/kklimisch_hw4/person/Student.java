/*
 * Kristen Klimisch
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package person;
import enums.Quarter;
import enums.StudentProgram;
import enums.StudentType;
import enums.StudentYear;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.Random;

/**
 * <p>The <strong>Student</strong> class holds information about a student.</p>
 * <ul>
 * <li><strong>first name:</strong> first name of the student</li>
 * <li><strong>last name:</strong> last name of the student</li>
 * <li><strong>suid:</strong> Seattle U identification number</li>
 * <li><strong>status:</strong> the status of the student (see PersonStatus enum)</li>
 * <li><strong>student type:</strong> a student can only be assigned a single student type
 *   (see StudentType enum)</li>
 * <li><strong>student program:</strong> a student can only be assigned to a single program at 
 *   a point of time, but can switch from one program to another (i.e. when 
 *   they've graduated from a program (see StudentProgram enum)</li>
 * <li><strong>student year:</strong> only relevant for undergraduates (see StudentYear enum)</li>
 * <li><strong>start term:</strong> associated with the quarter and year a student starts a
 *   particular program; for example, a single student may start the CERT in 
 *   RQ17 and then continue the MSCS in FQ18 (see Quarter enum)</li>
 * <li><strong>faculty advisor:</strong> students are assigned a faculty advisor, but may switch 
 *   advisors (i.e. faculty leaves or on sabbatical); may not be assigned an
 *   advisor for a period of time when first enrolled as a student</li>
 * <li><strong>email:</strong> the school (i.e. SU) email address</li>
 * </ul>
 * <p>For example, student <strong>Ada Lovelace</strong></p>
 * <ul>
 * <li><strong>first name:</strong> Ada</li>
 * <li><strong>last name:</strong> Lovelace</li>
 * <li><strong>suid:</strong> 100027</li>
 * <li><strong>status:</strong> ACTIVE</li>
 * <li><strong>student type:</strong> GRAD</li>
 * <li><strong>student program:</strong> CERT</li>
 * <li><strong>student year:</strong> </li>
 * <li><strong>start term:</strong> FQ 2018</li>
 * <li><strong>faculty advisor:</strong> Lin Li</li>
 * <li><strong>email:</strong> adalovelace@seattleu.edu</li>
 * </ul>
 * <p>And student <strong>Buster Bluth</strong></p>
 * <ul>
 * <li><strong>first name:</strong> Buster</li>
 * <li><strong>last name:</strong> Bluth</li>
 * <li><strong>suid:</strong> 100020</li>
 * <li><strong>status:</strong> ACTIVE</li>
 * <li><strong>student type:</strong> UNDERGRAD</li>
 * <li><strong>student program:</strong> BSCS</li>
 * <li><strong>student year:</strong> SOPHOMORE</li>
 * <li><strong>start term:</strong> WQ 2018</li>
 * <li><strong>faculty advisor:</strong> Roshanak Roshandel</li>
 * <li><strong>email:</strong> busterbluth@seattleu.edu</li>
 * </ul>
 * 
 * @author Kristen Klimisch
 * @version 1.0
 */
public class Student extends Person {

    // The following fields are included in the Person superclass:
    // -first name
    // - last name
    // - SUID
    // - status

    private String email;
    private StudentType studentType;
    private StudentProgram program;
    private StudentYear studentYear;
    private String startTerm;
    private Faculty advisor;

    /**
     * Constructor for Student object.
     *
     * @param firstName The first name of the student
     * @param lastName  The last name of the student
     */
    public Student(String firstName, String lastName) {
        super(firstName, lastName);
    }

    /**
     * Set method for student's email.
     *
     * @param firstName The first name of the student.
     * @param lastName  The last name of the student.
     */
    public void setEmail(String firstName, String lastName) {
        email = firstName.toLowerCase() + lastName.toLowerCase() + "@seattleu.edu";
    }

    /**
     * Set method for the student's Student Type.
     *
     * @param studentType - one of the defined options in the Student Type enumerator.
     */
    public void setStudentType(StudentType studentType) {
        this.studentType = studentType;
    }

    /**
     * Set method for the student's program.
     *
     * @param program - one of the defined options in the Student Program enumerator.
     */
    public void setProgram(StudentProgram program) {
        this.program = program;
    }

    /**
     * Computes the number of years an undergraduate student has been in school
     * and uses it to assign the student a descriptive student year
     * from one of the defined options in the Student Year enumerator,
     * which are as follows: freshman, sophomore, junior, or senior.
     * <p>
     * This method should only be used for students with a student type
     * of Undergraduate.
     * <p>
     * I didn't have time to do this for this assignment, but a future
     * improvement I could make to this method would be to incorporate
     * the entire start term (quarter and year)
     * into the computation of the number of years an undergraduate
     * student has been in school. The current computation just uses
     * the start year.
     *
     * @param year - the year in which the student started their current
     *             program
     * @return the descriptive student year
     */
    public void setStudentYear(int year) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int yearsInSchool = currentYear - year;
        if (yearsInSchool > 3) {
            this.studentYear = studentYear.SENIOR;
        } else if (yearsInSchool > 2) {
            this.studentYear = studentYear.JUNIOR;
        } else if (yearsInSchool > 1) {
            this.studentYear = studentYear.SOPHOMORE;
        } else {
            this.studentYear = studentYear.FRESHMAN;
        }
    }

    /**
     * Set method for the student's start term;
     *
     * @param quarter
     * @param year
     */
    public void setStartTerm(Quarter quarter, int year) {
        startTerm = quarter + " " + year;
    }

    /**
     * Accepts a list of active faculty members and randomly assigns
     * the student an advisor from the list.
     *
     * @param faculty an array list of active faculty members
     */
    public void setFacultyAdvisor(ArrayList<Faculty> faculty) {
        Random rand = new Random();

        // Randomly select the index of one of the faculty members in the
        // array list of active faculty members.
        int facultyIndex = rand.nextInt(faculty.size() - 1);

        // Set the Student's advisor to be the faculty member at
        // the randomly-assigned index.
        advisor = faculty.get(facultyIndex);
    }

    /**
     * Method to create a String representation of all the fields in the Student object.
     * String is formatted to match the desired output of the Registration System.
     *
     * @return String representation of the Student object
     */
    @Override
    public String toString() {
        String studentString = "Student: Name=" + super.getFirstName()+ " " +
                                super.getLastName() + ", " +
                               "SUID=" + super.getSuid() + ", " +
                               "Email=" + email + ", " +
                               "Status=" + super.getStatus() + ", " +
                               "Type=" + studentType + ", " +
                               "Program=" + program + ", " +
                               "Term=" + startTerm + ", " +
                               "Advisor=" + advisor.getFirstName() + " " + advisor.getLastName();
        if (studentType == StudentType.UNDERGRAD) {
            studentString += ", Year=" + studentYear;
        }
        return studentString;
    }
}


