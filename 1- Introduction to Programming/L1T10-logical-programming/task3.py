import datetime, math

# Your program should read in the times in minutes for all three events of a
# triathlon, namely swimming, cycling and running and then calculate and
# display the total time taken to complete the triathlon.

print("Enter the athlete's times for the following [MM:SS:mm]:")
tri_swim = input("Swimming: ")

# Extract minutes from string
swim_mins = tri_swim.split(":")
print(swim_mins)

# Extract minutes from string
tri_cycle = input("Cycling: ")
cycle_mins = tri_cycle.split(":")
print(cycle_mins)

# Extract minutes from string
tri_run = input("Running: ")
run_mins = tri_run.split(":")
print(run_mins)

# Calculate milliseconds and convert to seconds
milli_conversion = int((int(swim_mins[2])
                   + int(cycle_mins[2])
                   + int(run_mins[2]))/100)

milli_seconds= (int(swim_mins[2])
                + int(cycle_mins[2])
                + int(run_mins[2]))%100

# Calculate seconds and convert to minutes
second_conversion = int((int(swim_mins[1])
                         + int(cycle_mins[1])
                         + int(run_mins[1]))/60)

seconds = int((int(swim_mins[1])
               + int(cycle_mins[1])
               + int(run_mins[1])
               + int(milli_conversion))%60)

minutes = int(int(swim_mins[0])
              + int(cycle_mins[0])
              + int(run_mins[0]))+ int(second_conversion)

print(f"Total time: {minutes}:{seconds}:{milli_seconds}")

# The award a participant receives is based on the total time taken to
# complete the triathlon. The qualifying time for awards is 100 minutes.
# Display the award the participant will receive based on the following
# criteria

# Total time Award

# Within qualifying time. Provincial Colours
if minutes <= 99 and seconds <= 59 and milli_seconds <= 99:
    print("Provincial Colours")

# Within 5 minutes of qualifying time. Provincial Half Colours
elif (minutes >= 100 and minutes < 105) and(seconds >= 0 or seconds <= 59) and (milli_seconds >= 0 and milli_seconds <= 99):
    print("Provincial Half Colours")

# Within 10 minutes of qualifying time. Provincial Scroll
elif (minutes >= 105 and minutes < 110) and (seconds >= 0 or seconds <= 59) and (milli_seconds >= 0 and milli_seconds <= 99):
    print("Provincial Scroll") 

# More than 10 minutes of qualifying time. No award   
else:
    print("No reward")

# Values tested    
# 110:0:0 = No reward
# 109:59:99= Provincial Scroll  
# 105:0:0 = Provincial Scroll
# 104:59:99 = Provincial Half Colours
# 100:0:0 = Provincial Half Colours
# 99:59:99 = Provicial Colours


