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
import javax.swing.JFrame;
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
        
        Container c = getContentPane();
        c.add(new JScrollPane(tabellet), BorderLayout.CENTER);
    }   
}

// Setter farge på annenhver rad i tabellen
class Radalterneringstabell extends JTable
{
    public Radalterneringstabell(TableModel tab)
    {
        super(tab);
    }
    
    public Component prepareRenderer(
        TableCellRenderer rendrer, int rad, int kolonne)
    {
        Component c = super.prepareRenderer(rendrer, rad, kolonne);
        
        if( rad % 2 == 0 && !isCellSelected(rad,kolonne))
        {
            c.setBackground(getBackground());
        }
        else
        {
            c.setBackground(Color.CYAN);
        }
        return c;
    }
}


