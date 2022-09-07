package fishgui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;

public class GUI  {
	
	private JFrame frame;
	private Container container;
	private JPanel titlePanel;
	private JPanel startButtonPanel, mainTextPanel, choiceButtonPanel;
	//private PicturePanel picturePanel;
	private JLabel titleLabel;
	// labelPic;
	private JButton startButton, choice1, choice2, choice3, choice4, choice5, choice6;
	private JTextArea mainTextArea;
	private JScrollPane scrollPane;
	private Font titleFont = new Font("Segoe Print", Font.BOLD, 52);
	private Font smallFont = new Font("Verdana", Font.BOLD, 14);
	private Font bigFont = new Font("Verdana", Font.BOLD, 18);
	private Color background = new Color(135,206,250);
	private TitleScreenHandler tsh = new TitleScreenHandler();
	private ChoiceHandler ch = new ChoiceHandler();
	private String position;
	
	private SetUpGame g1;
	private ArrayList<Fish> bag;
	private Fish fish;
	private int fishAdded = 0;
	
	private String filePath = "C:\\Users\\robyn\\Documents\\documents\\general-workspace\\Fish\\src\\fishgui\\";
	
	public static void main(String[] args) {
		new GUI();
	}
	
	public GUI() {
		bag = new ArrayList<Fish>();
		g1 = new SetUpGame();
		
		
		frame = new JFrame("Fish Time!");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(background);
		frame.setLayout(null);		
		frame.setResizable(false);

		container =  frame.getContentPane();
		
		
		
		titlePanel = new JPanel();
		titlePanel.setBounds(20, 50, 445, 75);
		titlePanel.setBackground(background);
		
		titleLabel = new JLabel("Fish Time!");
		titleLabel.setForeground(Color.white);
		titleLabel.setFont(titleFont);
			
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(175, 250, 150, 50);
		startButtonPanel.setBackground(background);
		
		startButton = new JButton("START");
		startButton.setBackground(Color.white);
		startButton.setForeground(background);
		startButton.setFont(bigFont);
		startButton.addActionListener(tsh);
		startButton.setFocusPainted(false);
		titlePanel.add(titleLabel);
		startButtonPanel.add(startButton);
		
		/*
		picturePanel = new PicturePanel("C:\\Users\\robyn\\Documents\\documents\\general-workspace\\Fish\\src\\fishgui\\water-300.jpg");
		picturePanel.setBounds(510, 60, 300, 300);
		
		container.add(picturePanel);
		*/
		
		container.add(titlePanel);
		container.add(startButtonPanel);
		
		frame.setVisible(true);
	}	
	
	/*
	class PicturePanel extends JPanel{
        
		 
		 
		private static final long serialVersionUID = 1L;
		private ImageIcon pic;
        
        public PicturePanel(String path) {
            pic = new ImageIcon(path);
        }       
        
        public void paintComponent( Graphics g ){
            super.paintComponent( g );
            pic.paintIcon(this, g, 0, 0);
        }
        
    }
	*/
	
