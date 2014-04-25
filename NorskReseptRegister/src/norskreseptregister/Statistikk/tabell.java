/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package norskreseptregister.Statistikk;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

public class tabell
{
    public static void main(String[] args)
    {
        JFrame tabell = new tabellFrame();
        tabell.setVisible(true);
    }
}

class Medisintabell extends AbstractTableModel
{
    private String[] kolonnenavn =
    {
        "Medisin", "Januar","Februar","Mars","April","Mai","Juni","Juli",
        "August","September","Oktober","November","Desember"
    };
    
    private Object[][] celler = 
    {
        {
            "Medisin 1", new Integer(10),new Integer(10),new Integer(10),
            new Integer(10),new Integer(10),new Integer(10),new Integer(10),
            new Integer(10),new Integer(10),new Integer(10),new Integer(10),
            new Integer(10)
        },
        {
            "Medisin 2", new Integer(10),new Integer(10),new Integer(10),
            new Integer(10),new Integer(10),new Integer(10),new Integer(10),
            new Integer(10),new Integer(10),new Integer(10),new Integer(10),
            new Integer(10)
        },
        {
            "Medisin 3", new Integer(10),new Integer(10),new Integer(10),
            new Integer(10),new Integer(10),new Integer(10),new Integer(10),
            new Integer(10),new Integer(10),new Integer(10),new Integer(10),
            new Integer(10)
        },
        {
            "Medisin 4", new Integer(10),new Integer(10),new Integer(10),
            new Integer(10),new Integer(10),new Integer(10),new Integer(10),
            new Integer(10),new Integer(10),new Integer(10),new Integer(10),
            new Integer(10)  
        },
        {
            "Medisin 5", new Integer(10),new Integer(10),new Integer(10),
            new Integer(10),new Integer(10),new Integer(10),new Integer(10),
            new Integer(10),new Integer(10),new Integer(10),new Integer(10),
            new Integer(10)
        },
        {
            "Medisin 6", new Integer(10),new Integer(10),new Integer(10),
            new Integer(10),new Integer(10),new Integer(10),new Integer(10),
            new Integer(10),new Integer(10),new Integer(10),new Integer(10),
            new Integer(10)  
        },
        {
            "Medisin 7", new Integer(10),new Integer(10),new Integer(10),
            new Integer(10),new Integer(10),new Integer(10),new Integer(10),
            new Integer(10),new Integer(10),new Integer(10),new Integer(10),
            new Integer(10)
        },
        {
            "Medisin 8", new Integer(10),new Integer(10),new Integer(10),
            new Integer(10),new Integer(10),new Integer(10),new Integer(10),
            new Integer(10),new Integer(10),new Integer(10),new Integer(10),
            new Integer(10)
        },
        {
            "Medisin 9", new Integer(10),new Integer(10),new Integer(10),
            new Integer(10),new Integer(10),new Integer(10),new Integer(10),
            new Integer(10),new Integer(10),new Integer(10),new Integer(10),
            new Integer(10)
        },
        {
            "Medisin 10", new Integer(10),new Integer(10),new Integer(10),
            new Integer(10),new Integer(10),new Integer(10),new Integer(10),
            new Integer(10),new Integer(10),new Integer(10),new Integer(10),
            new Integer(10)
        }
    };
    
    //For å få satt eget kolonnenavn
    public String getColumnName(int kolonne)
    {
        return kolonnenavn[ kolonne ];
    }
    
    //For å informere tabellmodellen om kolonnenes datatyper
    public Class getColumnClass(int kolonne)
    {
        
        return celler[0][kolonne].getClass();
    }
    
    public int getColumnCount()
    {
        return celler[0].length;
    }
    
    public int getRowCount()
    {
        return celler.length;
    }
    
    public Object getValueAt(int rad, int kolonne)
    {
        return celler[rad][kolonne];
    }
}

// Legger tabellen inn i en frame
class tabellFrame extends JFrame
{
    private Radalterneringstabell tabellet;
    
    public tabellFrame()
    {
        setTitle("Statistikktabell");
        setSize(900,210);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Medisintabell tab = new Medisintabell();
        tabellet = new Radalterneringstabell(tab);
        
        JMenuBar menylinje = new JMenuBar();
        JMenu meny1 = new JMenu("Valg");
        JMenuItem valg1 = new JMenuItem("Print tabell");
        valg1.addActionListener(new printeLytter());
        
        menylinje.add(meny1);
        meny1.add(valg1);
        setJMenuBar(menylinje);
        
        Container c = getContentPane();
        c.add(new JScrollPane(tabellet), BorderLayout.CENTER);
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
                        new MessageFormat("side{0,number}"));*/
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




