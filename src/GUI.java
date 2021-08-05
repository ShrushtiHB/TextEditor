import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class GUI implements ActionListener {
	
	JFrame window;
	//TEXT AREA
	JTextArea textArea;
	JScrollPane scrollPane;
	boolean wordWrapOn = false;
	//TOP MENU BAR
	JMenuBar menuBar;
	JMenu menuFile, menuEdit, menuFormat, menuColor, menuAbout;
	//FILE MENU
	JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;
	//EDIT MENU
	JMenuItem iUndo, iRedo;
	//FORMET MENU
	JMenuItem iWrap, iFontArial, iFontCSMS, iFontTNR, iFontCalibri, iFontVerdana, iFontGeorgia, iFontCastellar;
	JMenuItem iFontSize8, iFontSize12, iFontSize16, iFontSize20, iFontSize24;
	JMenu menuFont, menuFontSize;
	//COLOR MENU
	JMenuItem iColor1, iColor2, iColor3;
	//ABOUT US MENU
	JMenuItem iAboutUs;
	
	FunctionFile file = new FunctionFile(this);
	FunctionFormat format = new FunctionFormat(this);
	FunctionColor color = new FunctionColor(this);
	FunctionEdit edit = new FunctionEdit(this);
	FunctionAbout about = new FunctionAbout(this);
	
	UndoManager um = new UndoManager();

	public static void main(String[] args) {
		
		new GUI();

	}
	public GUI() {
		createWindow();
		createTextArea();
		createMenuBar();
		createFileMenu();
		createEditMenu();
		createFormatMenu();
		createColorMenu();
		createAboutMenu();
		
		format.selectedFont = "Arial";
		format.createFont(16);
		format.wordWrap();
		color.changeColor("White");// set default
		window.setVisible(true);
	}

	public void createWindow() {
		window = new JFrame("NOTEPAD");
		window.setSize(700,500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void createTextArea() {
		textArea = new JTextArea();
		
		textArea.getDocument().addUndoableEditListener(
				(UndoableEditListener) new UndoableEditListener() {
					public void undoableEditHappened(UndoableEditEvent e) {
						um.addEdit(e.getEdit());
					}
				});
		
		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		window.add(scrollPane);
	}
	
	public void createMenuBar() {
		menuBar = new JMenuBar();
		window.setJMenuBar(menuBar);
		
		menuFile = new JMenu("File");
		menuBar.add(menuFile);
		
		menuEdit = new JMenu("Edit");
		menuBar.add(menuEdit);
		
		menuFormat = new JMenu("Format");
		menuBar.add(menuFormat);
		
		menuColor = new JMenu("Color");
		menuBar.add(menuColor);
		
		menuAbout = new JMenu("About Us");
		menuBar.add(menuAbout);
	}
	
	public void createFileMenu() {
		iNew = new JMenuItem("New");
		iNew.addActionListener(this);
		iNew.setActionCommand("New");
		menuFile.add(iNew);
		
		iOpen = new JMenuItem("Open");
		iOpen.addActionListener(this);
		iOpen.setActionCommand("Open");
		menuFile.add(iOpen);
		
		iSave = new JMenuItem("Save");
		iSave.addActionListener(this);
		iSave.setActionCommand("Save");
		menuFile.add(iSave);
		
		iSaveAs = new JMenuItem("SaveAs");
		iSaveAs.addActionListener(this);
		iSaveAs.setActionCommand("SaveAs");
		menuFile.add(iSaveAs);
		
		iExit = new JMenuItem("Exit");
		iExit.addActionListener(this);
		iExit.setActionCommand("Exit");
		menuFile.add(iExit);
	}
	
	public void createEditMenu() {
		iUndo = new JMenuItem("Undo");
		iUndo.addActionListener(this);
		iUndo.setActionCommand("Undo");
		menuEdit.add(iUndo);
		
		iRedo = new JMenuItem("Redo");
		iRedo.addActionListener(this);
		iRedo.setActionCommand("Redo");
		menuEdit.add(iRedo);
	}
	
	public void createFormatMenu() {
		iWrap = new JMenuItem("Word Wrap : Off");
		iWrap.addActionListener(this);
		iWrap.setActionCommand("Word Wrap");
		menuFormat.add(iWrap);
		
		menuFont = new JMenu("Font");
		menuFormat.add(menuFont);
		
		iFontArial = new JMenuItem("Arial");
		iFontArial.addActionListener(this);
		iFontArial.setActionCommand("Arial");
		menuFont.add(iFontArial);
		
		iFontCalibri = new JMenuItem("Calibri");
		iFontCalibri.addActionListener(this);
		iFontCalibri.setActionCommand("Calibri");
		menuFont.add(iFontCalibri);
		
		iFontCastellar = new JMenuItem("Castellar");
		iFontCastellar.addActionListener(this);
		iFontCastellar.setActionCommand("Castellar");
		menuFont.add(iFontCastellar);
		
		iFontCSMS = new JMenuItem("Comic Sans MS");
		iFontCSMS.addActionListener(this);
		iFontCSMS.setActionCommand("Comic Sans MS");
		menuFont.add(iFontCSMS);
		
		iFontGeorgia = new JMenuItem("Georgia");
		iFontGeorgia.addActionListener(this);
		iFontGeorgia.setActionCommand("Georgia");
		menuFont.add(iFontGeorgia);
		
		iFontTNR = new JMenuItem("Times New Roman");
		iFontTNR.addActionListener(this);
		iFontTNR.setActionCommand("Times New Roman");
		menuFont.add(iFontTNR);
		
		iFontVerdana = new JMenuItem("Verdana");
		iFontVerdana.addActionListener(this);
		iFontVerdana.setActionCommand("Verdana");
		menuFont.add(iFontVerdana);
	
		menuFontSize = new JMenu("Font Size");
		menuFormat.add(menuFontSize);
		
		iFontSize8 = new JMenuItem("8");
		iFontSize8.addActionListener(this);
		iFontSize8.setActionCommand("size8");
		menuFontSize.add(iFontSize8);
		
		iFontSize12 = new JMenuItem("12");
		iFontSize12.addActionListener(this);
		iFontSize12.setActionCommand("size12");
		menuFontSize.add(iFontSize12);
		
		iFontSize16 = new JMenuItem("16");
		iFontSize16.addActionListener(this);
		iFontSize16.setActionCommand("size16");
		menuFontSize.add(iFontSize16);
		
		iFontSize20 = new JMenuItem("20");
		iFontSize20.addActionListener(this);
		iFontSize20.setActionCommand("size20");
		menuFontSize.add(iFontSize20);
		
		iFontSize24 = new JMenuItem("24");
		iFontSize24.addActionListener(this);
		iFontSize24.setActionCommand("size24");
		menuFontSize.add(iFontSize24);		
	}
	
	public void createColorMenu() {
		iColor1 = new JMenuItem("White");
		iColor1.addActionListener(this);
		iColor1.setActionCommand("White");
		menuColor.add(iColor1);
		
		iColor2 = new JMenuItem("Black");
		iColor2.addActionListener(this);
		iColor2.setActionCommand("Black");
		menuColor.add(iColor2);
		
		iColor3 = new JMenuItem("Blue");
		iColor3.addActionListener(this);
		iColor3.setActionCommand("Blue");
		menuColor.add(iColor3);
	}
	
	public void createAboutMenu() {
		iAboutUs = new JMenuItem("Information");
		iAboutUs.addActionListener(this);
		iAboutUs.setActionCommand("Information");
		menuAbout.add(iAboutUs);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		switch(command) {
		case "New" : file.newFile(); break;
		case "Open" : file.open(); break;
		case "Save" : file.save(); break;
		case "SaveAs" : file.saveAs(); break;
		case "Exit" : file.exit(); break;
		case "Undo" : edit.undo(); break;
		case "Redo" : edit.redo(); break;
		case "Word Wrap" : format.wordWrap(); break;
		case "Arial" : format.setFont(command); break;
		case "Calibri" : format.setFont(command); break;
		case "Castellar" : format.setFont(command); break;
		case "Comic Sans MS" : format.setFont(command); break;
		case "Georgia" : format.setFont(command); break;
		case "Times New Roman" : format.setFont(command); break;
		case "Verdana" : format.setFont(command); break;
		case "size8" : format.createFont(8); break;
		case "size12" : format.createFont(12); break;
		case "size16" : format.createFont(16); break;
		case "size20" : format.createFont(20); break;
		case "size24" : format.createFont(24); break;
		case "White" : color.changeColor(command); break;
		case "Black" : color.changeColor(command); break;
		case "Blue" : color.changeColor(command); break;
		case "Information" : about.show(); break;
		}
	}
}
