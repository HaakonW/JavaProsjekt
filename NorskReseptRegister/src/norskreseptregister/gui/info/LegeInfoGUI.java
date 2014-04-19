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

public class LegeInfoGUI extends JPanel
{

    private JTextField fornavnfelt, etternavnfelt;
    private JTextArea utskrift;
    private JPanel panel1, panel2, panel3, panel4, panel5, panel6;
    private JLabel fornavnlabel, etternavnlabel;
    private JButton knapp1, knapp2, knapp3;
    private JCheckBox a, b, c;

    public LegeInfoGUI()
    {
        fornavnlabel = new JLabel("Fornavn   ");
        etternavnlabel = new JLabel("Etternavn ");
        etternavnfelt = new JTextField(20);
        fornavnfelt = new JTextField(20);
        knapp1 = new JButton("Vis alle leger");
        knapp2 = new JButton("Vis alle resepeter på lege");
        knapp3 = new JButton("Vis resepter i kategori");
        utskrift = new JTextArea(20,20);
        a = new JCheckBox("A");
        b = new JCheckBox("B");
        c = new JCheckBox("C");
        
        ///PANELS START ////
        
        panel1 = new JPanel();
        panel1.add(fornavnlabel);
        panel1.add(fornavnfelt);
       
       
       panel2 = new JPanel();
       panel2.add(etternavnlabel);
       panel2.add(etternavnfelt);
       
       panel3 = new JPanel();
       panel3.add(knapp1);
       panel3.add(knapp2);
       
       panel4 = new JPanel();
       panel4.add(a);
       panel4.add(b);
       panel4.add(c);
       panel4.add(knapp3);
       
       panel5 = new JPanel();
       panel5.add(utskrift);

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
       add(panel2, gc);
       
        gc.gridx = 0;
        gc.gridy = 2;
        gc.fill = 0;
        gc.anchor = GridBagConstraints.EAST;
        add(panel3, gc);
        
        gc.gridx = 0;
        gc.gridy = 3;
        add(panel4, gc);
        
        gc.gridx = 1;
        gc.gridy = 0;
        gc.gridheight = 6;
        add(panel5, gc);

        utskrift.setEditable(false); 
       

    }
    
 
}//end of class LegeInfoGUI
