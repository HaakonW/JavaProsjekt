/*
 Filen inneholder klassen LegeInfoGUI
 Laget av Henrik Fischer Bjelland
 Sist endret 11-04-2014 
 */
package norskreseptregister.gui.info;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.*;

public class StatestikkGUI extends JPanel
{
    private JTextField medisinfelt;
    private JTextArea utskrift;
    private JPanel panel1, panel2, panel3, panel4, panel5, panel6;
    private JLabel medisinlabel;
    private JButton knapp1, knapp2, knapp3;
   
    public StatestikkGUI()
    {
        
        medisinlabel = new JLabel("Medisinnavn");
        medisinfelt = new JTextField(20);
        knapp1 = new JButton("Vis pasienter ");
        knapp2 = new JButton("Vis Leger");
        utskrift = new JTextArea(20,20);
       
        ///PANELS START ////
        
        panel1 = new JPanel();
        panel1.add(medisinlabel);
        panel1.add(medisinfelt); 
       
        panel3 = new JPanel();
        panel3.add(knapp1);  
        panel3.add(knapp2);
       
       
       panel4 = new JPanel();
       panel4.add(utskrift);

       ///GRID START ////
       GridBagConstraints gc = new GridBagConstraints();
       setLayout(new GridBagLayout());
       gc.gridx = 0;
       gc.gridy = 0;
       gc.insets = new Insets(10, 5, 5, 10);
       gc.anchor = GridBagConstraints.WEST;
       gc.fill = GridBagConstraints.HORIZONTAL;
       add(panel1, gc);   
    
       
       gc.gridx = 0;
       gc.gridy = 1;
       add(panel3, gc);
               
        
        gc.gridx = 1;
        gc.gridy = 0;
        gc.gridheight = 6;
        add(panel4, gc);

        utskrift.setEditable(false); 

    }
}//end of class LegeInfoGUI
