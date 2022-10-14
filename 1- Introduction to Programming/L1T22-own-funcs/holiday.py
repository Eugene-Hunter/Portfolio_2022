
#● hotel_cost — This function will take the number of nights a user
#will be staying at a hotel as an argument, and return a total cost for
#the hotel stay (You can choose the price per night charged at the
#hotel).

# Function to calculate the overnight costs
def hotel_cost(nr_of_nights):
    
    # store the information from the user in a local variable
    nr_of_nights = int(nr_of_nights)
    room_cost = 450.00
    # Display the result on screen
    print(f"Total: {nr_of_nights} nights x R {room_cost} per room = R " + str(float(room_cost) * nr_of_nights) + "\n")

    #print(f"Cost per night: R ((room_per_night} * {nr_of_nights}) = R {room_per_night} per night x {nr_of_nights} nights.")
    return (room_cost * nr_of_nights)


#● plane_cost — This function will take the city you are flying to as an
#argument and return a cost for the flight (Hint: use if/else if
#statements in the function to retrieve a price based on the chosen
#city)

# Function to calculate the plane cost
def plane_cost(city):
    
    # While loop to request user to enter the information that is accepted
    while city != "Johannesburg" and \
          city != "Bloemfontein" and \
          city != "Cape Town" and \
          city != "Durban" and \
          city != "1" and \
          city != "2" and \
          city != "3" and \
          city != "4":
        print(f"The city {city} is not available, please try again.\n")
        city = input("Please enter Johannesburg, or Bloemfontein, or Cape Town or Durban: ")

    # Else statement when the information entered is accepted    
    else:
        
        print("Air travel cost:\n")

        # If function calculating the cost to Johannesburg
        if city == "Johannesburg" or city == "1":
            plane_cost = 2500.00
            print(f"Plane ticket to Johannesburg = R {plane_cost}\n")

        # Elif function calculating the cost to Cape Town        
        elif city == "Cape Town" or city == "2":       
            plane_cost = 1500.00
            print(f"Plane ticket to Cape Town = R {plane_cost}\n") 

        # Elif function calculating the cost to Durban
        elif city == "Durban" or city == "3":     
            plane_cost = 1700.00
            print(f"Plane ticket to Durban = R {plane_cost}\n")   
            
        # Elif function calculating the cost to Bloemfontein
        elif city == "Bloemfontein" or city == "4":    
            plane_cost = 1800.00
            print(f"Plane ticket to Bloemfontein = R {plane_cost}\n")    
        
        return plane_cost
        
        
#● car_rental — This function will take the number of days the car will
#be hired for as an argument and returns the total cost of the car
#rental.
# Function to calculate the car rental cost
def car_rental(nr_of_days):
    print("Car Rental:\n")
    nr_of_days = int(nr_of_days)
    hired_car = 150.00
    print(f"Total: {nr_of_days} days x R {hired_car} per day = R " + str(float(hired_car) * nr_of_days) + "\n")
    return hired_car * nr_of_days
    

#● holiday_cost — This function will take three arguments: the
#number of nights a user will be staying in a hotel, the city the user
#will be flying to and the number of days that the user will be hiring
#a car for.

# Function to calculate the total cost of the holiday and display it on the screen
def holiday_cost(hotel_room, plane_ticket, car_rental):
    print("\t\t---- Holiday Cost: ----\n")
    # Storing the total cost in a local variable
    total = float(hotel_room) + float(plane_ticket) + float(car_rental)

    # Display the result on screen
    print(f"""\t\tTotal cost of holiday:\n
            \tHotel cost\t: R {hotel_room}\n
            \tPlane ticket\t: R {plane_ticket}\n
            \tCar Rental\t: R {car_rental}
            \t\t\t___________\n
            \tTotal: \t\t: R {total}\n""")

# Variable that stores the request for the user and calls the function to calculate the hotel cost
hotel_fare = hotel_cost(input("How many nights are you booking into the hotel? "))
# Variable that stores the request for the user and calls the function to calculate the aor travel cost
print("""Which city are you flying to?
        1. Johannesburg
        2. Cape Town
        3. Durban
        4. Bloemfontein?""")
plane_fare = plane_cost(input("Enter City: "))

# Variable that stores the request for the user and calls the function to calculate the car rental cost
car_fare = car_rental(input("How many days are you hiring a vehicle? "))

holiday_fare = holiday_cost(hotel_fare, plane_fare, car_fare)


# Using these three arguments, you can call all three of the
#above functions with respective arguments and finally return a
#total cost for your holiday.
#● Print out all the details about the holiday in a meaningful way!
#● Try using your program with different combinations of input to show its
#compatibility with different options.



