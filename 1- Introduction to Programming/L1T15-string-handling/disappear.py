# The quick brown fox jumps over the lazy dog.

# Request user to enter a sentence
sentence = input("Enter a sentence: ")

# Request user to enter the characters to be removed from the sentence
characters = input("Enter the characters to strip from the sentence: ")

# Create a list of the individual characters
char_list = list(())
for a in characters:
    char_list.append(a)

# Count variable for the while loop
x = 0

# While loop to strip the sentence of the characters
while x < len(char_list):
    
    sentence = sentence.replace(char_list[x],"")
    x += 1

# Print the result
print(sentence)


