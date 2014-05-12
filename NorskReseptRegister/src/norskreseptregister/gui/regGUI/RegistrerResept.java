/*
 Filen inneholder klassen RegistrerResept.
 Laget av Henrik Fischer Bjelland, Haakon Winther
 Sist endret 11-05-2014 
 */
package norskreseptregister.gui.regGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.print.PrinterException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
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

// RegistrerResept er ment for å kunne registrere en resept som lagres i reseptRegisteret
public class RegistrerResept extends JPanel implements ActionListener
{
    private JButton regResept, visListe, velgPasient, velgLege, velgMedisin, hjelper, printUt;
    private JTextField datofelt, pasientfelt, legefelt, medisinfelt, mengdefelt;
    private JTextArea utskrift, anvisning;
    private JLabel datolabel, pasientdatalabel, legedatalabel, medisindatalabel, mengdelabel;
    private JScrollPane anvisningscroll, utskriftscroll;
    private JPanel datopanel, pasientpanel, legepanel, medisinpanel, mengdepanel, anvisningpanel, knappepanel, utskriftpanel;
    private RegisterSystem system;
    private Pasient pasient;
    private Lege lege;
    private Medisin medisin;
    private Medisinliste medisinliste;
    private Date dato;

    // "Hjelpefelt" for å lage resept for annen dato enn i dag
    private JTextField datoNummer;      // Dato 1-31
    private JTextField manedsNummer;    // Månedsnummer 1-12
    private JTextField aarNummer;       // År

    String placeholderpasient = "Trykk på knappen for å velge pasient";
    String placeholderlege = "Trykk på knappen for å velge lege";
    String placeholdermedisin = "Trykk på knappen for å velge medisin";

