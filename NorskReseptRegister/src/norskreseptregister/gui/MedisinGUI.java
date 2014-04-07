/*
Filen inneholder GUI for å kunne registere en medisin og legge de i en 
egenopprettet liste.

Laget av Peter Wilhelmsen
Sist endret 07.04.14
 */

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import norskreseptregister.Medisinliste;

//package norskreseptregister.gui;

/**
 *
 * @author PeterWilhelmsen
 */
public abstract class MedisinGUI extends JFrame implements ActionListener
{
    private Medisinliste liste;
    private String lagreListe = "medisinliste.txt";
    private JTextField regNavn;
    private JButton regMedisinnavn, visListe;
    private JTextArea utskrift,regAnvisning;
    
    
    public MedisinGUI()
    {
        super("Medisinregister");
        regNavn = new JTextField(10);
        //regAnvisning = new JTextArea(3,20);
        regMedisinnavn = new JButton("Registrer");
        visListe = new JButton("Vis liste");
        utskrift = new JTextArea(20,20);
        
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add( new JLabel("Medisinnavn"));
        c.add(regNavn);
        //c.add(new JLabel("Anvisning"));
        //c.add(regAnvisning);
        c.add(regMedisinnavn);
        c.add(visListe);
        c.add(utskrift);
        
        utskrift.setEditable(false);
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    
    /*Main-metode for å kjøre programmet
    - Vanlig main-metode nå, må byttes til eventQueue.invokeLater
    - Legges inn i hovedprogrammet senere. */
    
    public static void main(String[] args)
    {
        MedisinGUI vindu = new MedisinGUI() {

            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };

    }
    
    
}
