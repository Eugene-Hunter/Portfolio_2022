# Funtion to list all the days of the week

def days_of_week():

    # Local dictionary to store the days of the week
    week_days = ["Sunday",
                 "Monday",
                 "Tuesday",
                 "Wedneday",
                 "Thursday",
                 "Friday",
                 "Saturday"]

    # Display the result
    print("The days of the week: " + str(week_days).replace("'","").replace("[","").replace("]", ""))

    # Retun statement to get back to the main process
    return


def replace_words(z):

    sentence = list(())
    sentence = z.split(" ")
    new_sentence = ""
    x = 0
    while x < len(sentence):
        if x%2 != 0:
            new_sentence += " \"Hello\" "
            x += 1
        else:
            new_sentence += " " + sentence[x] + " " 
            x += 1
    print(new_sentence)    
        
    return


# Calling the function
days_of_week()

#sentence = "Mary had a little lamb, it's fleece as white as snow..."

# While loop to allow user to enter multiple sentences
answer = "y"
while answer == "y" or answer == "yes":

    # Request user to type in a sentence
    sentence = input("Type a sentence: ")

    # calling the function
    replace_words(sentence)

    # Asl the user if they want to type in another sentence
    answer = input("Do another sentence? ")

# Else statement to exit the program
else:
    exit()



