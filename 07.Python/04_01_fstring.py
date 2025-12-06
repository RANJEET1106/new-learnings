person = "RANJEET"
Goldmedal = 3

print(person+" has "+str(Goldmedal)+" Gold medals ")
print("%s has %s Gold medals"%(person,Goldmedal))
print("{} has {} Gold medals".format(person, Goldmedal))
print("{1} has {0} Gold medals".format(Goldmedal, person))
print("{person} has {Goldmedal} Gold medals".format(Goldmedal=Goldmedal, person=person))

player={
    'person':'RANJEET',
    'Goldmedal':3
}
print("{person} has {Goldmedal} Gold medals".format(**player))

print(f"{person} has {Goldmedal} Gold medals")
print(f"{person} has {2*5} Gold medals")
print(f"{player['person']} has {player['Goldmedal']} Gold medals")
num=10
print(f"2.25 times {num} = {2.25*num:.2f}")



