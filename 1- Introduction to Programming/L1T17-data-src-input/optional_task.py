# Create a new text file in this folder called input.txt. In the input.txt file
# enter some text, making sure it is at least a few lines long.
# ● Write a program that will count the number of characters, words and
# lines in the file.
# ● Your program should also count the total number of vowels (a, e, i, o and
# u) in the file.
# ● Print out your results

# Variable to store file contents
content = ""

# While loop to open the file and read the contents
with open("input.txt", "r") as f:

    # For loop to extract the contents of the file line by line.
    for line in f:

        content += line

# line of code to mark the end of the file    
content += "\n\t\t\t\t<----The End---->"

# Print the result
print(content)

# Count the number of lines , plus one
line_count = content.count('\n')
# Count the number of words
word_count = content.count(" ")
    
# Count the number of the vowel  in the text file
a_count = content.count("a")

# Count the number of the vowel  in the text file
e_count = content.count("e")
    
# Count the number of the vowel  in the text file
i_count = content.count("i")
   
# Count the number of o vowels in the text file
o_count = content.count("o")
    
# Count the number of u vowels in the text file
u_count = content.count("u")

print("\n")
# Print out the results:
    # Character count, word count and line count
print(f"Character count: {len(content)}\nWord count: {word_count}\nLine count: {line_count}\n")
    # Vowel count
print(f"Vowel count: a- {a_count}, e- {e_count}, i- {i_count}, o- {o_count}, u- {u_count}")
        
