#Create a new Python file in this folder called details.py
#● Use an input command to get the following information from the user.
#○ Name
#○ Age
#○ House number
#○ Street name
#● Print out a single sentence containing all the details of the user.
#● For example:
#○ This is John Smith he is 28 years old and lives at house number 42
#on Hamilton Street.

name = input("Your name: ")
age = input("Your age: ")
house_num = input("Your house's street number : ")
street_name = input("Your street's name: ")

print("{} who is {} years old, resides at number {} {}.".format(name,age,house_num,street_name))
