/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package norskreseptregister.Statistikk;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

public class TestTabell2 extends JFrame
{
    private DefaultTableModel modell;
    private JTable tabell;
    private JFrame ramme;
    private JScrollPane tabellscroll;
    private JMenuBar menylinje;
    private JMenu valg;
    private JMenuItem leggTil,print;
    
    public TestTabell2()
    {
        /*String[] kolonne = 
        {
            "Medisin","Januar","Februar","Mars"
        };
        
        Object[][] rader =
        {
            {"Navn1","tall","tall","tall"},
            {"Navn2","tall","tall","tall"}
        };*/
        
        modell = new DefaultTableModel();
        modell.addColumn("Medisin");
        modell.addColumn("Januar");
        modell.addColumn("Februar");
        modell.addColumn("Mars");
        
        //Test for rad
        /*String[] forste = {"Paracet","12","32","22"};
        modell.addRow(forste);*/
        
        //tabell = new JTable(modell);
        tabell = new tabellFarger(modell);
        tabellscroll = new JScrollPane(tabell);
        
        menylinje = new JMenuBar();
        valg = new JMenu("Valg");
        leggTil = new JMenuItem("Legg til rad");
        print = new JMenuItem("Print tabell");
        
        menylinje.add(valg);
        valg.add(leggTil);
        valg.add(print);
        setJMenuBar(menylinje);
        
        leggTil.addActionListener(new menylytter());
        print.addActionListener( new printelytter());
        
        ramme = new JFrame();
        ramme.setJMenuBar(menylinje);
        ramme.add(tabellscroll, BorderLayout.CENTER);
        ramme.setSize(500,300);
        ramme.setVisible(true);
        
    }//Konstruktør slutt
    
    
    // Lytter for printeknapp i menyen
    class printelytter implements ActionListener
    {
        public void actionPerformed (ActionEvent e)
        {
            try 
            {
                tabell.print(JTable.PrintMode.NORMAL);
            } 
            catch (PrinterException pex)
            {
               pex.printStackTrace(); 
            }
            
        }
    }
    
    //Lytter til menyen, for å legge til rad.
    class menylytter implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String [] rad = {"Medisin1","123","33","43"};
            modell.addRow(rad); 
        }
    }
    
    
    //Tabell med linjefarger og "klikkfarge"
    class tabellFarger extends JTable
    {
        private boolean printerUt = false;
        
        public tabellFarger(TableModel modell)
        {
            super(modell);
        }
        
        public void print(Graphics g)
        {
            printerUt = true;
            try
            {
                super.print(g);
            }
            finally
            {
                printerUt = false;
            }
        }
        
        public Component prepareRenderer(
        TableCellRenderer rendrer, int rad, int kolonne)
        {
           Component c = super.prepareRenderer(rendrer,rad,kolonne); 
           
           if(printerUt)
           {
               c.setBackground(getBackground());
           }
           else if( rad %2 == 0 && !isCellSelected(rad,kolonne))
           {
               c.setBackground(Color.GREEN);
           }
           else if(isCellSelected(rad,kolonne))
           {
               c.setBackground(Color.ORANGE);
           }
           else
           {
               c.setBackground(getBackground());
           }
           return c;
        }
    }
   
    // Mainmetode for å teste tabellen.
    public static void main(String[] args)
    {
        new TestTabell2();
    }
}
