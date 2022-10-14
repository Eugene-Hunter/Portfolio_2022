""" Create a simple calculator application that asks a user to enter two
numbers and the operation (e.g. +, -, x, etc.) that they’d like to perform on
the numbers. Display the answer to the equation. Every equation entered
by the user should be written to a text file. Use defensive programming to
write this program in a manner that is robust and handles unexpected
events and user inputs

 Create a simple calculator application that asks a user to enter two
numbers and the operation (e.g. +, -, x, etc.) that they’d like to perform on
the numbers. Display the answer to the equation. Every equation entered
by the user should be written to a text file. Use defensive programming to
write this program in a manner that is robust and handles unexpected
events and user inputs"""



def calculate(num_1, num_2, operator):

    try:
        if operator == "+":
            plus = int(num_1) + int(num_2)
            plus = f"{num_1} + {num_2} = {(plus):.2f}\n"
            print(plus)
            write_to_file(plus)
            return

        elif operator == "-":
            minus = int(num_1) - int(num_2)
            minus = f"{num_1} - {num_2} =  {(minus):.2f}\n"
            print(minus)
            write_to_file(minus)
            return

        elif operator == "x" or operator == "*":
            times = int(num_1) * int(num_2)
            times = f"{num_1} * {num_2} = {(times):.2f}\n"
            print(times)
            write_to_file(times)
            return

        elif operator == "/":
            divide = int(num_1) / int(num_2)
            divide = f"{num_1} / {num_2} = {(divide):.2f}\n"
            print(divide)
            write_to_file(divide)
            return

    except ValueError:
        print("You have entered characters not associated with numbers. ")
    except ZeroDivisionError:
        print("Division by zero error occured")
    
    
    
   # else:
   #     print("You have entered the wrong information, please check your information and try again.")
        #

    return

def write_to_file(info):

  

    try:

        with open(f"equations.txt", "a") as f:
            
            f.write(info + "\n")

            
    except FileNotFound as error:
        print("The file that you are trying to access does not exist.")
        print(error)
        

    finally:

        if f is not None:
            f.close()

    return

def multiple_equations():
    
    
    next_equation = "y"

    while next_equation == "y" or next_equation == "yes":
        num1 = input("Add the firste number: ")

        num2 = input("Add the second number: ")

        operand = input("Choose the operation; +, -, x, / ")
            
        calculate(num1, num2, operand)

        next_equation = input("Do another one? ")
    return    


def view_file():


    file_exists = False
    file = None
    while file_exists == False:
        file_name = input("Enter the file name and extension: ")
        print("\n")
        try:
            file = open(file_name, "r")
            contents = file.read()
            file_exists = True
            print(contents)
        except FileNotFoundError as error:
            file_exists = False
            print("The file you are trying to access was not found.")
            print("\n")
            print(error)
        except OSError:
            print("You entered illigal characters, check the name and try again.")
            print("\n")
        finally:
            if file is not None:
                file.close()


menu = "yes"

while menu != "no" and menu != "n":

    option = input("""What would you like to do?\n
        1: Do an equation
        2: View all equations
        3: Exit
        : """)
    print("\n")
    if option == "1":
        multiple_equations()
    elif option == "2":
        view_file()
    elif option == "3":
        exit()
    else:
        print("The input is not recognised")
        
else:
    exit()
