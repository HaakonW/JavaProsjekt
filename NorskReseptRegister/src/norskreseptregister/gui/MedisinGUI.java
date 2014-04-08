package norskreseptregister.gui;

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
import norskreseptregister.Medisin;
import norskreseptregister.Medisinliste;

//package norskreseptregister.gui;

/**
 *
 * @author PeterWilhelmsen
 */
public class MedisinGUI extends JPanel implements ActionListener
{
    private Medisinliste liste;
    private String lagreListe = "medisinliste.txt";
    private JTextField regNavn;
    private JButton regMedisinnavn, visListe;
    private JTextArea utskrift,regAnvisning;
    private String medisinlisten = "lagreMedisin.txt";
    
    
    public MedisinGUI()
    {
        regNavn = new JTextField(10);
        //regAnvisning = new JTextArea(3,20);
        regMedisinnavn = new JButton("Registrer");
        visListe = new JButton("Vis liste");
        utskrift = new JTextArea(20,20);
        
        regMedisinnavn.addActionListener(this);
        visListe.addActionListener(this);
        
        liste = new Medisinliste();
        
        //For å lese listen ved oppstart
        lesObjektFraFil();
        
        add( new JLabel("Medisinnavn"));
        add(regNavn);
        //add(new JLabel("Anvisning"));
        //add(regAnvisning);
        add(regMedisinnavn);
        add(visListe);
        add(utskrift);
        
        utskrift.setEditable(false); 
    }
    
    //Registrere ny medisin
    public Medisin nyMedisin()
    {
        if(!regNavn.getText().equals(""))
        {
            Medisin ny = new Medisin(regNavn.getText());
            // Kaller på medisinliste.settInn
            liste.settInn(ny);
            utskrift.setText("Medisin registrert:\n " + ny.toString());
            return ny;
        }
        return null;  
    }
    
    
     // Lese objekt fra fil  - HUSK Å IMPORTER java.io.*;
    public void lesObjektFraFil()
    {
        try(ObjectInputStream innfil = new ObjectInputStream(
                                        new FileInputStream(medisinlisten)))
        {
          liste = (Medisinliste)innfil.readObject(); 
            
        }
        catch(ClassNotFoundException cnfe)
        {
           JOptionPane.showMessageDialog(this, cnfe.getMessage());
           /* Må kanskje legge inn muligheten for å opprette ny liste
           om det ikke finnes en: liste = new Medisinliste();*/
        }
        catch(IOException ioe)
        {
          JOptionPane.showMessageDialog(this, "Feil ved lesing, "
                                         + "ny liste blir opprettet");
          //Kan opprette ny tom liste her også. Som forslaget i kommentar over
        }
    }

     //Lagre objektet på fil - try med ressurser
    
    public void skrivObjektTilFil()
    {
        try(ObjectOutputStream utfil = new ObjectOutputStream(
                                        new FileOutputStream(medisinlisten)))
        {
           utfil.writeObject(liste);
           utfil.close();
        }
        catch(NotSerializableException nse)
        {
           JOptionPane.showMessageDialog(this,"Objektet er ikke serialisert!"); 
        }
        catch(FileNotFoundException fnfe)
        {
            JOptionPane.showMessageDialog(this, "Finner ikke " + medisinlisten);
        }
        catch(IOException ioe)
        {
            System.out.println("Kan ikke skrive til fil!");
        }
    }
    
    
    public void visRegister()
    {
        utskrift.setText(liste.toString());
    }
    
    
    public void tomFelter()
    {
        regNavn.setText("");
    }
    
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == regMedisinnavn)
        {
            nyMedisin();
            skrivObjektTilFil();
            tomFelter();
        }
        if(e.getSource() == visListe)
        {
            visRegister();
        }
    }
    
   
}
