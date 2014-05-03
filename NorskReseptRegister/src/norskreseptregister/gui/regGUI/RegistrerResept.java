/*
 Filen inneholder klassen RegistrerResept.
 Laget av Henrik Fischer Bjelland, Haakon Winther
 Sist endret 09-04-2014 
 */
package norskreseptregister.gui.regGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import norskreseptregister.ObjektKlasser.Lege;
import norskreseptregister.ObjektKlasser.Medisin;
import norskreseptregister.ObjektKlasser.Medisinliste;
import norskreseptregister.ObjektKlasser.Pasient;
import norskreseptregister.ObjektKlasser.Resept;
import norskreseptregister.Reg.LegeRegister;
import norskreseptregister.Reg.PasientRegister;
import norskreseptregister.Reg.RegisterSystem;

public class RegistrerResept extends JPanel implements ActionListener
{
    
    private JButton regResept, visListe, velgPasient, velgLege, velgMedisin, hjelper;
    private JTextField datofelt, pasientfelt, legefelt, medisinfelt, mengdefelt, kategorifelt;
    private JTextArea utskrift, anvisning;
    private JLabel datolabel, pasientdatalabel, legedatalabel, medisindatalabel, mengdelabel, kategorilabel;
    private JScrollPane anvisningscroll, utskriftscroll;
    private JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8;
    private RegisterSystem system;
    private Pasient pasient;
    private Lege lege;
    private Medisin medisin;
    private Medisinliste medisinliste;
    private Date dato;

