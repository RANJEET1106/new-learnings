# while True:
#     stuff = input("Enter the string to capitalize [type q to quit]: ")
#     if(stuff=='q'):
#         break
#     print(stuff.upper())

# while True:
#     value = input("Integer [type q to quit]: ")
#     if(value=='q'):
#         break
#     number = int(value)
#     if number%2 ==0 :
#         continue 
#     print(number , " Squared is ", number*number)


# numbers = [1,3,5]
# position =0
# while position<len(numbers):
#     number = numbers[position]
#     if(number%2==0):
#         print("Found Even Numbers",number)
#         break
#     position+=1
# else:
#     print("No even number found")

i=1
while i<=20:
    print(10*i,end=",")
    i+=1
print()


i=10
while i:
    print(i,end=",")
    i-=1
print()


num=100000
factorial = 1
i = 1
while i <= num:
    factorial *= i
    i += 1

print(f"The factorial of {num} is {factorial}")
