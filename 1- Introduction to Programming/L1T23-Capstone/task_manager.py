

#=====importing libraries===========
import os # To Check if file exist, delete files
import datetime # To add dates in date format

#====Login Section====

user_list = ""

# Function to read from the user.txt file and return
def save_to_file(filename, info = "NONE"):
    with open(filename, 'w') as f:
        f.write(info)
    return

# Retrieve user list (user.txt), split the contents and return the result
def read_txt_file(file):
    f = open(file, "r")
    contents = f.read()
    f.close()
    contents = contents.split('\n')
    # Return the result
    return contents


# Function for logging in 
def login_func():
    access = False
    print("------------------ " + str(datetime.datetime.now().strftime("%d %b %Y")) + "---------------------")
    # While function to determine if the login details are correct 
    while access == False:
        u_name = input("Username: ")
        p_word = (input("Password: "))
        access = user_test(u_name, p_word, "login")
        
    return access


# function to check if username and password correspond
def user_test(*z):
    
    username = z[0]
    password = z[1]
    action = z[2]
    users = read_txt_file("user.txt")
    
    global users_d # Users dictionary
    global current_user
    
    user = list(())# List to store the individual user information
    message = "" # Variable to store the error message


    # If statement to verify login information
    if action == "login":    # For loop to split the username and password and store it in a dictionary
        
        for user in users:

            user = user.split(", ") # Separate usernames from passwords

            users_d = {"username" : user[0], "password" : user[1]} # Assign information to dictionary variable

            if username == users_d["username"]: # If statement to verify if the username is in the user.txt file

                if password ==  users_d["password"]: # If statement to verify if the password matches the password for the username

                    current_user = username
                    
                    return True # Return True is the username and password is accepted

            else:

                message = "Username or password incorrect."
                
        print(message)

        return False # Return False if the username of password is incorrect
    


    if action == "r": # If statement to check for username  duplicates
        
        for user in users: # For loop to cycle through the username list
            
            user = user.split(", ") # Split the username and passwords in the list
            
            users_d = {"username" : user[0]} # Assign the username to the users_d variable
            
            if username == users_d["username"]: # If statement to compare the new username entered
                                                # against the username in the list 
                
                print("The username already exist. Enter a different name.") # Display a message if the username already exists
                
                return True # Return True if the username has already been used
            
        return False # Return False if the username does not yet exist          
  

    
    if action == "a": # If statement to determine if the task is assigned to a user that uses the program
        
        for user in users: # For each line of data save the information to the user variable
            
            user = user.split(", ") # Split the file contents and store the result
            
            users_d = {"username" : user[0]} # assign username to dict variable
            
            if username != users_d["username"]: # If statement to determine if the 
                
                message = "The username entered is not registered, please try again." # Message stored in a variable if the user is not a registered user

            else: # Else statement if the username is a registered user
                return True # Return True
            
        print(message) # Display message if the username is not registed          
        return False # Return False

# Function to register a new username
def reg_user():
    
    print("Enter the new user's details:\n")

    used_name = True # Variable to store the boolean result about whether the username is registered or not

    new_user = "" # initialize the variable used to store the newly entered username

    new_p_word = "" # Initialise the the variable used to store the new password

    # While loop to check if username is already in use
    while used_name == True:  

        # Request the user to enter the username
        new_user = input("Name: ")      

        # function to check if the username is already in use and return the boolean result if it is already in used or not
        used_name = user_test(new_user, "", "r") # function call 


    # if the username is not in use, the password can then be created and stored

    if used_name == False: # If statement to allow the new user's details to be stored if the variable results to False

        p_word_match = False # If statement to confirm if the password and confirm password variables match
        
        while p_word_match == False: # While loop to check if the passwords match
        
            new_p_word = input("Password: ") # Request user to enter a password
           
            confirm_p_word = input("Confirm password: ")# Request user to re-enter the password

            if new_p_word != confirm_p_word: # If statement to determine if the passwords match 

                print("The passwords do not match.") # Display the result if the passwords do not match

                p_word_match = False # Return the False result if the passwords do not match

            else:

                p_word_match = True # REturn the True result if the passwords match

            
                    
        with open("user.txt", "a") as f: # Saving the new username and password in the user.txt file

            f.write("\n")

            f.write(f"{new_user}, {new_p_word}")
                
        print(f"{new_user} has been successfully registered.\n\n") # Confirm that the new username and password has been stored in the file

