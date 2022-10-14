#● Create a new Python file in this folder called replace.py.
#● Save the sentence: “The!quick!brown!fox!jumps!over!the!lazy!dog!.” as a
#single string.
sentence = "The!quick!brown!fox!jumps!over!the!lazy!dog!."

#● Reprint this sentence as “The quick brown fox jumps over the lazy
#dog.” using the replace() function to replace every “!” exclamation mark
#with a blank space.
print(sentence.replace("!"," "))

#● Reprint that sentence as “THE QUICK BROWN FOX JUMPS OVER THE
#LAZY DOG.” using the upper() function
print(sentence.upper().replace("!"," "))

#● Print the sentence in reverse
print(sentence[::-1].replace("!"," "))
