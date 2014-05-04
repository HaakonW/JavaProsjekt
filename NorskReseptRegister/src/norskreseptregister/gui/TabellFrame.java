/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package norskreseptregister.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

// Legger tabellen inn i en frame
public class TabellFrame extends JPanel
{
    public Radalterneringstabell tabellet;
    private final MedisinTabell medisinTabell;
    
    public TabellFrame(MedisinTabell medisinTabell)
    {
        this.medisinTabell = medisinTabell;
        
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        tabellet = new Radalterneringstabell(medisinTabell);
        
        //add(new JScrollPane(tabellet), BorderLayout.CENTER);
        JFrame frame = new JFrame("Statistikk for medisiner");
        JScrollPane tableContainer = new JScrollPane(tabellet);

        panel.add(tableContainer, BorderLayout.CENTER);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(1100,300);
        frame.setVisible(true);
    }
    
    //For å printe
    class printeLytter implements ActionListener
    {
        public void actionPerformed( ActionEvent e)
        {
            try
            {
                /*tabellet.print(JTable.PrintMode.NORMAL,
                        new MessageFormat("Medisinstatistikk"),
                        new MessageFormat("side{0,number}"));
                Dinne kan sette topptekst og bunntekst tror e*/
                tabellet.print(JTable.PrintMode.NORMAL);
            }
            catch(PrinterException pep)
            {
                pep.printStackTrace();
            }
        }
    }
}

// Setter farge på annenhver rad i tabellen
class Radalterneringstabell extends JTable
{
    private boolean printUt = false;
    
    public Radalterneringstabell(TableModel tab)
    {
        super(tab);
    }
    
    //
    public void print(Graphics g)
    {
        printUt = true;
        try
        {
            super.print(g);
        }
        finally
        {
            printUt = false;
        }
    }
    
    //
    public Component prepareRenderer(
        TableCellRenderer rendrer, int rad, int kolonne)
    {
        Component c = super.prepareRenderer(rendrer, rad, kolonne);
        
        if(printUt)
        {
            c.setBackground(getBackground());
        }
        else if( rad % 2 == 0 && !isCellSelected(rad,kolonne))
        {
            c.setBackground(Color.LIGHT_GRAY);
        }
        else if( isCellSelected(rad,kolonne)) //gir farge når kolonne klikkes
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