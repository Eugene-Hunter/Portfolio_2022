# Create an adult class with the following attributes and method:
# ○ name, age, eye_colour, hair_colour

class Adult:

    def __init__(self, name, age, eye_colour, hair_colour):
        self.name = name
        self.age = age
        self.eye_colour = eye_colour
        self.hair_colour = hair_colour

    # ○ Method called can_drive() that prints the name of the person and
    # that they are old enough to drive.
    def can_drive(self, name, age):
        if int(self.age) >= 18:
            return f"{self.name} is {self.age} years of age and old enough to drive"

# ● Create a subclass of the adult class named “Child” that has the same
# attributes, but overrides the can_drive method to print the persons name
# and that they are too young to drive.


class Child(Adult):

    def __init__(self, name, age, eye_colour, hair_colour):
        super().__init__(name, age, eye_colour, hair_colour)
        self.name = name
        self.age = age
        self.eye_colour = eye_colour
        self.hair_colour = hair_colour

    def can_drive(self, name, age):
        if int(self.age) < 18:
            return f"{self.name} is {self.age} years of age and not old enough to drive"


def main():

    more = "yes"

    while more == "yes" or more == "y":
        # ● Take user inputs that ask for the name, age, hair colour and eye colour of a
        # person.
        name = input("Name: ")
        
        age = input("Age: ")
        
        eye_colour = input("Eye colour: ")

        hair_colour = input("Hair colour: ")

        # ● Create some logic that determines if the person is 18 or older and create an
        # instance of the Adult class if this is true. Otherwise, create an instance of the
        # Child class. Once the object has been created, call the can_drive() method to
        # print out whether the person is old enough to drive or not.
        if int(age) < 18:
            message = Child(name, age, eye_colour, hair_colour).can_drive(name, age)
        else:
            message = Adult(name, age, eye_colour, hair_colour).can_drive(name, age)

        print(message)
        more = input("Do another one? ").lower()

    else:
        exit()


main()
