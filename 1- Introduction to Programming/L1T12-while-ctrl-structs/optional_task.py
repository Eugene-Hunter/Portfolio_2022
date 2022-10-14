
#Ask the user to enter a number less than or equal to 100.
number = int(input("Enter a number less than or equal to 100: "))

# If they enter one above 100, ask them to try again (and continue to do so
# Until they follow instructions).
while number > 100:
    number = int(input("Enter a number less than or equal to 100: "))



# Once they have entered a valid number, check if it is even.
odd_or_even = number%2

print("\n")


# If it is, multiply it by 2 and print it out. 
if odd_or_even == 0:
    number *= 2
    print(f"the number multplied by 2 = {number}" )
    
# If it isn't , multiply it by 3 and print it out
else:
    number *=3
    print(f"the number multplied by 3 = {number}" )
    
