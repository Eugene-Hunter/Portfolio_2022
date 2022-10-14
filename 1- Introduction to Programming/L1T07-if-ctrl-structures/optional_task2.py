#● This program will help the user decide what to wear. To determine what
#to wear, you need to determine whether the temperature is greater than
#20 degrees, whether it is the weekend, and whether it is sunny. Declare
#boolean variables for each one of these characteristics.

#● Then, ask the user a series of “yes or no” questions for each variable, and
#change the boolean variable to True or False based on their answer.
#● If the temperature is greater than 20 degrees, then the user should wear
#a short-sleeved shirt.
#● If the temperature is less than 20 degrees, then the user should wear a
#long-sleeved shirt.
#● If it is the weekend, the user should wear shorts.
#● If it is a weekday, the user should wear jeans.
#● If it is sunny, the user should wear a cap.
#● If it is not sunny, the user should wear a raincoat.
#● Display a sentence that fully describes what the user’s outfit should be.

temp = bool(input("Is the temperature over 20 degrees? "))
 
day = bool(input("Is it the weekend? "))
weather = bool(input("Is it sunny? "))

if temp == True:
    shirt = "short-sleeved shirt"
else:
    shirt = "long-sleeved shirt"

if day == True:
    pants = "shorts"
else:
    pants = "jeans"

if weather == True:
    cap_coat = "hat"
else:
    cap_coat = "raincoat"

    
print(f"The shirt to wear is a {shirt}, your pants should be {pants}, and you should wear a {cap_coat}.")
