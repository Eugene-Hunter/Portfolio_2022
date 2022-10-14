# Importing the libraries
import math
import random
import numpy as np
import matplotlib.pyplot as plt
from sklearn.linear_model import LinearRegression
from sklearn.preprocessing import PolynomialFeatures

def init():

    # Training set
    graph1_train_x = np.array([[46], [67], [28], [18], [55], [39], [50], [61], [33], [49], [24]])
    graph1_train_y = np.array(np.empty(len(graph1_train_x)))

    for x in range(len(graph1_train_x)):
        graph1_train_y[x] = calculate_curve(graph1_train_x[x])

    x_train = graph1_train_x
    y_train = graph1_train_y

    # Testing set
    graph2_test_x = np.array([[7], [60], [108], [49], [35], [90], [74], [62], [80], [54], [57]])
    graph2_test_y = np.array(np.empty(len(graph2_test_x)))

    for x in range(len(graph2_test_x)):
        graph2_test_y[x] = calculate_curve(graph2_test_x[x])

    x_test = graph2_test_x
    y_test = graph2_test_y

    # Train the linear regression line graph
    regressor = LinearRegression()
    regressor.fit(x_train, y_train)
    lin_spacing = np.linspace(0, 800, 100)
    yy = regressor.predict(lin_spacing.reshape(lin_spacing.shape[0], 1))

    # plotting the linear regression line
    plt.plot(lin_spacing, yy)
    # plotting the polynomial regression line
    poly_train = np.polyfit(x_train.squeeze(), y_train, deg=2)
    poly_fit_train = np.poly1d(poly_train)

    xx = np.linspace(0, 800, 100)
    plt.plot(xx, poly_fit_train(xx), c='r', linestyle='-')
    plt.grid(True)
    plt.axis([0, 200, 0, 12600])
    plt.title('Graph to depict polynomial regression')
    plt.xlabel('X axis')
    plt.ylabel('Y axis')
    plt.scatter(x_train, y_train)
    plt.scatter(x_test, y_test)
    plt.show()


def calculate_curve(x_value):
    # Calculate the exponential growth of the y value
    return (x_value * x_value) + (random.random() * 10.5) - (random.random() ** 2)


init()
""" The relationship between the 2 axes are purely fictional and should not be taken as factual. It serves
the purpose of this task only.  It serves the purpose to illustrate the polynomial curve that fits
in with the data. 

References that assisted me in trying to  understand polynomial regression. 
1)'Sharif'(Date Unknown)'Polynomial Regression in Two Minutes (with Python Code) | Machine Learning',Date Unknown,
Available at https://www.aionlinecourse.com/tutorial/machine-learning/polynomial-regression (accessed 14 September 2022)
2)'scikit-learn.org'(Date Unknown)'Underfitting vs. Overfitting',Date Unknown,Available at 
https://scikit-learn.org/stable/auto_examples/model_selection/plot_underfitting_overfitting.html (accessed 13 September 2022)
3)'javatpoint.com'(Date Unknown)'ML Polynomial Regression',Date Unknown,Available at 
https://www.javatpoint.com/machine-learning-polynomial-regression (accessed 13 September 2022)
4)'medium.com'(June 2021)'Polynomial Regression in Python using Sci-kit',June 2021,
Available at https://medium.com/pythoneers/polynomial-regression-in-python-using-sci-kit-b53db19412d3 (accessed 13 September 2022)
5)'pythonbasics.org'(Date Unknown)'Polynomial Regression in Python'(Date unknown),
Available at https://pythonbasics.org/polynomial-regression-in-python/ (accessed 13 September 2022)
6)'Tamas Ujhelyi'(16 Nov 2021)'Polynomial Regression in Python using scikit-learn (with a practical example)',Nov 2021
Available at https://data36.com/polynomial-regression-python-scikit-learn/ (accessed 13 September 2022)
7)'geeksforgeeks.org'(24 Aug 2022)'Python | Implementation of Polynomial Regression',Aug 2022,
Available at https://www.geeksforgeeks.org/python-implementation-of-polynomial-regression/ (accessed 12 September 2022)
8)'askpython.com,'(Date Unknown)'Polynomial Regression in Python – Complete Implementation in Python,Date unknown,
Available at https://www.askpython.com/python/examples/polynomial-regression-in-python (accessed 12 September 2022)
9)www.w3schools.com/'(Date unknown)'Machine Learning - Polynomial Regression','',Available at
https://www.w3schools.com/Python/python_ml_polynomial_regression.asp (accessed 11 September 2022)
10)'Aden Haussmann'(Jul 29, 2020)'Polynomial Regression: The Only Introduction You’ll Need',Jul 2022,
Available at https://towardsdatascience.com/polynomial-regression-the-only-introduction-youll-need-49a6fb2b86de (accessed 11 September 2022)
11)'Abhigyan'(2 Aug 2022)'Understanding Polynomial Regression!!!', Aug 2022,
Available at https://medium.com/analytics-vidhya/understanding-polynomial-regression-5ac25b970e18 (accessed 11 September 2022)
12)'wikipedia.org'(updated 10 Aug 2022)'Polynomial regression','Aug 2022',
Available at, https://en.wikipedia.org/wiki/Polynomial_regression' (accessed 11 September 2022)

Resources reused: 
Reused the algorithm as it appears in the HyperiodDev level 3 TasK 23 training
material, the file named regression.py, combined with the algorithm found on the
website https://pythonbasics.org/polynomial-regression-in-python/, and altered 
in order finalize the task.

"""