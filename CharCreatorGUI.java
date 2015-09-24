import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.List;
import java.util.Arrays;
import java.io.*;

public class CharCreatorGUI extends JFrame 
{
	private Race c1; 			//character object, subclass to be determined by initializeCharacter()
	private String raceChoice;	//desired race
	private String classChoice;	//desired class for determining subclass
	//for Ability Panel
	private int[] abilityScores = new int[6];	//array to hold STR, DEX, CON, INT, WIS and CHA
	private int s = 0;			//holds 0 to swap with
	private JPanel abilityPanel;
	private JLabel strength;	//ability Labels
	private JLabel dexterity;
	private JLabel constitution;
	private JLabel intelligence;
	private JLabel wisdom;
	private JLabel charisma;
	private JLabel swap;
	public JButton strButton;	//swap buttons
	public JButton dexButton;
	public JButton conButton;
	public JButton intButton;
	public JButton wisButton;
	public JButton chaButton;
	//for Skill Panel
	private JPanel skillPanel;	
	private String[][] SKILL_DATA;			//retrieve Meta data from object for labels
	private int[] skillPts = new int[52];	//hold assigned skill points
	private JComboBox skillBox;				//hold each skill
	private JLabel currentSkill;			//label for actively editable skill
	private String selectedSkill;			//variable to hold string of active skill
	private int skillIndex;					//variable to hold index of active skill
	private JButton skillINC;				//button to increment active skill's value
	private JButton skillDEC;				//button to decrement active skill's value
	private JLabel pointsLeftLabel;			//Label to show user how many skill points they have left
	private int pointsLeft;					//variable to hold skill points left
	//for Character Panel
	private JPanel charPanel;
	private JComboBox alignment;			//combobox for alignment choices
	private JTextField name;				//TextFields for general info
	private JTextField god;
	private JTextField height;
	private JTextField weight;
	private JLabel nLabel;					//Labels for alignment and general info
	private JLabel aLabel;
	private JLabel gLabel;
	private JLabel hLabel;
	private JLabel wLabel;
	//for finalize panel
	private JPanel finalPanel;				
	private JButton finalize;				//Button to make final calculations generate toString to .txt file
	//
	private final int WINDOW_WIDTH = 1100;	//windows width and height
	private final int WINDOW_HEIGHT = 250;	//
	
