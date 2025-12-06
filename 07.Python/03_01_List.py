a= [2,3,78,45,6]
print(a)
a.append(7)
print(a)
a.reverse()
print(a)

a.sort()
print(a)

a.sort(reverse=True)
print(a)

b= a.copy()
print(b)

b= list(a)
print(b)

print(type(b))