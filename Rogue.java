import java.util.Random;

public class Rogue extends Race
{
	private int HP;
	private int fortSave;
	private int reflexSave;
	private int willSave;
	private int meleeAttack;
	private int rangedAttack;
	private int gold;
	
	private int startingSkillPts;
	
	private int[] skillPointArray = new int[52];
	private String[][] SKILL_META_DATA = 		
												/*
												U  = can be used Untrained
												BA = Barbarian
												BD = Bard
												CL = Cleric
												DR = Druid
												FI = Fighter
												MO = Monk
												PA = Paladin
												RA = Ranger
												RO = Rogue
												SO = Sorcerer
												WI = Wizard
												*/ 
											{
												{"Appraise", "U BD RO"},
												{"AutoHypnosis", ""},
												{"Balance", "U BD MO RO"},
												{"Bluff", "U BD RO SO"},
												{"Climb", "U BA BD FI MO RA RO"},
												{"Concentration", "U BD CL DR MO PA RA SO WI"},
												{"Craft", "U BA BD CL FI MO PA RA RO SO WI"},
												{"Decipher Script", "BD RO WI"},
												{"Diplomacy", "U BD CL DR MO PA RO"},
												{"Disable Device", "RO"},
												{"Disguise", "U BD RO"},
												{"Escape Artist", "U BD MO RO"},
												{"Forgery", "U RO"},
												{"Gather Information", "U BD RO"},
												{"Handle Animal", "BA DR FI PA RA"},
												{"Heal", "U CL DR PA RA"},
												{"Hide", "U BD MO RA RO"},
												{"Intimidate", "U BA FI RO"},
												{"Jump", "U BA BD FI MO RA RO"},
												{"Knowledge (Arcana)", "BD CL MO SO WI"},
												{"Knowledge (Arch/Eng)", "BD WI"},
												{"Knowledge (Dungeoneering)", "BD RA WI"},
												{"Knowledge (Geography)", "BD RA WI"},
												{"Knowledge (History)", "BD CL WI"},
												{"Knowledge (Local)", "BD RO WI"},
												{"Knowledge (Nature)", "BD DR RA WI"},
												{"Knowledge (Nobility/Royalty)", "BD PA WI"},
												{"Knowledge (The Planes)", "BD CL WI"},
												{"Knowledge (Psionics)", "BD WI"},
												{"Knowledge (Religion)", "BD CL MO PA WI"},
												{"Listen", "U BD DR MO RA RO"},
												{"Move Silently", "U BD MO RA RO"},
												{"Open Lock", "RO"},
												{"Perform (Act)", "U BD MO RO"},
												{"Perform (Comedy)", "U BD MO RO"},
												{"Perform (Dance)", "U BD MO RO"},
												{"Perform (Instrument)", "U BA MO RO"},
												{"Perform (Sing)", "U BD MO RO"},
												{"Profession", "BD CL DR MO PA RA RO SO WI"},
												{"Psicraft", ""},
												{"Ride", "U BA DR FI PA RA"},
												{"Search", "U RA RO"},
												{"Sense Motive", "U BD MO PA RO"},
												{"Sleight of Hand", "BD RO"},
												{"Spellcraft", "BD CL DR SO WI"},
												{"Spot", "U DR MO RA RO"},
												{"Survival", "U BA DR RA"},
												{"Swim", "U BA BD DR FI MO RA RO"},
												{"Tumble", "BD MO RO"},
												{"Use Magic Device", "BD RO"},
												{"Use Psionic Device", ""},
												{"Use Rope", "U RA RO"},
											};
	
	
	
	//CONSTRUCTOR
	public Rogue() 
	{
		setCharClass("Rogue");
	}
	public Rogue(String n, String r) 
	{
		setName(n);
		setRace(r);
		setCharClass("Rogue");
	}
	
	
	
