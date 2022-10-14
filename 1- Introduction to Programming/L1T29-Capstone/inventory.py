from tabulate import tabulate


# Nike warehouses store the following information for each stock-taking list:
#  Country
#  Code
#  Product
#  Cost
#  Quantity
#  Value
# Other store managers (in other regions) would like to be able to use your program
# to do the following:
#  Search products by code.
#  Determine the product with the lowest quantity and restock it.
#  Determine the product with the highest quantity.
#  Calculate the value of each item entry, based on the quantity and cost of the
# item. The value is calculated by multiplying the cost by the quantity for each
# item entered

# Create a file named inventory.py, where a Shoe class should be
# defined.
# Create at least 5 shoe objects and store these in a list. Add
# functionality to search products in the objects list by code.
# Write code to determine the product with the lowest quantity, and
# restock it.
# Write code to determine the product with the highest quantity and
# mark it up as being for sale.

# You will have noticed that in the original data, there are only five
# columns. Write a function, value_per_item(), to calculate the value
# (or total worth) of e1ach item entered. (Please keep the formula for
# value in mind; value = cost * quantity.) This function should then
# create a sixth column for each product, named value.
# Represent the data from the objects list in a table format using
# Python's tabulate module, with the new value column added.
# In the Shoe class, create a function (read_data()) that will
# implement a try-except block for reading the following information
# from the file:
# country,
# code,
# product,
# cost, and
# quantity.

# Shoe class
class Shoe:

    # method initializing the shoe class
    def __init__(self, country, code, product, cost, quantity):
        self.country = country
        self.code = code
        self.product = product
        self.cost = int(cost)
        self.quantity = int(quantity)
        self.total_value = self.cost * self.quantity

    # repr function to be able to view the object information
    def __repr__(self):
        return f"{self.country},{self.code},{self.product},{self.cost},{self.quantity},{self.total_value}"

    # getter method that returns the current object's stock value
    def get_total_value(self):
        return self.total_value


# Function to retrieve file information
def read_data(short_list):
    # List to store the shoe objects
    shoes = []
    shoe1 = Shoe("United States", "SKU80000", "Hot Air II", 436, 204)
    shoe2 = Shoe("Jamaica", "SKU70000", "Blade Runner Supreme", 1471, 574)
    shoe3 = Shoe("England", "SKU60000", "Phantom", 532, 832)
    shoe4 = Shoe("Brazil", "SKU50000", "Aero Brazilliano", 4000, 814)
    shoe5 = Shoe("Australia", "SKU40000", "Outback", 160, 700)



    # Try/Except block to read the information from the file, and display
    # an error that the file does not exist instead of an exception error
    try:

        # If the shoe object file does not exist
        if not short_list:

            # with function to open and read the content of the file
            with open("inventory.txt", "r") as file_data:

                # Retrieving the info and saving it to a list variable
                from_file = file_data.readlines()

                shoe_list = from_file[1:]  # Saving the result to exclude the first

        else:  # If the shoe object list has already been saved in memory

            shoe_list = [str(short_list)]

        shoe_list.append(str(shoe1))
        shoe_list.append(str(shoe2))
        shoe_list.append(str(shoe3))
        shoe_list.append(str(shoe4))
        shoe_list.append(str(shoe5))

        #   List variable to store the information to be used in the tabulate method
        table = [["Country", "Code", "Product", "Cost", "Quantity"]]

        # for loop to append the individual objects to the file
        for shoe_data in shoe_list:

            # Sanitizing data
            shoe_data = shoe_data.replace("\n", "").split(",")
            # Inserting the information into the shoe object and saving the result in a variable
            shoe = Shoe(shoe_data[0], shoe_data[1], shoe_data[2], int(shoe_data[3]), int(shoe_data[4]))

            # Append the variables to the list
            shoes.append(shoe)

            table.append([shoe_data[0], shoe_data[1], shoe_data[2], int(shoe_data[3]), int(shoe_data[4])])

        # Display the result
        print(tabulate(table, headers="firstrow", tablefmt="grid"))

        # Return the list of shoe objects

    # Exception function to display a file not found error
    except FileNotFoundError:
        print("File not found")

    return shoes


