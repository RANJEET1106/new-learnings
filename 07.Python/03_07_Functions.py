def hello_World():
    print("Hello World")

hello_World()

def sum(num1,num2):
    return (num1+num2)

print(sum(100,20))

def do_nothing():
    pass
do_nothing()

def sum2(num1,num2):
    if(type(num1) is not int or type(num2) is not int):
        return
    return num1+num2

print(sum2('a',20))

def multiple_items(*args):
    print(args)
    print(type(args))

multiple_items("RANJEET","Akalank","Yash")


def add(*num):
    sum=0
    for n in num:
        sum=sum+n 
    print("Sum: ",sum)

add(5,2,6,8)

def multi_named_items(**kwargs):
    print(kwargs)
    print(type(kwargs))

multi_named_items(first_name="RANJEET", last_name="Deshmukh", location="Karad")

def func(a,b,*args,option=False,**kwargs):
    print(a,b)
    print(args)
    print(option)
    print(kwargs)
func(1,3,10,10,Name='RANJEET',salary=60000)


def func1(a,b=4):
    print(a,b)

func1(2)
func1(2,8)

def add_one(num):
    if(num>=9):
        return num+1
    total=num+1
    print(total,end=" ")
    return add_one(total)

myNewTotal = add_one(0)
print(myNewTotal)


def recursive_factorial(n):
    if n==1:
        return n
    else :
        return n*recursive_factorial(n-1)
    
num =6
if(num<0):
    print("Invalid input")
elif num==0:
    print("Factorical of 0 is 1")
else:
    print(f"factorial of {num} is {recursive_factorial(num)}")

def add():
    a= int(input("Enter the first number"))
    b= int(input("Enter the second number"))
    print(a+b)