    public RegistrerResept(RegisterSystem system, Medisinliste medisinliste)
    {
        this.system = system;
        this.medisinliste = medisinliste;

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        dato = cal.getTime();
        DateFormat dateFormat = new SimpleDateFormat("EEEEEEE, d. MMM, yyyy");
        String text = dateFormat.format(cal.getTime());

        datofelt = new JTextField(20);
        datofelt.setText(text);
        datolabel = new JLabel("Dato    ");

        // Hjelpefelt for å sette dato
        datoNummer = new JTextField(2);
        datoNummer.setText(Integer.toString(dato.getDate()));
        manedsNummer = new JTextField(2);
        manedsNummer.setText(Integer.toString(dato.getMonth() + 1));
        aarNummer = new JTextField(3);
        aarNummer.setText(Integer.toString(dato.getYear() + 1900));

        pasientfelt = new JTextField(20);
        pasientfelt.setText(placeholderpasient);
        pasientdatalabel = new JLabel("Pasient");

        legefelt = new JTextField(20);
        legefelt.setText(placeholderlege);
        legedatalabel = new JLabel("Lege    ");

        medisinfelt = new JTextField(20);
        medisinfelt.setText(placeholdermedisin);
        medisindatalabel = new JLabel("Medisin");

        mengdefelt = new JTextField(20);
        mengdelabel = new JLabel("Mengde");

        pasientfelt.setEditable(false);
        legefelt.setEditable(false);
        medisinfelt.setEditable(false);

        regResept = new JButton("Registrer");
        regResept.setToolTipText("Trykk her for å registrere");
        regResept.addActionListener(this);
        regResept.addKeyListener(new Knappelytter());

        visListe = new JButton("Vis liste");
        visListe.addActionListener(this);

        printUt = new JButton("Skriv ut");
        printUt.addActionListener(this);
        printUt.setVisible(false);

        velgPasient = new JButton("...");
        velgPasient.addActionListener(this);
        velgPasient.setPreferredSize(new Dimension(20, 20));
        velgPasient.addKeyListener(new Knappelytter());

        velgLege = new JButton("...");
        velgLege.addActionListener(this);
        velgLege.setPreferredSize(new Dimension(20, 20));
        velgLege.addKeyListener(new Knappelytter());

        velgMedisin = new JButton("...");
        velgMedisin.addActionListener(this);
        velgMedisin.setPreferredSize(new Dimension(20, 20));
        velgMedisin.addKeyListener(new Knappelytter());

        hjelper = new JButton("?");
        hjelper.addActionListener(this);
        hjelper.setPreferredSize(new Dimension(25, 25));

        anvisning = new JTextArea(6, 25);
        anvisning.setLineWrap(true);
        anvisning.setWrapStyleWord(true);
        anvisning.setBorder(BorderFactory.createTitledBorder(null, "Anvisning", 1, 2, null, Color.black));

        utskrift = new JTextArea(25, 22);
        utskrift.setEditable(false);
        utskrift.setLineWrap(true);
        utskrift.setWrapStyleWord(true);

        utskriftscroll = new JScrollPane(utskrift);
        utskriftscroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        anvisningscroll = new JScrollPane(anvisning);

        datopanel = new JPanel();
        datopanel.add(datolabel);
        datopanel.add(datofelt);

        // Hjelpefelt for å sette dato
        datopanel.add(datoNummer);
        datopanel.add(manedsNummer);
        datopanel.add(aarNummer);

        pasientpanel = new JPanel();
        pasientpanel.add(pasientdatalabel);
        pasientpanel.add(pasientfelt);

        legepanel = new JPanel();
        legepanel.add(legedatalabel);
        legepanel.add(legefelt);

        medisinpanel = new JPanel();
        medisinpanel.add(medisindatalabel);
        medisinpanel.add(medisinfelt);

        mengdepanel = new JPanel();
        mengdepanel.add(mengdelabel);
        mengdepanel.add(mengdefelt);

        anvisningpanel = new JPanel();
        anvisningpanel.add(anvisningscroll);

        knappepanel = new JPanel();
        knappepanel.add(regResept);
        knappepanel.add(visListe);
        knappepanel.add(printUt);

        utskriftpanel = new JPanel();
        utskriftpanel.add(utskriftscroll);

        /* Her starter layouten for registrering av resept. Sjekk
         produktdokumentasjonen for forklaring av layouten*/
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        int x = 0;
        int y = 0;

        gc.gridx = x;
        gc.gridy = y;
        gc.insets = new Insets(0, 0, 10, 0);
        gc.fill = GridBagConstraints.HORIZONTAL;
        add(datopanel, gc);

        gc.gridx = x;
        gc.gridy = ++y;
        add(pasientpanel, gc);

        gc.gridx = x;
        gc.gridy = ++y;
        add(legepanel, gc);

        gc.gridx = x;
        gc.gridy = ++y;
        add(medisinpanel, gc);

        gc.gridx = x;
        gc.gridy = ++y;
        add(mengdepanel, gc);

        gc.gridx = x;
        gc.gridy = ++y;
        add(anvisningpanel, gc);

        gc.gridx = x;
        gc.gridy = ++y;
        add(knappepanel, gc);

        // SLUTT PÅ FØRSTE KOLONNE, KOLONNE 2 STARTER
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
        add(utskriftpanel, gc);

        //KOLLONNE 3 STARTER
        gc.gridx = 4;
        gc.gridy = 6;
        gc.fill = GridBagConstraints.NONE;
        add(hjelper, gc);
    }// end of Konstruktør

    // Metode for å sjekke om legen har bevilling til å skrive ut medisinen som er valgt. 
    private boolean sjekkLegeBevillingMotMedisin()
    {
        String medisinGruppe = medisin.getGruppe();
        String legeBevilling = lege.getBevilling();
        if (legeBevilling.contains(medisinGruppe))
        {
            return true;
        }
        utskrift.setText("Legen har ikke bevilling for medisingruppe: " + medisinGruppe);
        return false;
    }

    // Metode for å sjekke om alle felte er fylt ut.
    private boolean sjekkFelter()
    {
        if (pasientfelt.getText().equals(placeholderpasient)
                || legefelt.getText().equals(placeholderlege)
                || medisinfelt.getText().equals(placeholdermedisin)
                || mengdefelt.getText().equals("")
                || anvisning.getText().equals(""))
        {
            utskrift.setText("Her er det noe feil! \n\n\nHusk å fyll ut alle feltene og velg pasient/lege/medisin med knappene"
                    + "\n\n<---\n\n\n<---");
            return false;
        }
        else
        {
            return true;
        }
    }

