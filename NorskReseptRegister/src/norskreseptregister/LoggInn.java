/*
 Filen inneholder klassen LoggInn.
 Klassen har en funksjon for å kunne logge seg inn Adminsiden
 Laget av Henrik Fischer Bjelland
 Sist endret 29-04-2014 
 */
package norskreseptregister;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.*;
import norskreseptregister.ObjektKlasser.Medisinliste;
import norskreseptregister.Reg.RegisterSystem;
import norskreseptregister.gui.AdminMain;

public class LoggInn extends JFrame
{
    private JButton loggInn;
    private JPanel panel1;
    private JLabel label1, label2, label3;
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
        panel1 = new JPanel();
        brukerfelt = new JTextField(15);
        passordfelt = new JPasswordField(15);
        label1 = new JLabel("Denne siden er kun for helsedirektoratet.");
        label2 = new JLabel("Brukernavn:");
        label3 = new JLabel("Passord:");
        setSize(300, 200);
        setLocation(500, 280);
        panel1.setLayout(null);

        label1.setBounds(20, 10, 300, 30);
        label2.setBounds(10, 50, 100, 20);
        label3.setBounds(10, 85, 100, 20);
        brukerfelt.setBounds(90, 50, 150, 20);
        passordfelt.setBounds(90, 85, 150, 20);
        loggInn.setBounds(130, 120, 80, 20);

        panel1.add(label1);
        panel1.add(label2);
        panel1.add(label3);
        panel1.add(brukerfelt);
        panel1.add(passordfelt);
        panel1.add(loggInn);

        getContentPane().add(panel1);
        setVisible(true);
        actionlogin();
    }

    //metode for logge inn, hvis if setningen blir true lages det et nytt Admin vindu.
    private void actionlogin()
    {
        loggInn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                String brukernavn = brukerfelt.getText();
                String passord = passordfelt.getText();
                if (brukernavn.equals("admin") && passord.equals("admin"))
                {
                    AdminMain ny = new AdminMain(system, medisinliste);
                    JFrame frame = new JFrame();
                    frame.getContentPane().add(new AdminMain(system, medisinliste));
                    frame.pack();
                    frame.setSize(740, 520);
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                    dispose();
                } 
                else
                {
                    JOptionPane.showMessageDialog(null, "Wrong Password / Username");
                    brukerfelt.setText("");
                    passordfelt.setText("");
                    brukerfelt.requestFocus();
                }

            }
        });
    }
    
    //prøvde å få til å kunne trykke enter men det funker ikke
    class Knappelytter implements KeyListener
    {
      public void keyPressed(KeyEvent e){
          if(e.getKeyCode()== KeyEvent.VK_ENTER){
                AdminMain ny = new AdminMain(system, medisinliste);
                JFrame frame = new JFrame();
                frame.getContentPane().add(new AdminMain(system, medisinliste));
                frame.pack();
                frame.setSize(740, 520);
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
                dispose();
          };
      };

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
