
#=====importing libraries===========
import os # To Check if file exist, delete files
import datetime # To add dates in date format

#====Login Section====

user_list = ""

# Function to read from the user.txt file and return the result
def read_user_txt():
    # Retrieve user list (user.txt) and save results in dictionary form
    f = open("user.txt", "r")
    user_list = f.read()
    f.close()
    users = user_list.split("\n") # username password
    # Return the result
    return users

# Function to read from the tasks.txt file and return the result
def read_tasks_txt():
    # Read file and save information to a variable
    tasks = ""
    f = open("tasks.txt", "r")
    tasks = (f.read().split('\n'))        
    f.close()
    # Return the result
    return tasks

# Function for logging in 
def login_func():
    access = False
    print("------------------ " + str(datetime.datetime.now().strftime("%d %b %Y")) + "---------------------")
    # While function to determine if the login details are correct 
    while access == False:
        u_name = input("Username: ")
        p_word = (input("Password: "))
        access = user_test(u_name, p_word, "login")
        print(access)
    return access

# function to check if username and password correspond
def user_test(*z):
    # z[0] = u_name
    # z[1] = p_word
    # z[2] = action
    username = z[0]
    password = z[1]
    action = z[2]
    users = read_user_txt()
    global current_user
    users_d = dict[[]] # type cating of the users dictionary
    user = list(())# list to store the individual user information
    # For loop to split the username and password and sttore it in a dictionary
    for user in users:
        user = user.split(", ") # Separate usernames from passwords
        users_d = {"username" : user[0], "password" : user[1]} # Assign information to dictionary variable

        # If function to verify login information
        if action == "login":
            # If funtion to verify if the username is in the user.txt file
            if username == users_d["username"]:
                # If function to verify if the password matches the password for the username
                if password ==  users_d["password"]:
                    current_user = username
                    print(f"You are now logged in as {current_user}")
                    return True
            # Else function if the username of the password is incorrect
            else:
                print("Username or password incorrect")
            return False

        if action == "r":    # Check for username  duplicates
            if username == users_d["username"]:
                print("The username already exist. Enter a different name.")
                return True

    # If function to determine if the task is assigned to a user that uses the program
    if action == "a": 
        for user in users: # For each line of data save the information to the user variable
            user = user.split(", ")
            users_d = {"username" : user[0]}
            if username == users_d["username"]:
                return True
        print("The username entered is not registered, please try again.")
        return False
            
# -------------------------------------------------------------------------


# Variable to store the login result    
access = bool(login_func())

