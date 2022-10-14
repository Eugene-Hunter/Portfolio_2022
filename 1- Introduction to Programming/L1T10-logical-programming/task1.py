import random

# Declare three variables called num1, num2 and num3. Assign each variable
# a number value.
# Initialize variables
num1 = int(random.randrange(1,1000))
num2 = int(random.randrange(1,1000))
num3 = int(random.randrange(1,1000))

print(num1)
print(num2)
print(num3)

# Compare num1 and num2 and display the larger value.

if num1 > num2:
    print(f"the first number is greater than the second number.")
if num2 > num1:
    print(f"The second number is greater than the first number.")

# Next, determine whether num1 is odd or even and display the result.
odd_even = num1%2

if odd_even ==0:
    print(f"{num1} is an even number.")
else:
    print(f"{num1} is an odd number.")
    
# Next, write a conditional statement to sort the three numbers from largest
# to smallest.

if num1 > num2 and num1 > num3:
    if num2 > num3:
        print(f"From largest to smallest: {num1}, {num2}, {num3}")
    else:
        print(f"From largest to smallest: {num1}, {num3}, {num2}")

elif num2 > num1 and num2 > num3:
    if num1 > num3:
        print(f"From largest to smallest: {num2}, {num1}, {num3}")
    else:
        print(f"From largest to smallest: {num2}, {num3}, {num1}")
        
else:
    if num1 > num2:
        print(f"From largest to smallest: {num3}, {num1}, {num2}")
    else:
        print(f"From largest to smallest: {num3}, {num2}, {num1}")


