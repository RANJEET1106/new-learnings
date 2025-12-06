myTuple = ('Deva', 42,42, True)
print(myTuple)
print(type(myTuple))

(one, *two, three) = myTuple
print(one)
print(two)
print(three)

print(myTuple.count(42))
