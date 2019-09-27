package convertisseur;
import javax.swing.JFrame;
import javax.swing.UIManager;

import de.javasoft.plaf.synthetica.SyntheticaWhiteVisionLookAndFeel;

public class ConverterMain {

	public static void main(String[] args) {
		try 
	    {
	      UIManager.setLookAndFeel(new SyntheticaWhiteVisionLookAndFeel());
	    } 
	    catch (Exception e) 
	    {
	      e.printStackTrace();
	    }
		Convertisseur cv = new Convertisseur();
		cv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
