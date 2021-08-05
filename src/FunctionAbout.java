import javax.swing.JOptionPane;

public class FunctionAbout {

	GUI gui;
	
	public FunctionAbout(GUI gui) {
		this.gui = gui;
	}
	
	public void show() {
		JOptionPane.showMessageDialog(null, "This software is developed by a group of 5 members as a home assignment activity for OOPS course.\n"
				+ "The names of the members are Shrushti Bhattad, Shaurya Singh, Sumit Singh, Shreyas Talwekar, and Samruddha Tupe.\n"
				, null, JOptionPane.INFORMATION_MESSAGE);
	}

}
