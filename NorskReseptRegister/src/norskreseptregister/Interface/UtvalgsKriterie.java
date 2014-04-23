/*
Filen inneholder interfacet Kriterie<T>
Laget av  Henrik Fischer Bjelland
Sist endret  08-04-2014 
 */

package norskreseptregister.Interface;

public interface UtvalgsKriterie<T>
{
    // Denne metoden skal returnere true hvis 'objekt' skal være med i utvalget
    public boolean objektetSkalVaereMed(T objekt);
}//end of interface Kriterie