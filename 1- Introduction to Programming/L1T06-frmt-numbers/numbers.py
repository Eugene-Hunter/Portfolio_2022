
#● Ask the user to enter three different integers
num1 = int(input("Enter first number: "))
num2 = int(input("Enter second number: "))
num3 = int(input("Enter third number: "))

#● Then print out:
#○ The sum of all the numbers
addition = num1 + num2 + num3
print(f"The sum of the 3 numbers = {addition}")

#○ The first number minus the second number
subtraction = num1 - num2
print(f"The subtraction of the first number ({num1}) from the second number ({num2}) = {subtraction}")

#○ The third number multiplied by the first number
multiply = num3 * num1
print(f"The multiplication of the third number ({num3}) with the first number ({num1}) = {multiply}")

#○ The sum of all three numbers divided by the third number
division = addition / num3
print(f"The sum of the 3 numbers ({addition}) divided by the third number({num3}) = {division}")
 
