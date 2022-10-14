# Request user to input the numbers list and the number of recursions
int_list = input('Input any amount of numbers, separated by commas (ex: 1,4,2,7): ')
int_list = int_list.replace(', ', ',').split(',')
num_recursions = input('Specify the number of recursions: ')


total = 0 # Variable to store the total


# Function to recursively add a number of integers 
def sum_recursion(i_list, num_recursion):

    global total

    # Type casting the variable
    num_recursion = int(num_recursion)

    # If statement to count down number of recursions
    if num_recursion > 0:

        # Adding stored integer to the total
        total += int(i_list[num_recursion-1])
        # Reducing the number of recursions
        num_recursion = num_recursion - 1

        # Initiating the recursion
        return sum_recursion(int_list, num_recursion)

    # Returning the final result
    return total


# Initiate the resursion function and print the result
sum_total = sum_recursion(int_list, num_recursions)

print(f"Adding the numbers all the way up to index {num_recursions} of {int_list} : {sum_total}")
