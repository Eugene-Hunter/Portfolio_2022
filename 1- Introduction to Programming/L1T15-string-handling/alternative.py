#Create a program called alternative.py that reads in a string and makes
#each alternate character an uppercase character and each other alternate
#character a lowercase character.
#● For example, the string “Hello World” would become “HeLlO WoRlD”

# Ask user to enter a sentence
native_str = input("Enter a sentence: ")

# Create an alternative string variable to store the result
alternative_str = ""

# For loop to change the case of each character in the string
for x in range(len(native_str)):
    if x == 0:
        alternative_str += native_str[x].upper()  
    elif x % 2 == 0:
        alternative_str += native_str[x].upper()
    else:
        alternative_str += native_str[x].lower()


# Print result
print(alternative_str)
