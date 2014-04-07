/*
 * Filen inneholder 
 * Laget av  * 
 * Sist endret  * 
 */

package norskreseptregister.gui;

/**
 *
 * @author Bandet
 */

import java.awt.*;
import javax.swing.*;

public class GridbagTest extends JFrame
{
    	private JButton okButton, cancelButton, helpButton;
	private JTextField fornavnfelt, etternavnfelt;
	private JLabel fornavnlabel, etternavnlabel;
    
    public GridbagTest()
    {
        // lager xPanel
        fornavnlabel = new JLabel("Fornavn:");
        fornavnfelt = new JTextField( 20 );

        etternavnlabel = new JLabel("Etternavn: " );
        etternavnfelt = new JTextField( 20 );
        
        JPanel xPanel = new JPanel();
        xPanel.setLayout( new GridLayout(2,0));

        xPanel.add( fornavnlabel );
        xPanel.add( fornavnfelt );
        xPanel.add(etternavnlabel);
        xPanel.add(etternavnfelt);
        
        JPanel yPanel = new JPanel();
        
        // lager feltPanel
        JPanel feltPanel = new JPanel();
        feltPanel.setLayout( new BorderLayout() );
        feltPanel.add(xPanel, BorderLayout.PAGE_START);  // NORTH
        feltPanel.add(yPanel, BorderLayout.PAGE_END);
        //

        // lager knappePanel
        okButton = new JButton( "Ok" );
        cancelButton = new JButton( "Cancel" );
        helpButton = new JButton( "Help" );

        JPanel knappePanel = new JPanel();
        knappePanel.setLayout( new GridLayout( 3, 1, 10, 5 ));

        knappePanel.add(okButton);
        knappePanel.add(cancelButton);
        knappePanel.add(helpButton);



        setLayout( new FlowLayout( FlowLayout.CENTER, 20, 5 ) );
        add( feltPanel );
        add( knappePanel );

        setSize( 600, 400 );
        setVisible( true );

          

    }  // end constructor
        // execute application
    	public static void main( String args[] )
	{
		GridbagTest application = new GridbagTest();
		application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
}
