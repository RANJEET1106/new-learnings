import yaml

python_data={
    "product":"Laptop",
    "price":1200,
    "features":['SSD','8GB RAM','Full HD']
}

yaml_output = yaml.dump(python_data)
print(yaml_output)

with open('output.yaml','w') as file:
    yaml.dump(python_data,file)