class Vehicle:
    def  __init__(self,make,model):
        self.make = make 
        self.model = model
        
    def moves(self):
        print("Move along...")
    def get_make_model(self):
        print(f"This car manufactured by {self.make} model name {self.model}")

my_car = Vehicle('Toyota','Fortuner')
my_car.moves()
my_car.get_make_model()
print(my_car.make)
print(my_car.model)

your_car = Vehicle('Mahindra','XUV700')
your_car.moves()
your_car.get_make_model()
print(your_car.make)
print(your_car.model)

print("\n\nInheritance")

class Airplane(Vehicle):
    def moves(self):
        print('Flies along...')

class Truck(Vehicle):
    def moves(self):
        print('Rumbles along...')

class GolfCart(Vehicle):
    pass 

cessna = Airplane('cessna','Skyhawk')
mack=Truck('Mack','Pinnacle')
golfwagon = GolfCart('Yamaha','GC100')

cessna.get_make_model()
cessna.moves()

mack.get_make_model()
mack.moves()

golfwagon.get_make_model()
golfwagon.moves()

print("\n\nInheritance2")

class Animal():
    def sound(self):
        print("Animal makes a sound")
a1=Animal()
a1.sound()

class Cat(Animal):
    pass 

class Dog(Animal):
    def sound(self):
        print("Dog Barks")
d1 = Dog()
d1.sound()

c1 = Cat()
c1.sound()


print("\n\nInheritance3")

class Shape():
    def area(self):
        return 0
print("Area of shape")
s1 = Shape()
s1.area()
print("Area of shape")

class Rectangle(Shape):
    def area(self):
        l=10
        b=20
        print(l*b)
r1=Rectangle()
r1.area()

print("\n\nInheritance3")

class Person():
    def __init__(self,name):
        self.name = name 
class Student(Person):
    def __init__(self,name, grade):
        super().__init__(name)
        self.grade = grade
    def display(self):
        print(self.name,self.grade)

s1 = Student("RANJEET","A")
s1.display()

print("\n\nInheritance4")

class Employee():
    def  __init__(self,name,salary):
        self.name = name 
        self.salary = salary
class Manager(Employee):
    def __init__(self, name, salary, department):
        super().__init__(name, salary)
        self.department = department
    def display(self):
        print(self.name, self.salary, self.department)

m1 = Manager("RANJEET","60000","Software")
m1.display()









