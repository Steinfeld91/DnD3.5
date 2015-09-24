public class DnDCharacter 
{
	//Character Info
	private String name;
	private String charClass;
	private String alignment;
	private String god;
	private String height;
	private String weight;
	private final int LEVEL = 1;
	
	
		
	//CONSTRUCTORS
	public DnDCharacter() {}
	public DnDCharacter(String n)
	{
		name = n;
	}
	
	
	
	//METHODS
	public void setName(String n)
	{
		name = n;
	}
	public String getName()
	{
		return name;
	}
	//
	public void setCharClass(String c)
	{
		charClass = c;
	}
	public String getCharClass()
	{
		return charClass;
	}
	//
	public int getLevel()
	{
		return LEVEL;
	}
	//
	public void setAlignment(String a)
	{
		alignment = a;
	}
	public String getAlignment()
	{
		return alignment;
	}
	//
	public void setGod(String g)
	{
		god = g;
	}
	public String getGod()
	{
		return god;
	}
	//
	public void setHeight(String h)
	{
		height = h;
	}
	public String getHeight()
	{
		return height;
	}
	//
	public void setWeight(String w)
	{
		weight = w;
	}
	public String getWeight()
	{
		return weight;
	}
}