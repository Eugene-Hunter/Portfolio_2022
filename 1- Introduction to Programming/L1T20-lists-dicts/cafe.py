


# Create a list called menu, which should contain at least 4 items in the cafe.
menu = list(("Milk", "French Fries", "Uno Biscuits", "Lemonade"))

# Next, create a dictionary called stock, which should contain the stock
#value for each item on your menu.
stock = {"Milk" : 325,
         "French Fries" : 166,
         "Uno Biscuits" : 264,
         "Lemonade" : 451
         }

# Create another dictionary called price, which should contain the prices for
# each item on your menu.
price = {"Milk" : 12.95,
         "French Fries" : 24.95,
         "Uno Biscuits" : 7.95,
         "Lemonade" : 9.95 #',' problem solved 
         }


# Calculate the total stock worth in the cafe. 
stock_value = []
stock_worth = 0.00
print(f"\nGross values for each product:\n")

# For loop to calculate the combined value of all the items
for item in menu: 
    gross = (int(stock[item]) * float(price[item]))
    stock_value = {item : f"R {gross:.2f}"}
    # Print out the result of the calculation.
    print(f"{stock_value}")
    stock_worth += gross
    
print(f"\nThe total worth of the stock: R {stock_worth:.2f}") 
