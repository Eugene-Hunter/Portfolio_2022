
sentence = input("Please enter a word or a sentence: ")
substring = input("Please enter the substring you wish to find")
replacement = input("Please enter a string to replace the given substring")
new = ""

# Function to search and replaca substring characters from a word or sentence
def search_replace(string, substr, replace_with, new, position = 0):

        # If statement to determine if the current search position larger
        # than the length of the string
        if  position < len(string):

            # If statement to check if the substring matches the characters
            # at the current search index
            if string[position : position + len(substr)]  == substr:

                # Include the replacement characters if the substring characters
                # were found in the string to the new string
                new += replace_with
                
                # Increment the index position by the length of the substring
                # to continue the search for additional matches
                position += len(substr)

                # Return statement searching recursively through the string
                return search_replace(string, substr, replace_with, new, position)

            # Elif statement to include non-matching characters to the new string
            elif string[position : position + len(substr)]  != substr:
                
                new += string[position]
                # Increment the index position by the length of the substring
                # to continue the search for additional matches
                position += 1
                
                # Return statement searching recursively through the string
                return search_replace(string, substr, replace_with, new, position)

            # Else statement to display a message if the characters not found
            else:
                print("The substring characters you searched for was not found.")

        # Else statement to return the final result
        else:
            return new

# Function call             
new = search_replace(sentence, substring, replacement, new)

# Print the result
if new:
    print(new)
# Display a message if there is no result to display
else:
    print("No results to display.")
