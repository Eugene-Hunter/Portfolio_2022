#Display the timetables for any number.

# Control variable
count = 13

# Ask user to enter the number of the times table they would like to view
time_table = int(input("which times table would you like to view? "))

print("\n") 

print(f"The {time_table} times table is as follows: ")

# Loop through the control variable
for x in range(count):

    # Print result of the times table 
    print(str(time_table) + " x " + str(x) + " = " + str(time_table * x))
             
