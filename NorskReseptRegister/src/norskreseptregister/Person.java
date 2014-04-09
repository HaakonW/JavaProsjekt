/*
 * Filen inneholder klassen Person som er superklassen til Lege og Pasient.
 * Laget av  Henrik
 * Sist endret 31/03/2014 
 */

package norskreseptregister;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public abstract class Person implements SkriveLeseObjekt
{
    private String fornavn;
    private String etternavn;

    public Person()
    {
        //parameterløs kontruktør
    }
    public Person(String fornavn, String etternavn)
    {
            this.fornavn = fornavn;
            this.etternavn = etternavn;
    }

    public String getFornavn()
    {
            return fornavn;
    }
    
        public String getEtternavn()
    {
            return etternavn;
    }

    public String toString()
    {
            String tekst = "";
            tekst+= "Navn : " + fornavn + " " + etternavn + "\n";
            return tekst;
    }
    
    public void SkrivObjektTilFil(FileOutputStream filnavn)
    {
        // TODO Auto-generated method stub
    }
    
    public boolean LesObjektTilFil(FileInputStream filnavn)
    {
        // TODO Auto-generated method stub
        return false;
    }
    
}//End of class Person