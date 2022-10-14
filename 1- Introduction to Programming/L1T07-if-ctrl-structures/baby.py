#● Ask the user to enter the year they were born and calculate if they are 18 or
#older.
birth_year = int(input("What year were your born? : "))
current_year = 2022
print("\n")
#● If they are 18 or older, then display a message saying “Congrats you are old
#enough.”
if (current_year - birth_year) >= 18:
    print("Congrats, you are old enough")
else:
    print("Sorry, you are not old enough")
