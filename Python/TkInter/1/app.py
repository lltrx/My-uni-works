
        ############
        #libraries#
        ############
import tkinter as tk
import time
from tkinter import Button, Entry, Label, Listbox, Place, StringVar, messagebox
from tkinter.constants import END
from db import Database
#The above lines to import libraries from TKinter and DB. 


db = Database('Task2/store.db')
# Connect to database and Put it in Task 2 folder.
        
        ############
        #   APP    #
        ############
        
app = tk.Tk()
app.geometry("1000x1000")
app.title("Cars app")
app.rowconfigure(0, weight=2)
app.columnconfigure(0, weight=2)
#Costmise the app by changing the geometry, the title, the row and column.


Main = tk.Frame(app, bg="steel blue")
Manager = tk.Frame(app, bg="steel blue")
Customer = tk.Frame(app, bg="steel blue")
#These line to add more frames to the app and direct them. 
#I changed the background colour of the frames by the parameter bg. 

        ############
        # Functions #
        ############

def show_window(window):
    window.tkraise()
#The tkraise function of the Frame widget is used to raise a frame to the top.

#I took information from this website https://rdrr.io/r/base/strptime.html to make the clock.
def clock():
    hour = time.strftime("%I")
    minute = time.strftime("%M")
    am_pm = time.strftime("%p")
    time_zone = time.strftime("%Z")
    date = time.strftime("%D")

    my_time.config(text=hour + ":" + minute + " " + am_pm + " "+ date)
    my_time.after(100, clock)
#This funcation to makes parameaters for variable and to costmise them how to apper in the app.
 
def update():
    my_time.config(text="New Text")
#This funcation for updating the time and the date 

#In the next lines I used this source for them https://github.com/bradtraversy/part_manager/blob/master/part_manager.py.
def populate_list():
    cars_list_Manager.delete(0, END)
    for row in db.fetch():
        cars_list_Manager.insert(END, row)
    cars_list_Customer.delete(0, END)
    for row in db.fetch():
        cars_list_Customer.insert(END, row)
#This function for removing and adding in cars list. And I put them in Manager and Customer windows. 

def add_item():
    if car_text.get() == '' or model_text.get() == '' or condition_text.get() == '' or price_text.get() == '' or phone_text.get() == '':
        messagebox.showerror('Required Fields', 'Please include all fields')
        return
    db.insert(car_text.get(), model_text.get(),
              condition_text.get(), price_text.get(), phone_text.get())
    cars_list_Manager.delete(0, END)
    cars_list_Customer.delete(0, END)
    cars_list_Manager.insert(END, (car_text.get(), model_text.get(),
                            condition_text.get(), price_text.get(), phone_text.get()))
    
    clear_text()
    populate_list()
#This function is adding information to the cars list.

def select_item(event):
    try:
        global selected_item
        index = cars_list_Manager.curselection()[0]
        selected_item = cars_list_Manager.get(index)


        car_entry.delete(0, END)
        car_entry.insert(END, selected_item[1])
        model_entry.delete(0, END)
        model_entry.insert(END, selected_item[2])
        condition_entry.delete(0, END)
        condition_entry.insert(END, selected_item[3])
        price_entry.delete(0, END)
        price_entry.insert(END, selected_item[4])
        phone_entry.delete(0, END)
        phone_entry.insert(END, selected_item[5])
    except IndexError:
        pass
#This funcation is to seclect items from the list easily, therefore from selecting them I can add, delete and update the list.

def remove_item():
    db.remove(selected_item[0])
    clear_text()
    populate_list()
#This function to remove itmes from the list

def update_item():
    db.update(selected_item[0], car_text.get(), model_text.get(),
              condition_text.get(), price_text.get(), phone_text.get())
    populate_list()
#This function to update variables in the list.

def clear_text():
    car_entry.delete(0, END)
    model_entry.delete(0, END)
    condition_entry.delete(0, END)
    price_entry.delete(0, END)
    phone_entry.delete(0, END)
#This funcation to clear the written variables in the Entry boxes 


for window in (Main, Manager, Customer):
    window.grid(row=0,column=0,sticky="nsew")
#These lines to costmise the windows

        ############
        #  Labels  #
        #     &    #
        # Entries  #
        ############

my_time = Label(Main, text="", font=("Helvetica", 20, "bold"), bg="steel blue", fg="white")
my_time.pack(pady=10)
my_time.place(x=400)

