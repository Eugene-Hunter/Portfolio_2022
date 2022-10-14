#● You need to design a program for a courier company to calculate the cost
#of sending a parcel.
# initialise variables:
total_cost = 0.00
package_prices = ((5.50,7.95,10.00,15.25,25.50,30.20,45.15,60.75,80.90,99.99))
package_cost = 0.00
distance_km = 0
delivery_method = ""
air_delivery = 0.36
freight_delivery = 0.25
insurance = ""
full_insurance = 50.00
limited_insurance = 25.00
gift = ""
gift_cost = 15.00
priority = ""
priority_delivery = 100.00
standard_delivery = 20.00
#● Ask the user to enter the price of the package they would like to purchase.

print("The price of our packages are as follows: ")
for x in range(len(package_prices)):
    print(f"R{package_prices[x]:.2f}")
   
print("\n")

package_cost = input("Please enter the price of the package you would like to purchase: R")
total_cost += float(package_cost)

print("\n")
#● Ask the user to enter the total distance of the delivery in kms.
distance_km = int(input("Please enter the total distance of the delivery: "))

print("\n")

#● Now add on the delivery costs to get the final cost of the product:
delivery_method = input("Please select the method of delivery: 'Air' or 'Freight': ").lower()
#▪ Air R0.36 per km or freight R0.25 per km
if delivery_method == "air":
    print("You selected air delivery.")
    delivery_cost = float(distance_km)*0.36
    print(f"Delivery cost: {distance_km} km x R{air_delivery:.2f} = R{delivery_cost:.2f} ")
else:
    print("You selected freight delivery.")
    delivery_cost = float(distance_km)*0.25
    print(f"Delivery cost: {distance_km} km x R{freight_delivery:.2f} = R{delivery_cost:.2f} ")

total_cost += delivery_cost
print("\n")
#o There are four categories to factor in when determining a parcel’s
#final cost, each with two options based on their delivery
#preferences. (Use an if-else statement based on the choice they
#make.)


#▪ Full insurance R50.00 or limited insurance R25.00
insurance = input("Please confirm if full insurance is required for R50.00, or limited insurance for R25.00: (Type in 'full'or 'limited'): ").lower()

if insurance == "full":
    print(f"You opted for full insurance")
    print(f"Insurance: R{full_insurance:.2f} + {total_cost:.2f} = R{(total_cost + full_insurance):.2f} ")
    total_cost += full_insurance
    
else:
    print(f"You opted for limited insurance")
    print(f"Insurance: R{limited_insurance:.2f} + {total_cost:.2f} = R{(total_cost + limited_insurance):.2f} ")
    total_cost += limited_insurance
    
print("\n")

#▪ Gift R15.00 or no gift R0.00
gift =  input("Please confirm if you would like to add a gift at R15.00, 'yes' or 'no': (Type in 'yes' or 'no'): ").lower()
print("\n")

if gift == 'yes':
    print(f"Gift: R{gift_cost:.2f} + {total_cost:.2f} = R{(total_cost + gift_cost):.2f} ")
    print("\n")
    total_cost += gift_cost 
else:
    print(f"No gift was included")
    print("\n")
    
#▪ Priority R100.00 or standard delivery R20.00
priority = input("Please confirm if it is either priority delivery at R100.00 or standard delivery at R20.00: (Type in 'Priority' or 'Standard': ").lower()
if priority == "priority":
    print("You selected priority delivery")
    print(f"Priority delivery: R{priority_delivery:.2f} + {total_cost:.2f} = R{(total_cost + priority_delivery):.2f} ")  
    total_cost += priority_delivery
else:
    print("You selected standard delivery")
    print(f"Standard delivery: R{standard_delivery:.2f} + {total_cost:.2f} = R{(total_cost + standard_delivery):.2f} ")
    total_cost += standard_delivery
#● Work out the total cost of the package based on the selection in each
#category.
print("\n")

print(f"The total cost to deliver your parcel = R{total_cost}.")
