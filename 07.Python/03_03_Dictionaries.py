car={
    "brand":"Toyota",
    "model":"Fortuner",
    "year":2025
}

car2=dict(brand="Mahindra",
          model="XUV700",
          year=2025)

print(car)
print(car2)
print(type(car))
print(type(car2))

print(car["brand"])
print(car.get('model'))

print(car.keys())
print(car.values())
print(car.items())

print('model' in car)
print('price' in car)

car['brand']="Tata"
car.update({"price":1000000})
print("Updated car values ",car)

car.pop('price')
print(car)
del car['model']
print(car)

print("clear")
car.clear()
print(car)

car3= car2 #create a reference (bad copy)
print(car3)

car4= car2.copy() # good copy
print(car4)

car5 =dict(car2)
print(car5)


member1 ={
    "name":"RANJEET",
    "id":369
}

member2 = {
    "name":"Akalank",
    "id":785
}

Group={
    "member1":member1,
    "member2":member2
}

print(Group)