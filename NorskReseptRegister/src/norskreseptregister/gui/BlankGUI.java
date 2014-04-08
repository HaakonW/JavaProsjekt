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
public class BlankGUI extends JPanel implements ActionListener
{
    private Medisinliste liste;
    private String lagreListe = "medisinliste.txt";
    private JTextField regNavn;
    private JButton regMedisinnavn, visListe;
    private JTextArea utskrift,regAnvisning;
    private String medisinlisten = "lagreMedisin.txt";   
    
    public BlankGUI()
    {
        
        
        regNavn = new JTextField(10);
        regMedisinnavn = new JButton("Registrer");
        visListe = new JButton("Vis liste");
        utskrift = new JTextArea(20,20);
        
        regMedisinnavn.addActionListener(this);
        visListe.addActionListener(this);        
        liste = new Medisinliste();
        
        //For å lese listen ved oppstart
        lesObjektFraFil();
        ///// GRID START//////
        
        JPanel utskriftomrad = new JPanel();
        utskriftomrad.add(new JTextArea(40,40));
        utskriftomrad.setBorder(BorderFactory.createLineBorder(Color.BLACK));
               
       
        
        JPanel regMed = new JPanel();
        regMed.add( new JTextField(10)); 
        regMed.add(new JButton("Registrer"));
               
        regMed.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        JPanel header = new JPanel();
        header.add(new JLabel("VELKOMMEN TIL MEDISINSIDEN"));
        header.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
       
        JPanel visListe = new JPanel();        
        visListe.add( new JButton("Vis Liste"));
        visListe.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
         GridBagConstraints gc = new GridBagConstraints();
        setLayout(new GridBagLayout());
        
        gc.gridx = 0;
        gc.gridy = 0;
        add(header, gc);
        
        gc.gridx = 0;
        gc.gridy = 1;
        add(regMed, gc);
        
        gc.gridx = 0;
        gc.gridy = 2;
        add(visListe, gc);
        
        gc.gridx = 1;
        gc.gridy = 1;
        add(utskriftomrad, gc);
        
        
        
        
        /*add(regNavn);
        //add(new JLabel("Anvisning"));
        //add(regAnvisning);
        add(regMedisinnavn);
        add(visListe);
        add(utskrift);*/
        
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
