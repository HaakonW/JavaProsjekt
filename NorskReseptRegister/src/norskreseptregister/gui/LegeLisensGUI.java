/*
Filen inneholder klassen LegeLisensGUI. Klassen er ment for å kunne velge en lege og endre lisensen
på denne legen.
Laget av  Haakon Winther, Henrik Fischer Bjelland
Sist endret 22-04-2014
 */
package norskreseptregister.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import norskreseptregister.ObjektKlasser.Lege;
import norskreseptregister.Reg.LegeRegister;
import norskreseptregister.Reg.RegisterSystem;
import norskreseptregister.gui.regGUI.RegistrerResept;
import norskreseptregister.gui.regGUI.VelgFraListeGUI;

public class LegeLisensGUI extends JPanel implements ActionListener
{
    private JLabel navnlabel, lisenslabel;
    private JTextField legedatafelt;
    private JButton velgLege, endreLisens, slettLege, hjelp;
    private JTextArea utskrift;
    private JCheckBox a, b, c;
    private JPanel panel1, panel2, panel3, panel4, panel6;
    private Lege lege;
    private final RegisterSystem system;

    public LegeLisensGUI(RegisterSystem system)
    {
        this.system = system;
        
        velgLege = new JButton("...");
        velgLege.addActionListener(this);
        velgLege.setToolTipText("Velg lege");
        velgLege.setPreferredSize(new Dimension(20, 20));
        
        slettLege = new JButton("Slett lege");
        slettLege.addActionListener(this);
        slettLege.setToolTipText("Slett lege");        
        
        endreLisens = new JButton("Endre bevilling");
        endreLisens.addActionListener(this);
        
        hjelp = new JButton("?");
        hjelp.addActionListener(this);
        hjelp.setPreferredSize(new Dimension(20, 20));
        hjelp.setToolTipText("Trenger du hjelp?" );
        
        navnlabel = new JLabel("Legens navn:");
        legedatafelt = new JTextField(20);
        legedatafelt.setText("Velg lege med knappen til høyre");
        legedatafelt.setEditable(false);
        
        lisenslabel = new JLabel("Godkjent lisens for:    ");
        a = new JCheckBox("A");
        b = new JCheckBox("B");
        c = new JCheckBox("C");        

        utskrift = new JTextArea(20, 20);
        utskrift.setEditable(false);
        utskrift.setBorder(BorderFactory.createEtchedBorder(Color.LIGHT_GRAY, Color.black));
        utskrift.setLineWrap(true);
        utskrift.setWrapStyleWord(true);
        
        ////PANEL START///
        panel1 = new JPanel();
        panel1.add(navnlabel);
        panel1.add(legedatafelt);
        panel1.add(velgLege);

        panel2 = new JPanel();
        panel2.setBorder(BorderFactory.createEtchedBorder());
        panel2.add(lisenslabel);
        panel2.add(a);
        panel2.add(b);
        panel2.add(c);        

        panel3 = new JPanel();
        panel3.setBorder(BorderFactory.createEtchedBorder());
        panel3.add(endreLisens);
        panel3.add(slettLege);

        panel4 = new JPanel();
        panel4.add(utskrift);

       /* Her starter layouten for registrer en person. Sjekk
        produktdokumentasjonen for forklaring av layouten*/
        GridBagConstraints gc = new GridBagConstraints();
        setLayout(new GridBagLayout());
        
        int x = 0;
        int y = 0;

        gc.gridx = x;
        gc.gridy = y;
        gc.insets = new Insets(10, 10, 10, 10);      
        add(panel1, gc);

        gc.gridx = x;
        gc.gridy = ++y;
        gc.fill = GridBagConstraints.HORIZONTAL;          
        add(panel2, gc);
        
        gc.gridx = x;
        gc.gridy = ++y;
        add(panel3, gc);
        
        //Nullstiller y for å kunne starte på toppen igjen
        y = 0;
        gc.gridx = ++x;
        gc.gridy = y;
        gc.gridheight = 6; // Viktig at den er 6 lang for å ikke ødelegge for andre elementer
        add(panel4, gc);
        
        //Siste rad for hjelpeboxen
        gc.gridx = ++x;
        gc.gridy = 6;
        add(hjelp, gc);

    }//end of konstruktør LegeLisensGUI
    
    //Denne metoden søker igjennom hele legeregisterer og viser et nytt vindu med alle legene der du kan velge en av disse.
    // Hvis valgtIndex er større en 0 har brukeren faktisk har gjort et valg
    public void VelgLege()
    {
        // #info: Gjort dialogen slik at den kan brukes til å velge mange forskjellige ting
        LegeRegister legeRegister = system.getLegeRegister();
        VelgFraListeGUI velgLege = new VelgFraListeGUI("Liste over alle leger:",
                "Velg lege", legeRegister.getListModel());
        velgLege.setLocationRelativeTo(this);
        velgLege.setVisible(true);
        int valgtIndex = velgLege.getValgtIndex();
        if (valgtIndex >= 0)
        {
            lege = legeRegister.HentEttObjekt(valgtIndex);
            legedatafelt.setText(lege.getNavn());
            setKnapperForBevilling();
        }
    }
    
    //Metode som getter bevillingen til en lege og setter denne i checkboksene avhenging av resultatet
    public void setKnapperForBevilling()
    {
        a.setSelected(lege.getBevillingA());
        b.setSelected(lege.getBevillingB());
        c.setSelected(lege.getBevillingC());
    }
    
    /*Metoden sjekker om noen av JCheckboxene er trykket på og endrer
    bevilligen til false hvis de ikke er huket av. Den skriver også ut informasjon i tekstfeltet 
    om hvilke endringer som har blitt gjort.
    */
    public void endreLisens()
    {
        lege.setBevillingA(a.isSelected());
        lege.setBevillingB(b.isSelected());
        lege.setBevillingC(c.isSelected());
        utskrift.setText("Bevilling er nå endret. \n" + 
        "Legen: " + lege.getNavn() + "\nHar nå bevilling i følgede reseptgrupper: \n"+ 
        lege.getBevilling());
    }
    
    //Metode for å slette en lege
    private void slettLege()
    {
        if ( lege != null)
        {
            if (system.getLegeRegister().SlettEttObjekt(lege))
            {
                utskrift.setText("Legen" + lege.getNavn() + 
                        "\n er nå slettet.");
            } 
        }
        else
        {
            utskrift.setText("Du må velge en lege først");
        }
    }
    //Metodene som lytter på knappene og utfører de forskjellige metodene i programmet.
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == velgLege)
        {
            VelgLege();
        }
        else if (e.getSource() == endreLisens) 
        {
            endreLisens();
        }
        else if(e.getSource() == hjelp)
        {
            JOptionPane.showMessageDialog(null, "I denne fanen  kan du endre en lege sin lisens."
                    + "\nDu velger lege med ... knappen og vil da med en gang se hva vedkommende"
                    + "\nhar godkjenning for. Videre kan du velge å ta fra lisens eller gi"
                    + "\ntilbake lisens. "
                    + "\nFor mere hjelp sjekk brukerveiledningen under om fanen.");

        }
        else if (e.getSource() == slettLege)
        {
            slettLege();
        }
    }
}//end of class LegeLisensGUI