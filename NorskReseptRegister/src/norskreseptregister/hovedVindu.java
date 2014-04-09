/*
 Inneholder klasse for å kjøre hovedvindu, med MainGUI.

Laget av Peter Wilhelmsen
Sist endret 08/04/14
 */

package norskreseptregister;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import norskreseptregister.gui.AdminMain;
import norskreseptregister.gui.MainGui;
import norskreseptregister.gui.hovedVinduGUI;


public class hovedVindu extends JFrame
{
   private JDesktopPane hovedvindu;
   private hovedVinduGUI maingui;
   
   //Hentet fra MAINGUI
   private JButton info;
   private JButton registrer;
   private JButton admin;
   private JButton rad, rad1, rad2, rad3, rad4, rad5, rad6, rad7, rad8, rad9, rad10, rad11, rad12, rad13, rad14;
   private JButton k, k1, k2, k3, k4, k5, k6, k7, k8, k9, k10, k11, k12, k13, k14;
   private JLabel header;
   /////////////////////////////////////////////////////////////////////////////
   
   //Konstruktør
   public hovedVindu()
   {
       
       
      JMenuBar menylinje = new JMenuBar();
      JMenu addmeny = new JMenu("Start");
      
      JMenuItem AdminGUI = new JMenuItem("Registrere medisin");
      AdminGUI.addActionListener(new Menylytter());
      addmeny.add(AdminGUI);
      
      JMenuItem RegMainGUI = new JMenuItem("Registere pasient/lege");
      RegMainGUI.addActionListener(new Menylytter());
      addmeny.add(RegMainGUI);

      menylinje.add(addmeny);
      setJMenuBar(menylinje);
           
      //Opprette hovedvinduet
      hovedvindu = new JDesktopPane();
      getContentPane().add(hovedvindu); // , BorderLayout.CENTER
     
     ////////////////////////////////////////////////////////////////////////
      /* EKSEMPEL PÅ INTERNALFRAME
      
      JInternalFrame ramme = new JInternalFrame("Internramme");
      ramme.setSize(300,200);
      ramme.setVisible(true);
      hovedvindu.add(ramme);*/
      ////////////////////////////////////////////////////////////////////////
      
      
     
        
      
      hovedvindu.setBackground(Color.RED); //Sette bakgrunnsfarge på hovedvindu
      setSize(1300,400);
      setVisible(true);
       
   }// End of Konstruktør
   
   
   //Skal lytte på trykk i menylinjen.
   private class Menylytter implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
          JInternalFrame internvindu = new JInternalFrame(
          "Intern vindu",true,true,true,true);
          
          //plassere et panel i det nye interne vinduet
          Container intern = internvindu.getContentPane();
          AdminMain ny = new AdminMain();
          intern.add(ny, BorderLayout.CENTER);
          
          internvindu.setDefaultCloseOperation(
          JInternalFrame.DISPOSE_ON_CLOSE);
      
          internvindu.pack();
          
          hovedvindu.add(internvindu);
          internvindu.setVisible(true);
          
          
          //RegMainGUI nyReg = new RegMainGUI();
      }
   }
   
   
   public static void main(String[] args)
   {
       hovedVindu ny = new hovedVindu();
   }
}
