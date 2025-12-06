squared = lambda num:num*num 
print(squared(5))

add_two = lambda num:num+2
print(add_two(8))

sum_total = lambda a,b:a+b 
print(sum_total(36,69))

def funcBuilder(x):
    return lambda num:num+x 

add_ten = funcBuilder(10)
add_twenty = funcBuilder(20)

print(add_ten(7))
print(add_twenty(7))

numbers = [3,7,12,18,20,21]
squared_num = map(lambda num:num*num, numbers)
print(list(squared_num))

odd_nums = filter(lambda num:num%2!=0,numbers)
print(list(odd_nums))

from functools import reduce
numbers1= [1,2,3,5,6,7]
total = reduce(lambda acc,curr: acc+curr, numbers1)
print(total)
print(sum(numbers1))

names = ['RANJEET',"Akalank",'Yash']
char_count = reduce(lambda acc,curr:acc+len(curr),names,0)
print(char_count)