# Function to add a new task
def add_task():
    
        
    answer = 'y' # Variable to store the user's decision on adding more than 1 task
        
    while answer == 'y' or answer == 'yes' or answer == 'no' or answer == 'n': # While loop to add more than 1 task

        if answer == 'y' or answer == 'yes':
            
            user_registered = False # Request the user to enter the assigned user's name

            while user_registered == False: # While statement to allow the user to create multiple tasks
                
                assigned_to = input('Assigned to: ').lower()
                
                user_registered = user_test(assigned_to, '' , 'a')
                            
            task_title = input('Title: ').title() # Request user to enter a title for the task
            
            task_date = datetime.datetime.now().strftime('%d %b %Y') # Store the current variable
            
            due_date = input('Due date(YYYY-MM-DD): ') # Request the user to enter a due date for the task
            due_d = due_date.split("-")
            year = int(due_d[2])
            month = int(due_d[1])
            day = int(due_d[0])
              
            due_date = datetime.datetime(day, month, year).strftime('%d %b %Y')
            
            task_description = input('Description: ') # Request user to enter the description of the task 
                
            task_complete = '' # Variable to store the completion status of the task
            
            while task_complete != 'yes' and task_complete != 'no': # While loop to request user to enter the status of the task
                
                task_complete = input('Has the task been completed? "yes" or "no": ').lower()

                if task_complete == 'y':
                    task_complete = 'yes'

                elif task_complete == 'n':
                    task_complete = 'no'


            
            with open('tasks.txt', 'a') as f: # Writing the contents to file
 
                f.write(f'\n{assigned_to}, {task_title}, {task_description}, {task_date}, {due_date}, {task_complete}')
            
                print('\nThe task has been added to the task file.\n') # Confirmation of the task added to the tasks,txt file
             
        elif answer == 'no' or answer == 'n':
            return
         
        answer = input('Would you like to add another task? (y)es or (n)o:').lower() # Ask user if another task needs to be added or not

