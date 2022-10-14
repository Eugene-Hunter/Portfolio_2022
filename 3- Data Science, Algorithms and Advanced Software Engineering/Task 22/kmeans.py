import csv
import math
import random
import matplotlib.pyplot as plt
import numpy as np
import pandas as pd
from sklearn.cluster import KMeans
"""

REFERENCES
1)' Mirko Stojiljković'(16 May 2022)'Linear Regression in Python','May 2022',Available at https://realpython.com/linear-regression-in-python/ (accessed 11 Sep 2022)
2)'w3schools.com'(Date Unknown)'Linear Regressions','Date Unknown',Available at https://www.w3schools.com/ai/ai_regressions.asp (accessed 9 Sep 2022)
3)'Bijay Kumar'(1 Jan 2022)'Scikit learn Linear Regression + Examples','Date Unknown',Available at https://pythonguides.com/scikit-learn-linear-regression/ (accessed 9 Sep 2022)
4)'johnwow'(25 Jul 2020)'Difference between r2_score and score() in linear regression','Date Unknown',Available at https://stackoverflow.com/questions/63083618/difference-between-r2-score-and-score-in-linear-regression (accessed 9 Sep 2022)
5)'simplilearn.com'(21 Jun 2022)'Sklearn Linear Regression','Date Unknown',Available at https://www.simplilearn.com/tutorials/scikit-learn-tutorial/sklearn-linear-regression-with-examplesv (accessed 8 Sep 2022)
6)'scikit-learn.org'(Date Unknown)'sklearn.linear_model.LinearRegression','Date Unknown',Available at https://scikit-learn.org/0.18/modules/generated/sklearn.linear_model.LinearRegression.html (accessed 8 Sep 2022)
7)'wikipedia.org'(27 Aug 2022)'Linear regression','Aug 2022',Available at https://en.wikipedia.org/wiki/Linear_regression (accessed 7 Sep 2022)
8)'geeksforgeeks.org'(22 Aug 2022)'Linear Regression (Python Implementation)','Date Unknown',Available at https://www.geeksforgeeks.org/linear-regression-python-implementation/ (accessed 7 Sep 2022)
9)'Partha Majumdar'(Date Unknown),'Scikit Learn - Linear Regression'(Date Unknown),Available at https://www.tutorialspoint.com/scikit_learn/scikit_learn_linear_regression.htm (accessed 7 Sep 2022)
10)geeksforgeeks.org(Date Unknown),'ML | Linear Regression',
Available at: https://www.geeksforgeeks.org/ml-linear-regression/ (Accessed 7 Sep 2022)
11) javatpoint.com (23 Aug 2022)'Python | Linear Regression using sklearn' Aug 2022, 
Available  at: https://www.geeksforgeeks.org/python-linear-regression-using-sklearn/ 7 Sep 2022)

Resources reused: None
Received assistance from the student whom uses the alias of ProductKnight(#2663)(on the Discord channel) in 
respect of displaying the statistical information in the console.

"""

def read_csv_file():
    """
    Information from the 3 csv files are extracted and stored in memory in 
    order for faster loading time of the data for analizing purposes
    :param
    :return:
    """

    countries_1953 = []
    countries_2008 = []
    countries_both = []

    with open("data1953.csv", newline='') as csvfile:
        csvreader = csv.reader(csvfile, dialect='excel', delimiter=',')
        for row in csvreader:
            countries_1953.append(row)
    with open("data2008.csv", newline='') as csvfile:
        csvreader = csv.reader(csvfile, dialect='excel', delimiter=',')
        for row in csvreader:
            countries_2008.append(row)
    with open("dataBoth.csv", newline='') as csvfile:
        csvreader = csv.reader(csvfile, dialect='excel', delimiter=',')
        for row in csvreader:
            countries_both.append(row)

    return countries_1953, countries_2008, countries_both


