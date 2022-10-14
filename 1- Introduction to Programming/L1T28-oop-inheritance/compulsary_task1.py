"""
Compulsory Task 1: 
------------------

Use the code provided copied to a new file named compulsory_task_1.py: 
1. Add another method in the Course class that prints the head office location: Woodstock, Cape Town
2. Create a subclass of the Course class named OOPCourse
3. Create a constructor that initialises the following attributes and assigns these values:
    --- "description" with a value "OOP Fundamentals"
    --- "trainer" with a value "Mr Anon A. Mouse"
4. Create a method in the subclass named "trainer_details" that prints what the 
   course is about and the name of the trainer by using the description and trainer attributes.
5. Create a method in the subclass named "show_course_id" that prints the ID number of the course: #12345
6. Create an object of the subclass called course_1 and call the following methods
   contact_details
   trainer_details
   show_course_id
   These methods should all print out the correct information to the terminal

On a side note, this task covers single inheritance. multiple inheritance is also possible in Python and 
we encourage you to do some research on multiple inheritance when you have finished this course
"""


class Course:
    
    h_o = "Woodstock, Cape Town"

    def __init__(self, name, contact_website):
        self.name = name
        self.contact_website = contact_website

    def contact_details(self):
        return f"Please contact us by visiting {self.contact_website}"

    def head_office(self):
        return f"Head Office: {self.h_o}"


class OOPCourse(Course):

    def __init__(self, name, contact_website, course_id, description, trainer):
        super().__init__(name, contact_website)
        self.course_id = course_id
        self.description = description
        self.trainer = trainer

    def trainer_details(self):
        return f"Course: {self.description}\nTrainer: {self.trainer}"

    def show_course_id(self):
        return f"Course ID: {self.course_id}"


course1 = OOPCourse("Fundamentals of Computer Science", "www.hyperiondev.com", "#12345",
                    "OOP Fundamentals", "Mr Anon A. Mouse")

print(f"""{course1.name}
{course1.contact_details()}
{course1.head_office()}
{course1.trainer_details()}
{course1.show_course_id()}""")
