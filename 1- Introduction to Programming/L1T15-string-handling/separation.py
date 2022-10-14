# Ask the user to enter a sentence
sentence = input("Enter a sentence")

# Store the result in a list
words = sentence.split(" ")

# Loop through the 'words' list, each word stored in a seperate cell 
for x in range(len(words)):
    
    # Print each word in a new line
    print((words[x]))


