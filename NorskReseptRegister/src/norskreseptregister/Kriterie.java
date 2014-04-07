/*
 * Filen inneholder 
 * Laget av  * 
 * Sist endret  * 
 */

package norskreseptregister;

/**
 *
 * @author Henrik
 */
public interface Kriterie<T>
{
    public boolean erOppfyltFor(T element);
}//end of interface Kriterie
