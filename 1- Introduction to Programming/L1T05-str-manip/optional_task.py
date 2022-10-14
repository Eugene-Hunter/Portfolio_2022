
#● Write Python code to take the name of a user's favourite restaurant and
#store it in a variable called fav_rest.
fav_rest = input("Enter the name of your restaurant")

#● Now, below this, write a statement to take in the user's favourite number.
#Use casting to store it in an integer variable called int_fav.
int_fav = int(input("Enter your favourite number"))


#● Now print out both of these using two separate print statements below
#what you have written. Be careful!
print(fav_rest)
print(int_fav)

#● Once this is working, try cast fav_rest to an integer. What happens? Add a
#comment in your code to explain why this is

print(int(fav_rest)) #casting text to integer will result in an error as a string is an invalid literal for integer type variables
      
