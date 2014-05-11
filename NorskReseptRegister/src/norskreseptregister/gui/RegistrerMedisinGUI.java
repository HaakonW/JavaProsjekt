/*
 Filen inneholder klassen RegistrerMedisinGUI.
 Laget av Peter Wilhelmsen, Henrik Fischer Bjelland, Haakon Winther
 Sist endret 11-05-14
 */
package norskreseptregister.gui;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import norskreseptregister.ObjektKlasser.Medisin;
import norskreseptregister.ObjektKlasser.Medisinliste;

//RegistrerMedisinGUi er for å kunne registere en medisin og legge de i en egenopprettet liste.
public class RegistrerMedisinGUI extends JPanel implements ActionListener
{
    private Medisinliste medisinliste;
    private JTextField regNavnFelt, regAtcFelt;
    private JButton regMedisin, visListe, hjelp;
    private JTextArea utskrift;
    private JScrollPane utskriftscroll;
    private JRadioButton a, b, c;

    public RegistrerMedisinGUI(Medisinliste medisinliste)
    {
        this.medisinliste = medisinliste;
        regNavnFelt = new JTextField(20);
        
        regAtcFelt = new JTextField(20);
        regAtcFelt.setText("f.eks G04B E03");
        
        regMedisin = new JButton("Registrer");
        regMedisin.addActionListener(this);
        
        visListe = new JButton("Vis liste");
        visListe.addActionListener(this);
        
        a = new JRadioButton("A");
        b = new JRadioButton("B");
        c = new JRadioButton("C");
        
        hjelp = new JButton("?");
        hjelp.addActionListener(this);        
        hjelp.setPreferredSize(new Dimension(20, 20));
        hjelp.setToolTipText("Trenger du hjelp?" );
        
        utskrift = new JTextArea(20, 20);
        utskrift.setEditable(false);
        utskrift.setLineWrap(true);
        utskrift.setWrapStyleWord(true);
        
        utskriftscroll = new JScrollPane(utskrift);
        
        
        medisinliste = new Medisinliste();

        knappeGruppe();

        //Elementer legges i paneler            
        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("Legemiddel  "));
        panel1.add(regNavnFelt);

        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("ATC-Nummer"));
        panel2.add(regAtcFelt);

        JPanel panel3 = new JPanel();
        panel3.setBorder(BorderFactory.createEtchedBorder());
        panel3.add(new JLabel("Reseptgruppe"));
        panel3.add(a);
        panel3.add(b);
        panel3.add(c);

        JPanel panel4 = new JPanel();
        panel4.setBorder(BorderFactory.createEtchedBorder());
        panel4.add(regMedisin);
        panel4.add(visListe);

        JPanel panel5 = new JPanel();
        panel5.add(utskriftscroll);

        /* Her starter layouten for registrer en person. Sjekk
        produktdokumentasjonen for forklaring av GridBagLayout*/
        
        GridBagConstraints gc = new GridBagConstraints();
        setLayout(new GridBagLayout());
        
        int x = 0;
        int y = 0;

        gc.gridx = x;
        gc.gridy = y;
        gc.insets = new Insets(5, 10, 5, 10);      
        add(panel1, gc);

        gc.gridx = x;
        gc.gridy = ++y;
        add(panel2, gc);

        gc.gridx = x;
        gc.gridy = ++y;
        gc.fill = GridBagConstraints.HORIZONTAL; 
        add(panel3, gc);

        gc.gridx = x;
        gc.gridy = ++y;
        add(panel4, gc);
        
        ///NY Kolonne
        y = 0;
        gc.gridx = ++x;
        gc.gridy = y;
        gc.gridheight = 5;
        add(panel5, gc);
        
        gc.gridx = 3;
        gc.gridy = 6;
        gc.insets = new Insets(0, 10, 0, 0);
        add(hjelp, gc);        
    } //end of konstruktør MedisinGUI

    private void knappeGruppe()
    {
        ButtonGroup knappegruppe = new ButtonGroup();
        knappegruppe.add(a);
        knappegruppe.add(b);
        knappegruppe.add(c);
    }

    // Registrere ny medisin 
    public Medisin nyMedisin()
    {
        if (sjekkMedisin(regNavnFelt.getText()))
        {
            Medisin ny = new Medisin(regNavnFelt.getText(), regAtcFelt.getText());
            SetMedisinGruppe(ny);
            medisinliste.settInn(ny);
            utskrift.setText("Medisin registrert:\n " + ny.toString());
            return ny;
        }
        return null;
    }
    
    /*
    Metoden setter Medisin i en bestemt gruppe (a, b eller c) 
    avneging av hvilken knapp som er huket av
    */
    public void SetMedisinGruppe(Medisin medisin)
    {
        if (a.isSelected())
        {
            medisin.setGruppeA(true);
        }
        else if (b.isSelected())
        {
            medisin.setGruppeB(true);
        }
        else if (c.isSelected())
        {
            medisin.setGruppeC(true);
        }
    }
    
    // Metoden viser hele medisinlisten i tekstfeltet Utskrift.
    public void visRegister()
    {
        utskrift.setText(medisinliste.toString());
    }
    
    // Metoden tømmer feltene for Navn og Atc nummer.
    public void tomFelter()
    {
        regNavnFelt.setText("");
        regAtcFelt.setText("");
        a.setSelected(false);
        b.setSelected(false);
        c.setSelected(false);
    }
    
    // Metode for å sjekke om medisinnavn består av bokstaver
    public boolean sjekkMedisin(String medisin)
    {  
 
        if(medisin.matches("^[a-zøæåéA-ZØÆÅ. \\-]{2,20}"))
        {
            return true;
        }
        else
        {
            utskrift.setText("Medisinnavn består kun av bokstaver");
            return false;
        } 
    }
    
    /*
    Metoden lytter på hvilke knapp som er trykket på og utfører metodekall
    utfra hvilken knapp som er valgt
    */
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == regMedisin)
        {
            nyMedisin();
            tomFelter();
        }
        if (e.getSource() == visListe)
        {
            visRegister();
        }
        if(e.getSource() == hjelp)
        {

            JOptionPane.showMessageDialog(null, "Her kan man registrere inn en ny medisin."
                    + "\nViktig at riktig ATC nummer og reseptgruppe er korrekt. Sjekk "
                    + "\nbrukerveiledningen for mer info. ");
        }
    }
}//end of class MedisinGUI