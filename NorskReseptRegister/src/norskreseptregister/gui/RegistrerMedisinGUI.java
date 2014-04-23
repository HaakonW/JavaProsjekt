/*
 Filen inneholder GUI for å kunne registere en medisin og legge de i en 
 egenopprettet liste.
 Laget av Peter Wilhelmsen, Henrik Fischer Bjelland
 Sist endret 22-04-14
 */
package norskreseptregister.gui;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import norskreseptregister.ObjektKlasser.Medisin;
import norskreseptregister.ObjektKlasser.Medisinliste;

public class RegistrerMedisinGUI extends JPanel implements ActionListener
{

    private Medisinliste medisinliste;
    private Medisin medisin;
    private JTextField regNavn, regAtc;
    private JButton regMedisinnavn, visListe, hjelp;
    private JTextArea utskrift, regAnvisning;
    private String medisinlisten = "lagreMedisin.txt";
    private JRadioButton a, b, c;

    public RegistrerMedisinGUI()
    {
        regNavn = new JTextField(20);
        regAtc = new JTextField(20);
        regMedisinnavn = new JButton("Registrer");
        visListe = new JButton("Vis liste");
        hjelp = new JButton("?");
        hjelp.setPreferredSize(new Dimension(20, 20));
        
        utskrift = new JTextArea(20, 20);
        utskrift.setBorder(BorderFactory.createEtchedBorder(Color.LIGHT_GRAY, Color.black));
        
        a = new JRadioButton("A");
        b = new JRadioButton("B");
        c = new JRadioButton("C");

        regMedisinnavn.addActionListener(this);
        visListe.addActionListener(this);
        hjelp.addActionListener(this);
        medisinliste = new Medisinliste();

        //For å lese listen ved oppstart
        lesObjektFraFil();
        knappeGruppe();

        ///////PANEL START/////             
        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("Medisinnavn"));
        panel1.add(regNavn);

        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("ATC-Nummer"));
        panel2.add(regAtc);

        JPanel panel3 = new JPanel();
        panel3.add(a);
        panel3.add(b);
        panel3.add(c);

        JPanel panel4 = new JPanel();
        panel4.add(regMedisinnavn);
        panel4.add(visListe);

        JPanel panel5 = new JPanel();
        panel5.add(utskrift);

        ///// GRID START//////
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
        gc.anchor = GridBagConstraints.WEST;
        add(panel3, gc);

        gc.gridx = 0;
        gc.gridy = 3;
        add(panel4, gc);

        gc.gridx = 2;
        gc.gridy = 0;
        gc.gridheight = 5;
        add(panel5, gc);
        
        gc.gridx = 3;
        gc.gridy = 6;
        gc.insets = new Insets(0, 10, 0, 0);
        add(hjelp, gc);

        utskrift.setEditable(false);
    } //end of konstruktør MedisinGUI

    private void knappeGruppe()
    {
        ButtonGroup knappegruppe = new ButtonGroup();
        knappegruppe.add(a);
        knappegruppe.add(b);
        knappegruppe.add(c);
    }

    //Registrere ny medisin 
    public Medisin nyMedisin()
    {
        if (!regNavn.getText().equals(""))
        {
            Medisin ny = new Medisin(regNavn.getText(), regAtc.getText());
            SetMedisinGruppe(ny);
            medisinliste.settInn(ny);
            utskrift.setText("Medisin registrert:\n " + ny.toString());
            return ny;
        }
        return null;
    }

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
    // Lese objekt fra fil  - HUSK Å IMPORTER java.io.*;
    public void lesObjektFraFil()
    {
        try (ObjectInputStream innfil = new ObjectInputStream(
                new FileInputStream(medisinlisten)))
        {
            medisinliste = (Medisinliste) innfil.readObject();

        } catch (ClassNotFoundException cnfe)
        {
            JOptionPane.showMessageDialog(this, cnfe.getMessage());
            /* Må kanskje legge inn muligheten for å opprette ny liste
             om det ikke finnes en: liste = new Medisinliste();*/
        } catch (IOException ioe)
        {
            JOptionPane.showMessageDialog(this, "Feil ved lesing, "
                    + "ny liste blir opprettet");
            //Kan opprette ny tom liste her også. Som forslaget i kommentar over
        }
    }

     //Lagre objektet på fil - try med ressurser
    public void skrivObjektTilFil()
    {
        try (ObjectOutputStream utfil = new ObjectOutputStream(
                new FileOutputStream(medisinlisten)))
        {
            utfil.writeObject(medisinliste);
            utfil.close();
        } catch (NotSerializableException nse)
        {
            JOptionPane.showMessageDialog(this, "Objektet er ikke serialisert!");
        } catch (FileNotFoundException fnfe)
        {
            JOptionPane.showMessageDialog(this, "Finner ikke " + medisinlisten);
        } catch (IOException ioe)
        {
            System.out.println("Kan ikke skrive til fil!");
        }
    }

    public void visRegister()
    {
        utskrift.setText(medisinliste.toString());
    }

    public void tomFelter()
    {
        regNavn.setText("");
        regAtc.setText("");
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == regMedisinnavn)
        {
            nyMedisin();
            skrivObjektTilFil();
            tomFelter();
        }
        if (e.getSource() == visListe)
        {
            visRegister();
        }
        if(e.getSource() == hjelp)
        {
            JOptionPane.showMessageDialog(null, "HJELP Pille");
        }
    }

}//end of class MedisinGUI
