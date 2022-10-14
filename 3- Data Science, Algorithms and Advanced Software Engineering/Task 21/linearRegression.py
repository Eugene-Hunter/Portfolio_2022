
import matplotlib.pyplot as plt
import numpy as np
from sklearn.datasets import load_diabetes
from sklearn import linear_model

# function to calculate the gradient and the y-intercept and return the target data
def return_function(dx_data, dy_data):

    m = ((np.mean(dx_data) * np.mean(dy_data)) - np.mean(dx_data * dy_data)) / \
        ((np.mean(dx_data))**2 - np.mean(dx_data**2))
    b = np.mean(dy_data) - (m * np.mean(dx_data))
    new_dy_data = (m * dx_data) + b
    return new_dy_data

d = load_diabetes()
d_X = d.data[:, np.newaxis, 2]  #numPy code
dx_train_data = d_X[:-20]
dy_train_data = d.target[:-20]
dx_test_data = d_X[-20:]
dy_test_data = d.target[-20:]

lr = linear_model.LinearRegression()
# Squeezing the train data into a 1D array, and returns the target data array
rf = return_function(dx_train_data.squeeze(), dy_train_data)

lr.fit(dx_train_data, rf)

mse = np.mean((lr.predict(dx_test_data) - dy_test_data) **2)
lr_score = lr.score(dx_test_data, dy_test_data)
print(lr.coef_)
print(mse)
print(lr_score)
plt.title("Diabetes Test and Train Data")
plt.scatter(dx_train_data, dy_train_data, c='r', label='Train data')
plt.scatter(dx_test_data, dy_test_data, c='g', label='Test data')
plt.legend(loc="upper left")
plt.plot(dx_test_data, lr.predict(dx_test_data), color='b' )
plt.show()



