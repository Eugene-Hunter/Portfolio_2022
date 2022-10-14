
# Function to open the file 'input.txt' and read the contents
def read_file(row):

    # Save the content to variable f
    f = open("input.txt", "r", encoding='utf-8-sig')
    content = f.read()
    content = content.split("\n")

    # Return the output
    return content[row]


# Function to determine the smallest number
def min_number():
    
    # Extract the first row from the file contents
    numbers = read_file(0)
    # Remove first 4 characters and split the numbers
    numbers = numbers[4:]
    numbers = numbers.split(",")
    # Find the smallest number
    min_nr = min(numbers)
    # Return function returning the result  
    return f"The min of {numbers} is {min_nr}\n"


# Function to determine the largest number 
def max_number():

    # Extract the second row from the file contents
    numbers = read_file(1)
    # Remove the first 4 characters and split the numbers
    numbers = numbers[4:]
    numbers = numbers.split(",")
    # find the largest number
    max_nr = max(numbers)
    # Return function returning the result  
    return f"The max of {numbers} is {max_nr}\n"


# Function to calculate the average
def avg_number():
    
    # Extract the third row from the file contents
    numbers = read_file(2)
    # Remove the first 4 characters and split the numbers
    numbers = numbers[4:]
    numbers = numbers.split(",")

    # Calculate the average between the list of numbers
    sum_of_num = 0
    for x in numbers:
        sum_of_num += int(x)
    avg_nr = sum_of_num / len(numbers)
    # Return function returning the result    
    return f"The avg of {numbers} is {avg_nr}\n"


# Function to calculate the percentile
def percentile():

    # Retrieve the information from the file
    content_row_3 = read_file(3)
    # Retrieve the percentile value
    percent = int(content_row_3[1:3])
    # Retrieving the list of integers
    row_3 = content_row_3[4:].split(",")
    row_3_len = len(row_3)

    # Calculate the percentile value
    p_value = int(percent / 100 * int(row_3_len))

    # Display the result on the screen
    return f"The {percent} percentile of {row_3} is {p_value}\n"


# Function to save the output to file
def save_to_file(*output):
    print("Saving to file: \n")
    # Write the contents to file, overwriting any data that  was in the file  already
    with open("output.txt", "w") as f:
        for x in output:
            f.write(str(x))
    print("Content saved to file 'output.txt'")

    
# Function call to retrieve the smallest number
min_str = min_number()

# Function call to retrieve the largest number
max_str = max_number()

# Function call to retrieve the average number
avg_str = avg_number()

# Function call to retrieve percentile value
percentile_str = percentile()

print(min_str, max_str, avg_str, percentile_str)
# Function call to save the information to the file 'output.txt'
save_to_file(min_str, max_str, avg_str, percentile_str)
