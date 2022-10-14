import math

# Ask the user to enter their weight in kg and their height in m
# Inform the user of what each threshold represents
print("If the user’s BMI is 30 or greater the user is obese")
print("If the user’s BMI is 25 or greater the user is overweight")
print("If the user’s BMI is 18.5 or greater the user is normal")
print("If the user’s BMI is less than 18.5 the user is underweight")
print("\n")

# Get weight from user
weight = float(input("Please enter your weight in kilograms: "))


# Loop to allow user to enter multiple scenarios
# Display the user’s BMI and whether they are obese, overweight, normal or
#underweight.
while weight != 0:
    
    height = float(input("Please enter your height in meters: "))

    # BMI = (weight in kg) / ((height in m)*(height in m))
    
    bmi = weight/math.pow(height,2)
    
    print(f"You BMI index is {bmi:.2f}.")
    
    #o If the user’s BMI is 30 or greater the user is obese
    if bmi >= 30.00:
        print("You are obese.")
        
    #o If the user’s BMI is 25 or greater the user is overweight
    elif bmi >= 25.00 and bmi < 30.00:
        print("You are overweight.")
        
    #o If the user’s BMI is 18.5 or greater the user is normal
    elif bmi >= 18.50 and bmi < 25.00:
        print("Your weight is normal.")

    #o If the user’s BMI is less than 18.5 the user is underweight
    else:
        print("You are underweight.")
        

    #● Ask the user to enter their weight in kg and their height in m
    weight = float(input("Please enter your weight in kilograms, enter '0' to exit: "))
else:
    exit()
