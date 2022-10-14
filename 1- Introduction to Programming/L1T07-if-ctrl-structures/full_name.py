#● Create a Python file called full_name.py in this folder.
#● This program will be used to validate that a user inputs at least two names
#when asked to enter their full name.
#● Ask the user to input their full name.
full_name = input("Please enter your full name")
#● Do some validation to check that the user has entered a full name. Give an
#appropriate error message if they haven’t. One of the following messages
#should be displayed based on the user’s input:
lngth = len(full_name)
print(full_name.search(""))

if lngth < 4:
    #o “You have entered less than 4 characters. Please make sure that you
    #have entered your name and surname.”
    print("You have entered less than 4 characters. Please make sure that you have entered your name and surname")
elif lngth > 25:
#o “You have entered more than 25 characters. Please make sure that
#you have only entered your full name.”
    print("You have entered more than 25 characters. Please make sure that you have only entered your full name")
#o “You haven’t entered anything. Please enter your full name.”
elif lngth == 0:
     print("You haven't entered anything. Please enter your full name")
#o “Thank you for entering your name.”
else:
    print("Thank you for entering your name")

