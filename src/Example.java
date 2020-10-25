import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.text.Style;
import javax.swing.Timer;
import java.awt.event.*;

public class Example extends JFrame {
    JTextPane textPane;

    public Example() {
       setTitle("Simple example");
       setSize(300, 200);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       textPane = new JTextPane();
       textPane.getAccessibleContext().setAccessibleName("Chat Output");
       add(textPane);
       int delay = 3000;
       ActionListener taskPerformer = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            writeText();
        }
    };
    new Timer(delay, taskPerformer).start();
       
    }

    public void writeText() {
        int len = textPane.getStyledDocument().getLength();
        Style style = textPane.getLogicalStyle();
        
        try {
            textPane.getStyledDocument().insertString(len, " test ", style);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}