package mum.edu.project.asd;

public class Director
{
	private SpreadSheet spreadsheet;	

	public Director(SpreadSheet sps)
	{
	spreadsheet = sps;
	}

	public SpreadSheet getSpreadsheet() { return spreadsheet; }

	public void writeInCellText(int r, int c, String text)
	{
		if (text != null)
			spreadsheet.cell(r, c).setContent(new TextCell(text));	
	}
	
	public Cell cell(int row, int col) 							// Get a reference to cell at (row,col)
	{ 
		return spreadsheet.cell(row, col); 
	}		

	public String contents()
	{
		return spreadsheet.show();
	}

	private void writeInCellNumber(int i, int j, float f) {
		// TODO Auto-generated method stub
		
		spreadsheet.cell(i, j).setContent(new NumberCell(f));
		
	}
	// numerical expression sprint3
	public void WriteInCellExpression(int r,int c , NumericOperation obj) {
		
		//spreadsheet.cell(r, c).setContent(new NumericOperation());
	}
	
	public String describe()
	{
		return spreadsheet.describe();
	}

	public String examine()
	{
		return spreadsheet.examine();
	}
	
	public void buildSample()										// Build sample data for development purpose
	{
		writeInCellText(1, 1, "Airfare:");
		
		writeInCellNumber(1, 2, 485.15f);

		writeInCellText(1, 3, "");
		
		writeInCellText(1, 4, "What we pay to the airlines");

		writeInCellText(2, 1, "Taxi:");
		
		writeInCellNumber(2, 2, 118);

		writeInCellText(3, 1, "Rental Car:");
		
		writeInCellNumber(3, 2, 295.85F);
		

		writeInCellText(4, 1, "Hotel:");
		
		writeInCellNumber(4, 2, 431);

		writeInCellText(5, 1, "Meals:");
		
		writeInCellNumber(5, 2, 150);
		
		writeInCellText(5, 3, "");
		
		writeInCellText(5, 4, "This is all our meals");

		writeInCellText(7, 1, "Sub-total:");
		writeInCellNumber(7, 2, spreadsheet.cell(1, 2).data());
		
		
		//reference goes here 
		writeInCellText(7, 4, "This is just a reference to [1, 2], to test the \"Reference\" class and mechanism");
		Reference ref = new Reference(cell(1,2));
		
		
	cell(7,2).setContent(ref);
	
		
		
		writeInCellText(8, 1, "Tax:");							// Tax factor label

		
		writeInCellNumber(8, 2, 0.15f);
		
		
		writeInCellText(9, 1, "Total:");

		writeInCellText(10, 1, "Partners: ");
		
		writeInCellNumber(10, 2, 4);

		writeInCellText(11, 1, "Months: ");
		
		writeInCellNumber(11, 2, 12);
		

		writeInCellText(12, 1, "Installments:");
		

	}


}