    public RegistrerResept(RegisterSystem system, Medisinliste medisinliste)
    {
        Calendar cal = Calendar.getInstance();
        //int style = DateFormat.MEDIUM;
        //DateFormat df;
        //df = DateFormat.getDateInstance(style, Locale.ENGLISH);
        String dateFormat = new SimpleDateFormat("dd/MM/yyyy/ HH:mm").format(new Date());
        //SimpleDateFormat sf = new SimpleDateFormat( "dd.MM.yy", norge );
        this.system = system;
        this.medisinliste = medisinliste;
        this.dato = dato;
        
        dato = cal.getTime();
        
        datofelt = new JTextField(20);
        datofelt.setText(dateFormat);
        datolabel = new JLabel("Dato    ");

        pasientfelt = new JTextField(20);
        pasientdatalabel = new JLabel("Pasient");

        legefelt = new JTextField(20);
        legedatalabel = new JLabel("Lege    ");

        medisinfelt = new JTextField(20);
        medisindatalabel = new JLabel("Medisin");

        mengdefelt = new JTextField(20);
        mengdelabel = new JLabel("Mengde");

        kategorilabel = new JLabel("Kategori");
        pasientfelt.setEditable(false);
        legefelt.setEditable(false);
        medisinfelt.setEditable(false);

        regResept = new JButton("Registrer");
        regResept.setToolTipText("Trykk her for å registrere");
        regResept.addActionListener(this);

        visListe = new JButton("Vis liste");
        visListe.addActionListener(this);

        velgPasient = new JButton("...");
        velgPasient.addActionListener(this);
        velgPasient.setPreferredSize(new Dimension(20, 20));

        velgLege = new JButton("...");
        velgLege.addActionListener(this);
        velgLege.setPreferredSize(new Dimension(20, 20));

        velgMedisin = new JButton("...");
        velgMedisin.addActionListener(this);
        velgMedisin.setPreferredSize(new Dimension(20, 20));

        hjelper = new JButton("?");
        hjelper.addActionListener(this);
        hjelper.setPreferredSize(new Dimension(25, 25));

        anvisning = new JTextArea(6, 25);
        anvisning.setLineWrap(true);
        anvisning.setWrapStyleWord(true);
        anvisning.setBorder(BorderFactory.createTitledBorder(null, "Anvisning", 1, 2, null, Color.black));
        utskrift = new JTextArea(25, 22);
        utskrift.setEditable(false);
        utskriftscroll = new JScrollPane(utskrift);
        utskriftscroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        anvisningscroll = new JScrollPane(anvisning);

        panel1 = new JPanel();
        panel1.add(datolabel);
        panel1.add(datofelt);

        panel2 = new JPanel();
        panel2.add(pasientdatalabel);
        panel2.add(pasientfelt);

        panel3 = new JPanel();
        panel3.add(legedatalabel);
        panel3.add(legefelt);

        panel4 = new JPanel();
        panel4.add(medisindatalabel);
        panel4.add(medisinfelt);

        panel5 = new JPanel();
        panel5.add(mengdelabel);
        panel5.add(mengdefelt);

        panel6 = new JPanel();
        panel6.add(anvisningscroll);

        panel7 = new JPanel();
        panel7.add(regResept);
        panel7.add(visListe);

        panel8 = new JPanel();
        panel8.add(utskriftscroll);

        //////// START GRID ///////////
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        int x = 0;
        int y = 0;

        gc.gridx = x;
        gc.gridy = y;
        gc.insets = new Insets(0, 0, 10, 0);
        gc.fill = GridBagConstraints.HORIZONTAL;
        add(panel1, gc);
        
        gc.gridx = x;
        gc.gridy = ++y;
        add(panel2, gc);       

        gc.gridx = x;
        gc.gridy = ++y;
        add(panel3, gc);       

        gc.gridx = x;
        gc.gridy = ++y;
        add(panel4, gc);
       
        gc.gridx = x;
        gc.gridy = ++y;
        add(panel5, gc);       

        gc.gridx = x;
        gc.gridy = ++y;
        add(panel6, gc);       

        gc.gridx = x;
        gc.gridy = ++y;
        add(panel7, gc);

        // SLUTT PÅ FØRSTE KOLONNE, KOLONNE 2 STARTER//
        x = 0;
        y = 0;

        gc.gridx = ++x;
        gc.gridy = ++y;
        gc.insets = new Insets(0, 0, 10, 10);
        gc.fill = GridBagConstraints.NONE;
        add(velgPasient, gc);

        gc.gridx = x;
        gc.gridy = ++y;
        add(velgLege, gc);

        gc.gridx = x;
        gc.gridy = ++y;
        add(velgMedisin, gc);

        gc.gridx = 3;
        gc.gridy = 0;
        gc.gridheight = 7;
        gc.fill = GridBagConstraints.VERTICAL;
        add(panel8, gc);

        //KOLLONNE 3 STARTER//
        gc.gridx = 4;
        gc.gridy = 6;
        gc.fill = GridBagConstraints.NONE;
        add(hjelper, gc);
    }//end of Konstruktør

    //Metode for å opprette en ny resept
    private void nyResept()
    {
        Resept ny = new Resept(dato, pasient,
                lege, medisin, mengdefelt.getText(), "", anvisning.getText());
        system.getReseptRegister().SettInn(ny);
        utskrift.setText("Registrert resept: \n" + ny.toString());
    }

    //Metode for å tømme alle tekstfeltene
    private void TomFelt()
    {
        Calendar cal = Calendar.getInstance();
        String dateFormat = new SimpleDateFormat("dd/MM/yyyy/ HH:mm").format(new Date());
        datofelt.setText(dateFormat);
        pasientfelt.setText("");
        legefelt.setText("");
        medisinfelt.setText("");
        mengdefelt.setText("");
        anvisning.setText("");
        //kategorifelt.setText("");
    }

    //Metode for å skrive ut alle legene i registeret
    private void SkrivUt()
    {
        String pasientliste = "";
        List<Resept> list = system.getReseptRegister().FinnAlleObjekter();
        for (Resept resept : list)
        {
            pasientliste += resept.toString();
            pasientliste += "\n------------------------\n";
        }
        utskrift.setText(pasientliste);
    }