# Function to edit the task
def edit_task(tasks):

    
    task_select = int(input("Select a task to edit, or -1 to go to the main menu: ")) # Request the user to enter a task to edit

    if task_select == -1: # If statement to return the user to the main menu
        
        return # Return to the main 
   
    task_sel = str(tasks[task_select - 1]).split(', ') # Variable to split and store the result of the contents of the tasks list   
    
    
    # Listing the task
    print(f'''
        Assigned To\t| {task_sel[0]}
        Title\t\t| {task_sel[1]} 
        Description\t| {task_sel[2]}
        Date Assigned\t| {task_sel[3]}
        Due date\t| {task_sel[4]}
        Task Complete\t| {task_sel[5]}\n
        ''')
    
    if task_sel[5] == "Yes": # If statement to determine if the tasks can still be updated if not
        
        print("The task can no longer be updated.\n\n") # Print the result if the task can no longer be updated
        
        return # Return to the main menu

    # Request the user to choose an option 
    submenu = input("""What would you like to do?
    1. Mark the task as complete
    2. Edit the task information
    (1) or (2): """)

    # If statement to select the option to mark the task as complete
    if submenu == "1":

        
        task_complete = input("Mark the task as complete? (y)es or (n)o: ").lower() # Request the user to select the option if the
                                                                                    # task should be marked as complete or not
        
        
        if task_complete == 'yes' or task_complete == 'y': # If task is complete, then change tasks_db x[5] to 'Yes'
            
            task_sel[5] = 'Yes'
            
        elif task_complete == 'no' or task_complete == 'n': # If statement to go back to the previou menu
            pass
        
        else: # Else statement to request the user to re enter the choice of the value entered is not equal to yes or no
            print("Please enter (y)es or (n)o.")

    # Elif statement to allow the user to edit the rest of the task's information        
    elif submenu == "2":

        
        option = 0

        # While loop to allow the user to edit more than one piece of task information
        while option != "6" and task_sel[5] != "Yes":
        
            print("""Edit task information")
            1. Reassign
            2. Edit Title
            3. Edit Description
            4. Edit Due Date
            5. Save and Exit
            6. Exit without Saving
            """)
            option = input("\t\t: ")

            # If statement to allow the user to edit the username to which the task is assigned to
            if option == "1":
                
                # Variable to store the boolean value about whether the new username is registered to use the program
                user_registered = False

                # While statement to allow the user to re-enter the new username
                # the task has been assigned to multiple times
                while user_registered == False:

                    
                    edit = input("Reassign To (Leave blank to skip): ") # Request user to enter the username the task should be assigned to 

                    if edit != "": # If statement to determine if the user entered text or left the option blank

                        # Calling the function to compare the username with the user list                       
                        verify = user_test(edit, "", "e")

                        # If statement to determine if the username entered was found in the user list
                        if verify == True:
                            
                            task_sel[0] = edit
                            user_registered = True
                            
                    # Else statement to inform the user that the usernamen entered was not found in the list
                    else:
                        print("Username is not registered in the database, check your spelling.")
                        
            # Elif statement to allow the user to edit the title of the task
            elif option == "2":
                edit = input("Edit Title (Leave blank to skip): ")
                if edit != "":
                    task_sel[1] = edit
            # ELif statement to allow the user to edit the description of the task
            elif option == "3":
                edit = input("Edit Description (Leave blank to skip): ")
                if edit != "":
                    task_sel[2] = edit
            # Elif statement to allow the user to change the due date of the task
            elif option == "4":
                edit = input("Change due date (Leave blank to skip): ")
                if edit != "":
                    task_sel[3] = edit
            # Elif option that will take the user up to the previous submenu
            elif option == "5":
                break
            #Elif statement that will take the user to the main menu
            elif option == "6":
                return
            # Else statement to inform the user that the option entered was not valid
            else:
                print(" The option you entered is not correct, try again.")
        

    # Remove the task from the list 
    tasks.pop(task_select - 1)

    # Insert the task with new information and sanitize the information
    tasks.insert((task_select - 1), str(task_sel).replace("'", "").replace("[", "").replace("]", "").replace("\"", ""))

    #  sanitize the entire list of any unwanted characters
    str(tasks).replace("'", "").replace('"', '')

    
    save = str()
    count = 1

    # For loop to cycle through the individual tasks
    for x in tasks:

        # If statement to determine if the current position is still within the bounds of the length of the task
        if count < len(tasks):

            # Save the information to a new variable
            save += f'{x}\n'
            
            print(count)
            count += 1
         
        else: # Else statement to save the last entry of the list without the additional new line
            save += f'{x}'
        
    # Save the information to the file tasks.txt
    save_to_file("tasks.txt", save)
        
    return # Return statement to take the user back to the main menu

# Function to view all the tasks
def view_all():

    
    print(f"Current user logged in: {current_user}\n")
   
    tasks = read_txt_file("tasks.txt") # Variable to store the contents of the tasks.txt file

    task_grid(tasks) # Calling the function to format the information into a table

    print("------------- Edit Tasks Menu --------------")
       
    edit_task(tasks) # Calling the function to allow the user to edit tasks


def view_mine():
    #print(f"Current user logged in: {current_user}\n")
    tasks = read_txt_file("tasks.txt")
    #tasks = tasks.split("\n")
    my_tasks = list(())
    
    # For loop to display the tasks in the tasks.txt file
    for x in tasks:
        
        # Split the contents of the information stored in the tasks variable
        new_tasks = x.split(", ")
        #tasks_num += 1
        if new_tasks[0] == current_user:
        #task_number += 1
            my_tasks.append(str(new_tasks).replace("[", "").replace("]", "").replace("'", ""))
    


    
    task_grid(my_tasks) # Calling the function to format the information into a table
    

