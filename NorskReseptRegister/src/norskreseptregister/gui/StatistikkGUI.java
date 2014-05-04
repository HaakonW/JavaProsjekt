/*
 Filen inneholder klassen StatistikkGUI.
 Klassen har metoder for å velge en medisin og et årstall og deretter skrive ut 
 en tabell over medisinforbruket i løpet av det valgte året. 
 Laget av Peter Wilhelmsen, Henrik Fischer Bjelland
 Sist endret 03-05-14
 */

package norskreseptregister.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import norskreseptregister.ObjektKlasser.Medisin;
import norskreseptregister.ObjektKlasser.Medisinliste;
import norskreseptregister.ObjektKlasser.Resept;
import norskreseptregister.Reg.RegisterSystem;
import norskreseptregister.gui.info.FinnReseptForMedisin;
import norskreseptregister.gui.regGUI.VelgFraListeGUI;

public class StatistikkGUI extends JPanel implements ActionListener
{
    private JLabel velgAar;
    private final JTextField Aarfelt;
    private final JButton velgMedisin, visStatistikk,hjelp;
    private JPanel panel1, panel2, panel3, panel4;
    private JTextArea utskrift;
    private TabellFrame frame;
    private Medisinliste medisinliste;
    private RegisterSystem system;
    private ArrayList <Medisin> valgteMedisiner;
    
    StatistikkGUI(RegisterSystem system, Medisinliste medisinliste, MedisinTabell medisintabell)
    {
        this.system = system;
        this.medisinliste = medisinliste;
        
        Aarfelt = new JTextField(4);
        
        velgMedisin = new JButton("Velg Legemiddel");
        velgMedisin.addActionListener(this);
        
        visStatistikk = new JButton("Vis statistikk");
        visStatistikk.setPreferredSize(new Dimension(200, 40));
        visStatistikk.addActionListener(this);
        
        hjelp = new JButton("?");
        hjelp.addActionListener(this);        
        hjelp.setPreferredSize(new Dimension(20, 20));
        
        velgAar = new JLabel("Velg år");
        utskrift = new JTextArea(20,20);
        utskrift.setBorder(BorderFactory.createEtchedBorder(Color.LIGHT_GRAY, Color.black));
        
        panel1 = new JPanel();
        panel1.setBorder(BorderFactory.createEtchedBorder());
        panel1.add(velgMedisin);
        
        panel2 = new JPanel();
        panel2.setBorder(BorderFactory.createEtchedBorder());
        panel2.add(velgAar);
        panel2.add(Aarfelt);
        
        panel3 = new JPanel();
        panel3.add(visStatistikk);
        
        panel4 = new JPanel();
        panel4.add(utskrift);

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
        //add(panel4, gc);
        
        ///NY Kolonne
        y = 0;
        gc.gridx = ++x;
        gc.gridy = y;
        gc.gridheight = 5;
        add(panel4, gc);
        
        gc.gridx = 3;
        gc.gridy = 6;
        gc.insets = new Insets(0, 10, 0, 0);
        add(hjelp, gc); 
    }
    
    //Metode for å velge ut en medisin
    private void velgMedisin()
    {
        VelgFraListeGUI velgMedisin = new VelgFraListeGUI("Liste over alle medisiner:",
                "Velg medisin", medisinliste.getListModel());
        velgMedisin.setLocationRelativeTo(this);
        velgMedisin.setVisible(true);
        int [] valgteIndexer = velgMedisin.getValgteFraListe();
        if (velgMedisin.getValgtIndex() >= 0 && valgteIndexer.length > 0)
        {
            valgteMedisiner = new ArrayList();
            String medisinerSomErValgt = "Medisiner som er valgt: \n";
            for (int valgtIndex : valgteIndexer)
            {
                Medisin medisin = medisinliste.HentEttElement(valgtIndex);
                valgteMedisiner.add(medisin);
                medisinerSomErValgt += medisin.getNavn() + "\n";
            }
            utskrift.setText(medisinerSomErValgt);
        }
    }
    
    //
    public void visStatistikk()
    {
        if (valgteMedisiner != null)
        {
            if (Aarfelt.getText().matches("^[0-9]{4}$"))
            {
                String aarfelt = Aarfelt.getText();
                int aar = Integer.parseInt(aarfelt);
                MedisinTabell medisinTabell = new MedisinTabell(valgteMedisiner.size());
                int radIndex = 0;
                for (Medisin medisin : valgteMedisiner)
                {
                    Object [] radDataModell = finnStatistikkForMedisin(medisin, aar);
                    medisinTabell.SettInnMedisinDataForEnRad(radIndex, radDataModell);
                    radIndex++;
                }
                frame = new TabellFrame(medisinTabell);
            }
            else
            {
              utskrift.setText("Skriv inn et gyldig årstall.");  
            }
        }
        else
        {
            utskrift.setText("Du må velge medisiner før du kan skrive ut statistikk.");
        }
    }
    
    // dette er dummy-data for statistikk som kommer
    private Object[] finnStatistikkForMedisin(Medisin medisin, int aar)
    {
        Object[] resultat = new Object[13];
        resultat[0] = medisin.getNavn();
         
        for (int i = 1; i < 13; i++)
        {
            resultat[i] = 0;
        }
        FinnReseptForMedisin query = new FinnReseptForMedisin(medisin);
        ArrayList<Resept> valgteResepter = system.getReseptRegister().FinnObjekterSomMatcher(query);
        for (Resept resept : valgteResepter)
        {
            if (resept.getDato().getYear() == aar)
            {
                int maaned = resept.getDato().getMonth()+1;
                int gammelVerdi = (int)resultat[maaned];
                resultat[maaned] = gammelVerdi + 1;
            }
        }
        return resultat;
    }

    //Metode som lytter på hvilke knapp som er trykket og kaller på metoden knyttet til knappen.
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == velgMedisin)
        {
            velgMedisin();
        }
        else if (e.getSource() == visStatistikk)
        {
            visStatistikk();
        }
        else if(e.getSource() == hjelp)
        {
            JOptionPane.showMessageDialog(null, "HJELP Statistikk");
        }
    }
}//end of class Statistikk

// tips: http://mathbits.com/MathBits/Java/Graphics/bargraphonly.html