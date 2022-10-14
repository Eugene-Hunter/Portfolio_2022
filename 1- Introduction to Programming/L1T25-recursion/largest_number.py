
num_list = [590,290,85,124,42,232,78]


# Function to determine largest number
def largest_number(num_list, position = 0, largest = 0):

    # Variable to store the length of the list
    list_len = len(num_list)

    # If statement to limit 
    if position < list_len:

        # If statement to determine if the current number is larger than the following number
        if num_list[position] >= largest:

            # Variable to save the largest number
            largest = num_list[position]

            # Increment variable to number next in line
            position = position + 1

            # Recursion statement  to iterate to the number next in line
            return largest_number(num_list, position, largest)

        # Else If statement to determine in the next number is smaller than the current number
        elif num_list[position] < largest:
            
            # Increment variable to number next in line
            position += 1

            # Recursion statement  to iterate to the number next in line            
            return largest_number(num_list, position, largest)

    else:
        # Recursion statement  to return the variable the has the largest number stored   
        return largest

# Variable that stores the result from the recursion function
max_num = largest_number(num_list)    

# Display the result
print(f"Largest number({num_list})")
print(f"=> {max_num}")

