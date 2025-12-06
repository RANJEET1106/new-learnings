import pymysql
import pymysql.cursors
connection = pymysql.connect(
    host='localhost',
    user='root',
    password='1106',
    database='python',
    cursorclass=pymysql.cursors.DictCursor
    )

try:
    with connection.cursor() as cursor:
        create_query = """create table if not exists 
        employees(id INT AUTO_INCREMENT PRIMARY KEY,
        name VARCHAR(100),
        department VARCHAR(100))"""
        cursor.execute(create_query)

        insert_query = "INSERT INTO employees(name,department) values(%s,%s)"
        values  = [("RANJEET","ADMIN"),("Akalank","PROD"),("Yash","IT")]
        cursor.executemany(insert_query,values)
        connection.commit()

        select_query="SELECT * FROM employees"
        cursor.execute(select_query)
        result=cursor.fetchall()
        with open("employees_output.txt","w") as f:
            for row in result:
                f.write(f"{row}\n")
                print(row)
finally:
    connection.close()