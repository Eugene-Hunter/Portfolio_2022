#o Require the user to enter the names of all pupils in a class. The user
#should be able to type “Stop” to indicate that the names of all the
#students have been entered.
#o Print out the total number of names the users entered after the
#loop has been exited.

# Ask the user to enter the names of the  students
names = input("Enter the names of all the pupils in the class. "
              "Enter 'Stop' to end: ")
# Counter to count the number of users
count = 0

# Enter the next name until the user enters 'Stop'
while names != "stop" and names != "Stop":
    names = input("Enter a name: ")
    count +=1

# Print out the number of names entered.
print("\n")
print(f"The number of names entered is {count}.")
