#The following lines of code were adapted from https://github.com/bradtraversy/part_manager 

from tkinter import *
from tkinter import messagebox
from db import Database
#To import Tkinter and messagebox
#db To import the data from database

db = Database('flatstore.txt')
#To save data in file 

def flats_list():
    owners_list.delete(0, END)
    for row in db.fetch():
        owners_list.insert(END, row)


def add_item():
    if owner_text.get() == '' or address_text.get() == '' or bedroom_text.get() == '' or price_text.get() == '':
        messagebox.showerror('Required Fields', 'Please include all fields')
        return
    db.insert(owner_text.get(), address_text.get(),
              bedroom_text.get(), price_text.get())
    owners_list.delete(0, END)
    owners_list.insert(END, (owner_text.get(), address_text.get(),
                            bedroom_text.get(), price_text.get()))
   
    flats_list()
#To add data to the database


def select_item(event):
    try:
        global selected_item
        index = owners_list.curselection()[0]
        selected_item = owners_list.get(index)

        owner_entry.delete(0, END)
        owner_entry.insert(END, selected_item[1])
        address_entry.delete(0, END)
        address_entry.insert(END, selected_item[2])
        bedroom_entry.delete(0, END)
        bedroom_entry.insert(END, selected_item[3])
        price_entry.delete(0, END)
        price_entry.insert(END, selected_item[4])
    except IndexError:
        pass
#This funcation to select any item in the list

def remove_item():
    db.remove(selected_item[0])
    flats_list()
#To remover from the database


def update_item():
    db.update(selected_item[0], owner_text.get(), address_text.get(),
              bedroom_text.get(), price_text.get())
    flats_list()
#To update the database



# Create window object
app = Tk()

# owner
owner_text = StringVar()
owner_label = Label(app, text='Owner Name', font=('bold', 14), pady=20)
owner_label.grid(row=0, column=0, sticky=W)
owner_entry = Entry(app, textvariable=owner_text)
owner_entry.grid(row=0, column=1)
# address
address_text = StringVar()
address_label = Label(app, text='Flat address', font=('bold', 14))
address_label.grid(row=0, column=2, sticky=W)
address_entry = Entry(app, textvariable=address_text)
address_entry.grid(row=0, column=3)
# Bedroom
bedroom_text = StringVar()
bedroom_label = Label(app, text='Bedrooms', font=('bold', 14))
bedroom_label.grid(row=1, column=0, sticky=W)
bedroom_entry = Entry(app, textvariable=bedroom_text)
bedroom_entry.grid(row=1, column=1)
# Price
price_text = StringVar()
price_label = Label(app, text='Price', font=('bold', 14))
price_label.grid(row=1, column=2, sticky=W)
price_entry = Entry(app, textvariable=price_text)
price_entry.grid(row=1, column=3)
# owners List (Listbox)
owners_list = Listbox(app, height=8, width=50, border=0)
owners_list.grid(row=3, column=0, columnspan=3, rowspan=6, pady=20, padx=20)
# Create scrollbar
scrollbar = Scrollbar(app)
scrollbar.grid(row=3, column=3)
# Set scroll to listbox
owners_list.configure(yscrollcommand=scrollbar.set)
scrollbar.configure(command=owners_list.yview)
# Bind select
owners_list.bind('<<ListboxSelect>>', select_item)

# Buttons
add_btn = Button(app, text='Add Flat', width=12, command=add_item)
add_btn.grid(row=2, column=0 , pady=20)
#adding button

remove_btn = Button(app, text='Remove Flat', width=12, command=remove_item)
remove_btn.grid(row=2, column=1)
#remove button 

update_btn = Button(app, text='Update Flat', width=12, command=update_item)
update_btn.grid(row=2, column=2)
#update button


# Change the tkinter title and size
app.title('Flats')
app.geometry('700x450')

# Populate data
flats_list()

# Start program
app.mainloop()


