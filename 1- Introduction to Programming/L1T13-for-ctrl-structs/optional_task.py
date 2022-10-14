

# Ask the user to input a number and cast it to an int
num = int(input("Enter a value greater than 10: "))

# Use if statement to determine if the value is greater than 10
if num > 10:

    # Use a for loop to output it as many times as its value.
    print("The number {num} will be printed {num} times: ")
    for x in range(num):
        print(num)


#If the user enters anything less than or equal to 10, the program should
#output "Sorry, too small".
else:
    print("Sorry, too small.")
    