# Funtion to format the information into a table
def task_grid(tasks):
    # Variables used to initialise the formatting of the information into the table layout
    task_num = 0
    task_number = 0
    reass_to = ""
    new_title = ""
    new_desc = ""
    tasks_num = 0

    # Display the header row of the table
    print("_________________________________________________________________________________________________________________________________________________________")
    print("|  #  | Assigned To     | Title                     | Description                                        | Date Assigned |   Due Date   | Task Complete |")
    print("|_____|_________________|___________________________|____________________________________________________|_______________|______________|_______________|")


    # For loop to display the tasks in the tasks.txt file
    for x in tasks:
        
        # Split the contents of the information stored in the tasks variable
        new_tasks = x.split(", ")
        tasks_num += 1

        task_number += 1

        # If statement to determine if the length of the information exceeds the maximum size
        # of the column width and to limit the length 
        if len(new_tasks[0]) > 15:
            reass_to = new_tasks[0][0 : 12] + "..."
        else:
            a = 1
            space1 = " "
            while a < (15 - len(new_tasks[0])):
                space1 = space1 + " "
                a += 1
                
            reass_to = new_tasks[0] + space1

        # If statement to determine if the length of the information exceeds the maximum size
        # of the column width and to limit the length 
        if len(new_tasks[1]) > 25:
            new_title = new_tasks[1][0 : 22] + "..."
        else:
            b = 1
            space2 = " "
            while b < (25 - len(new_tasks[1])):
                space2 += " "
                b += 1
                
            new_title = new_tasks[1] + space2

        # If statement to determine if the length of the information exceeds the maximum size
        # of the column width and to limit the length 
        if len(new_tasks[2]) > 50:
            new_desc = new_tasks[2][0 : 47] + "..."
        else:
            c = 1
            space3 = " "
            while c < (50 - len(new_tasks[2])):
                space3 += " "
                c += 1
            new_desc = new_tasks[2] + space3

        if new_tasks[5] == "Yes":
            task_completed = "Yes           "
        else:
            task_completed = "No            "
            

            # Print the result of the tasks
        print(f"""| {task_number}   | {reass_to} | {new_title} | {new_desc} |  {new_tasks[3]}  | {new_tasks[4]}  | {task_completed}|""")
        print("|_____|_________________|___________________________|____________________________________________________|_______________|______________|_______________|")

    return # Return statement to return the user to the main menu

# Function to generate reports
def generate_reports():

    # Calling the task_overview function and inserting the tasks.txt information as parameter
    tasks = task_overview(read_txt_file("tasks.txt"), True)

    # Calling the user_overview function and inserting the tasks list 
    user_overview(tasks, True)

    return

# Function to view the statistics
def view_stats():


    # Calling the function task_overview and inserting the information from the task_overview.txt file as parameter
    task_overview(read_txt_file("task_overview.txt"))

    # Variable to store the information from the tasks.txt file
    tasks = read_txt_file("tasks.txt")

    # Variable to store the information from the user.txt file
    users = read_txt_file("user.txt")

    # Display the number of users
    print(f"""\t\tNumber of users                    : {len(users)}""")

    # calling the function user_overview and inserting the information from the user_iverview.txt file as parameter
    user_overview(read_txt_file("user_overview.txt"))   


