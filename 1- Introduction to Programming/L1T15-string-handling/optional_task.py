

# Ask user to enter a word and store it in a variable
the_string = input("Enter a word to find out if it's a palindrome").lower()

# while loop to allow user to enter multiple words, multiple times 
while the_string != "" and the_string != "exit":

    # Get the length of the string
    i = len(the_string)
    
    # variable to store the string backwards
    reverse_string = ""

    # while loop to save the word backwards
    while i > 0:
        reverse_string += the_string[i - 1]
        i -= 1

    # Print the result of the word in reverse
    print(f"The word reversed is {reverse_string}.")

    # If the word in reverse matches the reversed word it is a palindrome
    if the_string == reverse_string:
        print("Your word is a palindrome")

    # Otherwise it is not a palindrome
    else:
        print("Your word is not a palindrome")
        
    print("\n")

    # User may choose to enter the next word or terminate the program
    the_string = input("Enter a word to find out if it's a palindrome, leave open or type 'exit' to close:")

# Otherwise the program is terminated
else:
    exit()
