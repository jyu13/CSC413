
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * @author Arnold Jiadong Yu
 */
public class EvaluatorUI extends JFrame implements ActionListener {

    private TextField txField = new TextField();
    private Panel buttonPanel = new Panel();
    // total of 20 buttons on the calculator,
    // numbered from left to right, top to bottom
    // bText[] array contains the text for corresponding buttons
    private static final String[] bText = {
        "7", "8", "9", "+", "4", "5", "6", "- ", "1", "2", "3",
        "*", "0", "^", "=", "/", "(", ")", "C", "CE"
    };
    private Button[] buttons = new Button[bText.length];

    public static void main(String argv[]) {
        EvaluatorUI calc = new EvaluatorUI();
    }

    public EvaluatorUI() {
        setLayout(new BorderLayout());

        add(txField, BorderLayout.NORTH);
        txField.setEditable(false);

        add(buttonPanel, BorderLayout.CENTER);
        buttonPanel.setLayout(new GridLayout(5, 4));

        //create 20 buttons with corresponding text in bText[] array
        for (int i = 0; i < 20; i++) {
            buttons[i] = new Button(bText[i]);
        }

        //add buttons to button panel
        for (int i = 0; i < 20; i++) {
            buttonPanel.add(buttons[i]);
        }

        //set up buttons to listen for mouse input
        for (int i = 0; i < 20; i++) {
            buttons[i].addActionListener(this);
        }

        setTitle("Calculator");
        setSize(400, 400);
        setLocationByPlatform(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    // 14 = =, 18  C = clear everything, 19 CE = clear what just typed
    public void actionPerformed(ActionEvent arg0) {
        // You need to fill in this fuction
        
        if(arg0.getSource() == buttons[0]){           
            txField.setText(txField.getText()+ bText[0]);
            
        }
        else if(arg0.getSource() == buttons[1]){
            txField.setText(txField.getText()+ bText[1]);
            
        }
        else if(arg0.getSource() == buttons[2]){
            txField.setText(txField.getText()+ bText[2]);
        }
        else if(arg0.getSource() == buttons[3]){
            txField.setText(txField.getText()+ bText[3]);
        }
        else if(arg0.getSource() == buttons[4]){
            txField.setText(txField.getText()+ bText[4]);
        }
        else if(arg0.getSource() == buttons[5]){
            txField.setText(txField.getText()+ bText[5]);
        }
        else if(arg0.getSource() == buttons[6]){
            txField.setText(txField.getText()+ bText[6]);
        }
        else if(arg0.getSource() == buttons[7]){
            txField.setText(txField.getText()+ bText[7]);
        }
        else if(arg0.getSource() == buttons[8]){
            txField.setText(txField.getText()+ bText[8]);
        }
        else if(arg0.getSource() == buttons[9]){
            txField.setText(txField.getText()+ bText[9]);
        }
        else if(arg0.getSource() == buttons[10]){
            txField.setText(txField.getText()+ bText[10]);
        }
        else if(arg0.getSource() == buttons[11]){
            txField.setText(txField.getText()+ bText[11]);
        }
        else if(arg0.getSource() == buttons[12]){
            txField.setText(txField.getText()+ bText[12]);
        } 
        else if(arg0.getSource() == buttons[13]){
            txField.setText(txField.getText()+ bText[13]);
        } 
        else if(arg0.getSource() == buttons[14]){       //after = sign start new expression, dont know how it should work
            Evaluator e = new Evaluator();
            int result = e.eval(txField.getText());
            txField.setText(String.valueOf(result));            
        }
        else if(arg0.getSource() == buttons[15]){
            txField.setText(txField.getText()+ bText[15]);
        } 
        else if(arg0.getSource() == buttons[16]){
            txField.setText(txField.getText()+ bText[16]);
        } 
        else if(arg0.getSource() == buttons[17]){
            txField.setText(txField.getText()+ bText[17]);
        } 
        else if(arg0.getSource() == buttons[18]){
            txField.setText("");
        }
        else if(arg0.getSource() == buttons[19]){
            
            txField.setText("");
            //String text = txField.getText();
            //if(text.length()>0)
            //    txField.setText(text.substring(0,text.length()-1));
        }
    }
}
