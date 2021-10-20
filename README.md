I choose to create a Person superclass that is inherited by the Student and Faculty classes. 
The Person superclass declares and initializes some of the shared fields of the Student
and Faculty classes: first name, last name, SUID, and person status (email is also a shared field,
but the Student and Faculty classes require different methods to set the email, so I chose to 
declare the email field in the Student and Faculty classes.) The primary reason I chose to create 
a Person superclass is for the assignment of the SUIDs. Assigning  the SUIDs in the Person 
superclass rather than in the Student and Faculty subclasses ensures that a Student object 
and Faculty object will never be assigned the same SUID. 

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

To do: Explain why didn't make a separate object for undergraduate students

Note to grader: I added a private static field called instanceCounter to the Person object 
to count how many times Faculty and Student objects have been instantiated. I use this field
to ensure that every Faculty and Student object is assigned a unique SUID. Per the
assignment instructions, I got permission from Professor Riley before adding
this private field.