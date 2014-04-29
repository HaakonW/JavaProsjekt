/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package norskreseptregister.Statistikk;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TestTabell2 extends JFrame
{
    private DefaultTableModel modell;
    private JTable tabell;
    private JFrame ramme;
    private JScrollPane tabellscroll;
    private JMenuBar menylinje;
    private JMenu valg;
    private JMenuItem leggTil; 
    
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
        
        tabell = new JTable(modell);
        tabellscroll = new JScrollPane(tabell);
        
        menylinje = new JMenuBar();
        valg = new JMenu("Valg");
        leggTil = new JMenuItem("Legg til rad");
        menylinje.add(valg);
        valg.add(leggTil);
        setJMenuBar(menylinje);
        
        leggTil.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String [] rad = {"Medisin1","123","33","43"};
                modell.addRow(rad);
            }
        });
        
        ramme = new JFrame();
        ramme.setJMenuBar(menylinje);
        ramme.add(tabellscroll, BorderLayout.CENTER);
        ramme.setSize(500,300);
        ramme.setVisible(true);
        
    }
    
   
    public static void main(String[] args)
    {
        new TestTabell2();
    }
}
