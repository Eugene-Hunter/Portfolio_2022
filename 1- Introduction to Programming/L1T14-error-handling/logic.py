import math
# Logical error


# Determine the size of a cube

side_len = int(input("Enter the length of one side of the cube in cm: "))


# Calculate the size of the cube
# The correct calculation of the side of the cude is math.pow(side_len, 3)
# or (side_len * side_len * side_len)

# The logical error is a calculation error and the result is incorrect
print(f"The size of the cube is {side_len * 3} cubic cm.")

# The correct calculation is as follows
# print(f"The size of the cube is {math.pow(side_len, 3)} cubic cm.")
