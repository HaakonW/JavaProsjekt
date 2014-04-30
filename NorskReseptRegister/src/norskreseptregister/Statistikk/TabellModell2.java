/*
 Filen inneholder modellen for tabellen vi skal bruke for å fremstille
deler av statistikken vår.

Laget av Peter Wilhelmsen
Sist endret 30/04/14
 */

package norskreseptregister.Statistikk;

import javax.swing.table.DefaultTableModel;

public class TabellModell2 extends DefaultTableModel
{
    private DefaultTableModel modell;
    //private String[] kolonne;
    
    public TabellModell2()
    {
        modell = new DefaultTableModel();
        modell.addColumn("Medisin");
        modell.addColumn("Januar");
        modell.addColumn("Februar");
        modell.addColumn("Mars");
        modell.addColumn("April");
        modell.addColumn("Mai");
        modell.addColumn("Juni");
        modell.addColumn("Juli");
        modell.addColumn("August");
        modell.addColumn("September");
        modell.addColumn("Oktober");
        modell.addColumn("November");
        modell.addColumn("Desember");
        
        /*String[] kolonne =
        {
            "Medisin","Januar","Februar","Mars","April","Mai","Juni","Juli",
        "August","September","Oktober","November","Desember"
        };*/
   
    }
}
