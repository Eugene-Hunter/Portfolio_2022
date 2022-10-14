# This is going to expand on the first control structure task we created.
# Write code to take in a user’s age using input()
# and store their age in an
# Integer variable called age.
age = int(input("Please enter your age: "))

# Check if the user’s age is 18 or older. If the user is 18 or older, print out

# The message “You are old enough!”.
if age >= 18:
    print("You are old enough.")
    
# Else if they are over 16 but under 18, print “Almost there”.
elif age >= 16 and age < 18:
    print("Almost there.")
    
# Otherwise print “You’re just too young!”.
else:
    print("You're just to young.")

