# An SMS Simulation


# ● Create a class definition for an Email which has four variables:
# has_been_read, email_contents, is_spam and from_address.
# ============================================================

# =======================OBJECT CLASSES=======================

class Email:

    # ● The constructor should initialise the sender’s email address.
    # ● The constructor should also initialise has_been_read and is_spam to false.

    def __init__(self, from_address, email_contents, has_been_read="No", is_spam="No"):
        self.from_address = from_address
        self.email_contents = email_contents
        self.has_been_read = has_been_read
        self.is_spam = is_spam

    # ● Create a function in this class called mark_as_read which should change
    # has_been_read to true.

    def mark_as_read(self):
        # change 'has been read'  to True
        self.has_been_read = "Yes"
        print("Marked as read = True")

    # ● Create a function in this class called mark_as_spam which should change
    # is_spam to true.

    def mark_as_spam(self):
        # Change 'is_spam' to True
        self.is_spam = "Yes"
        print("Mark is spam as True")

    def __repr__(self):
        return f"{self.from_address};;;{self.email_contents};;;{self.has_been_read};;;{self.is_spam};;;"


# ● Create a list called inbox to store all emails (note that you can have a list of
# objects).


# ● Then create the following methods:


# ○ get_count - returns the number of messages in the store.
# ======================================================================================================================

# =======================FILE FUNCTIONS========================

# ○ get_email - returns the contents of an email in the list. For this, allow
# the user to input an index i.e. get_email(i) returns the email stored
# at position i in the list. Once this has been done, has_been_read
# should now be true.
def from_file():
    mails = list(())
    mailbox = list(())
    with open("emails.txt", "r") as file:
        mails += file

        for x in mails:

            email = str(x).split(";;;")

            mailbox += [(Email(email[0], email[1], email[2], email[3]))]

    return mailbox


def save_emails(update_emails, source):
    if source == "update":
        print("<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>")
        print(update_emails)
        update_size = len(update_emails)
        print("update_size:", update_size)
        count = 1
        with open("emails.txt", "w") as f:
            for emails in update_emails:
                if int(count) < update_size:
                    f.write(f"{emails}\n")
                    count += 1
                else:
                    f.write(f"{emails}")

        print("<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>")

    elif source == "add":
        print("Sending email)")
        print(update_emails)
        with open("emails.txt", "a") as f:
            f.write(f"\n{update_emails}")

    get_emails(update_emails)
    return update_emails

# ============================================================

# =======================GET FUNCTIONS========================


def get_count(inbox):
    email_count = len(inbox)
    print("Email Count: " + str(email_count))
    return email_count


def get_emails(inbox):

    count = 0
    print("_________________________________________________________________________________")
    print("| Nr. |     From       |                Message                |  Read |  Spam  |")
    print("_________________________________________________________________________________")

    for mails in inbox:

        if len(mails.from_address) >= 12:
            from_addr = mails.from_address[:11] + "..."
        if len(mails.email_contents) >= 37:
            message = mails.email_contents[:34] + "..."
        if mails.has_been_read == "no" or mails.has_been_read == "No":
            read = "  No "
        else:
            read = " Yes "
        if mails.is_spam == "Yes\n" or mails.is_spam == "Yes":
            spam = " Yes  "
        else:
            spam = "  No  "

        count += 1
        if count >= 10:
            counter = f"{count} "
        elif count > 99:
            counter = f"{count}"
        else:
            counter = f"{count}  "

        print(f"| {counter} | {from_addr} | {message} | {read} | {spam} |")
        print("""_________________________________________________________________________________""")

    get_count(inbox)
    return inbox


def get_email(inbox, nr):
    if int(nr) > 0:
        inbox[(int(nr) - 1)].mark_as_read()
    print("get_email:\n", inbox[(int(nr) - 1)])
    print("\n")

    inbox = save_emails(inbox, "update")
    return inbox

# ○ get_unread_emails - should return a list of all the emails that haven’t
# been read.


def get_unread_emails(inbox):
    print("Get unread Emails")
    for mail in inbox:
        if mail.has_been_read == "No":
            print(mail)


# ○ get_spam_emails - should return a list of all the emails that have been
# marked as spam.


def get_spam_emails(inbox):
    print("Get Spam Emails")
    for mail in inbox:
        if mail.is_spam == "Yes":
            print(mail)


# ○ delete - deletes an email in the inbox.
# ============================================================

# =================ADD/INSERT FUNCTIONS=======================

# ○ add_email - which takes in the contents and email address from the
# received email to make a new Email object.

def add_email():
    # Create new email and add contents and sender's email address

    print("add_email")
    from_address = input("from : ")
    email_contents = input("content: ")
    new_email = Email(from_address, email_contents)
    inbox = save_emails(new_email, "add")
    print("INBOX: ", inbox)
    return inbox
# ============================================================

# =======================DELETE FUNCTIONS========================


def delete(inbox):
    print("Delete")
    nr = input("Select an email to delete")

    inbox.pop((int(nr) - 1))

    return


def mark_spam_email(inbox, nr):

    inbox[int(nr)-1].mark_as_spam()
    print(inbox)
    inbox = save_emails(inbox, "update")
    return inbox

# ● Fill in the rest of the logic for what should happen when the user inputs
# send/read/quit. Some of it has been done for you"
# ============================================================

# =======================MAIN FUNCTION========================


def main():

    option = ""

    while option != "exit":
        inbox = from_file()
        print(f"You have {get_count(inbox)} emails")

        option = input("""choose an option:
            1. inbox
            2. view unread emails
            3. view spam emails
            4. Send email
            5. exit
            : """)

        if option == "1" or option == "inbox":
            # store all emails
            print("--Inbox--------------------------------------------")
            get_emails(inbox)

        elif option == "2" or option == "unread":
            # after inbox is selected, display the content of the email
            print("--List Unread Emails----------------------------------------")
            get_unread_emails(inbox)

        elif option == "3" or option == "spam":

            print("--List Spam Emails-------------------------------------")
            get_spam_emails(inbox)

        elif option == "4" or option == "send":

            print("--Send Email-------------------------------------")
            add_email()

        elif option == "5" or option == "exit":
            print("Goodbye")
            exit()

        nr = input("Select email number: ")

        while option == "1":
            user_choice = input("""What would you like to do?
        1. Read email (r)
        2. Mark spam (m)
        3. Send email (s)
        4. Delete (d)
        5: Go back (b)
        :""").lower()

            if user_choice == "r" or user_choice == "1":

                get_email(inbox, nr)

            elif user_choice == "m" or user_choice == "2":
                mark_spam_email(inbox, nr)

            elif user_choice == "s" or user_choice == "3":
                inbox = add_email()
            elif user_choice == "d" or user_choice == "4":
                delete(inbox)
            elif user_choice == "b" or user_choice == "5":
                main()
            else:
                print("Oops - incorrect input")
    # ============================================================


main()
