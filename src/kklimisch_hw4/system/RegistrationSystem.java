package system;

import enums.Building;
import enums.FacultyType;
import enums.Quarter;
import enums.StudentType;
import enums.SubjectCode;
import enums.StudentProgram;
import exception.*;
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
    private ArrayList<Student> studentList;
    private ArrayList<Faculty> facultyList;
    private Map<SubjectCode, String> subjectList;
    private ArrayList<Course> courseList;
    private ArrayList<Section> sectionList;

    /**
     * Constructor for RegistrationSystem.
     */
    public RegistrationSystem() { 
        studentList = new ArrayList<>();
        facultyList = new ArrayList<>();
        subjectList = new HashMap<>();
        courseList = new ArrayList<>();
        sectionList = new ArrayList<>();
    }

    /**
     * Private helper method to find the index of a faculty member on
     * the faculty array list.
     * Assumption: Each faculty member is uniquely identified by
     * their first and last name.
     *
     * @param firstName  the faculty member's first name.
     * @param lastName   the faculty member's last name.
     * @return the index of the faculty member if found in the faculty list,
     *         else return -1
     */
    private int getFacultyIndex(String firstName, String lastName) {
        for (int i = 0; i < facultyList.size(); i++) {
            if ( (firstName == facultyList.get(i).getFirstName() ) &&
                    (lastName == facultyList.get(i).getLastName() ) ) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Private helper method to find the index of a course on the
     * course list array list. Each course is uniquely identified
     * by the combination of its subject code and course number.
     *
     * @param code the course subject code
     * @param num the course number
     * @return the index of the course if the course is found in the course list,
     *         else return -1
     */
    private int getCourseIndex(SubjectCode code, int num) {
        for (int i = 0; i < courseList.size(); i++) {
            if ( (num == courseList.get(i).getCourseNum() ) &&
                    (code == courseList.get(i).getCode() ) ) {
                return i;
            }
        }
        return -1;
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

        // Create student object.
        Student newStudent = new Student(firstName, lastName);

        // Check if student is already on the list. If they are,
        // throw a duplicate person exception.
        // Assumption: A student with the same first name and last name is a duplicate student.
        for (int i = 0; i < studentList.size(); i++)
            if ( (firstName == studentList.get(i).getFirstName() ) &&
                    (lastName == studentList.get(i).getLastName() ) ) {
                throw new DuplicatePersonException();
            }

        // After verifying that the student isn't already on the list,
        // initialize remaining student object fields.
        newStudent.setEmail(firstName, lastName);
        newStudent.setStudentType(type);
        newStudent.setProgram(program);
        newStudent.setStartTerm(quarter, year);
        newStudent.setFacultyAdvisor(facultyList);
        if (type == StudentType.UNDERGRAD) {
            newStudent.setStudentYear(year);

            // the Student Year field is never initialized for
            // graduate students, meaning the field is left null.
            // If time allows, I'd like to determine a better
            // way of handling this, because leaving the field
            // null could cause issues.
        }

        //Add student to the students list
        studentList.add(newStudent);
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

        // Create Faculty object.
        Faculty member = new Faculty(firstName, lastName);

        // Check if faculty member is already on the list. If they are,
        // throw a duplicate person exception.
        // Assumption: A faculty member with the same first name and last name
        // is a duplicate faculty member.
        for (int i = 0; i < facultyList.size(); i++) {
            if ((firstName == facultyList.get(i).getFirstName()) &&
                    (lastName == facultyList.get(i).getLastName())) {
                throw new DuplicatePersonException();
            }
        }

        // After verifying that the faculty member isn't already on the list,
        // initialize remaining faculty object fields.
        member.setFacultyType(type);
        member.setOffice(bldg, room);
        member.setEmail(email);

        // Add faculty member to list of faculty.
        facultyList.add(member);
    }
    
    /**
     * Adds a subject to the subject list collection.
     * 
     * @param code    The subject code
     * @param desc    The subject description
     *
     * @throws DuplicateSubjectException
     */
    public void addSubject(SubjectCode code, String desc) 
                            throws DuplicateSubjectException {

        // Check if the subject code or description are already on the subject list.
        // If they are, throw a duplicate subject exception. If they are not,
        // add the subject to the subject list.
        if ( (subjectList.containsKey(code) ) || (subjectList.containsValue(desc) ) ) {
            throw new DuplicateSubjectException();
        }
        else {
            subjectList.put(code, desc);
        }
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

        // Create Course object.
        Course newCourse = new Course(code, num, name, creditNum);

        // Check if course is already on the course list.
        // If it is, throw a duplicate course exception.
        // Assumption: A course with the same subject code and
        // course number as a course already on the list is a
        // duplicate course.
        for (int i = 0; i < courseList.size(); i++){
            if ( (num == courseList.get(i).getCourseNum() ) &&
                    (code == courseList.get(i).getCode() ) ) {
                throw new DuplicateCourseException();
            }
        }

        // After verifying that course is not a duplicate course,
        // add course to course list.
        courseList.add(newCourse);
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
     * @
     */
    public void addPrerequisite(SubjectCode code, int num, 
                            SubjectCode prereqCode, int prereqNum) 
                            throws CourseNotFoundException, PrereqCourseNotFoundException {

        // Find index of course to which the prerequisite should be added in
        // the courseList array list. If the course is not found in courseList,
        // throw a Course Not Found Exception.
        int courseIndex = getCourseIndex(code, num);

        // The getCourseIndex method returns -1 if the course is not found
        // in the course list.
        if (courseIndex == -1) {
            throw new CourseNotFoundException();
        }

        // Verify that the prerequisite course can also be found in the course list.
        // The prerequisite course needs to be in the course list because we don't
        // receive the prerequisite course name as an input parameter, so we
        // need to be able to get the prerequisite course name from the course list.
        // If the prerequisite course is not in the course list, throw a
        // Prereq Course Not Found Exception.
        int prereqIndex = getCourseIndex(prereqCode, prereqNum);
        if (prereqIndex == -1) {
          throw new PrereqCourseNotFoundException();
        }

        // Get name of prerequisite course
        String prereqName = courseList.get(prereqIndex).getName();

        // Add prerequisite information to the course.
        courseList.get(courseIndex).setPrerequiste(prereqCode, prereqNum, prereqName);
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

        // Find the index of the course with the subject code and course number entered
        // as input parameters in the courseList array list. The getCourseIndex method
        // returns -1 if the course is not found in the course list. If the course
        // is not found in the course list, throw a Course Not Found Exception.
        int courseIndex = getCourseIndex(code, courseNum);
        if (courseIndex == -1) {
            throw new CourseNotFoundException();
        }

        // Get the course at the specified index in the courseList.
        Course course = courseList.get(courseIndex);

        // Find index of faculty member with the first name and last name entered
        // as input parameters in the facultyList array list. The getFacultyIndex method
        // returns -1 if the faculty member is not found in the faculty list. If the faculty
        // member is not found in the faculty list, throw a Person Not Found Exception.
        int facultyIndex = getFacultyIndex(firstName, lastName);
        if (facultyIndex == -1) {
            throw new PersonNotFoundException();
        }

        // Get the faculty member at the specified index in the facultyList.
        Faculty instructor = facultyList.get(facultyIndex);

        // Create new Section object.
        Section section = new Section(course, sectionNum, instructor, quarter, year, cap, bldg, room);

        // Check if section is already on the section list.
        // If it is, throw a Duplicate Section Exception.
        // Assumption: If a section has the same course subject,
        // code, course number, and section number as a section
        // already on the list, it is a duplicate section.
        for (int i = 0; i < sectionList.size(); i++){
            if ( (courseNum == sectionList.get(i).getCourse().getCourseNum() ) &&
                    (code== sectionList.get(i).getCourse().getCode() ) &&
                    (sectionNum == sectionList.get(i).getSection() ) ) {
                throw new DuplicateSectionException();
            }
        }

        // After verifying that section is not already on the section list,
        // add section to the section list.
        sectionList.add(section);
    }

    /**
     * Method to print the information for every Faculty object in
     * the facultyList array list.
     */
    public void printFacultyList() {
        for (int i = 0; i < facultyList.size(); i++) {
            Faculty f = facultyList.get(i);
            String printFaculty = "Faculty: Name=" + f.getFirstName() + " " +
                                  f.getLastName() + ", " +
                                  "SUID=" + f.getSuid() + ", " +
                                  "Email=" + f.getEmail() + ", " +
                                  "Status=" + f.getStatus() + ", " +
                                  "Type=" + f.getFacultyType() + ", " +
                                  "Office=" + f.getOffice();
            System.out.println(printFaculty);
        }
    }


    /**
     * Method to print the information for every Student object in
     * the studentList array list.
     */
    public void printStudentList() {
        for (int i = 0; i < studentList.size(); i++) {
            Student s = studentList.get(i);
            String printStudent = "Student: Name=" + s.getFirstName() + " " +
                                  s.getLastName() + ", " +
                                  "SUID=" + s.getSuid() + ", " +
                                  "Email=" + s.getEmail() + ", " +
                                  "Status=" + s.getStatus() + ", " +
                                  "Type=" + s.getStudentType() + ", " +
                                  "Program=" + s.getProgram() + ", " +
                                  "Term=" + s.getStartTerm() + ", " +
                                  "Advisor=" + s.getFacultyAdvisor();
            if (s.getStudentType() == StudentType.UNDERGRAD ) {
                printStudent += ", Year=" + s.getStudentYear();
            }
            System.out.println(printStudent);
        }
    }

    /**
     * Method to print every code and description pair in the subjectList
     * hashMap.
     */
    public void printSubjectList() {
        for (var entry :subjectList.entrySet() ) {
              String printSubject = "Subject: " + entry.getValue() +
                                  " (" + entry.getKey() + ")";
            System.out.println(printSubject);
        }
    }

    /**
     * Private helper method for the Print Course List method.
     * Accepts a course object c and prints every prerequisite
     * unique identifier (which is the subject code + the course
     * number) and course name in the prerequisite HashMap.
     * @param c the Course object
     *
     * If time allows, I'd really like to fix the formatting of
     * how these are printed.
     */
    private void printPrerequisites(Course c) {
        Map<String, String> prerequisites = c.getPrerequiste();
        for (var entry :prerequisites.entrySet() ) {
            String prereqInfo = "Name=" + entry.getKey() + ": " +
                                entry.getValue();
            System.out.print(prereqInfo);
        }
    }

    /**
     * Method to print the information for every course in the course list,
     * including the information for the prerequisites for each course.
     */
    public void printCourseList() {
        for (int i = 0; i < courseList.size(); i++) {
            Course c = courseList.get(i);
            String printCourse = "Course: Name=" + c.getCode() + "-" +
                                 c.getCourseNum() + ": " +
                                 c.getName() + ", " +
                                 "Credits=" + c.getCreditNum() + ", " +
                                 "Prerequisites=[";
                                  System.out.print(printCourse);
                                  printPrerequisites(c);
            System.out.println("]");
        }
    }

    public void printSectionList() {
        for (int i=0; i< sectionList.size(); i++) {
            Section sec = sectionList.get(i);
            String printSection = "Section: Course=" + sec.getCourse().getCode() +
                                  "-" + sec.getCourse().getCourseNum() + ": " +
                                  sec.getCourse().getName() + ", " +
                                  "Faculty=" + sec.getInstructor(). getFirstName() + " " +
                                  sec.getInstructor().getLastName() + ", " +
                                  "Term=" + sec.getTerm() + ", " +
                                  "Capacity=" + sec.getCapacity() + ", " +
                                  "Room=" + sec.getBldg() + " " + sec.getRoom();
            System.out.println(printSection);
        }
    }






    
}
