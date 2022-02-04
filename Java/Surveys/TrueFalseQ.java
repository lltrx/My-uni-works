public class TrueFalseQ extends Question{

    public TrueFalseQ(String text, String answer){

        super(text, answer);
    }
    public TrueFalseQ(){
        
        super();
    }
    public void setAnswer(String correctAnswer){

        if(correctAnswer.equals("True")
         || correctAnswer.equals("False")){
            super.setAnswer(correctAnswer);
        }else{
            System.out.println("The answer must be 'True' or 'False");
        }

        }
    
    public void printQuestion(){

        super.printQuestion();
        System.out.println("Choice 'True' or 'False'");
    }
}