	/*
	public class PictureFrame extends JFrame {
	 
		private static final long serialVersionUID = 1L;
		ImageIcon pond1 = new ImageIcon("");
		ImageIcon pond2 = new ImageIcon("");
	 
		public PictureFrame() {
			this.setLocationRelativeTo(null);
			labelPic.setText("");
		}
		
		public void changeToPond1() {
			labelPic.setIcon(pond1);
		}
		
		public void changeToPond2() {
			labelPic.setIcon(pond2);
		}
	}

	*/
	
	
	public void createGameScreen() {
		titlePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(40, 50, 400, 230);
		mainTextPanel.setBackground(background);
		
		mainTextArea = new JTextArea("Hello world, it's time to fish!");
		//mainTextArea.setBackground(background);
		//mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(bigFont);
		mainTextArea.setLineWrap(true);
		mainTextArea.setEditable(false); 
				
		scrollPane = new JScrollPane(mainTextArea); 
		Dimension d = new Dimension(400, 230);
		scrollPane.setPreferredSize(d);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		mainTextPanel.add(scrollPane);
		container.add(mainTextPanel);		
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(115, 300, 250, 125);
		choiceButtonPanel.setBackground(background);
		choiceButtonPanel.setLayout(new GridLayout(3, 2));
		container.add(choiceButtonPanel);
		
		// CHOICE BUTTONS //
		choice1 = new JButton("Choice 1");
		choice1.setBackground(Color.white);
		choice1.setForeground(background);
		choice1.setFont(smallFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(ch);
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);
		//
		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.white);
		choice2.setForeground(background);
		choice2.setFont(smallFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(ch);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);
		//
		choice3 = new JButton("Choice 3");
		choice3.setBackground(Color.white);
		choice3.setForeground(background);
		choice3.setFont(smallFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(ch);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);
		//
		choice4 = new JButton("Choice 4");
		choice4.setBackground(Color.white);
		choice4.setForeground(background);
		choice4.setFont(smallFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(ch);
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice4);
		//
		choice5 = new JButton("Choice 5");
		choice5.setBackground(Color.white);
		choice5.setForeground(background);
		choice5.setFont(smallFont);
		choice5.setFocusPainted(false);
		choice5.addActionListener(ch);
		choice5.setActionCommand("c5");
		choiceButtonPanel.add(choice5);
		//
		choice6 = new JButton("Choice 6");
		choice6.setBackground(Color.white);
		choice6.setForeground(background);
		choice6.setFont(smallFont);
		choice6.setFocusPainted(false);
		choice6.addActionListener(ch);
		choice6.setActionCommand("c6");
		choiceButtonPanel.add(choice6);
		// CHOICE BUTTONS //
		