    // Metode for å opprette en ny resept
    private void nyResept()
    {
        //Hjelpekode for å velge dato. Bare for registrering av resepter før levering av oppgaven
        try
        {
            int dag = Integer.parseInt(datoNummer.getText());
            int maned = Integer.parseInt(manedsNummer.getText()) - 1;
            int aar = Integer.parseInt(aarNummer.getText()) - 1900;
            int time = dato.getHours();
            int minutt = dato.getMinutes();
            dato = new Date(aar, maned, dag);
            dato.setHours(time);
            dato.setMinutes(minutt);
        }
        catch (NumberFormatException ex)
        {
            utskrift.setText("Feil datoformat");
            return;
        }
        Resept ny = new Resept(dato, pasient,
                lege, medisin, mengdefelt.getText(), "", anvisning.getText());
        system.getReseptRegister().SettInn(ny);
        utskrift.setText("Registrert resept: \n" + ny.toString());
    }

    // Metode for å tømme alle tekstfeltene og sette dagens dato i datofeltet
    private void TomFelt()
    {
        Calendar cal = Calendar.getInstance();
        String dateFormat = new SimpleDateFormat("EEEEEEE, d. MMM, yyyy").format(new Date());
        datofelt.setText(dateFormat);
        pasientfelt.setText("");
        legefelt.setText("");
        medisinfelt.setText("");
        mengdefelt.setText("");
        anvisning.setText("");
    }

    // Metode for å skrive ut alle reseptene i registeret
    private void SkrivUt()
    {
        String reseptliste = "";
        List<Resept> list = system.getReseptRegister().FinnAlleObjekter();
        for (Resept resept : list)
        {
            reseptliste += resept.toString();
            reseptliste += "\n-------------------------------\n";
        }
        utskrift.setText(reseptliste);
    }

    // Metode for å velge ut en pasient fra pasientregisteret
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

