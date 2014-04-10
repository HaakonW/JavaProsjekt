/*
Filen inneholder klassen NorskReseptRegister som er mainklassen der alle 
vinduene våre blir kalt opp.
Laget av Haakon Winter, Henrik Fischer Bjelland, Peter Wilhelmsen.
Sist endret 10-04-2014 
 */

package norskreseptregister;

import java.awt.event.*;
import javax.swing.*;
import norskreseptregister.gui.MainGui;
import norskreseptregister.gui.regGUI.RegMainGUI;

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
    
