/*
 Inneholder klasse for å kjøre hovedvindu, med MainGUI.
 Laget av Peter Wilhelmsen, Henrik Fischer Bjelland
 Sist endret 17/04/14
 */
package norskreseptregister;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import norskreseptregister.Reg.RegisterSystem;
import norskreseptregister.gui.AdminMain;
import norskreseptregister.gui.InfoMainGUI;
import norskreseptregister.gui.regGUI.RegMainGUI;

public class hovedVindu extends JFrame
{

    private JDesktopPane hovedvindu;
    private Menylytter lytter;

    private JMenuBar menylinje;
    private JMenu addmeny;
    private JMenu addmeny2;
    private JMenu addmeny3;
    private JMenu addmeny4;

    private JMenuItem submeny1;
    private JMenuItem submeny2;
    private JMenuItem submeny3;
    private RegisterSystem system;

    //Konstruktør
    public hovedVindu(final RegisterSystem system)
    {
        lytter = new Menylytter();

        menylinje = new JMenuBar();
        addmeny = new JMenu("Admin");
        addmeny2 = new JMenu("Registrere");
        addmeny3 = new JMenu("Informasjon");
        addmeny4 = new JMenu("Statistikk");
        submeny1 = new JMenuItem("Gå inn");
        submeny2 = new JMenuItem("Åpne vinduet");
        submeny3 = new JMenuItem("Klikk videre");

        menylinje.add(addmeny);
        menylinje.add(addmeny2);
        menylinje.add(addmeny3);
        menylinje.add(addmeny4);

        addmeny.add(submeny1);
        addmeny2.add(submeny2);
        addmeny3.add(submeny3);

        submeny1.addActionListener(lytter);
        submeny2.addActionListener(lytter);
        submeny3.addActionListener(lytter);

        //Setter inn menylinjen i vinduet.
        setJMenuBar(menylinje);

        //Opprette hovedvinduet
        hovedvindu = new JDesktopPane();
        getContentPane().add(hovedvindu, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent winEvt)
            {
                system.SkrivTilFil();
            }
        });

     ////////////////////////////////////////////////////////////////////////
      /* EKSEMPEL PÅ INTERNALFRAME
      
         JInternalFrame ramme = new JInternalFrame("Internramme");
         ramme.setSize(300,200);
         ramme.setVisible(true);
         hovedvindu.add(ramme);*/
        ////////////////////////////////////////////////////////////////////////
        hovedvindu.setBackground(Color.GRAY); //Sette bakgrunnsfarge på hovedvindu
        setSize(1300, 700);
        setVisible(true);
        this.system = system;

    }// End of Konstruktør

    //Skal lytte på trykk i menylinjen.
    private class Menylytter implements ActionListener
    {

        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == submeny1)
            {
                JInternalFrame internvindu = new JInternalFrame(
                        "Admin", true, true, true, true);

                //plassere et panel i det nye interne vinduet
                //Container intern = internvindu.getContentPane();
                AdminMain ny = new AdminMain();
                internvindu.add(ny, BorderLayout.CENTER);

                internvindu.setDefaultCloseOperation(
                        JInternalFrame.DISPOSE_ON_CLOSE);

                internvindu.pack();

                hovedvindu.add(internvindu);
                internvindu.setVisible(true);

            }
            if (e.getSource() == submeny2)
            {
                JInternalFrame internvindu2 = new JInternalFrame(
                        "Registrering", true, true, true, true);

                RegMainGUI regG = new RegMainGUI(system);
                //Container c = internvindu.getContentPane();
                internvindu2.add(regG, BorderLayout.CENTER);

                internvindu2.setDefaultCloseOperation(
                        JInternalFrame.DISPOSE_ON_CLOSE);

                internvindu2.pack();

                hovedvindu.add(internvindu2);
                internvindu2.setVisible(true);

            }
            if (e.getSource() == submeny3)
            {
                JInternalFrame internvindu3 = new JInternalFrame(
                        "Informasjon", true, true, true, true);

                InfoMainGUI infoG = new InfoMainGUI();
                internvindu3.add(infoG, BorderLayout.CENTER);

                internvindu3.setDefaultCloseOperation(
                        JInternalFrame.DISPOSE_ON_CLOSE);

                internvindu3.pack();
                internvindu3.setSize(700, 300);

                hovedvindu.add(internvindu3);
                internvindu3.setVisible(true);
            }
        }//end of method actionPerformed
    } //end of Menylytter

}//end of class hovedVindu