    //Metode for å velge ut en pasient
    private void VelgPasient()
    {
        PasientRegister pasientRegister = system.getPasientRegister();
        VelgFraListeGUI velgPasient = new VelgFraListeGUI("Liste over alle pasienter:", 
                "Velg pasient", pasientRegister.getListModel());
        velgPasient.setLocationRelativeTo(this);
        velgPasient.setVisible(true);
        int valgtIndex = velgPasient.getValgtIndex();
        if (valgtIndex >= 0)    // Dvs at brukeren faktisk har gjort et valg
        {
            pasient = pasientRegister.HentEttObjekt(valgtIndex);
            pasientfelt.setText(pasient.getNavn());
        }
    }

    //Metode for velge ut en lege
    public void VelgLege()
    {
        // #info: Gjort dialogen slik at den kan brukes til å velge mange forskjellige ting
        LegeRegister legeRegister = system.getLegeRegister();
        VelgFraListeGUI velgLege = new VelgFraListeGUI("Liste over alle leger:", 
                "Velg lege", legeRegister.getListModel());
        velgLege.setLocationRelativeTo(this);
        velgLege.setVisible(true);
        int valgtIndex = velgLege.getValgtIndex();
        if (valgtIndex >= 0)    // Dvs at brukeren faktisk har gjort et valg
        {
            lege = legeRegister.HentEttObjekt(valgtIndex);
            legefelt.setText(lege.getNavn());
        }
    }

    //Metode for å velge ut en medisin
    private void VelgMedisin()
    {
        VelgFraListeGUI velgMedisin = new VelgFraListeGUI("Liste over alle medisiner:",
                "Velg medisin", medisinliste.getListModel());
        velgMedisin.setLocationRelativeTo(this);
        velgMedisin.setVisible(true);
        int valgtIndex = velgMedisin.getValgtIndex();
        if (valgtIndex >= 0)    // Dvs at brukeren faktisk har gjort et valg
        {
            medisin = medisinliste.HentEttElement(valgtIndex);
            medisinfelt.setText(medisin.getNavn());
        }
    }

    //Metode som får opp bekreftboks for ny resept. Ved yes_Option vil en ny repept bli registrert.
    private void bekreft()
    {
        int bekreft = JOptionPane.showConfirmDialog(null, "Du vil registrere denne resepten: "
                + "\nPasient: " + pasient.getNavn()
                + "\nLege: " + lege.getNavn()
                + "\nLegemiddel: " + medisin.getNavn()
                + "\nMengde: " + mengdefelt.getText()
                + "\nAnvisning: " + anvisning.getText(), "Bekreft Resept", JOptionPane.YES_NO_OPTION);
        if (bekreft == JOptionPane.YES_OPTION)
        {
            nyResept();
            TomFelt();
            bekreft = 0;
        }
    }

    //Metode som lytter på hvilke knapp som er trykket på
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == regResept)
        {
            bekreft();
        }
        if (e.getSource() == visListe)
        {
            SkrivUt();
        }
        if (e.getSource() == velgPasient)
        {
            VelgPasient();
        }
        if (e.getSource() == velgLege)
        {
            VelgLege();
        }
        if (e.getSource() == velgMedisin)
        {
            VelgMedisin();
        }
        if (e.getSource() == hjelper)
        {
            JOptionPane.showMessageDialog(null, hjelpetekst());
        }

    }//end of actionPerformed

    //Metoden returnerer en informativ tekst til brukeren
    public String hjelpetekst()
    {
        String hjelpeteksten = "For å kunne registrere en resept er det viktig at alle feltene er fylles ut."
                + "\nMan velger både pasient, lege og medisin ved å trykke på ... knappen til høyre for feltet"
                + "\nFor mere hjelp sjekk dokumentasjonen. /*LINK*/";
        return hjelpeteksten;
    }
}//end of class RegistrerResept