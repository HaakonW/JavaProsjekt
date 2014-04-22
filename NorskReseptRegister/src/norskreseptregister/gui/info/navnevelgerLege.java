/*
Skal vise dialogvindu der man kan se oversikt over alle godkjente leger, for så
å kunne velge en. 
Har LegeInfoGUI som foreldervindu - må til for å kunne opprette et slikt
undervindu.

Laget av Peter Wilhelmsen
Sist endret 15/04/14
 */

package norskreseptregister.gui.info;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class navnevelgerLege extends JDialog
{
    // Må her opprette en liste av navnene til legene
     private JList <String> legeliste;
     private String[] navn = 
     {
         "lege1", "lege2","lege3", "lege4","lege5","lege6","lege7"
             ,"lege8","lege9","lege10"
     };
    
    
    private JButton OK;

    
    
    // foreldrevinduet
    private LegeInfoGUI forelder;
    
    public navnevelgerLege() // LegeInfoGUI f
    {
        //super(f, "Velg lege", true);
        //forelder = f;
        
        legeliste = new JList<>(navn);
        
        //Kun et navn kan velges
        legeliste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        
        /*Må kanskje sette startnavn her
        < Random velger = new Random();
        */
        
        JPanel listepanel = new JPanel();
        listepanel.setLayout( new BoxLayout(listepanel, BoxLayout.PAGE_AXIS));
        listepanel.add( new JLabel("Legeliste"));
        
        JScrollPane listescroller = new JScrollPane(legeliste);
        listescroller.setSize(30,30);
        
        listepanel.add(listescroller);
        
        Container c = getContentPane();
        c.add(listepanel,BorderLayout.CENTER);
        c.add(listescroller, BorderLayout.PAGE_END);
        pack();
        
        setSize(300,300);
        setVisible(true);
       
    }
    
    public static void main(String[] args)
    {
            navnevelgerLege ny = new navnevelgerLege();
    }
}
