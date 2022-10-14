
#● Ask the user to enter a sentence. Save the user’s response in a variable
#called str_manip.
str_manip = input("Enter any sentence of your choice")
#● Using this string value, write the code to do the following:
#○ Calculate and display the length of str_manip.
print("The length of the string is: " + str(len(str_manip)) + " characters.")

#○ Find the last letter in str_manip. Replace every occurence of this
#letter in str_manip with ‘@’. E.g. if str_manip = “This is a bunch of
#words”, the output would be “Thi@ i@ a bunch of word@”
last = str_manip[-1]
print(str_manip.lower().replace(last,'@').capitalize())

#○ Print the last 3 characters in str_manip backwards. E.g. if str_manip
#= “This is a bunch of words”, the output would be “sdr”.
print(str_manip[:-4:-1])

#○ Create a five-letter word that is made up of the first three characters
#and the last two characters in str_manip. E.g. if str_manip = “This is a
#bunch of words”, the output would be “Thids”.
print(str_manip[:3] + str_manip[-2:])


#○ Display each word on a new line.

print(str_manip.replace(" ","\n"))
