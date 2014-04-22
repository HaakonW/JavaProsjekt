/*
Filen inneholder klassen LegeLisensGUI.
Laget av  Haakon Winther
Sist endret 09-04-2014
*/

package norskreseptregister.gui;

import java.awt.*;
import javax.swing.*;
//usikker på om vi bare kan importere swing.*; ????

public class LegeLisensGUI extends JPanel
{
   private JLabel fornavnlabel, etternavnlabel;
   private JTextField fornavnfelt, etternavnfelt;
   private JButton sokLege, endreLisens, hjelp;
   private JTextArea utskrift;
   private JCheckBox a, b, c;
   private JPanel panel1, panel2, panel3, panel4, panel5, panel6;
   
   public LegeLisensGUI()
   {
       fornavnfelt = new JTextField(20);
       etternavnfelt = new JTextField(20);
       sokLege = new JButton("Søk etter lege");
       endreLisens = new JButton("Endre bevilling");
       hjelp = new JButton("Hjelp");
       fornavnlabel = new JLabel("Fornavn:");
       etternavnlabel = new JLabel("Etternavn:");
       utskrift = new JTextArea(20,20);
       utskrift.setBorder(BorderFactory.createEtchedBorder(Color.LIGHT_GRAY, Color.black));
       a = new JCheckBox("A");
       b = new JCheckBox("B");
       c = new JCheckBox("C");
       
       ////PANEL START///
       
       panel1 = new JPanel();
       panel1.add(fornavnlabel);
       panel1.add(fornavnfelt);
       
       
       panel2 = new JPanel();
       panel2.add(etternavnlabel);
       panel2.add(etternavnfelt);

       
       panel3 = new JPanel();
       panel3.add(sokLege);
      
       
       panel4 = new JPanel();
       panel4.add(a);
       panel4.add(b);
       panel4.add(c);
       panel4.add(endreLisens);
              
       panel5 = new JPanel();
       panel5.add(hjelp);    
       
       panel6 = new JPanel();
       panel6.add(utskrift);
         
       
       /// GRID START ///
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
        
        gc.gridx = 0;
        gc.gridy = 4;  
        gc.anchor = GridBagConstraints.WEST;
        add(panel5, gc);
        
        gc.gridx = 0;
        gc.gridy = 5;
        //add(hjelp, gc);
        
        gc.gridx = 2;
        gc.gridy = 0;
        gc.gridheight = 6;
        add(panel6, gc);

        utskrift.setEditable(false); 
 
   }//end of konstruktør LegeLisensGUI
}//end of class LegeLisensGUI