def visualize_clusters(all_clusters, info, year):
    """
    After all the clusters have been created, the results are plotted using matplotlib.pyplot. Random colours
    are generated to separate the clusters visually from one another
    :param: all_clusters, info, year
    :return:
    """
    # Store number of countries and clusters.
    cluster_count = 1
    country_list = []

    # For Loop to cycle through the clusters and plot the points and display the results
    # Set colours for each cluster.
    for cluster in all_clusters:
        r = random.random()
        b = random.random()
        g = random.random()
        # Color list created with random choices.
        colours = [[r, g, b]]

        # Counter to count countries added to the clusters.
        count_country = 0

        # Loop through data points in the cluster to calculate average.
        for point in cluster['data_points']:
            x = point[1]
            y = point[2]
            sum_x = 0
            sum_y = 0
            sum_x += x
            sum_y += y

            # plot the country's position inside the cluster
            plt.scatter(point[1], point[2], c=colours)

            # count the number of countries added to the list
            count_country += 1

            # Add the country's name to the relevant cluster.
            countries = info
            for line in countries:
                if line[0] != 'Countries' and x == float(line[1]) and y == float(line[2]):
                    country_name = str(line[0])
                    country_list.append(country_name)

        # Create the graph labels and display the results
        plt.title(f"World Birth-rate & Life Expectancy: {year}")
        plt.xlabel('Birth Rate')
        plt.ylabel('Life Expectancy')
        print(f"\nCluster {cluster_count}: {count_country} countries.")
        print(f"Cluster {cluster_count} Country List: {country_list}")
        print(f"Cluster {cluster_count} average birth rate = {sum_x}")
        print(f"Cluster {cluster_count} average life expectancy = {sum_y}")

        # reset the cluster list and move to the next cluster.
        country_list.clear()
        cluster_count += 1

    plt.show()


def main():
    """
    extract data from the file
    Once the countries' information has been split, create the number of random
    centroids equal to the number of clusters and repeat the process to select
    a random centroid for each cluster.
    Next, assign each country to a cluster based on the distance to the country's
    nearest centroid. Do this by calculating the mean value for each of the
    countries and for each of the centroids.
    Iterate through the country list and calculate the distance from each of
    the centroids. For each country, obtain the closest centroid and store the
    value
    # For each country, do the following:

    # Step 1: For each country, obtain the closest centroid
    # Step 2: Append points into cluster with shortest centroid distance as data points.
    # Step 3: Create and cycle through all the clusters and obtain the closest centroid
    # step 4: Create a single list
    # Step 5: Calculate the squared distance for the countries
    :param:
    :return:
    """
    csv_data = read_csv_file()
    info = []
    year = ""

    repeat = 1
    while repeat == 1:
        year = input("Enter 1953 or 2008, otherwise enter both: ")
        if year == '1953':
            info = csv_data[0]
            break
        elif year == '2008':
            info = csv_data[1]
            break
        elif year == 'Both' or year == 'both':
            info = csv_data[2]
            break
        else:
            print("Your input was not recognised, please try again.")
            repeat = 1

    info = info[1:]
    countries = []

    for row in info:
        country = row[0]
        br = float(row[1])
        le = float(row[2])
        countries.append([country, br, le])
    nr_clusters = int(input("Enter the number of clusters: "))
    nr_iterations = int(input("Enter the number of iterations: "))
    all_clusters = []
    
    for next_iteration in range(nr_iterations):
        # If the centroids list does not exist, create a new list, else use the existing centroids list
        if next_iteration == 0:
            centroids_list = random.sample(countries, nr_clusters)
        else:
            centroids_list = [find_mean_values(cent['data_points']) for cent in all_clusters]
            print(centroids_list)

        # Create the cluster list with a center point and an empty 2nd list to store all the data points
        cluster = [{'center_point': center_point, 'data_points': []} for center_point in centroids_list]
        count_clusters = 0
        # For each country, calculate the closest centroid to the country and append it to the list
        for country in countries:

            centroid_closest_to_country = closest_centroid(country, centroids_list)
            cluster[centroid_closest_to_country]['data_points'].append(country)
            count_clusters += 1

        all_clusters = cluster
        calculate_cluster_mean(all_clusters, next_iteration)

    # Display the clusters
    visualize_clusters(all_clusters, info, year)


