package registration;

import enums.SubjectCode;
import java.util.*;

/**
 * <p>The <strong>Course</strong> class holds information about a course.</p>
 * <ul>
 * <li><strong>subject code:</strong> subject code of the course (see SubjectCode enum)</li>
 * <li><strong>course number:</strong> course number</li>
 * <li><strong>course name:</strong> course name</li>
 * <li><strong>credit number:</strong> number of credits associated with the course</li>
 * <li><strong>prerequisites:</strong> courses that are prerequisites of this course; may
 *   have multiple or none</li>
 * </ul>
 * <p>For example, <strong>CPSC 5011: Object-Oriented Concepts</strong></p>
 * <ul>
 * <li><strong>subject code:</strong> CPSC</li>
 * <li><strong>course number:</strong> 5011</li>
 * <li><strong>course name:</strong> Object-Oriented Concepts</li>
 * <li><strong>credit number:</strong> 3</li>
 * <li><strong>prerequisite(s):</strong> CPSC 5003</li>
 * </ul>
 * 
 * @author 
 */
public class Course {

    // TODO: add Course fields
    // - subject code (see SubjectCode)
    // - course number
    // - course name
    // - credit number
    // - a collection of prerequisite course(s)

    private SubjectCode code;
    private int courseNum;
    private String name;
    private int creditNum;
    private Map<SubjectCode, Integer> prerequiste;
    // collection of prereqs

    /**
     * Constructor for Course objects.
     *
     * @param code      The subject code of the course
     * @param courseNum The course number of the course
     * @param name      The course name
     * @param creditNum The number of the credits of the course
     */
    public Course(SubjectCode code, int courseNum, String name, 
                    int creditNum) {
        this.code = code;
        this.courseNum = courseNum;
        this.name = name;
        this.creditNum = creditNum;
        prerequiste = new HashMap<>();
    }

    /**
     * Get method for the course's subject code.
     *
     * @return the course's subject code.
     */
    public SubjectCode getCode() {
        return code;
    }

    /**
     * Get method for the course's number.
     *
     * @return the course's number.
     */
    public int getCourseNum() {
        return courseNum;
    }

    /**
     * Get method for course's name.
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Get method for the course's number of credits.
     *
     * @return the course's number of credits.
     */
    public int getCreditNum() {
        return creditNum;
    }

    /**
     * Set method for course prerequisites. Accepts the prerequisite course
     *
     * @param prereqCode
     * @param prereqNum
     */

    public void setPrerequiste(SubjectCode prereqCode, int prereqNum) {

    }

    

    
}

