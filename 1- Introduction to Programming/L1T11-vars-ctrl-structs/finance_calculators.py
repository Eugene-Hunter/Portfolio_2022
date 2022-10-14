import math

# Allow user to choose which calculations they want to do

invest_or_bond = input("""Choose either 'investment' or 'bond' from the menu below to proceed:
Investment  - to calculate the amount of interest
Bond        - to calculate the amount you'll have to pay on a home loan: """)

# While loop to allow user to re-enter incorrectly spelled option
while invest_or_bond != "investment" and invest_or_bond != "bond":
    
    invest_or_bond = input("The information you entered is incorrect, please enter 'investment' or 'bond': ")

else:

    # Calculate the cost of an investment
    if invest_or_bond == "investment":

        # Get user input 
        deposit = float(input("Enter the deposit amount: "))
        interest_rate = float(input("Enter the interest rate per annum: "))
        interest_rate /= 100 
        period_years = int(input("Enter the investment period in terms of years: "))
        interest = input("Enter the type of interest you want, 'compound' or 'simple': ")

        # While loop to allow user to re-enter incorrectly spelled option
        while interest != "compound" and interest != "simple":

            interest = input("The information you entered is incorrect, please enter 'compound' or 'simple': ")

        # Calculate the investment on simple investment terms
        if interest == "simple":

            # Simple interest is calculated as follows:
            # A = P * (1 + r * t)
            # r = interest, t = number of years, P = deposit amount
            # A = total amount once interest is applied
            
            return_on_investment = deposit * (1 + interest_rate * period_years)

        # Calculate the investment on compound investment terms
        if interest == "compound":
            
            # Compound interest is calculated as follows:
            # A = P * (1 + r)^t
            # r = interest rate, t = number of years, P = deposit amount
            # A = total amount once interest is applied

            return_on_investment = deposit * (math.pow((1 + interest_rate),(period_years)))

        print(f"The return on investment is R{return_on_investment:.2f}.")        

    # Calculate the bond repayment on a home loan    
    if invest_or_bond == "bond":
        
        # Bond repayment formula - the amount will have to be repaid on a home loan
        # each month is calculated as follows:
        # repayment: x = (i * P) / (1 - (1 + i)^(-n))

        # Get user input
        home_value = float(input("Enter the value of the home loan: "))
        interest_rate = float(input("Enter the interest rate: "))
        period_months = int(input("Enter the number of months of repayment: "))
        monthly_interest = (interest_rate / 12 / 100)
        monthly_repayment = (monthly_interest * home_value) / (1 - (math.pow((1 + monthly_interest), -period_months)))
        
        print (f"Your monthly repayment amount is R{monthly_repayment:.2f}.")  