# - - - - - - - - - - - - - - - - - - 11111111111111111111111111111111111111111 - - - - - - - - - - - - - - - - - - - #
# Function to search by product code
def search_by_code(item_list):
    # Variable to store the file information without the first row in the file information
    search_list = item_list[1:]
    search_more = "yes"
    # While statement to allow user to enter and search more than 1 product
    while search_more == "yes" or search_more == 'y'\
            or search_more == "no" or search_more == "n":
        # If statement to determine if the user wants to see more products
        if search_more == "yes" or search_more == "y":
            # Variable to store the user's input
            search_item = input("Search by product code: ").upper()

            # For loop to cycle through the shoe objects
            for this_product in search_list:

                # If statement to compare the user input with the information in the shoe object
                if this_product.code == search_item:
                    # Display the result
                    print(f"\t\t----{search_item}---- was found")
                    print(f"""\t\tCountry: {this_product.country}
        SKU Code: {this_product.code}
        Shoe Model: {this_product.product}
        Cost: {this_product.cost}
        Quantity: {this_product.quantity}
        """)

            search_more = input("Search again? yes or no: ").lower()

        elif search_more == "no" or search_more == 'n':
            read_data([])
            return


# - - - - - - - - - - - - - - - - - - 22222222222222222222222222222222222222222 - - - - - - - - - - - - - - - - - - - #
# Function to search by shoe type/product description
def search_by_product(item_list, find_product):
    print("Search by product")
    print("Find:", find_product)

    for this_product in item_list:
        # this_product = this_product.product
        # If statement to compare the product code to the user input
        if str(this_product.product) == find_product:
            # Display the result
            print(f"""\t\tCountry: {this_product.country}
        SKU Code: {this_product.code}
        Shoe Model: {this_product.product}
        Cost: {this_product.cost}
        Quantity: {this_product.quantity}
            """)


# Function to determine the items with the lowest stock count
def lowest_quantity(item_list):
    print("Lowest Quantity")
    # list Variable to store the object list excluding the first line
    # in the list of objects
    i_l_short = item_list[1:]
    # Variable to store the number of lines in the object list
    i_l_length = len(i_l_short)
    # variable to count the number of iterations
    count = 0
    return_count = 0
    # List the first object as the least quantity
    min_stock = i_l_short[0].quantity
    # List variable to store the lowest value
    lowest_stock = list(())
    # While loop to compare all the values in the object list
    while count < i_l_length:
        stock_qty = i_l_short[count].quantity
        # If statement to compare the current value in the object list against the
        # value that is currently stored as the lowest value
        if int(stock_qty) < int(min_stock):
            min_stock = stock_qty
            lowest_stock = i_l_short[count]
            return_count = count
        elif int(i_l_short[0].quantity) == int(min_stock):
            lowest_stock = i_l_short[0]
            return_count = 0

        count += 1

    # Display the result
    print("Country with the lowest stock count:\n", lowest_stock)
    # return the result
    return return_count


# Function to determine the stock with the highest stock count
def highest_quantity(item_list):
    print("highest quantity")
    # list variable to store the shoe object list without the first line in the list
    i_l_short = item_list[1:]
    # variable to store the number of objects in the object list
    i_l_length = len(i_l_short)
    # Variable to store the number of iterations
    count = 1
    # Variable to store the value of the highest stock amount
    max_stock = 0
    # List to store the highest values
    highest_stock = list(())
    # While loop to cycle through the list of objects
    while count < i_l_length:

        # variable to store the current value to be used to compare
        stock_qty = i_l_short[count].quantity
        # If statement to compare the current value against the highest value
        # stored
        if int(stock_qty) >= int(max_stock):
            max_stock = stock_qty
            highest_stock = i_l_short[count]
        count += 1

    print(highest_stock)


# Function to determine the stock value of the items
def value_per_item(item_list):
    print("Stock Value per item:")
    table = [["Country", "Code", "Product", "Cost", "Quantity", "Value"]]
    # for loop to cycle through the shoe object list
    for shoe_data in item_list:
        shoe_data = str(shoe_data).split(",")
        # Append the information to the list variable
        table.append([shoe_data[0], shoe_data[1], shoe_data[2], shoe_data[3], shoe_data[4], shoe_data[5]])

    # Display the result in a tabular format
    print(tabulate(table, headers="firstrow", tablefmt="grid"))


# Function to display a single country's list of items
def display_country(item_list):
    # Variable to save the user input
    search_item = input("Display which country: ")
    # List variable to store the values that match the search criteria
    country_list = []
    print("\n")
    # For loop to cycle through the list of objects
    for country in item_list:
        # If statement to compare the user input to the information in the list.
        if search_item == country.country:
            print(f"""\t\tCountry: {country.country}
        SKU Code: {country.code}
        Shoe Model: {country.product}
        Cost: {country.cost}
        Quantity: {country.quantity}
            """)
        country_list.append(country)

    read_data(country_list)
    return


# Function to replenish stock of a particular item
def replenish_stock(item_list, item_number):
    # list variable to store the object list without the first line in the list
    i_l_short = item_list[1:]
    print(f"Update Stock: {i_l_short[item_number]}")
    # Variable to store the user input
    add_stock = input("Enter the amount of stock to be added: ")
    # Adding the user input to the object in the object list
    item_list[int(item_number) + 1].quantity = str(int(item_list[int(item_number) + 1].quantity) + int(add_stock))
    # Update the information in the file
    update_file(item_list)
    # Return the updated list
    return item_list


