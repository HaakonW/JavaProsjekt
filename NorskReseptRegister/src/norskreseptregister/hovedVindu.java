/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package norskreseptregister;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import norskreseptregister.gui.AdminMain;

/**
 *
 * @author PeterWilhelmsen
 */
public class hovedVindu extends JFrame
{
   private JDesktopPane hovedvindu;
   
   //Konstruktør
   public hovedVindu()
   {
      JMenuBar menylinje = new JMenuBar();
      JMenu addmeny = new JMenu("legg til");
      JMenuItem lagInternVindu = new JMenuItem("Registrere medisin");
      
      lagInternVindu.addActionListener(new Menylytter());
      addmeny.add(lagInternVindu);
      
      menylinje.add(addmeny);
      setJMenuBar(menylinje);
      
      
      //Opprette hovedvinduet
      hovedvindu = new JDesktopPane();
      getContentPane().add(hovedvindu, BorderLayout.CENTER);
      
      setSize(1300,400);
      setVisible(true);
       
   }// End of Konstruktør
   
   
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