# Function to format and display the user overview statistics
def user_overview(info, stf = False): # stf = save_to_file

    # localised function to format the text and limit it to the size of the columns
    def space_count(field):
        field_len = len(field)
        
        # Formatting the information to fit into the grid    
        if field_len > 13:
            result = field[:12]
        else:
            b = 1
            space1 = " "
            space2 = " "
            while b < ((13 - field_len)/2):
                space1 += " "
                space2 += " "
                b += 1
                
            if (len(space1) + field_len + len(space2)) > 13:
                space1 = space1[:(len(space1)-1)]
            
            
        result = space1 + field + space2
            
        return result # return the result to the function

    # Localised function to format the user_overview table
    def table_entry(user, task_c, complete_c, uncomplete_c, overdue_c):
        print(f"|{user}|{task_c}|{complete_c}|{uncomplete_c}|{overdue_c}|")
        print("|-------------|-------------|-------------|-------------|-------------|")    
   
    user_count = 0

    # If statement to retrieve the information from the user.txt file
    if stf == True:
        users = read_txt_file("user.txt")
        save_info = ""  


    print("\n")


    print("-----------------------------------------------------------------------")
    print("---------------------------- User Overview ----------------------------")
    print("-----------------------------------------------------------------------")

    # Variable to store information in a list
    user_x = list(())

    # Display the header of the table
    print("_______________________________________________________________________")
    print("""|    Tasks    |   % Tasks   |   % Tasks   |   % Tasks   |   % Tasks   |
| Assigned to |  Assigned   |  Completed  | Uncompleted |   Overdue   |
|-------------|-------------|-------------|-------------|-------------|""")

    # If statement to determine if the information received is new information to be saved to file after
    # displaying it on the screen
    if stf == True:

        # For loop to cycle through the individual user information and populating the table fields
        for x in users:
            task_count = 0
            complete_count = 0
            uncomplete_count = 0
            overdue_count = 0
            this_user = x.split(', ')

            # For loop to cycle through the individual task information and populating the variables
            # with statistics of the tasks for each user
            for y in info:
                this_task = y.split(', ')
                #complete_count = {this_task[5] : 0}
                if this_user[0] == this_task[0]:
                    task_count += 1 # Count the number of tasks assigned to this user
                
                    if this_task[5] == "Yes" and this_user[0] == this_task[0]:
                        complete_count += 1 # The the number of completed tasks for this user
                    if this_task[5] == "No" and this_user[0] == this_task[0]:
                        uncomplete_count += 1 # Count the number of active tasks for this user
                
                    if this_task[4] > str(datetime.datetime.now().strftime("%d %b %Y")) and this_task[5] != "Yes":
                        overdue_count += 1

            # If statement to determine if a user have/had any tasks assigned to them and display only
            # the usernames that have/had tasks assigned to them. The information is first sent to the
            # function space_count to limit the length of the information to the size of the columns
            if task_count > 0:
                tasks_user = space_count(f"{this_user[0]}")
                tasks_ass = space_count(f"{((task_count/len(info) )* 100):.2f}")
                tasks_comp = space_count(f"{((complete_count/task_count)* 100):.2f}")
                tasks_inc = space_count(f"{((uncomplete_count/task_count)* 100):.2f}")
                tasks_overdue = space_count(f"{((overdue_count/task_count) * 100):.2f}")
                user_count += 1

                # Submitting the information to the table_entry function to populate the table
                table_entry(tasks_user, tasks_ass, tasks_comp, tasks_inc, tasks_overdue)

                # Saving the information in a variable that will be sent to the save_to_file function
                save_info += f"{tasks_user.strip()}, {task_count}, {complete_count}, {uncomplete_count}, {overdue_count}\n"

    #Else statement to determine if the information received was retrieved from the file
    else:

        # For loop to cycle throught the individual tasks
        for x in info:
            data = x.split(", ")
            task_count = int(data[1]) 

            # If statement determining if the user had any tasks assigned to them
            if task_count > 0:
                tasks_user = space_count(f"{data[0]}")
                tasks_ass = space_count(f"{((int(data[1])/int(7) )* 100):.2f}")
                tasks_comp = space_count(f"{((int(data[2])/int(task_count))* 100):.2f}")
                tasks_inc = space_count(f"{((int(data[3])/int(task_count))* 100):.2f}")
                tasks_overdue = space_count(f"{((int(data[4])/int(task_count)) * 100):.2f}")
                user_count += 1
                table_entry(tasks_user, tasks_ass, tasks_comp, tasks_inc, tasks_overdue)           

    print("\n")    

    # If statement to determine if the information is to be saved to the file
    if stf == True:        
        save_info = save_info[: -1]
        save_to_file("user_overview.txt", save_info)

    # Return statement to return the user to the main menu
    return


