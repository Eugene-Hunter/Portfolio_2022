
# Abbreviations dictionary
abbr = {"btw" : "By the way" , "ex" : "Example" , "l." : "Litre", "eta" : "estimated time of arrival"}
# Add another 2 abbreviations
abbr.update({"ms." : "millisecond"})
abbr.update({"abbr." : "abbreviation"})

# vairable to store the user's choice for multiple searches
more = 'yes'

# While loop to allow user to search and display more than 1 abbreviation
while more == 'yes' or more == 'y':
    abbr_lookup = input("Enter an abbreviation to find: ").lower()

    if abbr_lookup in abbr:
        print(f"\n{abbr_lookup}: {abbr.get(abbr_lookup)}\n")


    elif abbr_lookup not in abbr:
        print("\nAbbreviation not found\n")

    more = input("Would you like to search for another abbreviation? ")

    else:
        print("Good-bye")
        exit()
