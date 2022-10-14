# We will write a program called student_register.py that allows students
#to register for an exam venue.
# First, ask the user how many students are registering.
# Create a for loop that runs for that amount of students
# Each loop asks for the student to enter their ID number.
# Write each of the ID numbers to a Text File called reg_form.txt
# This will be used as an attendance register that they will sign when they
# arrive at the exam venue

# Request user to input the number of students
nr_of_students = int(input("How many students will attend the exam? "))

# List to store all the ID numbers    
students = list(())

# Top of list rows
students.append("\t\t\t\t----Registered Students----\n")
students.append("ID number\tSignature")

# For loop to enter user ID's one at a time
for count in range(nr_of_students):
    id_ = 0
    id_ = (input(f"Enter the digit ID number of student {count + 1}: "))

    # append user ID and placeholder for signature
    students.append(id_ + "\t\t_________________________\n")


# Open the file for writing
with open("reg_form.txt", "w") as f:

    # For loop to write student ID seperately to file
    for student in students:
        f.write((str(student)))

    # Confirm the file was created, Reading the file contacts back
    print("File has been created. Reading file contents:\n")

# Open file for reading
with open("reg_form.txt", "r") as f:
    for student in students:

        # Print result to the screen
        print(student + "\n")



        



  
