// In collaboration with 2613065y, 2614579a, 2615938b
package game;

public class GameButton extends javax.swing.JButton{

    String symbol = null;

    /** Sets the symbol to be shown on the button (for this game, the symbol will be “1” or “2” */
    public void setSymbol(String symbol){
        this.symbol = symbol;
        setText(symbol);
        if(symbol.equals("1")){
            setBackground(java.awt.Color.RED);
        }
        else{
            setBackground(java.awt.Color.BLUE);
        }
        setEnabled(false);
    }

    /** Returns the current symbol set on this button. If no symbol has been set, this method should return null. */
    public String getSymbol(){
        return symbol;
    }

    /** Resets the GameButton to its initial state */
   public void reset(){
       setText("");
       symbol = null;
       setBackground(null);
       setEnabled(true);
    }

}
