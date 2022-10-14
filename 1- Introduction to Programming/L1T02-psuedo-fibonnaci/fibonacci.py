
#Xa+2 = Xa+1 + Xa

value = int(input("Enter a value: "))

fibonacci = [0,1]
count = 2
while value != -1:
        for n in range(value-2):
                fibonacci.append(fibonacci[count - 2] + fibonacci[count -1])
                count +=1        
        print(fibonacci)
        fibonacci.clear()
        fibonacci = [0,1]
        count = 2
        value = int(input("Enter a value, -1 to exit: "))
else:
        exit()

