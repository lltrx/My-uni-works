#I used this source for the database https://github.com/bradtraversy/part_manager/blob/master/db.py.
import sqlite3


class Database:
    def __init__(self, db):
#When an object is generated from a class, this method is called to allow the class to initialise its attributes.
        self.conn = sqlite3.connect(db)
#Connect to connect the database.
        self.cur = self.conn.cursor()
#Cursor it is permanently connected to the connection, and all instructions are run inside the context of the database session covered by the connection.
        self.cur.execute(
#Unless there is a syntax problem, the text is parsed into a set of Python instructions, which are then performed, and if it is object code, it is simply executed.
            "CREATE TABLE IF NOT EXISTS cars (id INTEGER PRIMARY KEY, car text, model text, condition text, price text, phone text)")
        self.conn.commit()
#For tables that employ transactional storage engines, it's critical to run this function after each transaction that alters data.
    def fetch(self):
        self.cur.execute("SELECT * FROM cars")
        rows = self.cur.fetchall()
#The function returns a list of tuples that contains all rows of a query result set. It produces an empty list if there are no more rows available.
        return rows

    def insert(self, car, model, condition, price, phone):
#is a Python built-in function that inserts a specified element at a specified index in a list.
        self.cur.execute("INSERT INTO cars (car, model, condition, price, phone) VALUES (?, ?, ?, ?, ?)",
                         (car, model, condition, price, phone))
        self.conn.commit()

    def remove(self, id):
        self.cur.execute("DELETE FROM cars WHERE id=?", (id,))
        self.conn.commit()

    def update(self, id, car, model, condition, price, phone):
#If the key isn't already in the dictionary, this procedure adds it. It updates the key with the new value if the key is in the dictionary.
        self.cur.execute("UPDATE cars SET car = ?, model = ?, condition = ?, price = ?, phone = ? WHERE id = ?",
                         (car, model, condition, price, phone ,id))
        self.conn.commit()

    def __del__(self):
#When all references to an object have been destroyed, i.e. when an object is garbage collected, this method is invoked.
        self.conn.close()

