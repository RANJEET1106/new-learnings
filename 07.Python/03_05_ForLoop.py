for i in "apple":
    print(i,end=" ")
print()
for i in range (1,5):
    print(i, end=" ")
print()

for i in range (2,11,2):
    print(i, end=" ")
print()

# a= int(input("Enter value of a"))
# b= int(input("Enter value of b"))
# for i in range (a,b):
#     print(i, end=" ")
# print()

# count =0 
# for i in range (1,10):
#     if(i&1):
#         count+=1
# print(count)

# count=0
# for i in range(1,100):
#     if(i%3==0 and i%5==0):
#         count+=1
# print(count)

# sum=0
# for i in range(1,6):
#     sum+=i
# print(sum)

# sum=0
# for i in range(10):
#     n= int(input("Enter the number"))
#     sum+=n
# print(sum)

for i in range(1,3):
    print("Week:",i)
    for j in range (1,4):
        print("Day:",j)

for i in range (1,5):
    print()
    for j in range(1,i+1):
        print(j,end=" ")