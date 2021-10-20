Kristen Klimisch
CPSC 5011

**Is your asssignment fully working?**
I do believe my solution is fully working. I've identified some areas for future improvement 
in the code, but my solution is functional and meets the assignment specifications.

**Justification for additional classes and comments on design:**
I choose to create a Person superclass that is inherited by the Student and Faculty classes. 
The Person superclass declares and initializes some of the shared fields of the Student
and Faculty classes: first name, last name, SUID, and person status (email is also a shared field,
but the Student and Faculty classes require different methods to set the email, so I chose to 
declare and initialize the email field in the Student and Faculty classes.) 
The primary reason I chose to create  a Person superclass is for the assignment of the SUIDs.
Assigning  the SUIDs in the Person superclass rather than in the Student and Faculty subclasses 
ensures that a Student object  and Faculty object will never be assigned the same SUID.
Note to grader: I added a private static field called instanceCounter to the Person object
to count how many times Faculty and Student objects have been instantiated. I use this field
to ensure that every Faculty and Student object is assigned a unique SUID. Per the
assignment instructions, I got permission from Professor Riley before adding
this private field.

I added the Prereq Course Not Found Exception to my exceptions package so that I could throw 2 
exceptions from my Add Prequisites method to specifically tell the user why their attempt to add
a prerequisite was unsuccessful. The Course Not Found Exception will be thrown if the user attempts
to add a prerequisite to a course that is not in the course list. The Prereq Course Not Found
exception will be thrown if the user attempts to add a prerequisite that is not in the course
list. The user only provides the prerequisite's subject code and course number as input
parameters, but the Registration System also needs to print the prerequisite course's name.
That means that Registration System needs to retrieve the prerequisite course
name from the course list, which isn't possible if the prerequisite course isn't in the 
course list. 

I debated adding an Undergraduate class that would inherit from the Student class,
but ultimately decided against it for the purposes of this assignment. The argument 
for having a separate Undergraduate class is that the "Student Year" field and
is only applicable to the undergraduate students, not graduate students. In my
current program, the Student class has a Student Year field that is never
initialized for students with a Student Type of Graduate. I've implemented
if statements in both my Registration System class and the Student class 
to ensure that the Student Year field is only set and printed for Students 
with a Student Type of Undergraduate, but I'd prefer to not have a
Student Type field for all Student objects when it only applies to undergraduate 
students. However, I didn't know how I'd handle storing Undergraduate students in 
the Registration System if I'd made the Undergraduate students belong to an 
Undergraduate class rather than the Student class; would I create 2 
different student lists, one for graduate students and one for undergraduates?
If I stored both the Student and Undergraduate objects in one array list,
how would I know which type of object I was dealing with when I iterated 
through the list to print the objects? With more time, I would have explored 
these questions, but putting the Student Year field in the Student class and
only initializing it for undergraduate students had already given me a workable solution.
With the time constraints, I decided to just leave the class it was. 

Additionally, per the assignment specifications and Francis Kogge's confirmation on Slack,
I did not include any getter or setter methods in the Person, Student, Faculty, Course,
and Section classes that were not used by the Registration System. 

**Did you work on the extra credit problem?**
I really wanted to work on the extra credit! However, I decided 3 hours before the assignment
was due that I wanted to re-work a key part of my approach for printing the various
collections in the Registration System. Up to that point, all of my methods for printing 
the collections consisted of a series of get() method calls to get the information for the object's 
fields, with String formatting added between each get method call. After seeing Professor Riley's
statement that it's good practice to override the toString() methods for each class, 
I decided to instead implement a toString() method for each class and then repeatedly
call that method as I was printing the collections in the Registration System. 
This took up the rest of my available time, so I was not able to work on the extra credit problem
(and is also the reason for any vestigial get() methods in my classes). 

**How much time did you spend on the assignment?**
I spent approximately 25 hours working on this assignment. I don't know if I'm just slower than
my classmates, but that doesn't seem to be the case based on the conversations I've had. 

**Any feedback on the assignment?**
As with the HW 2, Password Vault, this assignment was an excellent learning experience.
I learned a lot about how classes fit together and interact with each other, and it was
a great exercise to think about which responsibilities should be handled by the Faculty,
Student, Course, and Section classes vs. by the Registration System class. Also as with
HW 2, the scope of this assignment felt substantial to me, and this was a really significant 
time commitment. The FAQ page for the Graduate Certificate in Computer Science Fundamentals
states, "The Certificate program meets 2x/week, with 8-10 hours of work outside of class per week."
Clearly, with me spending 20 hours outside of class on 1 assignment for 1 class, my time commitment
to this program is greatly exceeding 8-10 hours. I'm committed to and really love this program, 
but I'm finding it almost impossible to balance with my full time job. 





