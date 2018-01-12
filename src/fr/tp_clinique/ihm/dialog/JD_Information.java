package fr.tp_clinique.ihm.dialog;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class JD_Information {

	public JD_Information(String[] multiLineMsg){
		
	    JOptionPane pane = new JOptionPane();
	    pane.setMessage(multiLineMsg);
	    JDialog d = pane.createDialog(null, "Information");
	    d.setVisible(true);
	    int selection = getSelection(pane);

	    switch (selection) {
	    case JOptionPane.OK_OPTION:
	      //System.out.println("OK_OPTION");
	      break;
	    case JOptionPane.CANCEL_OPTION:
	      //System.out.println("CANCEL");
	      break;
	    default:
	      //System.out.println("Others");
	    }
	}
	
	public static int getSelection(JOptionPane optionPane) {
        int returnValue = JOptionPane.CLOSED_OPTION;

        Object selectedValue = optionPane.getValue();
        if (selectedValue != null) {
          Object options[] = optionPane.getOptions();
          if (options == null) {
            if (selectedValue instanceof Integer) {
              returnValue = ((Integer) selectedValue).intValue();
            }
          } else {
            for (int i = 0, n = options.length; i < n; i++) {
              if (options[i].equals(selectedValue)) {
                returnValue = i;
                break; // out of for loop
              }
            }
          }
        }
        return returnValue;
      }
}
