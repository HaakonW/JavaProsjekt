/*
Filen inneholder AdminMainHjemGUI klassen som er første siden du kommer til 
ved å trykke på Admin i vårt hovedprogram.
Laget av Henrik Fischer Bjelland
Sist endret  09-04-2014
*/

package norskreseptregister.gui.info;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import norskreseptregister.Reg.RegisterSystem;
import norskreseptregister.gui.LegeLisensGUI;

class InfoMainHjemGUI extends JPanel implements ActionListener
{
    private JButton knapp1, knapp2, knapp3;
    private JPanel panel3, panel2, panel1;
    private JLabel label1, label2, label3;
    LegeLisensGUI paneltest;
    private RegisterSystem system;
    private final InfoMainGUI infoMainGUI;

    public InfoMainHjemGUI(InfoMainGUI infoMainGUI)
    {
        this.infoMainGUI = infoMainGUI;
        this.paneltest = new LegeLisensGUI(system);
        ImageIcon legeinf = new ImageIcon("src/norskreseptregister/gui/bilder/docinfo.png");
        ImageIcon pasinf = new ImageIcon("src/norskreseptregister/gui/bilder/pasinfo.png");
        ImageIcon medinf = new ImageIcon("src/norskreseptregister/gui/bilder/epille.png");
        
        knapp1 = new JButton(legeinf);
        knapp2 = new JButton(pasinf);
        knapp3 = new JButton(medinf);
        
        knapp1.setFocusPainted(false);
        
        knapp1.setToolTipText("Info om lege");
        knapp2.setToolTipText("Info om pasient");
        knapp3.setToolTipText("Info om medisin");
        
        knapp1.addActionListener(this);
        knapp2.addActionListener(this);
        knapp3.addActionListener(this);
        
        label1 = new JLabel("LegeInfo");
        label1.setFont(new Font ("PT Serif", Font.PLAIN, 20)); 
        label2 = new JLabel("PasientInfo");
        label2.setFont(new Font ("PT Serif", Font.PLAIN, 20)); 
        label3 = new JLabel("MedisinInfo");
        label3.setFont(new Font ("PT Serif", Font.PLAIN, 20)); 
        
        GridBagConstraints gc = new GridBagConstraints();
        setLayout(new GridBagLayout());
        
        int x = 0;
        int y= 0;

        gc.gridx = 0;
        gc.gridy = ++y;
        gc.insets = new Insets(10,10,10,10);
        add(knapp1, gc);
        
        gc.gridx = ++x;
        gc.gridy = y;
        add(knapp2, gc);
        
        gc.gridx = ++x;
        gc.gridy = y;
        add(knapp3, gc);
        
        x = 0;
        
        gc.gridx = x;
        gc.gridy = ++y;
        add(label1,gc);
                
        gc.gridx = ++x;
        gc.gridy = y;
        add(label2, gc); 
        
        gc.gridx = ++x;
        gc.gridy = y;
        add(label3,gc);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == knapp1)
        {
            infoMainGUI.getTabbedPane().setSelectedIndex(1);
        }
        else if(e.getSource() == knapp2)
        {
            infoMainGUI.getTabbedPane().setSelectedIndex(2);
        }
        else if (e.getSource() == knapp3)
        {
            infoMainGUI.getTabbedPane().setSelectedIndex(3);
        }
    }

}//end of class AdminMainHjemGUI