Main_title=  Label(Main, text="Welcome to Cars app", font=("Helvetica", 20, "bold"), fg="white" ,bg="steel blue")
Main_title.place(x=370, y=300)

Manager_title=  Label(Manager, text="Manager page", font=("Helvetica", 20, "bold"), fg="white", bg="steel blue")
Manager_title.place(x=420, y=10)

Customer_title=  Label(Customer, text="Customers page" ,font=("Helvetica", 20, "bold"), fg="white", bg="steel blue")
Customer_title.place(x=440, y=10)
#All of above lines to give all variables a Label and direct them in a specific window with some changing in the layout and the place.

#The next lines I used this source for them https://github.com/bradtraversy/part_manager/blob/master/part_manager.py.
car_text = StringVar()
car_label = Label(Manager, text="Car Name:",font=("Helvetica", 15, "bold"), fg="white", bg="steel blue")
car_label.place(x=100,y=200)
car_entry = Entry(Manager, textvariable=car_text, bd=6 ,bg="#b3b3b3")
car_entry.place(x=100,y=225)

model_text = StringVar()
model_label = Label(Manager, text="Model:", font=("Helvetica", 15, "bold"),fg="white", bg="steel blue")
model_label.place(x=300,y=200)
model_entry = Entry(Manager, textvariable=model_text, bd=6 ,bg="#b3b3b3")
model_entry.place(x=300, y=225)

condition_text = StringVar()
condition_label = Label(Manager, text="Condition:", font=("Helvetica", 15, "bold"), fg="white", bg="steel blue")
condition_label.place(x=500, y=200)
condition_entry = Entry(Manager, textvariable=condition_text, bd=6 ,bg="#b3b3b3")
condition_entry.place(x=500, y=225)

price_text = StringVar()
price_label = Label(Manager, text="Price:", font=("Helvetica", 15, "bold"), fg="white" , bg="steel blue")
price_label.place(x=700, y=200)
price_entry = Entry(Manager, textvariable=price_text, bd=6 ,bg="#b3b3b3")
price_entry.place(x=700, y=225)

phone_text = StringVar()
phone_label = Label(Manager, text="Phone Number:", font=("Helvetica", 15, "bold"), fg="white" , bg="steel blue")
phone_label.place(x=400, y=275)
phone_entry = Entry(Manager, textvariable=phone_text, bd=6 ,bg="#b3b3b3")
phone_entry.place(x=400, y=300)
#The previous lines to give each variable a StringVar, Lable and Entry box to insert the data, also some layout and changing their places.

        ############
        #  Lists   #
        ############

cars_list_Manager = Listbox(Manager, height=20, width=100, border=1)
cars_list_Manager.place(x=50, y=450)
cars_list_Manager.bind('<<ListboxSelect>>', select_item)

cars_list_Customer = Listbox(Customer, height=40, width=100, border=1)
cars_list_Customer.place(y=100, x=50)
cars_list_Customer.bind('<<ListboxSelect>>', select_item)
#These lines to direct and changing the place of the list, also to insert select function into the list.

         ############
        #  Buttons  #
        ############

add_btn = Button(Manager, text='Add Car',font=("Helvetica", 15), width=12, command=add_item,)
add_btn.place(x=200, y=400)

remove_btn = Button(Manager, text='Remove Car',font=("Helvetica", 15), width=12, command=remove_item)
remove_btn.place(x=350, y=400)

update_btn = Button(Manager, text='Update Car',font=("Helvetica", 15), width=12, command=update_item)
update_btn.place(x=500,y=400)

clear_btn = Button(Manager, text='Clear Car',font=("Helvetica", 15), width=12, command=clear_text)
clear_btn.place(x=650, y=400)

back_btn = Button(Customer, text='Back to main',font=("Helvetica", 15),command=lambda:show_window(Main), width=12)
back_btn.place(x=450, y=50)

back_btn = Button(Manager, text='Back to main',font=("Helvetica", 15),command=lambda:show_window(Main), width=12)
back_btn.place(x=420,y=50)

next_btn = Button(Main, text='Manager',font=("Helvetica", 15),command=lambda:show_window(Manager), width=12)
next_btn.place(x=500,y=400)

next_btn = Button(Main, text='Customer',font=("Helvetica", 15), command=lambda:show_window(Customer), width=12 )
next_btn.place(x=300, y=400)
#These lines to add buttons to the app and direct it to the correct place with change their places and layout them.


populate_list()

clock()

show_window(Main)

app.mainloop()