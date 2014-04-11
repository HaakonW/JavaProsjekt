/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package norskreseptregister;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JInternalFrame;
import norskreseptregister.gui.AdminMain;

/**
 *
 * @author PeterWilhelmsen
 */
public class hovedVinduKall
{
    public hovedVinduKall()
    {
    /*JInternalFrame internvindu = new JInternalFrame(
            "Admin",true,true,true,true);*/
        JInternalFrame internvindu = new JInternalFrame("Admin",true,true,true,true);
     
          
             //plassere et panel i det nye interne vinduet
            Container intern = internvindu.getContentPane();
            AdminMain ny = new AdminMain();
            intern.add(ny, BorderLayout.CENTER);
          
            internvindu.setDefaultCloseOperation(
            JInternalFrame.DISPOSE_ON_CLOSE);
      
            internvindu.pack();
            
            //hovedvindu.add(internvindu);
            internvindu.setVisible(true);
    }   
}


