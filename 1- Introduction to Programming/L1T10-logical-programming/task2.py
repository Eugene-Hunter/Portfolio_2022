import math, cmath

# This program will be used to calculate the area that the foundation of a
# building covers. This program should:

# Ask the user to enter the shape of the building (square, rectangular
# or round).
building_shape = input("Enter the shape of the building; square, rectangular or round, press enter to exit: ")

# Based on the user’s input, prompt for the appropriate dimensions.
# Formulae for area:
# Area of square = length of the square to the power of two (length 2).
# Area of rectangle = length x width.
# Area of circle = pi X radius squared (𝛱radius2)
# Calculate and display the area that will be taken up by the foundation
# of the building.

while (building_shape == "square"
       or building_shape == "rectangular"
       or building_shape == "round"
       or building_shape ==""):

    # Calculate if the building shape is square
    if building_shape == "square":
        length = float(input("Enter the length of the building in meters: "))
        area = math.pow(length,2)
        
        print(f"The area of the {building_shape} building is {area:.2f} meters ")
        building_shape = input("Enter the shape of the building: ").lower()

    # Calculate if the building shape is rectangular        
    elif building_shape == "rectangular":
        length = float(input("Enter the length of the building in meters: "))
        width = float(input("Enter the width of the building in meters: "))
        area = length * width
        
        print(f"The area of the {building_shape} building is {area:.2f} meters ")
        building_shape = input("Enter the shape of the building: ").lower()

    # Calculate if the building shape is round    
    elif building_shape == "round":
        radius = float(input("Enter the radius of the building meters: "))
        area = float((cmath.pi)*(math.pow(radius,2)))
        
        print(f"The area of the {building_shape} building is {area:.2f} meters ")
        building_shape = input("Enter the shape of the building: ").lower()

    # Exit
    elif building_shape == "":
        exit()

# If the value entered was incorrect, the shape can be re-entered
else:
    building_shape = input("Your input is not correct, re-enter the shape of the building, : ").lower()

    






