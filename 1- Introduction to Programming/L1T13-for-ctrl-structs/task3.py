
# control variables


# Display the Countdown from 20 to 1
print("Display the countdown from 20 to 1")

countdown = 20

for x in range(countdown):

    # Decrement the count_down value with the value of x
    print(countdown - x)
       
print("\n")

# Print all even numbers between 1 and 20
print("Print all even numbers between 1 and 20")

all_even = 20

for even in range(all_even):
    if even == 0:
        continue
    # Determine and print the number if it is an even number
    if even % 2 == 0:
        print(str(even))

print("\n")

# Print 5 rows of stars incrimenting each loop with 1 star
print("Print stars in increments of 1")

star_range = 5
stars = ""

# For loop to increase the number of stars
for x in range(star_range):
    stars += "*"
    print(stars)
        
print("\n")

# Compute the greatest common divisor (GCD, or #highest common factor) of two
# positive integers

positive_int1 = int(input("Enter a value greater than 0: "))
positive_int2 = int(input("Enter a second value greater than 0: "))

# variable to store the greatest common divisor result
gcd = 0

# For loop to determine the greatest common divisor
for divisor in (range(positive_int1)) and (range(positive_int2)):
        if divisor == 0:
            continue
        # Get the next divisor of both integers
        common_denom1 = positive_int1 % (divisor)
        common_denom2 = positive_int2 % (divisor)

        # Determine if both integers are possible divisors
        if common_denom1 == 0 and common_denom2 == 0:

            # Store the value of the next and greater common divisor
            # divisor is the n-th loop iteration starting with 0
            gcd = divisor

            # Print statement showing all the common divisors for control and validation purpose
            #print(str(divisor) + ": " + str(common_denom1) + " " + str(common_denom2))

# Output the result
print(f"The greatest common divisor of the 2 values is {gcd}.")




