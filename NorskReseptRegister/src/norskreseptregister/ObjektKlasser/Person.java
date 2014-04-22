/*
Filen inneholder klassen Person som er superklassen til Lege og Pasient.
Laget av  Henrik Fischer Bjelland
Sist endret 31-03-2014 
*/

package norskreseptregister.ObjektKlasser;

import java.io.Serializable;

public abstract class Person implements Serializable
{
    private static final long serialVersionUID = 1L;
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
    
    public String getNavn()
    {
        return etternavn + " , " + fornavn;
    }

    public String toString()
    {
            String tekst = "";
            tekst+=fornavn + " " + etternavn + ",\n";
            return tekst;
    }  
}//End of class Person