# Function to update the file with new information
def stock_update(shoe_list):
    print("- - - - - - - - - - Stock Update - - - - - - - - - -")

    new_list = []
    read_data(shoe_list)
    new_list.extend(shoe_list)

    sku = input("Enter SKU to update: ")

    # For loop to cycle through the object list
    for shoe_item in shoe_list:
        # If statement that checks if the user input matches
        # the information in the object list
        if shoe_item.code == sku:

            # Display the result
            print(f"""\t\tCurrent Stock amount for {shoe_item.code}:
        Country: {shoe_item.country}
        Description: {shoe_item.product}
        Quantity: {shoe_item.quantity}
        Cost: {shoe_item.cost}""")
            # Variable to store user input
            update = input("Enter quantity to add: ")
            # If statement to check if the value entered is greater than 0
            if int(update) > 0:
                shoe_item.quantity = int(shoe_item.quantity) + int(update)

            else:
                print("the update was unsuccessful, please try again")

    update_file(shoe_list)


# Append new items to the end of the file
def save_to_file(add_list):

    print("Saving to File")
    # With statement to open and save the contents to file
    with open("inventory-test.txt", "a") as f:
        for item in add_list:
            print(item)
            f.write(f"\n{item}")


# Update the file with all changes to the information
def update_file(add_list):

    # Variable to store the number of items in the object list
    data_len = len(add_list)
    # Variable to count the number of iterations
    counter = 0
    # With statement to open and read the contents of the file
    with open("inventoryTest.txt", "w") as f:
        # For loop to cycle through the object list
        for item in add_list:
            # If statement to save the information to the file
            if counter < (data_len - 1):
                f.write(f"{item}\n")
                counter += 1
            else:
                f.write(f"{item}")
    return


# Function to add new shoes(items) to the existing list
def add_shoe():
    print("Add Shoe items")
    # List variable to store the list of new shoe objects
    new_list = list(())

    # variable to store user's response to adding more shoe objects
    option = input("Add another? Yes or no?").lower()
    
    # While statement to determine if the user wants to add more than 1 new shoe object
    while option == "yes" or option == "y" or option == "no" or option == "n":
        if option == "yes" or option == "y":
            new_country = input("Enter the country: ")
            new_code = input("Enter the SKU code: ")
            new_product = input("Enter the product name: ")
            new_cost = input("Enter the cost per item")
            new_quantity = input("Enter the quantity")

            new_list += [Shoe(new_country, new_code, new_product, new_cost, new_quantity)]
            option = input("Add another? ").lower()

        elif option == "no" or option == "n":
            print("No")
            # If statement to save the new list of objects to the file
            if new_list:
                save_to_file(new_list)
            main()

    else:
        print("Incorrect option")


# main function
def main():

    option = ""
    shoe_list = read_data([])

    while option != "quit":
        option = input("""
1. Search by product code
2. Search by product description
3. Display a country
4. Determine lowest stock
5. Determine highest stock
6. Calculate value per item
7. Stock Adjustment
0. Quit
: """).lower()

        if option == "1":  # Search by product code
            print("Option 1")
            if not shoe_list:
                print("No data available.")
                pass
            else:
                search_by_code(shoe_list)

        elif option == "2":  # Search by product description
            print("Option 2")
            search_item = input("Enter shoe model: ")
            search_by_product(shoe_list, search_item)

        elif option == "3":  # Display a country
            print("Option 3")
            display_country(shoe_list)

        elif option == "4":  # Determine the lowest stock
            print("Option 4")
            # print(shoe_list)
            item_number = lowest_quantity(shoe_list)
            print(item_number)
            replenish_stock(shoe_list, item_number)

        elif option == "5":  # Determine the highest stock
            print("Option 5")
            highest_quantity(shoe_list)

        elif option == "6":  # Calculate the value per item
            print("Option 6")
            value_per_item(shoe_list)

        elif option == "7":  # Stock adjustment

            print("Stock Adjustment")
            adjust_option = input("""
            1. Update Stock (u)
            2. Add Stock Items (a)
            3. Go Back (b)
            : """).lower()

            if adjust_option == "1" or adjust_option == "u":
                print("Update Stock")
                stock_update(shoe_list)

            elif adjust_option == "2" or adjust_option == "a":
                print("Add Product Items")
                add_shoe()

            elif adjust_option == "3" or adjust_option == "b":
                continue
            else:
                print("The option entered is incorrect. Try Again")
            main()

        elif option == "quit" or option == "0":
            exit()
        else:
            print("Oops, you entered the  incorrect option")
            main()


main()

