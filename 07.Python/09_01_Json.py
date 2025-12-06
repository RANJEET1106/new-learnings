import json

x = {
    "name":"RANJEET",
    "age":21,
    "city":"Karad"
}

y= json.dumps(x)
print(y)

print(json.dumps(["Krushna","Koyna"]))
print(json.dumps(["apple","grapes"]))
print(json.dumps(["Namaskar"]))
print(json.dumps(42))
print(json.dumps(45.53))
print(json.dumps(True))
print(json.dumps(False))
print(json.dumps(None))

people_string ='''
{
    "people":[
        {
            "name":"RANJEET",
            "phone":1234567890,
            "emails":["ranjeet@edgeverve.com","ranjeet@infosys.com"],
            "has_license":true
        },
        {
            "name":"Akalank",
            "phone":9876543210,
            "emails":["akalank@edgeverve.com","akalank@infosys.com"],
            "has_license":false
        }
    ]
}'''

data = json.loads(people_string)
print(data)
print(type(data))

print(type(data['people']))

for person in data['people']:
    print(person) 

for person in data['people']:
    print(person['name']) 

new_string = json.dumps(data,indent=2,sort_keys=True)
print(new_string)