	//CONSTRUCTOR
	public CharCreatorGUI()
	{
		initializeCharacter();
		
		rollAbilities();
		buildAbilityPanel();
		buildSkillPanel();
		buildCharacterPanel();
		buildFinalPanel();
		
		setTitle("Dungeons &n Dragons Character Creator: " + classChoice);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		add(abilityPanel, BorderLayout.EAST);
		add(skillPanel, BorderLayout.CENTER);
		add(charPanel, BorderLayout.NORTH);
		add(finalPanel, BorderLayout.SOUTH);
		
//		pack();
		setVisible(true);
	}
	
	
	//METHODS
	public void initializeCharacter()		//give user a choice of Class, then Race. 
	{										//then initialize c1 as the correct player class
		String[] classOption = {	"Barbarian", 
									"Bard", 
									"Cleric", 
									"Druid", 
									"Fighter", 
									"Monk", 
									"Paladin",
									"Ranger",
									"Rogue",
									"Sorcerer",
									"Wizard"
								};
		
		//give class options. cant be changed beyond this point
		classChoice = (String) JOptionPane.showInputDialog(null, "Choose a Class: ", 
											"Class Options", 
											JOptionPane.QUESTION_MESSAGE, null, 
											classOption, classOption[0]); 
											
		String[] raceOption = {"Human",
								"Dwarf",
								"Elf",
								"Gnome",
								"Half-Elf",
								"Half-Orc",
								"Halfling"};
		
		raceChoice = (String) JOptionPane.showInputDialog(null, "Choose a Race: ", 
											"Race Options", 
											JOptionPane.QUESTION_MESSAGE, null, 
											raceOption, raceOption[0]);
		
		if (classChoice == "Barbarian")	//if class chosen
		{
			c1 = new Barbarian("", raceChoice);
		}
		else if (classChoice == "Bard") 
		{
			c1 = new Bard("", raceChoice);
		}
		else if (classChoice == "Cleric") 
		{
			c1 = new Cleric("", raceChoice);
		}
		else if (classChoice == "Druid") 
		{
			c1 = new Druid("", raceChoice);
		}
		else if (classChoice == "Fighter") 
		{
			c1 = new Fighter("", raceChoice);
		}
		else if (classChoice == "Monk") 
		{
			c1 = new Monk("", raceChoice);
		}
		else if (classChoice == "Paladin") 
		{
			c1 = new Paladin("", raceChoice);
		}
		else if (classChoice == "Ranger") 
		{
			c1 = new Ranger("", raceChoice);
		}
		else if (classChoice == "Rogue") 
		{
			c1 = new Rogue("", raceChoice);
		}
		else if (classChoice == "Sorcerer") 
		{
			c1 = new Sorcerer("", raceChoice);
		}
		else if (classChoice == "Wizard") 
		{
			c1 = new Wizard("", raceChoice);
		}
	}
	public void rollAbilities()			//generate 6 random numbers between 3 and 18
	{
		Random rand = new Random();
		
		for (int i = 0; i < abilityScores.length; i++) 
		{
			abilityScores[i] =	(1 + rand.nextInt(6)) + 
								(1 + rand.nextInt(6)) +
								(1 + rand.nextInt(6));
		}
	}
	public void updateGUI()				//update what the user sees
	{
		swap.setText("Swap with selected Ability Score: " + s);
		strength.setText("Strength: " + abilityScores[0]);
		dexterity.setText("Dexterity: " + abilityScores[1]);
		constitution.setText("Constitution: " + abilityScores[2]);
		intelligence.setText("Intelligence: " + abilityScores[3]);
		wisdom.setText("Wisdom: " + abilityScores[4]);
		charisma.setText("Charisma: " + abilityScores[5]);
		
		currentSkill.setText(selectedSkill + ": " + skillPts[skillIndex]);
		pointsLeftLabel.setText("You Have " + pointsLeft + " Skill Points Left");
	}
	public void buildAbilityPanel()
	{
		abilityPanel = new JPanel();
		
		abilityPanel.setLayout(new GridLayout(7, 2));
		JLabel emptyCell = new JLabel("");
		
		swap = new JLabel("Swap with selected Ability Score: " + s);
		strength = new JLabel("Strength: " + abilityScores[0]);
		dexterity = new JLabel("Dexterity: " + abilityScores[1]);
		constitution = new JLabel("Constitution: " + abilityScores[2]);
		intelligence = new JLabel("Intelligence: " + abilityScores[3]);
		wisdom = new JLabel("Wisdom: " + abilityScores[4]);
		charisma = new JLabel("Charisma: " + abilityScores[5]);
		
		strButton = new JButton("SWAP-->");
		dexButton = new JButton("SWAP-->");
		conButton = new JButton("SWAP-->");
		intButton = new JButton("SWAP-->");
		wisButton = new JButton("SWAP-->");
		chaButton = new JButton("SWAP-->");
		
		strButton.addActionListener(new strButtonListener());
		dexButton.addActionListener(new dexButtonListener());
		conButton.addActionListener(new conButtonListener());
		intButton.addActionListener(new intButtonListener());
		wisButton.addActionListener(new wisButtonListener());
		chaButton.addActionListener(new chaButtonListener());
		
		abilityPanel.add(swap);
			abilityPanel.add(emptyCell);
		abilityPanel.add(strButton);
			abilityPanel.add(strength);
		abilityPanel.add(dexButton);
			abilityPanel.add(dexterity);
		abilityPanel.add(conButton);
			abilityPanel.add(constitution);
		abilityPanel.add(intButton);
			abilityPanel.add(intelligence);
		abilityPanel.add(wisButton);
			abilityPanel.add(wisdom);
		abilityPanel.add(chaButton);
			abilityPanel.add(charisma);
	}
	public void buildSkillPanel()
	{
		SKILL_DATA = c1.getSkillMetaData();
		String[] skillLabels = new String[52];
		for (int i = 0; i < 52; i++) 
		{
			skillLabels[i] = SKILL_DATA[i][0];
			skillPts[i] = 0;
		}
		pointsLeft = c1.getStartingSkillPts();
		
		skillPanel = new JPanel();
		
		skillPanel.setLayout(new GridLayout(5, 2));
		
		JLabel emptyCell = new JLabel("");
		pointsLeftLabel = new JLabel("You Have " + pointsLeft + " Skill Points Left");
		currentSkill = new JLabel("Select a Skill");
		
		skillBox = new JComboBox(skillLabels);
		skillBox.addActionListener(new skillBoxListener());
		
		skillINC = new JButton("^");
		skillDEC = new JButton("v");
		skillINC.addActionListener(new increment());
		skillDEC.addActionListener(new decrement());
		
		skillPanel.add(pointsLeftLabel);
		skillPanel.add(emptyCell);
		skillPanel.add(skillBox);
		skillPanel.add(emptyCell);
		skillPanel.add(currentSkill);
		skillPanel.add(emptyCell);
		skillPanel.add(emptyCell);
		skillPanel.add(emptyCell);
		skillPanel.add(skillINC);
		skillPanel.add(skillDEC);
	}
	public void buildCharacterPanel()
	{
		String[] alignChoice = {"Lawful Good","Lawful Neutral", "Lawful Evil",
								"Neutral Good",	"Neutral","Neutral Evil", 
								"Chaotic Good",	"Chaotic Neutral","Chaotic Evil"};
		
		charPanel = new JPanel();
		
		name = new JTextField(10);
		god = new JTextField(10);
		height = new JTextField(10);
		weight = new JTextField(10);
		
		nLabel = new JLabel("Character Name: ");
		gLabel = new JLabel("Deity: ");
		hLabel = new JLabel("Height: ");
		wLabel = new JLabel("Weight(lbs.): ");
		
		alignment = new JComboBox(alignChoice);
		aLabel = new JLabel("Alignment: ");
		
		charPanel.add(nLabel);
		charPanel.add(name);
		charPanel.add(gLabel);
		charPanel.add(god);
		charPanel.add(hLabel);
		charPanel.add(height);
		charPanel.add(wLabel);
		charPanel.add(weight);
		charPanel.add(aLabel);
		charPanel.add(alignment);
	}
	public void buildFinalPanel()
	{
		finalPanel = new JPanel();
		
		finalize = new JButton("Finalize Character Choices");
		finalize.addActionListener(new FINAL());
		
		finalPanel.add(finalize);
	}
	
	
	//ACTION LISTENERS
	private class FINAL implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{
			String align = (String) alignment.getSelectedItem();//set alignment.
			c1.setAlignment(align);
			
