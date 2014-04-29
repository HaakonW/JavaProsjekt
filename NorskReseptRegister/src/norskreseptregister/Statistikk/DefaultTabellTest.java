/*
 For å testkjøre tabell
 */

package norskreseptregister.Statistikk;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DefaultTabellTest extends JFrame
{
    private DefaultTabell modell;
    private JTable tabell;
    private JScrollPane tabellscroll;
    private JFrame ramme;
    
    public DefaultTabellTest()
    {
        modell = new DefaultTabell();
        tabell = new JTable();
        tabell.setModel(modell);
        tabellscroll = new JScrollPane(tabell);
        
        ramme = new JFrame();
        ramme.add(tabellscroll,BorderLayout.CENTER);
        ramme.setSize(500,300);
        ramme.setVisible(true);
    }
    
    public static void main(String [] args)
    {
        new DefaultTabellTest();
    }
}
