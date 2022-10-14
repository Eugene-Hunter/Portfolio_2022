#● Create a new Python file in this folder called optional_task.py
#● Use input to get any two numbers from the user.
#● Store these numbers in variables called num1 and num2.
#● Now swap these two numbers around. The number stored in num1
#should now be stored in num2, and the number stored in num2 should
#now be stored in num1.
#● Print out the values of num1 and num2 before the swap, and the values
#of num1 and num2 after the swap

num1 = input("Enter your first number")
num2 = input("Enter your second number")
print("I will now attempt to swap your first number,{} and your second number, {} around.".format(num1,num2))

swap = num1
num1 = num2
num2 = swap

print("\n.....")      
print("\n.....")
print("\n.....")
print("\n")
print("Now your first number is {} and your second number is {}".format(num1,num2))
      
