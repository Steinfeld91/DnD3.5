public abstract class Race extends DnDCharacter
{
	private String race;
	private String size;
	private int speed;
	private int STR;
	private int DEX;
	private int CON;
	private int INT;
	private int WIS;
	private int CHA;
	private int strMod = 0;
	private int dexMod = 0;
	private int conMod = 0;
	private int intMod = 0;
	private int wisMod = 0;
	private int chaMod = 0;
	private int STRraceMod = 0;
	private int DEXraceMod = 0;
	private int CONraceMod = 0;
	private int INTraceMod = 0;
	private int WISraceMod = 0;
	private int CHAraceMod = 0;
	
	
	
	//CONSTRUCTORS
	public Race() {}
	public Race(String n, String r) 
	{
		setName(n);
		race = r;
	}
	
	
	
	public void racialApp()
	{
		if (race == "Human") 
		{
			size = "Medium";
			speed = 30;
		}
		else if (race == "Dwarf") 
		{
			size = "Medium";
			speed = 20;
			CONraceMod = 2;
			CHAraceMod = -2;
		}
		else if (race == "Elf") 
		{
			size = "Medium";
			speed = 30;
			DEXraceMod = 2;
			CONraceMod = -2;
		}
		else if (race == "Gnome") 
		{
			size = "Small";
			speed = 20;
			CONraceMod = 2;
			STRraceMod = -2;
		}
		else if (race == "Half-Elf") 
		{
			size = "Medium";
			speed = 30;
		}
		else if (race == "Half-Orc") 
		{
			size = "Medium";
			speed = 30;
			STRraceMod = 2;
			INTraceMod = -2;
			CHAraceMod = -2;
		}
		else if (race == "Halfling") 
		{
			size = "Small";
			speed = 20;
			DEXraceMod = 2;
			STRraceMod = -2;
		}
		
		calcMods();
	}
	//
	public void calcMods()
	{
		int STRnRace = STR + STRraceMod;
		int DEXnRace = DEX + DEXraceMod;
		int CONnRace = CON + CONraceMod;
		int INTnRace = INT + INTraceMod;
		int WISnRace = WIS + WISraceMod;
		int CHAnRace = CHA + CHAraceMod;
		STR = STRnRace;
		DEX = DEXnRace;
		CON = CONnRace;
		INT = INTnRace;
		WIS = WISnRace;
		CHA = CHAnRace;
		
		if (race == "Half-Orc" && INTnRace < 3) 
		{
			INT = 3;
		}
		
		switch (STRnRace) 
		{
			case 20:
				strMod = 5;
				break;
			case 19:
			case 18:
				strMod = 4;
				break;
			case 17:
			case 16:
				strMod = 3;
				break;
			case 15:
			case 14:
				strMod = 2;
				break;
			case 13:
			case 12:
				strMod = 1;
				break;
			case 9:
			case 8:
				strMod = -1;
				break;
			case 7:
			case 6:
				strMod = -2;
				break;
			case 5:
			case 4:
				strMod = -3;
				break;
			case 3:
			case 2:
				strMod = -4;
				break;
			case 1:
				strMod = -5;
				break;
			default:
				break;
		}
		switch (DEXnRace) 
		{
			case 20:
				dexMod = 5;
				break;
			case 19:
			case 18:
				dexMod = 4;
				break;
			case 17:
			case 16:
				dexMod = 3;
				break;
			case 15:
			case 14:
				dexMod = 2;
				break;
			case 13:
			case 12:
				dexMod = 1;
				break;
			case 9:
			case 8:
				dexMod = -1;
				break;
			case 7:
			case 6:
				dexMod = -2;
				break;
			case 5:
			case 4:
				dexMod = -3;
				break;
			case 3:
			case 2:
				dexMod = -4;
				break;
			case 1:
				dexMod = -5;
				break;
			default:
				break;
		}
		switch (CONnRace) 
		{
			case 20:
				conMod = 5;
				break;
			case 19:
			case 18:
				conMod = 4;
				break;
			case 17:
			case 16:
				conMod = 3;
				break;
			case 15:
			case 14:
				conMod = 2;
				break;
			case 13:
			case 12:
				conMod = 1;
				break;
			case 9:
			case 8:
				conMod = -1;
				break;
			case 7:
			case 6:
				conMod = -2;
				break;
			case 5:
			case 4:
				conMod = -3;
				break;
			case 3:
			case 2:
				conMod = -4;
				break;
			case 1:
				conMod = -5;
				break;
			default:
				break;
		}
		switch (INTnRace) 
		{
			case 20:
				intMod = 5;
				break;
			case 19:
			case 18:
				intMod = 4;
				break;
			case 17:
			case 16:
				intMod = 3;
				break;
			case 15:
			case 14:
				intMod = 2;
				break;
			case 13:
			case 12:
				intMod = 1;
				break;
			case 9:
			case 8:
				intMod = -1;
				break;
			case 7:
			case 6:
				intMod = -2;
				break;
			case 5:
			case 4:
				intMod = -3;
				break;
			case 3:
			case 2:
				intMod = -4;
				break;
			case 1:
				intMod = -5;
				break;
			default:
				break;
		}
		switch (WISnRace) 
		{
			case 20:
				wisMod = 5;
				break;
			case 19:
			case 18:
				wisMod = 4;
				break;
			case 17:
			case 16:
				wisMod = 3;
				break;
			case 15:
			case 14:
				wisMod = 2;
				break;
			case 13:
			case 12:
				wisMod = 1;
				break;
			case 9:
			case 8:
				wisMod = -1;
				break;
			case 7:
			case 6:
				wisMod = -2;
				break;
			case 5:
			case 4:
				wisMod = -3;
				break;
			case 3:
			case 2:
				wisMod = -4;
				break;
			case 1:
				wisMod = -5;
				break;
			default:
				break;
		}
		switch (CHAnRace) 
		{
			case 20:
				chaMod = 5;
				break;
			case 19:
			case 18:
				chaMod = 4;
				break;
			case 17:
			case 16:
				chaMod = 3;
				break;
			case 15:
			case 14:
				chaMod = 2;
				break;
			case 13:
			case 12:
				chaMod = 1;
				break;
			case 9:
			case 8:
				chaMod = -1;
				break;
			case 7:
			case 6:
				chaMod = -2;
				break;
			case 5:
			case 4:
				chaMod = -3;
				break;
			case 3:
			case 2:
				chaMod = -4;
				break;
			case 1:
				chaMod = -5;
				break;
			default:
				break;
		}
	}
	//
	public void setRace(String r)
	{
		race = r;
	}
	public String getRace()
	{
		return race;
	}
	//
	public void setSize(String s)
	{
		size = s;
	}
	public String getSize()
	{
		return size;
	}
	//
	public void setSpeed(int s)
	{
		speed = s;
	}
	public int getSpeed()
	{
		return speed;
	}
	//
	public void setSTR(int S)
	{
		STR = S;
	}
	public int getSTR()
	{
		return STR;
	}
	//
	public void setDEX(int D)
	{
		DEX = D;
	}
	public int getDEX()
	{
		return DEX;
	}
	//
	public void setCON(int C)
	{
		CON = C;
	}
	public int getCON()
	{
		return CON;
	}
	//
	public void setINT(int I)
	{
		INT = I;
	}
	public int getINT()
	{
		return INT;
	}
	//
	public void setWIS(int W)
	{
		WIS = W;
	}
	public int getWIS()
	{
		return WIS;
	}
	//
	public void setCHA(int C)
	{
		CHA = C;
	}
	public int getCHA()
	{
		return CHA;
	}
	//
	public void setSTRMod(int s)
	{
		strMod = s;
	}
	public int getSTRMod()
	{
		return strMod;
	}
	//
	public void setDEXMod(int d)
	{
		dexMod = d;
	}
	public int getDEXMod()
	{
		return dexMod;
	}
	//
	public void setCONMod(int c)
	{
		conMod = c;
	}
	public int getCONMod()
	{
		return conMod;
	}
	//
	public void setINTMod(int i)
	{
		intMod = i;
	}
	public int getINTMod()
	{
		return intMod;
	}
	//
	public void setWISMod(int w)
	{
		wisMod = w;
	}
	public int getWISMod()
	{
		return wisMod;
	}
	//
	public void setCHAMod(int c)
	{
		chaMod = c;
	}
	public int getCHAMod()
	{
		return chaMod;
	}
	//
	public void setSTRraceMod(int s)
	{
		STRraceMod = s;
	}
	public int getSTRraceMod()
	{
		return STRraceMod;
	}
	//
	public void setDEXraceMod(int d)
	{
		DEXraceMod = d;
	}
	public int getDEXraceMod()
	{
		return DEXraceMod;
	}
	//
	public void setCONraceMod(int c)
	{
		CONraceMod = c;
	}
	public int getCONraceMod()
	{
		return CONraceMod;
	}
	//
	public void setINTraceMod(int i)
	{
		INTraceMod = i;
	}
	public int getINTraceMod()
	{
		return INTraceMod;
	}
	//
	public void setWISraceMod(int w)
	{
		WISraceMod = w;
	}
	public int getWISraceMod()
	{
		return WISraceMod;
	}
	//
	public void setCHAraceMod(int c)
	{
		CHAraceMod = c;
	}
	public int getCHAraceMod()
	{
		return CHAraceMod;
	}
	//
	//
	//
	//ABSTRACTS
	public abstract int getStartingSkillPts();
	public abstract String[][] getSkillMetaData();
	public abstract void setSelectedSkillPts(int[] x);
	public abstract void calcStats();
	public abstract boolean alignmentCheck();
	//
	//
	//
	public String toString()
	{
		String str = 	"Name: " + getName() +
						"\nAlignment: " + getAlignment() +
						"\nGod: " + getGod() +
						"\nHeight: " + getHeight() +
						"\nWeight: " + getWeight() +
						"\nRace: " + race +
						"\nSpeed: " + speed + "ft" +
						"\nSTR: " + STR + "		Mod: " + strMod +
						"\nDEX: " + DEX + "		Mod: " + dexMod +
						"\nCON: " + CON + "		Mod: " + conMod +
						"\nINT: " + INT + "		Mod: " + intMod +
						"\nWIS: " + WIS + "		Mod: " + wisMod +
						"\nCHA: " + CHA + "		Mod: " + chaMod;
		
		return str;
	}
}