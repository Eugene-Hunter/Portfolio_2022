#ask the user to enter the name of three products
product1 = input("Product 1: ")
product2 = input("Product 2: ")
product3 = input("Product 3: ")

# Now ask for the price of each product. Each product must have two decimal
#values.
price1 = float(input(f"Price for {product1}: "))
price2 = float(input(f"Price for {product2}: "))
price3 = float(input(f"Price for {product3}: "))

#Calculate the total of all three products.
total = round((float(price1 + price2 + price3)),2)

#Calculate the average price of the three products. (Hint: you may want to
#look up round() )
avg = round(total/3,2)

#Then print out the following sentence after performing your calculations:

#“The Total of [product1], [product2], [product3] is Rxx,xx and the
#average price of the items is Rxx,xx.”

print(f"The total of {product1}, {product2}, {product3} is R{total}, and the average price of the items is R{avg}")
