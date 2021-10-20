/*
 * Kristen Klimisch
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package registration;

import enums.Building;
import enums.Quarter;
import person.Faculty;

/**
 * <p>The <strong>Section</strong> class holds information about a course section.</p>
 * <ul>
 * <li><strong>course:</strong> course associated with the section</li>
 * <li><strong>section:</strong> section number for the course</li>
 * <li><strong>instructor:</strong> instructor for the section (assume single instructor)</li>
 * <li><strong>term:</strong> quarter and year when the section is offered (see Quarter enum)</li>
 * <li><strong>capacity:</strong> capacity for the section</li>
 * <li><strong>location:</strong> building and room where the section is held (see Building enum)</li>
 * </ul>
 * <p>For example, <strong>CPSC 5011-02: Object-Oriented Concepts</strong>
 * <ul>
 * <li><strong>course:</strong> CPSC 5011</li>
 * <li><strong>section:</strong> 02</li>
 * <li><strong>instructor:</strong> Sheila Oh</li>
 * <li><strong>term (quarter/year):</strong> FQ18</li>
 * <li><strong>capacity:</strong> 30</li>
 * <li><strong>location (building/room):</strong> LEML 122</li>
 * </ul>
 * 
 * @author Kristen Klimisch
 * @version 1.0
 */
public class Section {
    private Course course;
    private int section;
    private Faculty instructor;
    private int year;
    private Quarter quarter;
    private int cap;
    private Building bldg;
    private int room;

    /**
     * Constructor for the Section class.
     *
     * @param course     The course associated with the section
     * @param section    The section number for the course
     * @param instructor The faculty instructor teaching the course
     * @param quarter    The quarter that the course section is held 
     * @param year       The year that the course section is held
     * @param cap        The capacity of the course section
     * @param bldg       The building that the course section is held
     * @param room       The room that the course section is held
     */
    public Section(Course course, int section, Faculty instructor, Quarter quarter, 
                    int year, int cap, Building bldg, int room) {
        this.course = course;
        this.section = section;
        this.instructor = instructor;
        this.quarter = quarter;
        this.year = year;
        this.cap = cap;
        this.bldg = bldg;
        this.room = room;
    }

    /**
     * Get method for the section's course.
     *
     * @return the course associated with the section
     */
    public Course getCourse() {
        return course;
    }

    /**
     * Get method for the section's section number.
     *
     * @return the section's section number
     */
    public int getSection() {
        return section;
    }

    /**
     * Get method for the section's instructor.
     *
     * @return the section's instructor
     */
    public Faculty getInstructor(){
        return instructor;
    }

    /**
     * Get method for the section term,
     * which is the quarter and year in which the section is held.
     *
     * @return the section term
     */
    public String getTerm() {
        String term = quarter + " " + year;
        return term;
    }

    /**
     * Get method for the section's capacity.
     *
     * @return the section's capacity
     */
    public int getCapacity() {
        return cap;
    }

    /**
     * Get method for the building in which the section is held.
     *
     * @return the building in which the section is held.
     */
    public Building getBldg() {
        return bldg;
    }

    /**
     * Get method for the room number for the section.
     *
     * @return the room number for the section
     */
    public int getRoom() {
        return room;
    }
}
