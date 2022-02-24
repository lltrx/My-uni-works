from flask import Flask, render_template, flash, request
from wtforms import Form, TextField, TextAreaField, validators, RadioField
#The first two lines for importing classes, Validators and Fields from flask and wtforms.
#Wtform is an extension for flask to create web forms.


app=Flask(__name__)
#Application instance need for Flask app. 
app.config['SECRET_KEY'] = 'TR0011@'
# The aboveline needed for webforms to protects the application from cross-site request forgery attacks. 

class ReusableForm(Form):
#This class to give each variable a class and each class has a parameter and module.
    name = TextField('Name:', validators=[validators.DataRequired()])
    gicnumber = TextField('GIC Number:', validators=[validators.DataRequired()])
    email = TextField('Email:', validators=[validators.DataRequired()])
#The above three lines have a claas called TextField, which is an entry class, that should enable the user to input text information.
    q1 = TextAreaField('Descrip the course?', validators=[validators.DataRequired()])
    q2 = TextAreaField('How far do you like the Course?', validators=[validators.DataRequired()])
#For these lines they have TextAreaField class, which is Multiple-line text field.
    q3 = RadioField(choices=[('1'),('2'),('3'),('4'),('5')], validators=[validators.DataRequired()])
#For the above line it has a RadioField class, which is a class makes list of Radio buttons.

    
    
def write_to_disk(name, gicnumber, email, q1, q2, q3):
    data = open('Task1/file.txt', 'a')
    data.write('Name={}, GicNumber={}, Email={}, Answer1={}, Answer2={}, Answer3={} \n'.format(name, gicnumber, email, q1, q2, q3))
    data.close()
#The above lines are for a funcation to write parametes in a text file and save the file in Task 1 folder. 

@app.route('/', methods=['GET', 'POST'])

#To handle both GET and POST requests, we add that in the decorator app.route() method.
#The most common method. A GET message is send, and the server returns data.
#Post Used to send HTML form data to the server. The data received by the POST method is not cached by the server.
#The form data will POST to the URL in the action clause of the form label.


def hello():
#Start a new funcation called hello.
    form = ReusableForm(request.form)
#Recall the class ReusableForm and connect it with a variable.
    if request.method == 'POST':
        name=request.form['name']
        gicnumber=request.form['gicnumber']
        email=request.form['email']
        q1=request.form['q1']
        q2=request.form['q2']
        q3=request.form['q3']
#Give all variables a POST method.
        
 
        if form.validate():
            write_to_disk(name, gicnumber, email, q1, q2, q3)
            flash('Thank you for rating GIC')
#This if funaction, if the user write all Fields it will write it in the file text.
#Also will flash a Massage for the user. 
        else:
            flash('Error: All Fields Are Required')
#However if the user miss any Field it will flash an Error Massage.
    return render_template('index.html', form=form)
#Render_template is to import the html file to the flask web. 
            

if __name__ == '__main__':
    app.run(debug=True)
#these lines above are application instance and they are important for Flask app.
