
# Function to populate and display the minefield grid 
def grid():

    minefield_grid = [ ["-", "#", "-", "-", "-"],
                       ["-", "-", "-", "#", "-"],
                       ["#", "-", "-", "-", "#"],
                       ["-", "-", "#", "-", "-"],
                       ["-", "#", "-", "-", "-"] ]
    # Count the number of rows
    grid_rows = len(minefield_grid)

    
    # For loop to count number of columns per row
    for row in (range(grid_rows)):

        # Count the rows
        grid_cols = len(minefield_grid[row])

    # For loop to iterate through the rows
    for row in (range(grid_rows)):
        # For loop to iterate through the columns
        for col in (range(grid_cols)):
            # If function to determine if the block contains the '-' sign
            if minefield_grid[row][col] == "-":
                minefield_grid[row][col] = 0

                # If function to determine if the upper left diagonal block exist 
                if (row - 1) >= 0 and (col - 1) >= 0:

                    # If function to determine if the upper left diagonal block contains the '#' key 
                    if minefield_grid[row - 1][col - 1] == "#":

                        # IF true, add one to the count 
                        minefield_grid[row][col] += 1
                        
                # If function to determine if the upper middle block exist         
                if (row - 1) >= 0:
                    # If function to determine if the upper middle block exist contains the '#' key 
                    if minefield_grid[row - 1][col] == "#":
                        
                        # IF true, add one to the count 
                        minefield_grid[row][col] += 1
                        
                # If function to determine if the upper right diagonal block exist 
                if (row - 1) >= 0 and (col + 1) < len(range(grid_cols)):

                    # If function to determine if the upper right diagonal block contains the '#' key 
                    if minefield_grid[row -1][col + 1] == "#":

                        # IF true, add one to the count
                        minefield_grid[row][col] += 1

                # If function to determine if the block to the left exist 
                if (col - 1) >= 0:

                    # If function to determine if the block to the left contains the '#' key 
                    if minefield_grid[row][col - 1] == "#":

                        # IF true, add one to the count 
                        minefield_grid[row][col] += 1
                        
                # If function to determine if the block to the right exist 
                if (col + 1) < len(range(grid_cols)):

                    # If function to determine if the block to the right contains the '#' key 
                    if minefield_grid[row][col + 1] == "#":

                        # IF true, add one to the count 
                        minefield_grid[row][col] += 1

                # If function to determine if the lower left diagonal block exist 
                if (row + 1) < len(range(grid_rows)) and (col - 1) >= 0:

                    # If function to determine if the lower left diagonal block contains the '#' key 
                    if minefield_grid[row + 1][col - 1] == "#":

                        # IF true, add one to the count 
                        minefield_grid[row][col] += 1

                # If function to determine if the lower middle block exist 
                if (row + 1) < len(range(grid_rows)):

                    # If function to determine if the lower middle block contains the '#' key 
                    if minefield_grid[row + 1][col] == "#":

                        # IF true, add one to the count 
                        minefield_grid[row][col] += 1
                        
                # If function to determine if the lower right diagonal block exist 
                if (row + 1) < len(range(grid_rows)) and (col + 1) < len(range(grid_cols)):
                    
                    # If function to determine if the lower right diagonal block contains the '#' key 
                    if minefield_grid[row +1][col + 1] == "#":
                        
                        # IF true, add one to the count 
                        minefield_grid[row][col] += 1

        # Display the result each time all the colums of the row have been checked and counted
        print(str(minefield_grid[row]).replace("[","['").replace("]", "']").replace(", " , "', '").replace("''" , "'") )           


# Calling of the function 
grid()
