/*
 * Kristen Klimisch
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
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
 * @author Kristen Klimisch
 * @version 1.0
 */
public class Course {
    private SubjectCode code;
    private int courseNum;
    private String name;
    private int creditNum;
    private Map<String, String> prerequiste;
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
     * Set method for course prerequisites. Creates a unique String identifier
     * for the prerequisite course that consists of the prerequisite subject
     * code and course number. Adds this unique identifier and the prerequisite
     * course name as key-value pair to the prerequisite HashMap.
     *
     * @param prereqCode
     * @param prereqNum
     * @param prereqName
     */

    public void setPrerequiste(SubjectCode prereqCode, int prereqNum, String prereqName) {
        String prereqIdentifier = prereqCode + "-" + prereqNum;
        prerequiste.put(prereqIdentifier, prereqName);
    }

    /**
     * Private helper method for the toString() method.
     * Creates a String representation of all unique identifiers and
     * course names in the prerequisite HashMap.
     *
     * @return a String representation of all unique identifiers and
     *         course names in the prerequisite HashMap.
     */
    private String prereqToString() {

        // Count of total entries in the prerequisite HashMap.
        int totalEntries = prerequiste.size();

        // Count of the number of entries in the map that
        // have been access through the for loop below.
        int entryCounter = 1;

        String prereqInfo = "";

        for (var entry :prerequiste.entrySet() ) {
            prereqInfo = "Name=" + entry.getKey() + ": " +
                         entry.getValue();

            // Print a comma after each entry except the last entry
            // in the map.
            if (entryCounter != totalEntries) {
                prereqInfo += (", ");
            }
        }
        return prereqInfo;
    }

    /**
     * Method to create a String representation of all fields in the course object,
     * including all key-value pairs in the prerequisite HashMap.
     *
     * @return a String representation of the course object.
     */
    @Override
    public String toString() {
        String courseString = "Course: Name=" + code + "-" +
                courseNum+ ": " +
                name + ", " +
                "Credits=" + creditNum + ", " +
                "Prerequisites=[";
        courseString += prereqToString()+ ("]");
        return courseString;
    }
}

