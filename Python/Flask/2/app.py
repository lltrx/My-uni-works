from flask import Flask, render_template, flash, request
# flask to run the app successful
from wtforms import Form, TextField, TextAreaField, validators, BooleanField 
# wtforms to imports from classes


app=Flask(__name__)
#creating flask object
app.config.from_object(__name__)
app.config['SECRET_KEY'] = 'TR0011@'
#flask-wtf must have a secert key to encryption the app


class ReusableForm(Form):
#To start the function
    name = TextField('Name:', validators=[validators.Required()])
    gicnumber = TextField('GIC Number:', validators=[validators.Required()])
    email = TextField('Email', validators=[validators.DataRequired()])
    qu1 = TextAreaField('Descrip the course?', validators=[validators.DataRequired()])
    qu2 = TextAreaField('How far do you like the Course?', validators=[validators.DataRequired()])
    o1 = BooleanField('Yes!', [validators.Optional()])
    
    
    

#TextField to write the name, gicnumber, email in
#TextAreaField to write long answers in
    
def write_to_disk(name, gicnumber, email, qu1, qu2, o1):
    data = open('file.txt', 'a')
    data.write('Name={}, GicNumber={}, Email={}, Answer1={}, Answer2={}, o1={} \n'.format(name, gicnumber, email, qu1, qu2, o1))
    data.close()
# For save data in a file.txt

@app.route('/', methods=['GET', 'POST'])
def hello():
    form = ReusableForm(request.form)
    
    if request.method == 'POST':
        name=request.form['name']
        gicnumber=request.form['gicnumber']
        email=request.form['email']
        qu1=request.form['qu1']
        qu2=request.form['qu2']
        o1=request.form['o1']
        
      
# To sneds post by pressing the submit button
        if form.validate():
            write_to_disk(name, gicnumber, email, qu1, qu2, o1)
            flash('Hello {} {}'.format(name, gicnumber))

        else:
            flash('Error: All Fields Are Required')
# flash to wrin if there is any mistake
    return render_template('index.html', form=form)
# to return the html file 
            

if __name__ == '__main__':
    app.run(debug=True)
# to run the app
            
