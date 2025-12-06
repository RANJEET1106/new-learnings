import re 
text ="The rain in Karad"
y = re.search("^The .* Karad$",text)

if y:
    print("Enjoyy")
else:
    print("Not so much to enjoy")

y = re.findall('in',text)
print(y)

y= re.split(r"\s",text,maxsplit=1)
print(y)

y = re.sub(r'\s','6',text)
print(y)