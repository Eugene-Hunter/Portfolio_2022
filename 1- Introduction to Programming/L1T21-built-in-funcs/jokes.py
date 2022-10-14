#● You are going to create a random joke generator using Python’s random
#module. This will require a bit of research on your part. For more
#information on the random module:
#https://pynative.com/python-random-module/
#● Create a list of jokes.
#● Use the random module to display a random joke each time the code
#runs.

# Import random module to randomize the output
import random

# Variable to store the user's response should they want to read another joke
answer = "y"

# While loop to show another joke should the user wish to read more
while answer == "y" or answer == "yes" or answer == "no" or answer == "n":
    print("\n")
    # If statement to display another joke if the user entered "yes" or "y"
    if answer == "y" or answer == "yes":
        # list variable to store the jokes
        jokes = ["Q: Why do we tell actors to break a leg?\n\nA: Because every play has a cast.",
             "Q: How do poets say hello?\n\nA: Hey, haven't we metaphor?",
             "Q: How does a rabbi make his coffee?\n\nA: Hebrews it.",
             "Q: Why did the gym close down?\n\nA: It just didn't work out.",
             "Q: Why do bees have sticky hair?\n\nA: Because they use honeycombs.",
             "Q: Did you hear about the man who got hit by the same bike every morning?\n\nA: It was a vicious cycle.",
             "I got arrested for downloading the whole wikipedia.\n\nI told them I could explain everything.",
             "Q: How do you make a tissue dance?\n\nA: You put a little boogie in it.",
             "Q: What did the fish say when it swam into a wall?\n\nA: Dam.",
             "Q: There are three types of people in the world\n\nA: Those who can count and those who can't."]

        # Display a random joke from the jokes list
        print(random.choice(jokes))

        # Request the user to input their response to reading another joke
        answer = input("\nWant to see another joke? ").lower()
    # Elif statement to exit the program if the user no longer wants to see anymore jokes    
    elif answer == "no" or answer == "n":
        print("Thanks for playing. Good-bye.")
        exit()

    # Else statement requesting the suer to enter either yes or no if the user type in the incorrect response
else:
    answer = input("Yes or no: ").lower()


