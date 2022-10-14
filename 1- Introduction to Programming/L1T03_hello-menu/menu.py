#welcome patron to restaurant
print("Welcome to our little Corner Restaurant!\n")
print("We know that you will have a great experience.\n")
print("Our menu is as follows:")
# create menu with 10 items stored
menu = list(("Prawn cocktail","Pitta bread","Garlic snails","Beef and reef plate","Calzone pizza","Hawaiin pizza","Seafood platter","Chicken Schnitzel","Coffee","Cola soda"))
#list items on menu
menuLength = len(menu)
#loop
for y in range(len(menu)):
    print("{}: {}".format((y+1),menu[y]))
    
#ask user to order their 3 favourite food items from menu
print("\nEnter your 3 favourite items, one at a time.")

#initialize order list
favourite = ["","",""]
#loop
for m in range(len(favourite)):
#accept user input    
    favourite[m] = input("Item {}: ".format(m + 1))
    

#print each item separately
print("\nThank you, your order of " + str(len(favourite)) + " items are as follows:")
#loop   
for i in range(len(favourite)):
    print("{}: {}".format((i+1),favourite[i]))
   

print("\nHave a nice day.")