# While loop to repeat the menu
while access == True:

    print(f"============================ Welcome \"{current_user}\" ============================")
    #presenting the menu to the user and 
    # making sure that the user input is converted to lower case.
    if current_user == "admin":
            menu = input('''Select one of the following Options below:
        \tr - Registering a user
        \ta - Adding a task
        \tva - View all tasks
        \tvm - view my task
        \tvs - Statistics
        \te - Exit
        \t: ''').lower()

    else:
        menu = input('''Select one of the following Options below:
        \tr - Registering a user
        \ta - Adding a task
        \tva - View all tasks
        \tvm - view my task
        \te - Exit
        \t: ''').lower()

    if menu == 'r': # Register a new user
        
        print("================================= Register A User =================================\n")

        # If statement to limit which users can register a new user
        if current_user == "admin":
            print("==== Register New User ===\n")
            print("Enter the new user's details:\n")
            used_name = True
            new_user = ""
            new_p_word = ""

            # While loop to check if username is already in use
            while used_name == True:  
                new_user = input("Name: ")      
                used_name = user_test(new_user, "", "r") # function call 
            # if the username is not in use, the password can then be created and stored
            else:
                p_word_match = False
                #While loop to check if the passwords match
                while p_word_match == False:
                    new_p_word = input("Password: ")
                    confirm_p_word = input("Confirm password: ")
                    
                    if new_p_word == confirm_p_word:
                        p_word_match = True
                    else:
                        print("The passwords do not match.")
                        p_word_match = False
                        
            # Saving the new username and password in the user.txt file            
            with open("user.txt", "a") as f:
                f.write("\n")
                f.write(f"{new_user}, {new_p_word}")
                
            # Confirm that the new username and password has been stored in the file    
            print(f"{new_user} has been successfully registered.\n\n")

        # Else if the user is not authorised     
        else:
            print("You are not authorised to add users")

    elif menu == 'a': # Adding a task

        print("================================= Add A Task =================================\n")

        # Variable to store the user's decision on adding more than 1 task
        answer = 'y'

        # While loop to add more than 1 task
        while answer == 'y' or answer == 'yes':
            # Request the user to enter the assigned user's name
            
            user_registered = False
            while user_registered == False:
                assigned_to = input("Assigned to: ").lower()
                # Date that the task was created
                user_registered = user_test(assigned_to, "" , "a")
            # Request user to enter a title for the task
            task_title = input("Title: ").title()
            task_date = datetime.datetime.now().strftime("%d %b %Y")
            # Request the user to enter a due date for the task
            due_date = input("Due date(YYYY-MM-DD): ")
            due_d = due_date.split("-")
            year = int(due_d[2])
            month = int(due_d[1])
            day = int(due_d[0])
            due_date = datetime.datetime(day, month, year).strftime("%d %b %Y")
            # Variable to the completion status of the task
            task_complete = "no"
            # While loop to request user to enter the status of the task
            while task_complete != "yes" and task_complete != "no":
                task_complete = input("Has the task been completed? 'yes' or 'no': ").lower()
            # Request user to enter the description of the task    
            task_description = input("Description: ")            

            # Writing the contents to file
            with open("tasks.txt", "a") as f:
                f.write("\n")
                f.write(f"{assigned_to}, {task_title}, {task_description}, {task_date}, {due_date}, {task_complete}")
            # Confirmation of the task added to the tasks,txt file
            print("\nThe task has been added to the task file.\n")

            # Ask user if another task needs to be added or not
            answer = input("Would you like to add another task? (y)es or (n)o:").lower()

        
        
        print("Main menu\n")
        
    elif menu == 'va': # View all tasks

        print("================================ View All Tasks ================================\n")

        # Variable containing the username cuurently logged in
        current_user
        print(f"Current user logged in: {current_user}\n")
        tasks = read_tasks_txt()
        # For loop to display the tasks in the tasks.txt file
        for x in tasks:
            # Split the contents of the information stored in the tasks variable
            new_tasks = x.split(", ")
            # Listing all the tasks using a dictionary variable
            tasks_db = {"Username": new_tasks[0], "Task Title" : new_tasks[1], "Task Description" : (new_tasks[2].replace(",", "`")), "Task date" : new_tasks[3], "Due date" : new_tasks[4], "Task Complete" : new_tasks[5]}

            # Print the result
            print(f"""                
        "Assigned To"\t\t| {tasks_db['Username']}\n
        "Title"\t\t\t| {tasks_db['Task Title']}\n
        "Description"\t\t| {tasks_db['Task Description']}\n
        "Date Assigned"\t\t| {tasks_db['Task date']}\n
        "Due date"\t\t| {tasks_db['Due date']}\n
        "Task Complete"\t\t| {tasks_db['Task Complete']}\n
        """)

        
             
    elif menu == 'vm': # View only the current user's tasks
        # Tasks global variable
        tasks
        
        print("================================= View my Tasks =================================\n")
        # Variable containing the username that is currently logged in 
        current_user
        print(f"Current user logged in: {current_user}\n")
        tasks = read_tasks_txt()


        # For loop to display the tasks in the tasks.txt file
        for x in tasks:
            # Split the contents of the information stored in the tasks variable
            new_tasks = x.split(", ")
            # Listing all the tasks using a dictionary variable
            tasks_db = {"Username": new_tasks[0], "Task Title" : new_tasks[1], "Task Description" : (new_tasks[2].replace(",", "`")), "Task date" : new_tasks[3], "Due date" : new_tasks[4], "Task Complete" : new_tasks[5]}

            if new_tasks[0] == current_user:
            # Print the result
                print(f"""                
        "Assigned To"\t\t| {tasks_db['Username']}\n
        "Title"\t\t\t| {tasks_db['Task Title']}\n
        "Description"\t\t| {tasks_db['Task Description']}\n
        "Date Assigned"\t\t| {tasks_db['Task date']}\n
        "Due date"\t\t| {tasks_db['Due date']}\n
        "Task Complete"\t\t| {tasks_db['Task Complete']}\n
        """)

                
    # View Statistics, admin only            
    elif menu == 'vs' and current_user == "admin": 
        print("================================= View Statics =================================\n")
        
        tasks = read_tasks_txt()
        users = read_user_txt()
        print(f"""
        \t\tNumber of tasks: {len(tasks)}\n
        \t\tNumber of users: {len(users)}\n
        """)
    # Exit the program
    elif menu == 'e':
        print('Goodbye!!!')
        exit()    
    else:
        print("You have entered a wrong choice, Please Try again")



