
# Ask user to enter the start year
year = int(input("Enter a start year to check out the leap years: "))

# Ask user to enter the number of years to check. - Control variable
number_of_years = int(input("Enter the number of consecutive years you want to view: "))

# Use a for loop to determine and display which years were or will be leap
# years.
for x in range(number_of_years):

    # if year is divsible by 4 then print it's a leap year        
    if  year % 4 == 0:
        print(f"{year} is a leap year")
        year += 1

    # If year is not divisible by 4 print it is not a leap year    
    else:
        print(f"{year} isn't a leap year.")
        year += 1  
