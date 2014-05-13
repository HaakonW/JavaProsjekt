/*
 Filen inneholder klassen LoggInn.
 Laget av Henrik Fischer Bjelland
 Sist endret 11-05-2014 
 */
package norskreseptregister;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
import norskreseptregister.ObjektKlasser.Medisinliste;
import norskreseptregister.Reg.RegisterSystem;
import norskreseptregister.gui.AdminMain;
import java.awt.Desktop;
import java.awt.Dimension;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/* 
 LoggInn er et JFrame vindu som dukker opp hvis du trykker på adminknappen.
 Klassen har som hensikt å gi tilgang til adimnvinduet, kun for autoriserte brukere.
 */
public class LoggInn extends JFrame
{
    private JButton loggInn;
    private JPanel panel;
    private JLabel overskriftlabel, brukernavnlabel, passordlabel, feilmeldinglabel;
    private JTextField brukerfelt;
    private JPasswordField passordfelt;
    private final RegisterSystem system;
    private final Medisinliste medisinliste;

    public LoggInn(RegisterSystem system, Medisinliste medisinliste)
    {
        super("Login vindu");
        this.system = system;
        this.medisinliste = medisinliste;

        loggInn = new JButton("Logg inn");
        loggInn.setBounds(93, 120, 145, 20);
        //loggInn.setPreferredSize(new Dimension(40, 20));

        brukerfelt = new JTextField(15);
        brukerfelt.setBounds(90, 50, 150, 20);

        passordfelt = new JPasswordField(15);
        passordfelt.addKeyListener(new Knappelytter());
        passordfelt.setBounds(90, 85, 150, 20);

        overskriftlabel = new JLabel("Denne siden er kun for helsedirektoratet.");
        overskriftlabel.setBounds(20, 10, 300, 30);

        brukernavnlabel = new JLabel("Brukernavn:");
        brukernavnlabel.setBounds(10, 50, 100, 20);

        passordlabel = new JLabel("Passord:");
        passordlabel.setBounds(10, 85, 100, 20);

        feilmeldinglabel = new JLabel("Feil brukernavn eller passord. Prøv igjen!");
        feilmeldinglabel.setForeground(Color.red);
        feilmeldinglabel.setBounds(23, 150, 300, 20);
        feilmeldinglabel.setVisible(false);

        panel = new JPanel();
        panel.setLayout(null);
        panel.add(overskriftlabel);
        panel.add(brukernavnlabel);
        panel.add(passordlabel);
        panel.add(brukerfelt);
        panel.add(passordfelt);
        panel.add(loggInn);
        panel.add(feilmeldinglabel);

        getContentPane().add(panel);
        setSize(300, 200);
        setLocation(500, 280);
        setLocationRelativeTo(null);
        setVisible(true);
        settOppLytter();
    }

    // Setter opp lyttermetoden
    private void settOppLytter()
    {
        loggInn.addActionListener(new ActionListener()
        {
            // Lyttemetode som kaller på loggInn da bruker har trykket på Logginn knappen
            public void actionPerformed(ActionEvent ae)
            {
                loggInn();
            }
        });
    }

    // Metode for logge inn, hvis brukernavn og passord er korrekt åpnes adminvinduet.
    private void loggInn()
    {
        String brukernavn = brukerfelt.getText();
        String passord = passordfelt.getText();
        if (brukernavn.equals("admin") && passord.equals("admin"))
        {
            AdminMain ny = new AdminMain(system, medisinliste);
            JFrame frame = new JFrame();
            frame.getContentPane().add(new AdminMain(system, medisinliste));
            frame.pack();
            frame.setSize(740, 460);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            dispose();
        }
        // EasterEgg
        else if (brukernavn.equals("kaveh") && passord.equals("medisin"))
        {
            Desktop d = Desktop.getDesktop();
            try
            {
                URI uri = new URI("https://www.youtube.com/watch?v=1SwcQDjLzJU");
                d.browse(uri);
            }
            catch (URISyntaxException ex)
            {
                feilmeldinglabel.setVisible(true);;
            }
            catch (IOException ex)
            {
                feilmeldinglabel.setVisible(true);
            }
            brukerfelt.setText("");
            passordfelt.setText("");
        }
        else
        {
            feilmeldinglabel.setVisible(true); //Dette er feilmeldingen
            brukerfelt.setText("");
            passordfelt.setText("");
            brukerfelt.requestFocus();
        }
    }

    // Metode som lytter på om ENTER-tasten er trykket på 
    private class Knappelytter implements KeyListener
    {
        public void keyPressed(KeyEvent e)
        {
            if (e.getKeyCode() == KeyEvent.VK_ENTER)
            {
                loggInn();
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
}//end of class LoggInn
