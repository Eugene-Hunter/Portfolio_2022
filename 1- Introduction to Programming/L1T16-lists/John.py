# Ask user to enter his/her name
name = input("Enter your name: ").title()

# create a list variable to store all the names that are not "John"
incorrect = list(())

# While the string is != “John”, add every string is entered into a list until
# “John” is entered
while name != "John":
    incorrect.append(name.title())
    name = input("Enter your name: ").title()

# Print out the list of incorrect names
print(f"Incorrect names: {(incorrect)} ")
    
