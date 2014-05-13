/*
 Filen inneholder klassen hovedVindu2.
 Laget av Peter Wilhelmsen, Henrik Fischer Bjelland, Haakon Winther
 Sist endret 29/04/14
 */

package norskreseptregister;

import java.awt.Component;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import norskreseptregister.ObjektKlasser.Medisinliste;
import norskreseptregister.Reg.RegisterSystem;
import norskreseptregister.gui.info.InfoMainGUI;
import norskreseptregister.gui.regGUI.RegMainGUI;

// Klassen inneholder hovedvinduet som er det første du kommer til ved å kjøre programmet.
public class hovedVindu2 extends JFrame implements ActionListener
{  
    private JLabel label1, label2, label3,tekstLabel;
    private JButton adminVindu, registreringVindu, infoVindu;
    private RegisterSystem system;
    private Medisinliste medisinliste;
    private JMenuBar menylinje;
    private JMenu valg,hjelp;
    private JMenuItem lagreValg, adminValg,regValg, infoValg, avsluttValg, omValg,brukerValg;
    
    public hovedVindu2(final RegisterSystem system, final Medisinliste medisinliste)
    {  
        this.system = system;
        this.medisinliste = medisinliste;
        ImageIcon admin = new ImageIcon("src/norskreseptregister/gui/bilder/Admin.png");
        ImageIcon register = new ImageIcon("src/norskreseptregister/gui/bilder/register.png");
        ImageIcon info = new ImageIcon("src/norskreseptregister/gui/bilder/info.png");
        
        adminVindu = new JButton(admin);
        registreringVindu = new JButton(register);
        infoVindu = new JButton(info);
        
        adminVindu.addActionListener(this);
        registreringVindu.addActionListener(this);
        infoVindu.addActionListener(this);
        
        tekstLabel = new JLabel("Velkommen til Norsk Reseptregister");
        tekstLabel.setFont(new Font ("PT Serif", Font.PLAIN, 17));
        
        label1 = new JLabel("Admin");
        label1.setFont(new Font ("PT Serif", Font.PLAIN, 20));
        
        label2 = new JLabel("Registrering");
        label2.setFont(new Font ("PT Serif", Font.PLAIN, 20));
        
        label3 = new JLabel("Informasjon");
        label3.setFont(new Font ("PT Serif", Font.PLAIN, 20));
        
        adminVindu.setFocusPainted(false);
        registreringVindu.setFocusPainted(false);
        infoVindu.setFocusPainted(false);
        
        adminVindu.setToolTipText("Gå til Admin");
        registreringVindu.setToolTipText("Gå til Registrering");
        infoVindu.setToolTipText("Gå til info"); 
        
        GridBagConstraints gc = new GridBagConstraints();
        setLayout(new GridBagLayout());      
       
        gc.gridx = 0;
        gc.gridy = 1; 
        gc.insets = new Insets(10,10,10,10);
        add(adminVindu, gc);
        
        gc.gridx = 1;
        gc.gridy = 1;
        add(registreringVindu, gc);
        
        gc.gridx = 2;
        gc.gridy = 1;
        add(infoVindu, gc);
        
        gc.gridx = 0;
        gc.gridy = 2;
        add(label1, gc);
        
        gc.gridx = 1;
        gc.gridy = 2;
        add(label2, gc);
        
        gc.gridx = 2;
        gc.gridy = 2;
        add(label3, gc);
        
        gc.gridx = 0;
        gc.gridy = 3;
        gc.fill = 3;
        gc.gridwidth= GridBagConstraints.VERTICAL;
        add(tekstLabel, gc);
        
        menylinje = new JMenuBar();
        setJMenuBar(menylinje);
        
        valg = new JMenu("Valg");
        valg.setMnemonic('V');
        hjelp = new JMenu("Hjelp");
        hjelp.setMnemonic('H');
        menylinje.add(valg);
        menylinje.add(hjelp);
        
        /*valg.setMnemonic(KeyEvent.VK_E);
        valg.getAccessibleContext().setAccessibleDescription(
        "The only menu in this program that has menu items");*/
        
        //Menyalternativer
        
        lagreValg = new JMenuItem("Lagre");
        lagreValg.setAccelerator(KeyStroke.getKeyStroke(
        KeyEvent.VK_L,ActionEvent.ALT_MASK));
        lagreValg.addActionListener(this);
        
        adminValg = new JMenuItem("Admin");
        adminValg.setAccelerator(KeyStroke.getKeyStroke(
        KeyEvent.VK_A,ActionEvent.ALT_MASK));
        adminValg.addActionListener(this);
        
        regValg = new JMenuItem("Registrering");
        regValg.setAccelerator(KeyStroke.getKeyStroke(
        KeyEvent.VK_R,ActionEvent.ALT_MASK));
        regValg.addActionListener(this);
        
        infoValg = new JMenuItem("Informasjon");
        infoValg.setAccelerator(KeyStroke.getKeyStroke(
        KeyEvent.VK_I,ActionEvent.ALT_MASK));
        infoValg.addActionListener(this);
        
        avsluttValg = new JMenuItem("Avslutt");
        avsluttValg.setAccelerator(KeyStroke.getKeyStroke(
        KeyEvent.VK_Q,ActionEvent.ALT_MASK));
        avsluttValg.addActionListener(this);
        
        omValg = new JMenuItem("Om");
        omValg.setAccelerator(KeyStroke.getKeyStroke(
        KeyEvent.VK_O, ActionEvent.ALT_MASK));
        omValg.addActionListener(this);
        
        brukerValg = new JMenuItem("Brukerveiledning");
        brukerValg.setAccelerator(KeyStroke.getKeyStroke(
        KeyEvent.VK_B,ActionEvent.ALT_MASK));
        brukerValg.addActionListener(this);
        
        valg.add(lagreValg);
        valg.add(adminValg);
        valg.add(regValg);
        valg.add(infoValg);
        valg.add(avsluttValg);
        
        hjelp.add(omValg);
        hjelp.add(brukerValg);
        
        setSize(740, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        //Dette er nå unødvendig siden addShutdownHook() gjør det samme
        
//        addWindowListener(new WindowAdapter()
//        {
//            public void windowClosing(WindowEvent winEvt)
//            {
//                skrivTilFil();
//            }
//        });
        
        Thread t = new Thread() {
            public void run() {
                skrivTilFil();
            }
        };
        Runtime.getRuntime().addShutdownHook(t);
    }
    
    //
    private void skrivTilFil()
    {
        system.SkrivTilFil();
        medisinliste.SkrivTilFil();
    }
    
    //Metode for å et av et vindu av valgt component ( registreringsvindu eller infovindu)
    private void visGUI(Component component) throws HeadlessException
    {
        JFrame frame = new JFrame();
        frame.getContentPane().add(component);
        frame.pack();
        frame.setSize(740, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    //Metode for å lytte på hvilke knapp som er trykket og oppretter deretter et vindu av valgt type.
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == adminVindu || e.getSource() == adminValg)
        {
            LoggInn ny = new LoggInn(system, medisinliste);
        }
        else if (e.getSource() == registreringVindu || e.getSource() == regValg)
        {
            RegMainGUI reg = new RegMainGUI(system, medisinliste);
            visGUI(reg);
        }
        else if (e.getSource() == infoVindu || e.getSource() == infoValg)
        {
            InfoMainGUI infoG = new InfoMainGUI(system, medisinliste);
            visGUI(infoG);
        }
        else if (e.getSource() == brukerValg)
        {
            if (Desktop.isDesktopSupported())
            {
                try
                {
                    File myFile = new File("src/kravspesifikasjon.pdf");
                    Desktop.getDesktop().open(myFile);
                } 
                catch (IOException ex)
                {
                    JOptionPane.showMessageDialog(null, "Systemet ditt støtter ikke visning av pdf-filer.");
                }
            }
        }
        else if (e.getSource() == avsluttValg)
        {
            System.exit(0);
        }
        else if (e.getSource()== omValg)
        {
            OmVindu om = new OmVindu();
        }
        else if (e.getSource() == lagreValg)
        {
            skrivTilFil();
        }
    }
}