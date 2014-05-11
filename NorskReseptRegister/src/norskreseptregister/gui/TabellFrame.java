/*
 Filen inneholder klassen TabellFrame.
 Laget av Peter Wilhelmsen, Henrik Fischer Bjelland
 Sist endret 11-05-14
 */
package norskreseptregister.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

/* 
Klassen har metoder for ...
*/
public class TabellFrame extends JPanel
{
    public Radalterneringstabell tabellet;
    private final MedisinTabell medisinTabell;
    private JMenuBar menylinje;
    private JMenu valg;
    private JMenuItem printUt;
    
    public TabellFrame(MedisinTabell medisinTabell)
    {
        this.medisinTabell = medisinTabell;
        
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        tabellet = new Radalterneringstabell(medisinTabell);
        
        //add(new JScrollPane(tabellet), BorderLayout.CENTER);
        JFrame frame = new JFrame("Statistikk for valgte medisiner");
        JScrollPane tableContainer = new JScrollPane(tabellet);
        
        menylinje = new JMenuBar();
        valg = new JMenu("Valg");
        printUt = new JMenuItem("Print tabell");
        printUt.addActionListener( new printeLytter());
        menylinje.add(valg);
        valg.add(printUt);
        
        frame.setJMenuBar(menylinje);
        panel.add(tableContainer, BorderLayout.CENTER);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setSize(1025,419); 
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    // Metode For å printe tabellen
    public class printeLytter implements ActionListener
    {
        public void actionPerformed( ActionEvent e)
        {
            try
            {
                tabellet.print(JTable.PrintMode.NORMAL);
            }
            catch(PrinterException pep)
            {
                pep.printStackTrace();
            }
        }
    }
} // end of class TabellFrame

// Setter farge på annenhver rad i tabellen
class Radalterneringstabell extends JTable
{
    private boolean printUt = false;
    
    public Radalterneringstabell(TableModel tab)
    {
        super(tab);
        getColumnModel().getColumn(0).setPreferredWidth(110);
        getColumnModel().getColumn(1).setPreferredWidth(70);
        getColumnModel().getColumn(2).setPreferredWidth(70);
        getColumnModel().getColumn(3).setPreferredWidth(70);
        getColumnModel().getColumn(4).setPreferredWidth(70);
        getColumnModel().getColumn(6).setPreferredWidth(70);
        getColumnModel().getColumn(7).setPreferredWidth(70);
        getColumnModel().getColumn(8).setPreferredWidth(70);
        getColumnModel().getColumn(9).setPreferredWidth(70);
        getColumnModel().getColumn(10).setPreferredWidth(70);
        getColumnModel().getColumn(11).setPreferredWidth(70);
        getColumnModel().getColumn(12).setPreferredWidth(70);
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
} // end of class Radalterneringstabell