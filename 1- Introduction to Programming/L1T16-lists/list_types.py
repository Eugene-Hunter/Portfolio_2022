# Define a list of the full names of the 3 best friends
friends_names = ["Kevin Munning" , "Mark Knoffler" , "Abraham Dixon"]

# Print out of the first and 3rd name and the length of the list.
print(f"First friend's name is {friends_names[0]}.")
print(f"The third friend's name is {friends_names[2]}.")
print(f"The length of the list is {len(friends_names)}")

# Define a list called friends_ages that stores the age of each of your
# friends
friends_ages = list((40 , 41 , 42))

# variable for the age counter
x = 0

# For loop to print out the names and the ages for each of the friends
for names in friends_names:
    print(f"{names} is {friends_ages[x]} years old.")
    x += 1
    
