import math
import statistics

answer = "yes"
# While loop to allow user to insert multiple lists of numbers
while answer == "yes" or answer == "y":
    # Request user to enter a list of values
    numbers = input("Insert 10 decimal numbers separated by commas (eg. 1,2,3)")
    num_list = numbers.split(",")
    new_list = [] # Variable to store the list of numbers
    
    # Initializing variable used to store the sum of the list of numbers
    total = 0.00


    # For loop to append the individual numbers to a list
    for num in num_list:
        new_list.append(int(num))
        total += int(num)


    # Display the results
    print(f"\ntotal: {total:.2f}\n")

    print(f"Largest number: {max(new_list)}\n") 

    print(f"Smallest number: {min(new_list)}\n")

    print(f"The average of the numbers are: {(total / len(num_list)):.2f}\n")
    
    print(f"The median of the numbers are {statistics.median(new_list)}")

    # Variable to store the user's response to enter another list of numbers or not.
    answer = input("Would you like to do another set? ")
