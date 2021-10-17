package person;

import enums.*;


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
 * @author 
 */
public class Student extends Person {

    // The following fields are included in the Person superclass:
    // -first name
    // - last name
    // - SUID

    private String email;
    private Quarter quarter;
    private PersonStatus status;
    private StudentType type;
    private StudentProgram program;
    private StudentYear studentYear; // Can I just not initialize this if the StudentType is Graduate?
    private String startTerm;
    private String facultyAdvisor;


    /**
     * Constructor for Student object.
     * @param firstName   The first name of the student
     * @param lastName    The last name of the student
     */
    public Student(String firstName, String lastName) {

        // TODO: implement Student constructor
        super(firstName, lastName);
        email = firstName.toLowerCase() + lastName.toLowerCase() + "@seattleu.edu";
      //  this.type = type;
       // this.program = program;
       // startTerm = quarter + " " + year;

        // Only initialize the student year field for undergraduate students.
       // if (type == StudentType.UNDERGRAD) {
       //     this.studentYear = assignStudentYear(year);
       // }

        // Need to implement this method
       // facultyAdvisor = assignAdvisor();
    }

 //   public setStudentType(StudentType type) {}

    /**
     * Assigns undergraduate students a descriptive student year
     * from one of the defined options in the Student Year enumerator,
     * which are as follows: freshman, sophomore, junior, or senior.
     *
     * @param year
     * @return the descriptive student year
     */
    public StudentYear setStudentYear(int year) {
        // Note: I hardcoded in the translation of year
        // to start term to match the Sample Output.
        // If time allows, I will improve this by
        // determining the student year by computing
        // Now - Start Term.
        if (year == 2016) {
            return StudentYear.SENIOR;
        }
        else if (year == 2017) {
            return StudentYear.JUNIOR;
        }
        else if (year == 2018) {
            return StudentYear.SOPHOMORE;
        }
        else {
            return StudentYear.FRESHMAN;
        }
    }

    public String assignAdvisor() {
        // Iterate through number of faculty on faculty list to get length
        // Assign random number between 0 and at length
        // get faculty member name
        return "hello";
    }

    /**
     * Method to return a String representation of all field in the Person object.
     * String representation uses the format shown in the Sample Output for the
     * Student List in the registration system.
     * @return
     */
    public String toString() {

        String completePersonString = "Student: " + "Name=" + super.getFullName() + ", " +
                "SUID=" + super.getSuid() + ", " + "Email= " + email;
    }

}
