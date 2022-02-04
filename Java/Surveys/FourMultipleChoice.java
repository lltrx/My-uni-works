public class FourMultipleChoice extends Question {

    private String [] choices;
    private int arrayCounter;
    

    public FourMultipleChoice(String text, String answer, String[] choices){
        super(text, answer);
        arrayCounter = 0;
    }

    public FourMultipleChoice(){
        choices = new String[5];
        //To set the length for the choices
    }

    public void addChoice(String choice, boolean correct){

        if(arrayCounter >= 4){
            ;
        
    }else{
        choices[arrayCounter+1] = choice;
        arrayCounter = arrayCounter +1;
            if (correct == true){
            }
    }
    }
    public void printQuestion() {
        System.out.println(id + "." + " " + text);
        //The form for MultipleChoice question
        for (int i = 1; i <= arrayCounter; i++)
            System.out.println(id + "." + (i) + " " + choices[i]);
            //The form for the choices
 
        
    }
}