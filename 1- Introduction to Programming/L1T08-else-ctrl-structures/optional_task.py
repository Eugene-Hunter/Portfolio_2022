#● Design a program for a department store to calculate the monthly wage
#for two different types of employees.

#● Employees can either be a salesperson or a manager.
employee_type = list(("Salesagent", "Manager"))
#● Salespeople earn an 8% commission on their gross sales and a fixed salary
#of R2 000.00 per month. Managers earn an hourly rate of R40.00.
salesagent_basic = 2000.00
salesagent_commission = 0.08
manager_hour_rate = 40.00
#● Determine if the user is a salesperson or a manager.
employee = input("what position does the employee hold? Salesagent or Manager? ").lower()
#● Then, depending on their answer, calculate the monthly wage for the
#employee.
#● If the user is a salesperson, ask for their gross sales for the month.
if employee == "salesagent":
    gross_sales = float(input("Please enter your gross sales for the month: R"))
    commission = gross_sales*salesagent_commission
    total_wage = commission + salesagent_basic
    print(f"Your total wage as salesagent is R{total_wage}.")
#● If the user is a manager, ask for the number of hours worked for the
#month.
else:
    manager_hours = float(input("Enter the number of hours worked during the month: R")) 
    total_wage = manager_hours*manager_hour_rate
    print(f"Your total wage as manager is R{total_wage}.")
#● Display the total monthly wage for the employee.


