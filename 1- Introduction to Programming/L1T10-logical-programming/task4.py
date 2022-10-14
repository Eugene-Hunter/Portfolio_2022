# Ask the user to enter an integer 

number = int(input("\nEnter a number: "))
divisible_2 = float(number % 2)
divisible_5 = float(number % 5)

# Determine if the number is divisible by 2 and/or 5

# Divisible by 2 and 5,
if divisible_2 == 0 and divisible_5 == 0:
    print(f"\nThe number {number} is divisble by 2 and 5.")
    
# Divisible by 2 or by 5
elif divisible_2 == 0 or divisible_5 == 0:
    print(f"\nThe number {number} is divisble by 2 or 5.") 

# Not divisible by 2 or 5
else:
    print(f"\nThe number {number} is not divisible by 2 or 5.")

