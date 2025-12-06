def validate(username,password):
    s_username = "Infosys"
    s_password= "123"
    if(username== s_username and password== s_password):
        return True
    return False

username = input("Enter the username: ")
password = input("Enter the password: ")
print(validate(username, password))

def add(a, b):
    return a + b
a = int(input("Enter value of a: "))
b = int(input("Enter value of b: "))
c = int(input("Enter value of c: "))
sum = add(a,b)
ans = sum*c
print(ans)