#● Ask the user to enter an integer.
number = int(input("Enter a number: "))
#loop to allow user to enter a value more than once
while number != 0:
    #● Test whether the number entered is odd or even. Hint: use the modulus
    #operator
    odd_even = number % 2
    if odd_even == 1:
        #● Print out the number and whether it is even
            print(f"The number {number} is odd")
    else:
        #● Print out the number and whether it is odd
            print(f"The number {number} is even")
    number = int(input("Enter a number: "))
else:
    exit(0)
