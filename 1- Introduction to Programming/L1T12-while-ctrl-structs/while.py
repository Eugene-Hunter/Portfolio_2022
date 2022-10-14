
print("Enter multiple numbers and calculate the average, enter -1 to exit:")
# Ask the user to enter multiple numbers to calculate the average:
number = int(input("Enter a number: "))

# Count the number of iterations
count = 0

# Total of the numbers entered
total = 0

# While loop to allow user to enter multiple numbers
while number != -1:
    
    # Add numbers together
    total += number
    count +=1

    #Ask user to enter another number
    number = int(input("Enter the next number, -1 to exit: "))

# Calculate the average of the numbers entered    
average = float(total / count)

# Print the result
print(f"The average of the numbers enter is {average:.2f}.")    
    