    // Metode for velge ut en lege fra legeregisteret
    private void VelgLege()
    {
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

    // Metode for å velge ut en medisin fra medisinlista
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
            utFyller();
        }
    }

    /*
     Metode som får opp bekreftboks for ny resept. Ved yes_Option vil en ny repept bli registrert.
     Når medisinen er bekreftet kommer det opp mulighet for å printe ut resepten.
     */
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
            //TomFelt(); 
            bekreft = 0;
            printUt.setVisible(true);
        }
    }

    //Metode som lytter på hvilke knapp som er trykket på
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == regResept)
        {
            if (sjekkFelter())
            {
                if (sjekkLegeBevillingMotMedisin())
                {
                    bekreft();
                }
            }
        }
        if (e.getSource() == visListe)
        {
            SkrivUt();
        }
        else if (e.getSource() == velgPasient)
        {
            VelgPasient();
        }
        else if (e.getSource() == velgLege)
        {
            VelgLege();
        }
        else if (e.getSource() == velgMedisin)
        {
            VelgMedisin();
        }
        else if (e.getSource() == hjelper)
        {
            JOptionPane.showMessageDialog(null, hjelpetekst());
        }
        else if (e.getSource() == printUt)
        {
            try
            {
                utskrift.print();
            }
            catch (PrinterException pex)
            {
                pex.printStackTrace();
            }
        }
    }// end of actionPerformed

    // Metoden returnerer en informativ tekst til brukeren
    private String hjelpetekst()
    {
        String hjelpeteksten = "For å kunne registrere en resept er det viktig at alle feltene er fylt ut."
                + "\nMan velger både pasient, lege og medisin ved å trykke på ... knappen til høyre for feltet"
                + "\nFor mere hjelp sjekk dokumentasjonen. /*LINK*/";
        return hjelpeteksten;
    }

    // Lytterklasse for å kunne innregigstrere pasienter med kun tastatur
    private class Knappelytter implements KeyListener
    {
        public void keyPressed(KeyEvent e)
        {
            if (e.getKeyCode() == KeyEvent.VK_1)
            {
                VelgPasient();
            }
            if (e.getKeyCode() == KeyEvent.VK_2)
            {
                VelgLege();
            }
            if (e.getKeyCode() == KeyEvent.VK_3)
            {
                VelgMedisin();
            }
            if (e.getKeyCode() == KeyEvent.VK_ENTER)
            {
                bekreft();
            }
        }

        @Override
        public void keyTyped(KeyEvent e)
        {

        }

        @Override
        public void keyReleased(KeyEvent e)
        {

        }
    }

    // Metode for å fylle ut mengdefelt og anvisnigsfelt med informasjon hentet fra felleskatalogen.
    private void utFyller()
    {
        switch (medisinfelt.getText())
        {
            case "Abstral":
                mengdefelt.setText("30 Tabletter");
                anvisning.setText("Maks. 4 doser pr. dag.");
                break;

            case "Apocillin":
                mengdefelt.setText("250mg");
                anvisning.setText("Kan tas 3 ganger i døgnet med dobbel dose om kvelden.");
                break;

            case "Cosylan":
                mengdefelt.setText("125ml");
                anvisning.setText("5-10 ml, Helst ufortynnet, 3-4 ganger daglig");
                break;

            case "Diclofenac":
                mengdefelt.setText("30 Tabletter");
                anvisning.setText("2-3 doser daglig.");
                break;

            case "Dolcontin":
                mengdefelt.setText("60mg");
                anvisning.setText("Dosering hver 12. time");
                break;

            case "Euthyrox":
                mengdefelt.setText("100 Tabletter");
                anvisning.setText("1 tablett daglig");
                break;

            case "Imovane":
                mengdefelt.setText("5mg");
                anvisning.setText("1 Dose skal inntes kort til før en skal gå til sengs.");
                break;

            case "Inegy":
                mengdefelt.setText("28stk Blister");
                anvisning.setText("10 mg/20 mg pr dag.");
                break;

            case "Ketalar":
                mengdefelt.setText("20ml hettegl.");
                anvisning.setText("Skal kun brukes av eller under ledelse av l"
                        + "ege som har erfaring med legemidlets egenskaper og bruk.");
                break;

            case "Metadon Abcur":
                mengdefelt.setText("20stk");
                anvisning.setText("Startdose 5 mg, 1-3 ganger/dag");
                break;

            case "Metoprolol":
                mengdefelt.setText("100stk");
                anvisning.setText(" Startdose 100 mg/døgn. ");
                break;

            case "Morfin-Skopolamin":
                mengdefelt.setText("A 10 × 1 ml (plastamp.)");
                anvisning.setText("Vanlig enkeltdose 1 ml.");
                break;

            case "Oxycodone Actavis":
                mengdefelt.setText("20mg");
                anvisning.setText("Tas med eller uten mat. "
                        + "Svelges hele med tilstrekkelig mengde væske. Ved sterke smerter. ");
                break;

            case "Palladon":
                mengdefelt.setText("28stk");
                anvisning.setText("1,3 mg eller 2,6 mg hver 4. time. Må ikke gies til barn!");
                break;

            case "Paracetamol":
                mengdefelt.setText("20 tabletter");
                anvisning.setText("2 piller ved store smerter. Vent 4 timer mellom ny dosering");
                break;

            case "Paralgin Forte":
                mengdefelt.setText("10 tabletter");
                anvisning.setText("1 pille taes ved store smerter. "
                        + "Ny pille kan taes etter 6 timer. Max 3 i døgnet.");
                break;

            case "Pedea":
                mengdefelt.setText("4 glass");
                anvisning.setText("3 injeksjoner gitt med 24 timers intervaller i sammarbeid med neonatolog");
                break;

            case "Penomax":
                mengdefelt.setText("20stk");
                anvisning.setText("Voksne og ungdom: 1-2 tabletter 3 ganger daglig.\n"
                        + "Barn >5 år: 1 tablett 3 ganger daglig.");
                break;

            case "Petidin":
                mengdefelt.setText("10stk");
                anvisning.setText("Taes rektalt opptil 6 ganger om døgnet ved ekstreme smerter. "
                        + "Må ikke kombineres med bilkjøring eller tunge maskiner");
                break;

            case "Rivotril":
                mengdefelt.setText("200stk");
                anvisning.setText("Taes som avtalt med legen");
                break;

            case "Tramadol":
                mengdefelt.setText("20stk");
                anvisning.setText("Tas med eller uten mat. Svelges hele med tilstrekkelig væske. "
                        + "Skal ikke deles/tygges.");
                break;

            case "Zopiclone":
                mengdefelt.setText("100stk");
                anvisning.setText("Forbigående og kortvarige søvnvansker. "
                        + "Som støtteterapi for en begrenset tid ved behandling av kroniske søvnvansker.");
                break;
        }// end of switch 
    } // end of utFyller
}// end of class RegistrerResept
