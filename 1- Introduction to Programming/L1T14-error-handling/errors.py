# This example program is meant to demonstrate errors.
 
# There are some errors in this program, try run the program by pressing F5.
# Now look at the error messages and find and fix the errors.

print ("Welcome to the error program") # Syntax error - paretheses

print ("\n") # Syntax error - paretheses, indentation

ageStr = "24" #I'm 24 years old. # Syntax error - indentation
                                 # Runtime error - '=' operator
                                 
age = int(ageStr) # Syntax error - indentation
                  # Runtime error - type casting

print("I'm " + format(age) + " years old.")  # Syntax error - indentation
                                             # Runtime error - format method

three = "3"  # Syntax error - indentation

answerYears = int(age) + int(three)  # Syntax error - indentation
                                     # Runtime error - type casting

print ("The total number of years: " + format(answerYears)) # Syntax error - paretheses
                                                            # Logical error - format method added

answerMonths = answerYears * 12 # Runtime error  - undeclared variable 'answer', changed to answerYears

print (f"In 3 years and 6 months, I'll be {answerMonths + 6} months old") # Syntax error - paretheses
                                                                          # Logical error - format method added
                                                                          # Logical error - included 6 months
 
#HINT, 330 months is the correct answer

