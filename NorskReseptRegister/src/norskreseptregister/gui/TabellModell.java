/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package norskreseptregister.gui;

import javax.swing.table.AbstractTableModel;

public class TabellModell extends AbstractTableModel
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