			if (!c1.alignmentCheck()) 		//ensures alignement is valid for the chosen class
			{
				JOptionPane.showMessageDialog(null, "Not a valid alignment for " + classChoice + "s!");
			}
			else if (pointsLeft > 0) 		//makes sure there is no unsused skill points
			{
				JOptionPane.showMessageDialog(null, "You have unspent skill points!");
			} 
			else if (	abilityScores[0] == 0 || //makes sure all abilities are not 0
						abilityScores[1] == 0 || 
						abilityScores[2] == 0 || 
						abilityScores[3] == 0 || 
						abilityScores[4] == 0 || 
						abilityScores[5] == 0	) 
			{
				JOptionPane.showMessageDialog(null, "You forgot to swap an ability score!");
			}
			else
			{
				String n = name.getText();
				String g = god.getText();
				String h = height.getText();
				String w = weight.getText();
				
				c1.setName(n);					//assign data to object
				c1.setGod(g);					//
				c1.setHeight(h);				//
				c1.setWeight(w);				//
												//
				c1.setSTR(abilityScores[0]);	//
				c1.setDEX(abilityScores[1]);	//
				c1.setCON(abilityScores[2]);	//
				c1.setINT(abilityScores[3]);	//
				c1.setWIS(abilityScores[4]);	//
				c1.setCHA(abilityScores[5]);	//
												//
				c1.setSelectedSkillPts(skillPts);//.............
				
				c1.calcStats();					//final calculation 
				
				String filename = JOptionPane.showInputDialog("Enter filename for .txt file: ");
				try 
				{
					FileWriter fw = new FileWriter(filename, true);
					PrintWriter outputFile = new PrintWriter(fw);
					
					String str = c1.toString();
					outputFile.print(str);
					outputFile.close();
				} 
				catch (IOException ioe) 
				{
					
				}
			}
		}
	}
	private class strButtonListener implements ActionListener//swap ability score with s
	{
		public void actionPerformed(ActionEvent e)
		{
			int i;
			
			i = abilityScores[0];
			abilityScores[0] = s;
			s = i;
			
			updateGUI();
		}
	}
	private class dexButtonListener implements ActionListener//......
	{
		public void actionPerformed(ActionEvent e)
		{
			int i;
			
			i = abilityScores[1];
			abilityScores[1] = s;
			s = i;
			
			updateGUI();
		}
	}
	private class conButtonListener implements ActionListener//......
	{
		public void actionPerformed(ActionEvent e)
		{
			int i;
			
			i = abilityScores[2];
			abilityScores[2] = s;
			s = i;
			
			updateGUI();
		}
	}
	private class intButtonListener implements ActionListener//......
	{
		public void actionPerformed(ActionEvent e)
		{
			int i;
			
			i = abilityScores[3];
			abilityScores[3] = s;
			s = i;
			
			updateGUI();
		}
	}
	private class wisButtonListener implements ActionListener//......
	{
		public void actionPerformed(ActionEvent e)
		{
			int i;
			
			i = abilityScores[4];
			abilityScores[4] = s;
			s = i;
			
			updateGUI();
		}
	}
	private class chaButtonListener implements ActionListener//......
	{
		public void actionPerformed(ActionEvent e)
		{
			int i;
			
			i = abilityScores[5];
			abilityScores[5] = s;
			s = i;
			
			updateGUI();
		}
	}
	private class skillBoxListener implements ActionListener//change labels based on selected skill
	{
		public void actionPerformed(ActionEvent e)
		{
			selectedSkill = (String) skillBox.getSelectedItem();
			skillIndex = (int) skillBox.getSelectedIndex();
			
			updateGUI();
		}
	}
	private class increment implements ActionListener//Increment current current skill. do nothing if there are no points left
	{
		public void actionPerformed(ActionEvent e)
		{
			if (pointsLeft <= 0) 
			{
				
			}
			else
			{
				skillPts[skillIndex] += 1;
				pointsLeft -= 1;
				
				updateGUI();
			}
		}
	}
	private class decrement implements ActionListener//decrement current skill. do nothing if current skill is zero
	{
		public void actionPerformed(ActionEvent e)
		{
			if (skillPts[skillIndex] == 0) 
			{
				
			}
			else 
			{
				skillPts[skillIndex] -= 1;
				pointsLeft += 1;
				
				updateGUI();
			}
		}
	}
	
	public static void main(String[] args) 
	{
		CharCreatorGUI w1 = new CharCreatorGUI();
	}
}