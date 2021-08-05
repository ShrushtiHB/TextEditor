import java.awt.Font;

public class FunctionFormat {
	
	GUI gui;
	Font arial, comicSansMS, timesNewRoman, calibri, verdana, georgia, castellar, bold, boldp;
	String selectedFont;
	
	public FunctionFormat(GUI gui) {
		this.gui = gui;
	}
	
	public void wordWrap() {
		if(gui.wordWrapOn==false) {
			gui.wordWrapOn=true;
			gui.textArea.setLineWrap(true);
			gui.textArea.setWrapStyleWord(true);
			gui.iWrap.setText("Word Wrap : On");
		}
		
		else if(gui.wordWrapOn==true) {
			gui.wordWrapOn=false;
			gui.textArea.setLineWrap(false);
			gui.textArea.setWrapStyleWord(false);
			gui.iWrap.setText("Word Wrap : Off");
		}
	}
	
	public void createFont(int fontSize) {
		arial = new Font("Arial", Font.PLAIN, fontSize);
		comicSansMS = new Font("Comic Sans MS", Font.PLAIN, fontSize);
		timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);
		calibri = new Font("Calibri", Font.PLAIN, fontSize);
		verdana = new Font("Verdana", Font.PLAIN, fontSize);
		georgia = new Font("Georgia", Font.PLAIN, fontSize);
		castellar = new Font("Castellar", Font.PLAIN, fontSize);
		setFont(selectedFont);
	}
	
	public void setFont(String font) {
		selectedFont = font;
		switch(selectedFont) {
		case "Arial" : gui.textArea.setFont(arial); break;
		case "Comic Sans MS" : gui.textArea.setFont(comicSansMS); break;
		case "Times New Roman" : gui.textArea.setFont(timesNewRoman); break;
		case "Calibri" : gui.textArea.setFont(calibri);; break;
		case "Verdana" : gui.textArea.setFont(verdana); break;
		case "Georgia" : gui.textArea.setFont(georgia); break;
		case "Castellar" : gui.textArea.setFont(castellar); break;
		}
	}

}
