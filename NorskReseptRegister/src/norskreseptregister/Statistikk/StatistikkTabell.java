/*
 Klasse for tabell som brukes til grafisk fremstilling av medisinforbruket.

Laget av Peter Wilhelmsen
Sist endret 23/04/14
 */

package norskreseptregister.Statistikk;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class StatistikkTabell
{
    public static void main(String[] args)
    {
        JFrame vindu = new Statistikkramme();
        vindu.setVisible(true);
    }
}

class Statistikkramme extends JFrame
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
    
    
    public Statistikkramme()
    {
        setTitle("Statistikk");
        setSize(500,210);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //For å opprette tabellen
        JTable tabell = new JTable(celler, kolonnenavn);
        
        Container c = getContentPane();
        c.add( new JScrollPane(tabell), BorderLayout.CENTER );
    }
}
