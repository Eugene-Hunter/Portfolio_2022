
# Request user to enter a string
word = input("Enter a word and get the count of each character: ")
#supercalifragilisticexpialicious

# For loop to count all the characters that are the same
result = dict((chars, word.count(chars)) for chars in word)

# Print the final result
print(result)





