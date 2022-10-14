
# Function that addes 2 numbers together and displays the result on screen
def add_num(num1 , num2):
    print(f"\n{num1} + {num2} = " + str(num1 + num2) + "\n")
    return

# Function that subtract one number from another and displays the result on screen
def subtract_num(num1, num2):
    print(f"\n{num1} - {num2} = " + str(num1 - num2) + "\n")
    return

# Function that multiplies 2 numbers together and displays the result on screen
def multiply_num(num1, num2):
    print(f"\n{num1} * {num2} = " + str(num1 * num2) + "\n")
    return

# Function that divides one number from another and displays the result on screen
def divide_num(num1, num2):
    print(f"\n{num1} / {num2} = " + str(num1 / num2) + "\n")
    return


answer = "yes"
option = ""

# While loop to allow user to add, subtract, multiply and divide repeatedly
while answer == "y" or answer == "yes":


    print("- - - - - - - - - - - - - - - - - - - - - - - -")

# Print the options to screen
    option = int(input("""\nOption 1: Add\n
Option 2: Subract\n
Option 3: Multiply\n
Option 4: Divide\n
:"""))  
    number1 = 0
    number2 = 0

    # If statement for doing addition
    if option == 1:
        print("Add numbers")
        number1 = int(input("Enter the first number : "))
        number2 = int(input("Enter the second number : "))
        add_num(number1, number2)

    # Elif statement for dong subtraction    
    elif option == 2:
        print("Subract numbers")
        number1 = int(input("Enter the first number : "))
        number2 = int(input("Enter the second number : "))
        subtract_num(number1, number2)

    # Elif statement for doing multiplication    
    elif option == 3:
        print("Multiply numbers")
        number1 = int(input("Enter the first number : "))
        number2 = int(input("Enter the second number : "))
        multiply_num(number1, number2)
        
    # Elif statement for doing division
    elif option ==4:
        print("Divide numbers")
        number1 = int(input("Enter the first number : "))
        number2 = int(input("Enter the second number : "))
        divide_num(number1, number2)


          
        print("- - - - - - - - - - - - - - - - - - - - - - - -")

        # Request user to input whether they want to do more calculations
        answer = input("Do you want to do another calculation? ")

    # Else statemtent to exit
    else:
        exit()
