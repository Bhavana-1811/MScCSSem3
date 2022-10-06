import mysql.connector as m

# database which you want to backup
db = 'my_db'

print('Connecting database...')
connection = m.connect(host='localhost', user='root',password='root', database=db)
cursor = connection.cursor()
print('Database connected')

# Getting all the table names
cursor.execute('SHOW TABLES;')

tables  = cursor.fetchall()
table_names = []
for record in tables:
        table_names.append(record[0])
backup_dbname = db + '_backup'
print('Creating backup databse named as', backup_dbname)
cursor.execute(f'CREATE DATABASE {backup_dbname}')
cursor.execute(f' SELECT DATABASE();')
print('current databse:',cursor.fetchall())
cursor.execute(f' USE {backup_dbname}')
cursor.execute(f' SELECT DATABASE();')
print('Switched to',cursor.fetchall())

for table_name in table_names:
        cursor.execute(f'CREATE TABLE {table_name} SELECT * FROM {db}.{table_name}')
