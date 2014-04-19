/*
Filen inneholder AdminMainHjemGUI klassen.
Laget av Henrik Fischer Bjelland
Sist endret  09-04-2014
*/

package norskreseptregister.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class AdminMainHjemGUI extends JPanel
{
    private JButton endreLisens, medisin;
    private JPanel panel2, panel1;
    private JLabel label1, label2;
    LegeLisensGUI paneltest = new LegeLisensGUI();

    public AdminMainHjemGUI()
    {
        endreLisens = new JButton("Endre Lisens");
        medisin = new JButton("Registrer Medisin");
        ImageIcon modLeg = new ImageIcon("src/norskreseptregister/gui/bilder/Refresh-icon.png");
        ImageIcon regPill = new ImageIcon("src/norskreseptregister/gui/bilder/epille.png");
        
        label1 = new JLabel();        
        label1.setIcon(modLeg); 
        label1.setBorder(BorderFactory.createRaisedBevelBorder());        

        
        label2 = new JLabel();        
        label2.setIcon(regPill);
        label2.setBorder(BorderFactory.createRaisedBevelBorder());
       
        
        panel1 = new JPanel();
        panel1.add(label1);
        panel1.addMouseListener(new MouseAdapter() 
        {
        //@Override        
            public void mouseClicked(MouseEvent e) 
            {
                System.out.println("DU TRYKKET PÅ ENDRE LEGE");
            }
        }
        );
        
        panel2 = new JPanel();
        panel2.add(label2);
        panel2.addMouseListener(new MouseAdapter() 
        {
        //@Override        
            public void mouseClicked(MouseEvent e) 
            {
                System.out.println("DU TRYKKET PÅ ENDRE LISENS");
            }
        }
        );
        
        //panel1.add(regPill):
        
        GridBagConstraints gc = new GridBagConstraints();
        setLayout(new GridBagLayout());
        gc.gridx = 0;
        gc.gridy = 0;
        gc.insets = new Insets(10, 5, 5, 10);
        add(panel1, gc);
        
        gc.gridx = 1;
        gc.gridy = 0;
        add(panel2, gc);  
    }
    
  
    
}//end of class AdminMainHjemGUI
