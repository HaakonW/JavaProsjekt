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
import norskreseptregister.gui.regGUI.VelgPersonGUI;

public class LegeLisensGUI extends JPanel implements ActionListener
{
    private JLabel fornavnlabel, etternavnlabel;
    private JTextField legedatafelt;
    private JButton velgLege, endreLisens, hjelp;
    private JTextArea utskrift;
    private JCheckBox a, b, c;
    private JPanel panel1, panel2, panel3, panel4, panel6;
    private Lege lege;
    private final RegisterSystem system;

    public LegeLisensGUI(RegisterSystem system)
    {
        this.system = system;
        velgLege = new JButton("...");
        velgLege.setPreferredSize(new Dimension(20, 20));
        endreLisens = new JButton("Endre bevilling");
        hjelp = new JButton("?");
        hjelp.setPreferredSize(new Dimension(20, 20));
        
        fornavnlabel = new JLabel("Fornavn:");
        etternavnlabel = new JLabel("Etternavn:");

        legedatafelt = new JTextField(20);
        utskrift = new JTextArea(20, 20);

        utskrift.setBorder(BorderFactory.createEtchedBorder(Color.LIGHT_GRAY, Color.black));
        a = new JCheckBox("A");
        b = new JCheckBox("B");
        c = new JCheckBox("C");

        velgLege.addActionListener(this);
        endreLisens.addActionListener(this);
        hjelp.addActionListener(this);

        velgLege.setToolTipText("Velg lege");

        ////PANEL START///
        panel1 = new JPanel();
        panel1.add(fornavnlabel);
        panel1.add(legedatafelt);
        panel1.add(velgLege);

        panel3 = new JPanel();

        panel4 = new JPanel();
        panel4.add(a);
        panel4.add(b);
        panel4.add(c);
        panel4.add(endreLisens);

        panel6 = new JPanel();
        panel6.add(utskrift);

        /// GRID START ///
        GridBagConstraints gc = new GridBagConstraints();
        setLayout(new GridBagLayout());

        gc.gridx = 0;
        gc.gridy = 0;
        gc.insets = new Insets(10, 10, 10, 10);
        gc.anchor = GridBagConstraints.WEST;
        gc.fill = GridBagConstraints.HORIZONTAL;
        add(panel1, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        gc.fill = 0;
        gc.anchor = GridBagConstraints.EAST;
        add(panel3, gc);

        gc.gridx = 0;
        gc.gridy = 3;
        add(panel4, gc);

        gc.gridx = 3;
        gc.gridy = 6;
        add(hjelp, gc);

        gc.gridx = 2;
        gc.gridy = 0;
        gc.gridheight = 6;
        add(panel6, gc);

        utskrift.setEditable(false);
    }//end of konstruktør LegeLisensGUI
    
    //Denne metoden søker igjennom hele legeregisterer og viser et nytt vindu med alle legene der du kan velge en av disse.
    public void VelgLege()
    {
        // #info: Gjort dialogen slik at den kan brukes til å velge mange forskjellige ting
        LegeRegister legeRegister = system.getLegeRegister();
        DefaultListModel model = new DefaultListModel();
        for (Lege l : legeRegister.FinnAlleObjekter())
        {
            model.addElement(l.toString());
        }

        VelgPersonGUI velgLege = new VelgPersonGUI(model);
        velgLege.setLocationRelativeTo(this);
        velgLege.setVisible(true);
        int valgtIndex = velgLege.getValgtIndex();
        if (valgtIndex >= 0)    // Dvs at brukeren faktisk har gjort et valg
        {
            lege = legeRegister.HentEttObjekt(valgtIndex);
            legedatafelt.setText(lege.getNavn());
        }
    }
    /*Metoden sjekker om noen av JCheckboxene er trykket på og endrer
    da bevilligen til false. Den skriver også ut informasjon i tekstfeltet 
    om hvilke endringer som har blitt gjort.
    */
    public void endreLisens()
    {
        if (a.isSelected())
        {
            lege.setBevillingA(false);
        }
        else if (b.isSelected())
        {
            lege.setBevillingB(false);
        }
        else if (c.isSelected())
        {
            lege.setBevillingC(false);
        }
        utskrift.setText("Bevilling er nå endret. \n" + 
        "Legen: " + lege.getNavn() + "\nHar nå bevilling i følgede reseptgrupper: \n"+ 
        lege.getBevilling());
    }
    //Metodene som lytter på knappene og utfører de forskjellige metodene i programmet.
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == velgLege)
        {
            VelgLege();
        }
        if (e.getSource() == endreLisens)
        {
            endreLisens();
        }
        if(e.getSource() == hjelp)
        {
            JOptionPane.showMessageDialog(null, "HJELP LISENS");
        }
    }
}//end of class LegeLisensGUI
