/*
 Tabelloppsett for å kunne bruke metoder for å legge til ønsket rad

Laget av Peter Wilhelmsen
29/04/14
 */

package norskreseptregister.Statistikk;

import javax.swing.table.DefaultTableModel;

public class DefaultTabell extends DefaultTableModel
{
    private String[] kolonnenavn =
    {
        "Medisin","Januar","Februar","Mars","April","Mai","Juni","Juli",
        "August","September","Oktober","November","Desember"   
    };
        
    private String[][] celler =
    {
        {"navn","1","2","3","4","5","6","7","8","9","10","11","12"},
        {"navn2","1","2","3","4","5","6","7","8","9","10","11","12"}
    };
        
    public String getColumnName(int kolonne)
    {
        return kolonnenavn[ kolonne];
    }
      
    public Class getColumnClass(int kolonne)
    {
        return celler[ 0][ kolonne].getClass();
    }
      
    public int getColumnCount()
    {
        return celler[0].length;
    }
      
    /*public int getRowCount()
    {
        return rader.length;
    }*/
      
    public Object getValueAt(int rad, int kolonne)
    {
        return celler[rad][kolonne];
    }
}
       
        
     
    


