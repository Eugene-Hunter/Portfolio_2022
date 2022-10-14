#● Write a program that 
#● Make use of the while loop repetition structure so the program prints out
#all the even numbers from 1 up to (and possibly including) the number
#given by the user.

# Ask the user to enter a number.
number = int(input("Enter a number: "))

# Count the number of iterations
count = 1

#Print all even numbers that is less and equal to the number             
while count <= number:

    # Determine if the number is divisible by 2 i.e. even
    result = count%2

    # If the number is divisible by 2
    if result == 0:
        
        # Print the even number
        print(f"Even numbers {count}")

    # increase the count by 1    
    count += 1    
