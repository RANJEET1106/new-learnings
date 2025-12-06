try:
    a=int(input())
    b=int(input())
    print(a+b)
except Exception as e:
    print("Something went wrong",e)

try:
    a=input("Enter first string: ")
    b=input("Enter ssecond string: ")
    print(a/b)
except Exception as e:
    print("Something",e)

try:
    a=int(input())
except ValueError as e :
    print("ValueError",e)

try:
    a=int(input())
    b=int(input())
    c=input()
    print(c/a)
    # print(d)
except ValueError as e:
    print("ValueError",e)
except TypeError as e:
    print("TypeError",e)
except Exception as e:
    print("Something",e)   
finally:
    print("Done")

