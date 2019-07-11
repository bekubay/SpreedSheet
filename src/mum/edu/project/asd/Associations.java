package mum.edu.project.asd;

import Framework.OneToOne;

public class Associations
{
	static public OneToOne<Cell, Content> cellIsMadeOfContents = new OneToOne<Cell, Content>("Contains", "Belongs To", "Owner", "Contents");
	
	static public String report()
	{
		StringBuilder str = new StringBuilder();
		
		str.append(cellIsMadeOfContents);
		
		return str.toString();
	}

}