def calculate_cluster_mean(all_clusters, iter):
    """
    Step 6: We then calculate the mean distance for all the countries. We calculate the distance away from
    each of the centroids and for every country and display the cluster's total distance squared
    This is repeated for all the clusters and the sum of the squared distances for each iteration is displayed
    :param data:
    :return: br, le
    """
    for cluster in all_clusters:

        sum_squared = 0.00
        sum_of_distance = 0.00
        cluster_mean = cluster['center_point']

        for point in cluster['data_points']:

            sum_of_distance += calculate_euclidean_distance(point, cluster_mean)
            sum_squared += math.pow(sum_of_distance,2)

    print(f"Iteration {iter +1 }: Sum of distance squared: {sum_squared}.")

def find_mean_values(data):
    """
    Step 7: Calculate the mean values for each cluster each time a country is added to the cluster
    :param data:
    :return: br, le
    """
    br = 0
    le = 0
    for points in data:
        br += points[1]
        le += points[2]
    return [br/len(data), le/len(data)]


def closest_centroid(country, centroids_list):
    """
    Step 8: compare the distance to each of the centroids using the euclidean distance
    and return the closest distance
    :param: country, centroids_list
    :return: position
    """
    position = []
    e_distance = np.ndarray(shape=len(centroids_list))
    for count, centroid in enumerate(centroids_list):

        e_distance[count] = (calculate_euclidean_distance(country, centroid))
    position = np.argmin(e_distance)
    return position



def calculate_euclidean_distance(country, centroids):

    """
     If statement to determine correct size of the list in order to ensure that the correct data is used
     to calculate the euclidean distance for each centroid. The formula used to calculate the distance is
     distance = sqrt((x2 - x1) ** 2 + (y2 - y1) ** 2)
    :param: country, centroids
    :return: distance
    """
    distance = 0.00
    if len(centroids) > 2:
        distance = math.sqrt((centroids[1] - country[1]) ** 2 + (centroids[2] - country[2]) ** 2)
    else:
        distance = math.sqrt((centroids[0] - country[1]) ** 2 + (centroids[1] - country[2]) ** 2)
    return distance


def init():
    """
    The program is accessed through this init() function.
    It starts with a while loop to allow user to display more than 1 set of results
    """
    yes_no = 1

    while yes_no != '0':
        main()
        yes_no = input("Enter 1 to view another graph or 0 to exit: ")
        if yes_no == '0':
            continue


init()

#TASK INSTRUCTIONS
#Some hints on how to start, as well as guidance on things which may trip you up, have been added to this file.
#You will have to add more code that just the hints provided here for the full implementation.
#You will also have to import relevant libraries for graph plotting and maths functions.

# ====
# Define a function that computes the distance between two data points

# ====
# Define a function that reads data in from the csv files
# HINT: http://docs.python.org/2/library/csv.html.
# HINT2: Remember that CSV files are comma separated, so you should use a "," as a delimiter.
# HINT3: Ensure you are reading the csv file in the correct mode.

# ====
# Define a function that finds the closest centroid to each point out of all the centroids
# HINT: This function should call the function you implemented that computes the distance between two data points.
# HINT: Numpy has a useful method that allows you to find the index of the smallest value in an array.

    #====
#Write a function to visualise the clusters. (optional, but useful to see the changes and if your algorithm is working)

    #====
# Write the initialisation procedure1953

#====
# Implement the k-means algorithm, using appropriate looping for the number of iterations
# --- find the closest centroid to each point and assign the point to that centroid's cluster
# --- calculate the new mean of all points in that cluster
# --- visualise (optional, but useful to see the changes)
#---- repeat

    # ====
# Print out the results for questions
#1.) The number of countries belonging to each cluster
#2.) The list of countries belonging to each cluster
#3.) The mean Life Expectancy and Birth Rate for each cluster

# Find the Euclidean distance between two points, each of which has an 𝑥 and a 𝑦 coordinate.
# A reminder that this is given by the formula sqroot((𝑥2 − 𝑥1)2+ (𝑦2 − 𝑦1)2)
# Find the distance to each of the centroids from each of the points.
# Ie. If you have 15 points and 3 centroids, you need to calculate the
# distance from each of the 15 points to each of the 3 centroids.
# Compute the two-dimensional mean. To compute the mean (or
# average) of a number of observations, you simply add all the
# observations together and then divide by the number of
# observations you added together. Thus, to compute the
# two-dimensional mean (ie. the mean coordinate point (𝑥, 𝑦)),
# calculate the mean of the x values and the mean of the y values of
# all the points
