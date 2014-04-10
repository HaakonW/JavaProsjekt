/*
 * Filen inneholder Respetklassen
 * Laget av Haakon * 
 * Sist endret 31. Mars * 
 */

package norskreseptregister;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Resept 
{
    private String dato;
    private Pasient pasientdata;
    private Lege legedata;
    private String medisindata;
    private String mengde;
    private String kategori;
    private String anvisning;
    
    public Resept()
    {
    }
        
    public Resept(String dato, Pasient pasientdata, Lege legedata, 
    String medisindata, String mengde, String kategori, String anvisning)
    {
        this.dato = dato;
        this.pasientdata = pasientdata;
        this.legedata = legedata;
        this.medisindata = medisindata;
        this.mengde = mengde;
        this.kategori = kategori;
        this.anvisning = anvisning; 
    }     
        public String getDato()
        {
            return dato;
        }
        
        public Pasient getPasientdata()
        {
            return pasientdata;
        }
        
        public Lege getLegedata()
        {
            return legedata;
        }
        
        public String getMedisinData()
        {
            return medisindata;
        }
        
        public String getMengde()
        {
            return mengde;
        }
        
        public String getKategori()
        {
            return kategori;
        }
        
        public String getAnvisning()
        {
            return anvisning;
        }
        
        public String toString()
        {
            String tekst = "";
            tekst += "Utskrevet dato: " + dato + 
                    "\nPasient: " + pasientdata + 
                    "\nLege: " + legedata +  
                    "\n Medisin" + medisindata + 
                    "\n Mengde; " + mengde +
                    "\n Kategori: " + kategori + 
                    "\n Anvisning: " + anvisning;
            return tekst;
        } 
        
        //@Override
        public void SkrivObjektTilFil(/*FileOutputStream stream*/)
        {
            // TODO Auto-generated method stub

        }

        //@Override
        public boolean LesObjektFraFil(FileInputStream stream)
        {
            // TODO Auto-generated method stub
            return false;
        }

} // End of class Resept
