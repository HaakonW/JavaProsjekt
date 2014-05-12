/*
 Filen inneholder klassen MedisinTabell.
 Laget av Peter Wilhelmsen
 Sist endret 11-05-14
 */
package norskreseptregister.gui;

import javax.swing.table.AbstractTableModel;

// 
public class MedisinTabell extends AbstractTableModel
{
    private final int antallRader;
    private Object[][] dataCeller;

    public MedisinTabell(int antallRader)
    {
        this.antallRader = antallRader;
        dataCeller = new Object[antallRader][];
    }

    private String[] kolonnenavn =
    {
        "Medisin", "Januar", "Februar", "Mars", "April", "Mai", "Juni", "Juli",
        "August", "September", "Oktober", "November", "Desember"
    };

    // For å få satt eget kolonnenavn
    public String getColumnName(int kolonne)
    {
        return kolonnenavn[ kolonne];
    }

    // Informere tabellmodellen om kolonnenes datatyper
    public Class getColumnClass(int kolonne)
    {
        return dataCeller[0][kolonne].getClass();
    }

    // Informere tabellmodellen om kolonnenes datatyper
    public int getColumnCount()
    {
        return dataCeller[0].length;
    }

    // returnerer antall kolonner
    public int getRowCount()
    {
        return dataCeller.length;
    }

    // Returnerer en datatype
    public Object getValueAt(int rad, int kolonne)
    {
        return dataCeller[rad][kolonne];
    }

    // Setter inn medisindata for en rad
    public void SettInnMedisinDataForEnRad(int rad, Object[] radData)
    {
        dataCeller[rad] = radData;
    }
}//end of class MedisinTabell
