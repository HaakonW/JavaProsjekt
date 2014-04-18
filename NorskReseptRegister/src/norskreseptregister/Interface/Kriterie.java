/*
Filen inneholder interfacet Kriterie<T>
Laget av  Henrik Fischer Bjelland
Sist endret  08-04-2014 
 */

package norskreseptregister.Interface;

public interface Kriterie<T>
{
    public boolean erOppfyltFor(T element);
}//end of interface Kriterie