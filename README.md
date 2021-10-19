I choose to create a Person superclass that is inherited by the Student and Faculty classes. 
The Person superclass declares and initializes some of the shared fields of the Student
and Faculty classes: first name, last name, SUID, and person status (email is also a shared field,
but the Student and Faculty classes require different methods to set the email, so I chose to 
declare the email field in the Student and Faculty classes.) The primary reason I chose to create 
a Person superclass is for the assignment of the SUIDs. Assigning  the SUIDs in the Person 
superclass rather than in the Student and Faculty subclasses ensures that a Student object 
and Faculty object will never be assigned the same SUID. 

To do: Explain why didn't make a separate object for undergraduate students

Note to grader: I added a private static field called instanceCounter to the Person object 
to count how many times Faculty and Student objects have been instantiated. I use this field
to ensure that every Faculty and Student object is assigned a unique SUID. Per the
assignment instructions, I got permission from Professor Riley before adding
this private field.