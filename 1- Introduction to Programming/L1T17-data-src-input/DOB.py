
"""
Write a program that reads the data from the text file called DOB.txt and prints
it out in two different sections in the format displayed below:
Name
A Masinga
Etc.
Birthdate
21 July 1988
Etc.

"""
# Initialize variables
contents = ""
persons = list(())
details = list(())

# Open file and read data stored in the file in read and write mode
with open("DOB.txt", "r+") as f:
    # For loop to read the contents line by line
    for line in f:
        contents += line

# Split between the lines
persons = contents.split("\n")


# For each line in the persons list
for person in persons:

     # If a line exists
     if person:
        # Split the line into 3 parts 
        details = person.split(" ", 2)
        # Output the result to formatted text 
        print(f"Name:\n{details[0][0]} {details[1]}\nBirthdate:\n{details[2]}\n")











    


