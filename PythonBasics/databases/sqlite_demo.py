import sqlite3

connection = sqlite3.connect('res/sales-example.db', isolation_level=None)
print('Connected')


# SELECTING
# cursor = connection.cursor()
# cursor.execute('SELECT * FROM catalog;')
# results = cursor.fetchall()
# print(results)


category_id = input('Enter id -> ')
category_name = input('Enter some category -> ')
cursor = connection.cursor()
cursor.execute("", [category_name, category_id])

