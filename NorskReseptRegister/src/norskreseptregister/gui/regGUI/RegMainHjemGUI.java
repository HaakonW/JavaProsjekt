/*
Filen inneholder klassen RegMainHjemGUI.
Laget av  Henrik Fischer Bjelland
Sist endret 09-04-2014 
*/

package norskreseptregister.gui.regGUI;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

class RegMainHjemGUI extends JPanel
{
    private JButton regPasient, regLege, regResept;
    private JPanel panel1, panel2;
    private JLabel label1, label2, label3;

    public RegMainHjemGUI()
    {
        regPasient= new JButton("Registrer Pasient");
        regLege = new JButton("Registrer Lege");
        regResept = new JButton("Registrer Resept");
        ImageIcon regleg = new ImageIcon("src/norskreseptregister/gui/bilder/doktor.png");
        ImageIcon regPas = new ImageIcon("src/norskreseptregister/gui/bilder/person.png");
        ImageIcon regRes = new ImageIcon("src/norskreseptregister/gui/bilder/Resept.png");
        
        label1 = new JLabel();
        label1.setIcon(regleg);
        label1.setBorder(BorderFactory.createRaisedBevelBorder());
        label1.addMouseListener(new MouseAdapter() 
        {
        //@Override        
            public void mouseClicked(MouseEvent e) 
            {
                System.out.println("DU TRYKKET PÅ ENDRE REGISTRER LISENS");
            }
        }
        );
        
        label2 = new JLabel();
        label2.setIcon(regPas);
        label2.setBorder(BorderFactory.createRaisedBevelBorder());
        label2.addMouseListener(new MouseAdapter() 
        {
        //@Override        
            public void mouseClicked(MouseEvent e) 
            {
                System.out.println("DU TRYKKET PÅ REGISTRER PASIENT");
            }
        }
        );
        
        label3 = new JLabel();
        label3.setIcon(regRes);
        label3.setBorder(BorderFactory.createRaisedBevelBorder()); 
        label3.addMouseListener(new MouseAdapter() 
        {
        //@Override        
            public void mouseClicked(MouseEvent e) 
            {
                System.out.println("DU TRYKKET PÅ REGISTER RESPET");
            }
        }
        );
        
        panel2 = new JPanel();
        panel2.add(regPasient);
        panel2.add(regLege);
        panel2.add(regResept);
        
        
        GridBagConstraints gc = new GridBagConstraints();
        setLayout(new GridBagLayout());
        gc.gridx = 0;
        gc.gridy = 0;
        gc.insets = new Insets(10, 5, 5, 10);
        gc.anchor = GridBagConstraints.WEST;
        gc.fill = GridBagConstraints.HORIZONTAL;
        //add(panel1, gc);
        
        gc.gridx = 0;
        gc.gridy = 0;
        add(label1, gc);
        
        gc.gridx = 1;
        gc.gridy = 0;
        add(label2, gc);        
        
        gc.gridx = 2;
        gc.gridy = 0;
        add(label3, gc);
        
        gc.gridx = 0;
        gc.gridy = 1;
        add(regLege, gc);
        
        gc.gridx = 1;
        gc.gridy = 1;
        add(regPasient, gc);
        
        gc.gridx = 2;
        gc.gridy = 1;
        add(regResept, gc);
        
        
        
    }
}//end of class RegMainHjemGUI
