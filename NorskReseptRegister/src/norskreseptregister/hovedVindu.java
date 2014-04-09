/*
 Inneholder klasse for å kjøre hovedvindu, med MainGUI.

Laget av Peter Wilhelmsen
Sist endret 08/04/14
 */

package norskreseptregister;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import norskreseptregister.gui.AdminMain;


public class hovedVindu extends JFrame
{
   private JDesktopPane hovedvindu;

   //Konstruktør
   public hovedVindu()
   {
       
       
      JMenuBar menylinje = new JMenuBar();
      JMenu addmeny = new JMenu("Start");
      JMenu addmeny2 = new JMenu("Neste");
      JMenu addmeny3 = new JMenu("Tredje");
      
      
      JMenuItem AdminGUI = new JMenuItem("Registrere medisin");
      AdminGUI.addActionListener(new Menylytter());
      addmeny.add(AdminGUI);

      menylinje.add(addmeny);
      menylinje.add(addmeny2);
      menylinje.add(addmeny3);
      setJMenuBar(menylinje);
           
      //Opprette hovedvinduet
      hovedvindu = new JDesktopPane();
      getContentPane().add(hovedvindu,BorderLayout.CENTER);
     
     ////////////////////////////////////////////////////////////////////////
      /* EKSEMPEL PÅ INTERNALFRAME
      
      JInternalFrame ramme = new JInternalFrame("Internramme");
      ramme.setSize(300,200);
      ramme.setVisible(true);
      hovedvindu.add(ramme);*/
      ////////////////////////////////////////////////////////////////////////
      

      hovedvindu.setBackground(Color.BLUE); //Sette bakgrunnsfarge på hovedvindu
      setSize(1300,600);
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
      }
   }
   
   
   public static void main(String[] args)
   {
       hovedVindu ny = new hovedVindu();
   }
}
