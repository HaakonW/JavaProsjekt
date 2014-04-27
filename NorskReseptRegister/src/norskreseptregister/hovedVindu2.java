/*
 Inneholder klasse for å kjøre hovedvindu2
 Laget av Peter Wilhelmsen, Henrik Fischer Bjelland, Haakon Winther
 Sist endret 26/04/14
 */

package norskreseptregister;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import norskreseptregister.ObjektKlasser.Medisinliste;
import norskreseptregister.Reg.RegisterSystem;
import norskreseptregister.gui.AdminMain;


public class hovedVindu2 extends JFrame implements ActionListener
{   
    //private AdminMain adminvindu();
    private JLabel label1, label2, label3;
    private JButton knapp1, knapp2, knapp3;
    private RegisterSystem system;
    private Medisinliste medisinliste;
    
    public hovedVindu2(RegisterSystem system, Medisinliste medisinliste)
    {  
        ImageIcon elege = new ImageIcon("src/norskreseptregister/gui/bilder/Refresh-icon.png");
        ImageIcon epille = new ImageIcon("src/norskreseptregister/gui/bilder/epille.png");
        ImageIcon statistikk = new ImageIcon("src/norskreseptregister/gui/bilder/statistikk.png");
        
        knapp1 = new JButton(elege);
        knapp2 = new JButton(epille);
        knapp3 = new JButton(statistikk);
        
        knapp1.addActionListener(this);
        knapp2.addActionListener(this);
        knapp3.addActionListener(this);

        label1 = new JLabel("Admin");
        label1.setFont(new Font ("PT Serif", Font.PLAIN, 20));
        
        label2 = new JLabel("Registrering");
        label2.setFont(new Font ("PT Serif", Font.PLAIN, 20));
        
        label3 = new JLabel("Informasjon");
        label3.setFont(new Font ("PT Serif", Font.PLAIN, 20));
        
        knapp1.setFocusPainted(false);
        knapp2.setFocusPainted(false);
        knapp3.setFocusPainted(false);
        
        knapp1.setToolTipText("Endre lisens for lege");
        knapp2.setToolTipText("Registrer ny medisin");
        knapp3.setToolTipText("Statistikk"); 
        
        GridBagConstraints gc = new GridBagConstraints();
        setLayout(new GridBagLayout());      
        
        gc.gridx = 0;
        gc.gridy = 1; 
        gc.insets = new Insets(10,10,10,10);
        add(knapp1, gc);
        
        gc.gridx = 1;
        gc.gridy = 1;
        add(knapp2, gc);
        
        gc.gridx = 2;
        gc.gridy = 1;
        add(knapp3, gc);
        
        gc.gridx = 0;
        gc.gridy = 2;
        add(label1, gc);
        
        gc.gridx = 1;
        gc.gridy = 2;
        add(label2, gc);
        
        gc.gridx = 2;
        gc.gridy = 2;
        add(label3, gc);

        setVisible(true);
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == knapp1)
        {
            AdminMain ny = new AdminMain(system, medisinliste);
        }
    } 
}
