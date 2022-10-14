THE TASK AT HAND
You are asked to create a project management system for a small structural
engineering firm called “Poised”. Poised does the engineering needed to ensure
the structural integrity of various buildings. They want you to create a Java
program that they can use to keep track of the many projects on which they work.
Poised stores the following information for each project that they work on:
? Project number.
? Project name.
? What type of building is being designed? E.g. House, apartment block or
store, etc.
? The physical address for the project.
? ERF number.
? The total fee being charged for the project.
? The total amount paid to date.
? Deadline for the project.
? The name, telephone number, email address and physical address of the
architect for the project.
? The name, telephone number, email address and physical address of the
contractor for the project.
? The name, telephone number, email address and physical address of the
customer for the project.
Poised wants to be able to use your program to do the following:
? Capture information about new projects. If a project name is not provided
when the information is captured, name the project using the surname of
the customer. For example, a house being built by Mike Tyson would be
called “House Tyson.” An apartment block owned by Jared Goldman would
be called “Apartment Goldman.”
? Update information about existing projects. Information may need to be
adjusted at different stages throughout the lifecycle of a project. For
example, the deadline might change after a meeting with various
stakeholders.
? Finalise existing projects. When a project is finalised, the following should
happen:
? An invoice should be generated for the client. This invoice should
contain the customer’s contact details and the total amount that the
customer must still pay. This amount is calculated by subtracting the
total amount paid to date from the total fee for the project. If the
customer has already paid the full fee, an invoice should not be
generated.
? The project should be marked as “finalised” and the completion date
should be added. All the information about the project should be
added to a text file called CompletedProject.txt.
? See a list of projects that still need to be completed.
? See a list of projects that are past the due date.
? Find and select a project by entering either the project number or project
name.
Before you begin
A key focus of this project will be ensuring that your code is correct, well-formatted
and readable. In this regard, make sure that you do the following before
submitting your work:
1. Make sure that you have identified and removed all syntax, runtime and
logical errors from your code.
2. Make sure that your code is readable. To ensure this, add comments to your
code, use descriptive variable names and make good use of whitespace and
indentation. See this style guide to see how classes and methods should be
named and how your program should be formatted.
3. Make sure that your code is as efficient as possible. How you choose to write
code to create the solution to the specified problem is up to you. However,
make sure that you write your code as efficiently as possible.
4. Make sure that all output that your program provides to the user is easy to
read and understand. Labelling all data that you output (whether in text
files or to the screen) is essential to make the data your program produces
more user-friendly.