# Function to format and display the task overview statistics
def task_overview(info, stf = False):

    # Variables to initialise the formatting of the table
    completed_tasks = 0
    uncompleted_tasks = 0
    active_overdue = 0
    len_info = 0

    # If statement to determine if the information received is new
    if stf == True:
        len_info = len(info)
        for x in info:
            this_task = x.split(', ')
            if this_task[5] == "Yes":
                completed_tasks += 1
            if this_task[5] == "No":
                uncompleted_tasks += 1
            if this_task[4] > str(datetime.datetime.now().strftime("%d %b %Y")) and this_task[5] == "No":
                active_overdue += 1
    # Else statement to determine if the information was retrieved from the task_overview.txt file
    else:

        # For loop to cycle through the individual task information 
        for y in info:
            this_task = y.split(',')
            len_info = this_task[0]
            completed_tasks = this_task[1]
            uncompleted_tasks = this_task[2]
            active_overdue = this_task[3]
           
            


    print("-----------------------------------------------------------------------")
    print("---------------------------- Tasks Overview ---------------------------")
    print("-----------------------------------------------------------------------")
            
    # The total number of tasks
    print("\n\t\tTotal number of tasks              :", len_info)
    
    # The total number of completed tasks.
    print("\t\tThe number of completed tasks      :", completed_tasks)

    # The total number of uncompleted tasks.
    print("\t\tThe number of uncompleted tasks    :", uncompleted_tasks)
    
    # The total number of tasks that haven’t been completed and that are overdue.
    print("\t\tThe number of overdue tasks        :", active_overdue)
    
    # The percentage of tasks that are incomplete.
    print("\t\tThe percentage of incomplete tasks :", f"{(int(uncompleted_tasks)/int(len_info) * 100):.2f} %")
    
    # The percentage of tasks that are overdue.
    print("\t\tThe percentage of tasks overdue    :", f"{((int(active_overdue)/int(len_info)) * 100):.2f} %")

    # Variable to save the new information to the task_overview.txt file
    save_info = f"{len(info)},{completed_tasks},{uncompleted_tasks},{active_overdue}"

    # If statement to determine if the information is to be save to file
    if stf == True:
        # Function call to save the information to the task_overview.txt file
        save_to_file("task_overview.txt", save_info)


    return info # Return the information to the function caller



# Variable to store the login result    
access = bool(login_func())

# While loop to repeat the menu
while access == True:

    print(f"============================ Welcome \"{current_user}\" ============================")
    #presenting the menu to the user and 
    # making sure that the user input is coneverted to lower case.
    if current_user == "admin":
            menu = input('''\nSelect one of the following Options below:
        \tr - Registering a user
        \ta - Adding a task
        \tva - View all tasks
        \tvm - view my task
        \tds - Statistics
        \tgr - Generate Reports
        \te - Exit
        \t: ''').lower()

    else:
        menu = input('''\nSelect one of the following Options below:
        \tr - Registering a user
        \ta - Adding a task
        \tva - View all tasks
        \tvm - view my task
        \te - Exit
        \t: ''').lower()

    if menu == 'r': # Register a new user
        
        print("=============================== Register A User ===============================\n")

        # If statement to limit which users can register a new user
        if current_user == "admin":
            
            # Calling of the reg_user function
            reg_user()
            
        else:
            # Else if the user is not authorised 
            print("You are not authorised to add users")

    elif menu == 'a': # Adding a task

        print("================================= Add A Task =================================\n")

        # Calling of the add_task function
        add_task()
        
        print("\nMain menu\n")
        
    elif menu == 'va': # View all tasks

        print("================================ View All Tasks ================================\n")

        # Variable containing the username cuurently logged in
        current_user
        edit_another = "yes"
        
        # Calling of the view_all function
        view_all()
                

    elif menu == 'vm': # View only the current user's tasks
        # Tasks global variable
        
        print("================================= View my Tasks =================================\n")
        # Variable containing the username that is currently logged in 
        current_user

        # Calling of the view_mine function
        view_mine()
                
    # View Statistics, admin only            
    elif menu == 'ds' and current_user == "admin": 
        print("================================= View Statics =================================\n")

        # # Calling of the view_statistics function
        view_stats()
        
    elif menu == 'gr' and current_user == "admin":
        print("================================= Generate Reports =================================\n")
        generate_reports()

    # Exit the program
    elif menu == 'e':
        print('Goodbye!!!')
        exit()
        
    else:
        print("You have entered a wrong choice, Please Try again")