		mainMenu();
	}
	
	public void mainMenu() {
		position = "mainMenu";
		mainTextArea.setText("Welcome to the pond!\nWhat would you like to do?");
		choice1.setText("Fish");
		choice2.setText("View Bag");
		choice3.setText("Save bag");
		choice4.setText("Load bag");
		choice5.setText("Empty bag");
		choice6.setText("Exit");
	}
	
	public void fish() {
		position = "fish";
		fish = g1.generateFish();
		mainTextArea.setText("Congratulations, you caught a "+ fish.getSpeciesName() + " weighing " + fish.getWeight() + "kg.\nWould you like to keep it?");
		choice1.setText("Yes");
		choice2.setText("No");
		choice3.setText("");
		choice4.setText("");
		choice5.setText("");
		choice6.setText("");
	}
	
	public void afterAddingFish() {
		position = "afterAddingFish";
		mainTextArea.setText("Fish was added to bag.");
		choice1.setText("Back");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice5.setText("");
		choice6.setText("");
	}
	
	public void afterLeavingFish() {
		position = "afterLeavingFish";
		mainTextArea.setText("Fish was returned to the water.");
		choice1.setText("Back");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice5.setText("");
		choice6.setText("");
	}
	
	public void viewBag() {
		
		position = "viewBag";
		
		String fishlist = "";
		
		for (Fish f : bag) {
			fishlist += f.getSpeciesName() + " " + f.getWeight() + "kg\n";
		}
		
		mainTextArea.setText("You have " + bag.size() + " fish in your bag:\n" + fishlist);
		choice1.setText("Back");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice5.setText("");
		choice6.setText("");
	}
	
	public void saveBag() {
		
		position = "saveBag";
		
		mainTextArea.setText("Select a file to save to");
		
		if (isFileEmpty(filePath + "save1")) {
			choice1.setText("<empty>");
		} else {
			choice1.setText("File 1 ");
		}
		if (isFileEmpty(filePath + "save2")) {
			choice2.setText("<empty>");
		} else {
			choice2.setText("File 2");
		}
		if (isFileEmpty(filePath + "save3")) {
			choice3.setText("<empty>");
		} else {
			choice3.setText("File 3");
		}
		if (isFileEmpty(filePath + "save4")) {
			choice4.setText("<empty>");
		} else {
			choice4.setText("File 4");
		}
		if (isFileEmpty(filePath + "save5")) {
			choice5.setText("<empty>");
		} else {
			choice5.setText("File 5");
		}
		
		choice6.setText("Back");
	}
	
	public void afterSave(String file) {
		position = "afterSave";
		mainTextArea.setText("Bag containing " + bag.size() + " fish saved to " + file + ".");
		choice1.setText("Back");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice5.setText("");
		choice6.setText("");
	}
	
	public boolean isFileEmpty(String fileName) {
		boolean isFileEmpty = false;
		BufferedReader buffer = null;
		try {
			FileReader in = new FileReader(fileName);
			buffer = new BufferedReader(in);
			String line = buffer.readLine();
			if (line == null) return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (buffer != null) {
				try {
					buffer.close();
				} catch (IOException e) {
					System.out.println("Couldn't close file");
					e.printStackTrace();
				}
			}
		}
		return isFileEmpty;
	}
	
	public void saveToFile(String fileName) {
		try {
		      FileWriter writer = new FileWriter(fileName);
		      for (Fish f : bag) { 
		    	  writer.write(f.getSpeciesName());
		    	  writer.write(" ");
		    	  writer.write(String.valueOf(f.getWeight()));
		    	  writer.write("\n");
		      }
		      
		      writer.close();
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	public void loadSave() {
		 position = "loadSave";
		 mainTextArea.setText("Select a save file to load.");
		 
		 if (isFileEmpty(filePath + "save1")) {
				choice1.setText("<empty>");
			} else {
				choice1.setText("File 1 ");
			}
			if (isFileEmpty(filePath + "save2")) {
				choice2.setText("<empty>");
			} else {
				choice2.setText("File 2");
			}
			if (isFileEmpty(filePath + "save3")) {
				choice3.setText("<empty>");
			} else {
				choice3.setText("File 3");
			}
			if (isFileEmpty(filePath + "save4")) {
				choice4.setText("<empty>");
			} else {
				choice4.setText("File 4");
			}
			if (isFileEmpty(filePath + "save5")) {
				choice5.setText("<empty>");
			} else {
				choice5.setText("File 5");
			}
			
			choice6.setText("Back");
	}
	
	public void loadFishes(String fileName) {
		ArrayList<String> lines = readFileLines(fileName);
		String fishName;
		String weightString;
		Double fishWeight;
		for (String l : lines) {
			fishName = l.replaceAll("[0-9]|,| |\\.", "");
			weightString = l.toLowerCase().replaceAll("[a-z]|,| |\\/", "");
			fishWeight = Double.parseDouble(weightString);
			bag.add(new Fish(getSpecies(fishName, g1.getSpeciesList()), (double)fishWeight));
			fishAdded++;
		}
	}
	
	private Species getSpecies(String searchTerm, ArrayList<Species> speciesList) {
		Species species = null;
		for (Species s : speciesList) {if (s.getSpeciesName().equals(searchTerm)) {species = s;}}
		if (species == null) {throw new NullPointerException("Can't find species");}
		return species;
		
		
	}
	
	private ArrayList<String> readFileLines(String fileName) {
		BufferedReader buffer = null;
		ArrayList<String> lines = new ArrayList<String>();
		try {
			FileReader in = new FileReader(fileName);
			buffer = new BufferedReader(in);
			String line = buffer.readLine();
			while (line != null) {
				lines.add(line);
				line = buffer.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (buffer != null) {
				try {
					buffer.close();
				} catch (IOException e) {
					System.out.println("Could not close file");
					e.printStackTrace();
				}
			}
		}
		
		return lines;
	}
	
	public void afterLoad(String fileName) {
		position = "afterLoad";
		mainTextArea.setText("Loaded " + fishAdded + " fish from" + fileName + ".");
		fishAdded = 0;
		choice1.setText("Back");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice5.setText("");
		choice6.setText("");
		
	}
	
	public void confirmEmpty() {
		position = "confirmEmpty";
		mainTextArea.setText("Bag contains " + bag.size() + " fish.\nAre you sure you want to empty it?\nYou will lose any unsaved fish.");
		choice1.setText("Back");
		choice2.setText("Yes");
		choice3.setText("");
		choice4.setText("");
		choice5.setText("");
		choice6.setText("");
	}
	
	public void emptyBag() {
		position = "emptyBag";
		
		bag.clear();
		
		mainTextArea.setText("Bag has been emptied.");
		choice1.setText("Back");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice5.setText("");
		choice6.setText("");
	}
	
	public void confirmExit() {
		position = "confirmExit";
		mainTextArea.setText("Are you sure you want to exit?\nYou will lose any unsaved progress.");
		choice1.setText("Back");
		choice2.setText("Yes");
		choice3.setText("");
		choice4.setText("");
		choice5.setText("");
		choice6.setText("");
	}
	public class TitleScreenHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			createGameScreen();
			frame.setVisible(false);
			frame.setVisible(true);
		}
	}
	
	public class ChoiceHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String choice = e.getActionCommand();
			
			switch (position) {
			case "mainMenu":
				switch (choice) {
				case "c1":
					// catch a fish
					fish();
					break;
				case "c2":
					// view bag
					viewBag();
					break;
				case "c3":
					// save bag
					saveBag();
					break;
				case "c4":
					// load save
					loadSave();
					break;
				case "c5":
					// empty bag
					confirmEmpty();
					break;
				case "c6":
					// go to confirm exit screen
					confirmExit();
					break;
				}
			break;
			
			case "fish":
				switch (choice) {
				case "c1":
					// yes add fish to bag
					bag.add(fish);
					afterAddingFish();
					break;
				case "c2":
					// no dont add it to bag
					afterLeavingFish();
					break;
					
				} 
			break;
			
			case "afterAddingFish":
				switch (choice) {
				case "c1":
					// leave
					mainMenu();
					break;
				}
			break;
			
			case "afterLeavingFish":
				switch (choice) {
				case "c1":
					// leave
					mainMenu();
					break;
				}
			break;
			
			case "viewBag":
				switch (choice) {
				case "c1":
					// leave
					mainMenu();
					break;
				}
			break;
			case "saveBag":
				switch (choice) {
				case "c1":
					saveToFile(filePath + "save1");
					afterSave(" File 1");
					break;
				case "c2":
					saveToFile(filePath + "save2");
					afterSave(" File 2");
					break;
				case "c3":
					saveToFile(filePath + "save3");
					afterSave(" File 3");
					break;
				case "c4":
					saveToFile(filePath + "save4");
					afterSave(" File 4");
					break;
				case "c5":
					saveToFile(filePath + "save5");
					afterSave(" File 5");
					break;
				case "c6":
					// leave
					mainMenu();
					break;
				}
			break;
			case "afterSave":
				switch (choice) {
				case "c1":
					// leave
					mainMenu();
					break;
				}
			break;
			case "loadSave":
				switch (choice) {
				case "c1":
					loadFishes(filePath + "save1");
					afterLoad(" File 1");
					break;
				case "c2":
					loadFishes(filePath + "save2");
					afterLoad(" File 2");
					break;
				case "c3":
					loadFishes(filePath + "save3");
					afterLoad(" File 3");
					break;
				case "c4":
					loadFishes(filePath + "save4");
					afterLoad(" File 4");
					break;
				case "c5":
					loadFishes(filePath + "save5");
					afterLoad(" File 5");
					break;
				case "c6":
					// leave
					mainMenu();
					break;
				}
			break;
			case "afterLoad":
				switch (choice) {
				case "c1":
					// leave
					mainMenu();
					break;
				}
			break;
			case "confirmEmpty":
				switch (choice) {
				case "c1":
					// leave
					mainMenu();
					break;
				case "c2":
					// empty bag
					emptyBag();
					break;
				}
			break;
			case "emptyBag":
				switch (choice) {
				case "c1":
					// leave
					mainMenu();
					break;
				}
			break;
			case "confirmExit":
				switch (choice) {
				case "c1":
					// leave
					mainMenu();
					break;
				case "c2":
					// exit game
					System.exit(0);
					break;
				}
			break;
			}	
		}
	}
}
