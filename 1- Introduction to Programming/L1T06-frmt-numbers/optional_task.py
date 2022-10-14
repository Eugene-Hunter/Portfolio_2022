import math
# Calculate the area of the triangle.
# Print out the area.
# Hint: If side1, side2 and side3 are the sides of the triangle:
# s = (side1 + side2 + side3)/2 and
# area = √(s(s-a)*(s-b)*(s-c))

# Ask the user to enter the lengths of all three sides of a triangle.
side1 = float(input("Side 1 of triangle: "))
side2 = float(input("Side 2 of triangle: "))
side3 = float(input("Side 3 of triangle: "))

# Calculate the area of the triangle.
s = (side1 + side2 + side3)/2

area = math.sqrt(s*(s-side1)*(s-side2)*(s-side3))

print("Area of the triangle is %0.2f" %area)
