# import random library
import random


# Write the numbers from both files to a third file called all_numbers.txt
# All the numbers in all_numbers.txt should be sorted from smallest to lar-
# gest

# -------------------------------------------------------------------------
# Create a text file called numbers1.txt that contains Integers which are
# sorted from smallest to largest.
# Create another text file called numbers2.txt which also contains Integers
# that are sorted from smallest to largest.

# Lists to store integers
rand_numbers1 = list(())
rand_numbers2 = list(())

# variable to limit the size of the number of entries in each file
y = 0
#While loop to generate random numbers to store in the lists
while y < 100:

    rand_numbers1.append(random.randrange(1,10000))
    rand_numbers2.append(random.randrange(1,10000))
    y = y + 1

# Sort the lists from smallest to biggest
rand_numbers1.sort()
rand_numbers2.sort()


# Display the contents of the files on screen
#print("numbers1.txt:\n" + str(rand_numbers1) + "\n")
#print("numbers2.txt:\n" + str(rand_numbers2) + "\n")

# -------------------------------------------------------------------------
# Create numbers1.txt file

# Open/Create the file in write mode
with open("numbers1.txt", "w") as f:
    
    # For loop to write the numbers to file
    for number in rand_numbers1:
        f.write(f"{number} ")
# -------------------------------------------------------------------------
# Create numbers2.txt file

# Open/Create the file in write mode
with open("numbers2.txt", "w") as f:    

    # For loop to write the numbers to file
    for number in rand_numbers2:
        f.write(f"{number} ")
    
# -------------------------------------------------------------------------
# Extracting and combining numbers1.txt and numbers2.txt

extract1 = ""
extract2 = ""

# Open the numbers1.txt file in read-only mode
with open("numbers1.txt", "r") as f:
    # For each line in the file
    for line in f:
        # Extract the information and remove white spaces and replace the comma
        extract1 += line.strip().replace(' ' , ',')

# Open the numbers2.txt file in read-only mode
with open("numbers2.txt", "r") as f:
    # For each line in the file
    for line in f:
        # Extract the information and remove white spaces and replace the comma
        extract2 += line.strip().replace(' ' , ',')

# List variable to store the extracted information
all_numbers = list(())

# Splitting the extracted strings after each value
extract1 = list(extract1.split(','))
extract2 = list(extract2.split(','))

# For loop to append the individual results to the all_numbers list
for x in extract1:
    all_numbers.append(int(x))
    
# For loop to append the individual results to the all_numbers list
for x in extract2:
    all_numbers.append(int(x))

# Sort the all_numbers.txt list
all_numbers.sort()

# Variable to store the formatted results
text_to_file = ""

# For loop to add the sorted list to the text_to_file variable that will be
# used to save the information in the all_numbers.txt file
for x in all_numbers:
    text_to_file += str(x) + " "
    
# Display the contents to be saved in the file on the screen   
#print(text_to_file)

# -------------------------------------------------------------------------
# Save the results to the all_numbers.txt file

# Create the all_numbers.txt file
with open("all_numbers.txt", "w") as f:
    # Write the results to the file
    f.write(text_to_file)

# Confirmation that file has been created  
print("\nThe file all_numbers.txt was created")



