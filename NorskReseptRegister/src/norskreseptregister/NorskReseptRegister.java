/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package norskreseptregister;
import java.awt.event.*;
import javax.swing.*;
import norskreseptregister.gui.MainGui;
import norskreseptregister.gui.RegMainGUI;
import norskreseptregister.gui.RegistrerLege;
/**
 *
 * @author Bandet
 */
public class NorskReseptRegister 
{
    public static void main(String[] args) {
        // TODO code application logic here
        //GuiBeta tab = new GuiBeta();
        //legeGUI vindu = new legeGUI();
        
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                MainGui vindu = new MainGui();
                //RegisterSystem system = new RegisterSystem();
                //RegMainGUI hjem = new RegMainGUI(system);
                //RegistrerLege vindu = new RegistrerLege(system);
                //hjem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //hjem.setVisible(true);
            }
        });
        
    }
   
}

 /*EventQueue.invokeLater(new Runnable()
    {
        public void run()
        {
        GuiBeta tab = new GuiBeta();
        tab.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tab.setVisible(true);
        }
    });*/
    
