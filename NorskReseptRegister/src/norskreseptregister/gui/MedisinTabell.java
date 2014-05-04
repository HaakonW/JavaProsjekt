/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package norskreseptregister.gui;

import javax.swing.table.AbstractTableModel;

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
        "Medisin", "Januar","Februar","Mars","April","Mai","Juni","Juli",
        "August","September","Oktober","November","Desember"
    };
    
    //For å få satt eget kolonnenavn
    public String getColumnName(int kolonne)
    {
        return kolonnenavn[ kolonne ];
    }
    
    //For å informere tabellmodellen om kolonnenes datatyper
    public Class getColumnClass(int kolonne)
    {
        
        return dataCeller[0][kolonne].getClass();
    }
    
    //
    public int getColumnCount()
    {
        return dataCeller[0].length;
    }
    
    //
    public int getRowCount()
    {
        return dataCeller.length;
    }
    
    //
    public Object getValueAt(int rad, int kolonne)
    {
        return dataCeller[rad][kolonne];
    }
    
    //
    public void SettInnMedisinDataForEnRad(int rad, Object[] radData)
    {
        dataCeller[rad] = radData;
    }
}//end of class MedisinTabell