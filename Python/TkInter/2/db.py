#The following lines of code were adapted from https://github.com/bradtraversy/part_manager 

import sqlite3
#sqlite for saving data in database


class Database:
    def __init__(self, db):
        self.conn = sqlite3.connect(db)
        self.cur = self.conn.cursor()
        self.cur.execute(
            "CREATE TABLE IF NOT EXISTS owners (id INTEGER PRIMARY KEY, owner text, address text, bedroom text, price text)")
        self.conn.commit()
# Setup the connection and execute if there are nothing in the table
    def fetch(self):
        self.cur.execute("SELECT * FROM owners")
        rows = self.cur.fetchall()
        return rows
#To fetch all the curd opreations 
    def insert(self, owner, address, bedroom, price):
        self.cur.execute("INSERT INTO owners VALUES (NULL, ?, ?, ?, ?)",
                         (owner, address, bedroom, price))
        self.conn.commit()
#To add data to database

    def remove(self, id):
        self.cur.execute("DELETE FROM owners WHERE id=?", (id,))
        self.conn.commit()
#To remover data from database
    def update(self, id, owner, address, bedroom, price):
        self.cur.execute("UPDATE owners SET owner = ?, address = ?, bedroom = ?, price = ? WHERE id = ?",
                         (owner, address, bedroom, price, id))
        self.conn.commit()
#To update data in database
    def __del__(self):
        self.conn.close()


