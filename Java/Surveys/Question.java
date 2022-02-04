public class Question { 
    String text;
    String answer;
    int id;
    // To define each variable
    protected static int questionID = 1;
    // To start with 1 

    public Question (String text, String answer){

        id = Question.questionID ++; 

    }
    public Question(){
        text = "";
        answer = "";
        id = Question.questionID ++;
        //These linse to add numbers for the questions
    }
    public void setText(String textQuestion){

        text = textQuestion;
        //To set a questions
    }
    public void setAnswer(String correctAnswer){

        answer = correctAnswer;
        //To set answers

    }

    public boolean checkAnswer(String response){

        if( answer.equals(response)){
            return true;
        }else{
            return false;
        }
        //This method To check if the Answer ture of false
    }
        public void printQuestion(){

            System.out.println(id + "." + " " + text);
            //This will be the form for the questions
    }

    public static void main(String[] args){
        FourMultipleChoice fmc = new FourMultipleChoice();
        //fmc is a shrotname for FourMultipleChoice
        fmc.setText( "In 1768, Captain James Cook set out to explore which ocean?" );
        // Write ur Question here
        fmc.addChoice( "Atlantic Ocean" , false);
        fmc.addChoice( "Indian Ocean" , false);
        fmc.addChoice( "Pacific Ocean" , true);
        fmc.addChoice( "Arctic Ocean" , false);
        // Write ur Answers here
        fmc.printQuestion();
        


        TrueFalseQ tfq = new TrueFalseQ();
        // tfq is a shortname for TrueFalseQ
        tfq.setText( "The earth is the fourth planet from the sun." );
        // Write ur Question here
        tfq.setAnswer("False");
        // Write ur Answers here
        tfq.printQuestion();


    }
    
}
