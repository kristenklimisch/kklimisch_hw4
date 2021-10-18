I choose to create a Person superclass that is inherited by the Student and Faculty classes. 
The Person superclass declares and initializes some of the shared fields of the Student
and Faculty classes: first name, last name, SUID, and person status (email is also a shared field,
but the Student and Faculty classes require different methods to set the email, so I chose to 
declare the email field in the Student and Faculty classes.) The primary reason I chose to create 
a Person superclass is for the assignment of the SUIDs. Assigning  the SUIDs in the Person 
superclass rather than in the Student and Faculty subclasses ensures that a Student object 
and Faculty object will never be assigned the same SUID. 