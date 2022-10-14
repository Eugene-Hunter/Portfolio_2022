# Error1 - Runtime error

# z = x + 1 # Error will occur when z initializes due to the variable x that has
            # not been declared, To correct it, x needs to declared before using
            # it in any functions or other variables, etc

# Error2 - Logical error

# The length of 1 side of a cube in mm to meter
length_mm = int(input("Enter the length of the side of the cube in millimeters: "))


length_m = ((length_mm / 3 / 1000) *(length_mm / 3 / 1000) * (length_mm / 3 / 1000))
# The logical error here is a calculation error, which is determining a cube's
# size in meters, calculated incorrectly due to the incorrect formula used.
# Cube size in determined by measurement of the length of 1 side of the cube
# to the power of 3.

print(f"The size of the {length_mm} millimeter cube is {length_m:.2f} cubic meters.")