	//METHODS
	public void calcStats()
	{
		racialApp();
		
		Random rand = new Random();
		
		HP = 6 + getCONMod();
		fortSave = 0 + getCONMod();
		reflexSave = 2 + getDEXMod();
		willSave = 0 + getWISMod();
		meleeAttack = 0 + getSTRMod();
		rangedAttack = 0 + getDEXMod();
		gold = (	(1 + rand.nextInt(4)) + 
					(1 + rand.nextInt(4)) + 
					(1 + rand.nextInt(4)) + 
					(1 + rand.nextInt(4)) + 
					(1 + rand.nextInt(4))	) * 10;
		
		applyRaceMods();
	}
	public void calcStartingSkillPoints()
	{
		startingSkillPts = (8 + getINTMod()) * 4;
		
		if (getRace() == "Human") 
		{
			startingSkillPts += 4;
		}
	}
	public boolean alignmentCheck()			//returns true for appropriate alignment
	{
		return true;
	}///////////////////////////////////////////////////////////////////
	public void applyRaceMods()
	{
		if (getRace() == "Elf") 
		{
			skillPointArray[30] += 2;	//Listen
			skillPointArray[41] += 2;	//Search
			skillPointArray[45] += 2;	//Spot
		}
		else if (getRace() == "Gnome") 
		{
			skillPointArray[30] += 2;	//Listen
			skillPointArray[6] += 2;	//Craft
		}
		else if (getRace() == "Half-Elf") 
		{
			skillPointArray[30] += 1;	//Listen
			skillPointArray[41] += 1;	//Search
			skillPointArray[45] += 1;	//Spot
			skillPointArray[8] += 2;	//Diplomacy
			skillPointArray[13] += 2;	//Gather Information
		}
		else if (getRace() == "Halfling") 
		{
			skillPointArray[4] += 2;	//Climb
			skillPointArray[18] += 2;	//Jump
			skillPointArray[30] += 2;	//Listen
			skillPointArray[31] += 2;	//Move Silently
			
			fortSave += 1;
			reflexSave += 1;
			willSave += 1;
		}
	}
	//
	public void setHP(int hp)	
	{	
		HP = hp;
	}
	public int getHP()
	{
		return HP;
	}
	//
	public void setFortSave(int fort)
	{
		fortSave = fort;
	}
	public int getFortSave()
	{
		return fortSave;
	}
	//
	public void setReflexSave(int flex)
	{
		reflexSave = flex;
	}
	public int getReflexSave()
	{
		return reflexSave;
	}
	//
	public void setWillSave(int will)
	{
		willSave = will;
	}
	public int getWillSave()
	{
		return willSave;
	}
	//
	public void setMeleeAttack(int attack)
	{
		meleeAttack = attack;
	}
	public int getMeleeAttack()
	{
		return meleeAttack;
	}
	//
	public void setRangedAttack(int attack)
	{
		rangedAttack = attack;
	}
	public int getRangedAttack()
	{
		return rangedAttack;
	}
	//
	public void setGold(int g)
	{
		gold = g;
	}
	public int getGold()
	{
		return gold;
	}
	public int getStartingSkillPts()
	{
		calcStartingSkillPoints();
		return startingSkillPts;
	}
	//
	//
	//SKILLS
	//
	//
	public void setSelectedSkillPts(int[] x)	
	{	
		System.arraycopy( x, 0, skillPointArray, 0, x.length );
	}
	public int[] getSkillPtsArray()
	{
		return skillPointArray;
	}
	public String[][] getSkillMetaData()
	{
		return SKILL_META_DATA;
	}
	public String toString()
	{
		String str = 	"Name: " + getName() +
						"\nRace: " + getRace() +
						"\nClass: " + getCharClass() + " Lvl. " + getLevel() +
						"\nAlignment: " + getAlignment() +
						"\nGod: " + getGod() +
						"\nHeight: " + getHeight() +
						"\nWeight: " + getWeight() +
						"\nSpeed: " + getSpeed() + "ft" +
						
						"\nSTR: " + String.format("%5d", getSTR()) + 
							"\t\tMod: " + String.format("%5d", getSTRMod()) +
						"\nDEX: " + String.format("%5d", getDEX()) + 
							"\t\tMod: " + String.format("%5d", getDEXMod()) +
						"\nCON: " + String.format("%5d", getCON()) + 
							"\t\tMod: " + String.format("%5d", getCONMod()) +
						"\nINT: " + String.format("%5d", getINT()) + 
							"\t\tMod: " + String.format("%5d", getINTMod()) +
						"\nWIS: " + String.format("%5d", getWIS()) + 
							"\t\tMod: " + String.format("%5d", getWISMod()) +
						"\nCHA: " + String.format("%5d", getCHA()) + 
							"\t\tMod: " + String.format("%5d", getCHAMod()) +
							
						"\n\nSTATS:" + 
						"\n\tHP:\t\t\t" + String.format("%5d", HP) +
						"\n\tFortitude Save:\t\t" + String.format("%5d", fortSave) +
						"\n\tReflex Save:\t\t" + String.format("%5d", reflexSave) +
						"\n\tWill Save:\t\t" + String.format("%5d", willSave) +
						"\n\tMelee Attack:\t\t" + String.format("%5d", meleeAttack) +
						"\n\tRanged Attack:\t\t" + String.format("%5d", rangedAttack) +
						"\n\tStarting Gold:\t\t" + String.format("%5d", gold) +
						
						"\n\nSKILLS("+ startingSkillPts +")";
		
		String skill = "";
		int i;//row counter
		
		for (i = 0; i < 52; i++) 
		{
			//skip skills character cant use
			if (SKILL_META_DATA[i][1].contains("U")
					||
				SKILL_META_DATA[i][1].contains("RO")
					||
				skillPointArray[i] > 0) 
			{
				//add skills to be printed to skill string
				skill += "\n\t" + SKILL_META_DATA[i][0] + ":\n" + String.format("%10d", skillPointArray[i]);
			}

		}
		
		//append skill string to str
		str += skill;
		
		
		return str;
	}
}