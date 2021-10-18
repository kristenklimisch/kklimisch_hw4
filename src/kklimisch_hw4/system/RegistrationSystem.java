package system;

import enums.Building;
import enums.FacultyType;
import enums.Quarter;
import enums.StudentType;
import enums.SubjectCode;
import enums.StudentProgram;
import exception.CourseNotFoundException;
import exception.DuplicateCourseException;
import exception.DuplicatePersonException;
import exception.DuplicateSubjectException;
import exception.PersonNotFoundException;
import exception.DuplicateSectionException;
import person.Student;
import person.Faculty;
import registration.Course;
import registration.Section;
import java.util.*;

/**
 * <p>The <strong>RegistrationSystem</strong> class stores information about the school, 
 * including the ability to add students, add faculty, add courses, and add prerequisite(s).</p>
 * 
 * @author ohsh
 */
public class RegistrationSystem {
    private ArrayList<Student> students;
    private ArrayList<Faculty> faculty;


    /**
     * Constructor for RegistrationSystem.
     */
    public RegistrationSystem() { 
        students = new ArrayList<>();


        // TODO: implement RegistrationSystem constructor
    
    }
    
    /**
     * Add a student to the student list collection.
     * 
     * @param firstName  The first name of the student
     * @param lastName   The last name of the student
     * @param type       The student type
     * @param program    The student program    
     * @param quarter    The start quarter of the student
     * @param year       The start year of the student
     * @throws DuplicatePersonException The person is already in the system
     */
    public void addStudent(String firstName, String lastName, 
                            StudentType type, StudentProgram program,
                            Quarter quarter, int year) 
                            throws DuplicatePersonException {
        
        // Create student object and initialize all fields.
        Student student = new Student(firstName, lastName);
        student.setStudentType(type);
        student.setProgram(program);
        student.setStartTerm(quarter, year);
        student.setFacultyAdvisor();
        if (type == StudentType.UNDERGRAD) {
            student.setStudentYear(year);

            // the Student Year field is never initialized for
            // graduate students, meaning the field is left null.
            // If time allows, I'd like to determine a better
            // way of handling this, because leaving the field
            // null could cause issues.
        }

        // NEED to write code to check if there is a duplicate person on the list
        // This is just stand in code for testing
        if (year == 2020){
            throw new DuplicatePersonException();
        }

        // Add student to list
        //Add student to the students list
        students.add(student);
    }
    
    /**
     * Add a faculty to the faculty list collection.
     * 
     * @param firstName   The first name of the faculty
     * @param lastName    The last name of the faculty
     * @param type        The faculty type
     * @param bldg        The building of the faculty office
     * @param room        The (building) room of the faculty office
     * @param email       The email of the faculty
     * @throws DuplicatePersonException The person is already in the system
     */
    public void addFaculty(String firstName, String lastName,
                            FacultyType type, Building bldg, int room, String email) 
                            throws DuplicatePersonException {    
        
        // TODO: implement addFaculty method
    
    }
    
    /**
     * Adds a subject to the subject list collection.
     * (hint: use a Map instead of creating a class)
     * 
     * @param code    The subject code
     * @param desc    The subject description
     * 
     * @throws DuplicateSubjectException The subject is already in the system
     */
    public void addSubject(SubjectCode code, String desc) 
                            throws DuplicateSubjectException {
        
        // TODO: implement addSubject method
    
    }
    
    /**
     * Adds a course to the course list collection.
     * 
     * @param code       The subject code of the course
     * @param num        The course number of the course
     * @param name       The course name
     * @param creditNum  The number of the credits of the course
     * @throws DuplicateCourseException    The course is already in the system 
     */
    public void addCourse(SubjectCode code, int num, String name, 
                            int creditNum) throws DuplicateCourseException {
        
        // TODO: implement addCourse method
    
    }
    
    /**
     * Adds a prerequisite to an existing course in the course
     * list collection.
     * 
     * @param code          The subject code of the course
     * @param num           The course number of the course
     * @param prereqCode    The subject code of the prerequisite
     *                      to add to the course
     * @param prereqNum     The course number of the prerequisite
     *                      to add to the course
     * @throws CourseNotFoundException The course was not found in the system
     */
    public void addPrerequisite(SubjectCode code, int num, 
                            SubjectCode prereqCode, int prereqNum) 
                            throws CourseNotFoundException {
        
        // TODO: implement addPrerequisite method
    
    }
    
    /**
     * Adds a section to the section list collection.
     * 
     * @param code       The subject code of the course
     * @param courseNum  The course number of the course
     * @param sectionNum The section number for the course
     * @param firstName  The first name for the faculty teaching the course
     * @param lastName   The last name for the faculty teaching the course
     * @param quarter    The quarter that the course section is held 
     * @param year       The year that the course section is held
     * @param cap        The capacity of the course section
     * @param bldg       The building that the course section is held
     * @param room       The room that the course section is held
     * @throws CourseNotFoundException   The course was not found in the system
     * @throws PersonNotFoundException   The person was not found in the system
     * @throws DuplicateSectionException The section is already in the system
     */
    public void addSection(SubjectCode code, int courseNum, int sectionNum,
                            String firstName, String lastName, Quarter quarter, int year, 
                            int cap, Building bldg, int room) 
                            throws CourseNotFoundException, PersonNotFoundException, DuplicateSectionException {


        // TODO: implement addSection method
    
    }

    /**
     * Method to print the information for every Student object in
     * the students array list.
     */
    public void printStudentList() {
        for (int i = 0; i < students.size(); i++) {
            Student listStudent = students.get(i);
            String printStudent = "Student: Name= " + listStudent.getFullName() + ", " +
                                  "SUID= " + listStudent.getSuid() + ", " +
                                  "Email= " + listStudent.getEmail() + ", " +
                                  "Status= " + listStudent.getStatus() + ", " +
                                  "Type= " + listStudent.getStudentType() + ", " +
                                  "Program = " + listStudent.getProgram() + ", " +
                                  "Term= " + listStudent.getStartTerm() + ", " +
                                  "Advisor= " + listStudent.getFacultyAdvisor();
            if (listStudent.getStudentType() == StudentType.UNDERGRAD ) {
                printStudent += ", Year=" + listStudent.getStudentYear();
            }
            System.out.println(printStudent);
        }
    }


    
    
    // TODO: add RegistrationSystem collections
    // - student list
    // - faculty list
    // - subject list
    // = course list
    // - section list
    // 
    // Note -- there is no list for prerequisites - these should be included 
    // as part of the course list


    
}
