/*
Filen inneholder AdminMainHjemGUI klassen.
Laget av Henrik Fischer Bjelland
Sist endret  09-04-2014
*/

package norskreseptregister.gui.info;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import norskreseptregister.Reg.RegisterSystem;
import norskreseptregister.gui.LegeLisensGUI;

class InfoMainHjemGUI extends JPanel
{
    private JButton knapp1, knapp2, knapp3, knapp4, knapp5, knapp6;
    private JPanel panel3, panel2, panel1;
    private JLabel label1, label2, label3;
    LegeLisensGUI paneltest;
    private RegisterSystem system;

    public InfoMainHjemGUI()
    {
        this.paneltest = new LegeLisensGUI(system);
        ImageIcon legeinf = new ImageIcon("src/norskreseptregister/gui/bilder/docinfo.png");
        ImageIcon pasinf = new ImageIcon("src/norskreseptregister/gui/bilder/pasinfo.png");
        ImageIcon medinf = new ImageIcon("src/norskreseptregister/gui/bilder/epille.png");
        
        knapp1 = new JButton("Info om lege");
        knapp2 = new JButton("Info om pasient");
        knapp3 = new JButton("Info om medisin");
        
        knapp1.setFocusPainted(false);
        
        label1 = new JLabel();        
        label1.setIcon(legeinf); 
        label1.setBorder(BorderFactory.createRaisedBevelBorder());
        
        label2 = new JLabel();        
        label2.setIcon(pasinf);
        label2.setBorder(BorderFactory.createRaisedBevelBorder());
        
        label3 = new JLabel();        
        label3.setIcon(medinf);
        label3.setBorder(BorderFactory.createRaisedBevelBorder());
              
       
        
        panel1 = new JPanel();
        panel1.add(label1);
        panel1.addMouseListener(new MouseAdapter() 
        {
        //@Override        
            public void mouseClicked(MouseEvent e) 
            {
                System.out.println("DU TRYKKET PÅ LEGEINFO");
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
                System.out.println("DU TRYKKET PÅ PASIENTINFO");
            }
        }
        );
        
        panel3 = new JPanel();
        panel3.add(label3);
        panel3.addMouseListener(new MouseAdapter() 
        {
        //@Override        
            public void mouseClicked(MouseEvent e) 
            {
                System.out.println("DU TRYKKET PÅ MEDISININFO");
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
        
        gc.gridx = 2;
        gc.gridy = 0;
        add(panel3, gc);
        
        gc.gridx = 0;
        gc.gridy = 1;
        add(knapp1, gc);
        
        gc.gridx = 1;
        gc.gridy = 1;
        add(knapp2, gc);
        
        gc.gridx = 2;
        gc.gridy = 1;
        add(knapp3, gc);
    }

}//end of class AdminMainHjemGUI
