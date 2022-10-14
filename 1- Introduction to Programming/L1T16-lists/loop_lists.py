
# Define a list of strings of your 5 favourite movies
fav_movies = ["Never-Ending Story", "Avengers", "Spider-Man", "It", "Adams Family"]
# Variable to store the title 'Movie:
movie_list = list(())
lists = ""

# For loop to cycle through the movies and enumerating each value
for count, name in enumerate(fav_movies):
    print(f"Movie {count + 1}: {name}")
    
    lists += f"Movie {count + 1}: {name}. "

print("\n")

# List the movies in a single line
print(lists)
    
