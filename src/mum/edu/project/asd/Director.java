package mum.edu.project.asd;



public class Director {
	private SpreadSheet spreadsheet;

	public Director(SpreadSheet sps) {
		spreadsheet = sps;
	}

	public SpreadSheet getSpreadsheet() {
		return spreadsheet;
	}

	public void writeInCellText(int r, int c, String text) {
		if (text != null)
			spreadsheet.cell(r, c).setContent(new Text(text));
	}

	public Cell cell(int row, int col) // Get a reference to cell at (row,col)
	{
		return spreadsheet.cell(row, col);
	}

	public String contents() {
		return spreadsheet.show();
	}

	private void writeInCellNumber(int i, int j, float f) {
		// TODO Auto-generated method stub

		spreadsheet.cell(i, j).setContent(new Number(f));

	}

	// numerical expression sprint3
	public void WriteInCellExpression(int r, int c, ArthemeticOperations obj) {

		// spreadsheet.cell(r, c).setContent(new NumericOperation());
	}

	public String describe() {
		return spreadsheet.describe();
	}

	public String examine() {
		return spreadsheet.examine();
	}

	public void buildSample() // Build sample data for development purpose
	{
		setCell(1, 1, "Airfare:");

		setCell(1, 2, "485.15");

		setCell(1, 3, "");

		setCell(1, 4, "What we pay to the airlines");

		setCell(2, 1, "Taxi:");

		setCell(2, 2, "118");

		
		setCell(3, 1, "Rental Car:");

		// adding the total of rental car
		Add add = new Add();
		Number num1 = new Number(295);
		Number num2 = new Number(0.85f);
		add.addContent(num1);
		add.addContent(num2);

		spreadsheet.cell(3, 2).setContent(add);
		cell(3, 2).setContent(add);
		// writeInCellNumber(3, 2, add);

		setCell(4, 1, "Hotel:");

		setCell(4, 2, "431");

		setCell(5, 1, "Meals:");

		setCell(5, 2, "115+2+3+4*5*6/3-7/8");

		setCell(5, 3, "");

		setCell(5, 4, "This is all our meals");

		setCell(7, 1, "Sub-total:");

		// getting the subtotal
		Add subTotal = new Add();

		for (int i = 1; i <= 5; i++) {
			subTotal.addContent(new Reference(spreadsheet.cell(i, 2)));
		}
		//spreadsheet.cell(7, 2).setContent(subTotal);
	//	cell(7, 2).setContent(subTotal);
		setCell(7, 2, "[1,2]+[2,2]+[3,2]+[4,2]+[5,2]");
		

		// subtracting values
		Subtract subtract = new Subtract();
		for (int i = 1; i <= 5; i++) {
			subtract.subContent(new Reference(spreadsheet.cell(i, 2)));
		}

		// spreadsheet.cell(7, 3).setContent(subtract);
		// cell(7, 3).setContent(subtract);

		// muliplying values
		Multiply multiply = new Multiply();
		for (int i = 1; i <= 5; i++) {
			multiply.multContent(new Reference(spreadsheet.cell(i, 2)));
		}

		// spreadsheet.cell(7, 4).setContent(multiply);
		/// cell(7, 4).setContent(multiply);

		// writeInCellNumber(7, 2, spreadsheet.cell(1, 2).data());

		// reference goes here
		setCell(7, 4, "This is just a reference to [1, 2], to test the \"Reference\" class and mechanism");
		Reference ref = new Reference(cell(1, 2));

		
		// cell(7,2).setContent(ref);

		setCell(8, 1, "Tax:"); // Tax factor label

		setCell(8, 2, "0.15");

		setCell(9, 1, "Total:");

		// calculating total

		Multiply multiply2 = new Multiply();
		multiply2.multContent(new Reference(cell(7, 2)));
		multiply2.multContent(new Reference(cell(8, 2)));

		Subtract subtract2 = new Subtract();
		subtract2.subContent(new Reference(cell(7, 2)));
		subtract2.subContent(new Number(multiply2.data()));

		//spreadsheet.cell(9, 2).setContent(subtract2);
	//	cell(9, 2).setContent(subtract2);

		
		setCell(9, 2, "[7,2]*(1-[8,2])");
		
		
		Group group = new Group();
		//group.evaluate(new Number(1.0f), new Reference(cell(8, 2)), "*");
		//group.evaluate(new Reference(cell(7, 2)), group, "-");

		setCell(10, 1, "Partners: ");

		setCell(10, 2, "4");

		setCell(11, 1, "Months: ");

		setCell(11, 2, "12");

		writeInCellText(12, 1, "Installments:");
		Division division = new Division();
		division.divideContent(new Reference(cell(9, 2)));
		division.divideContent(new Reference(cell(10, 2)));
		division.divideContent(new Reference(cell(11, 2)));

		spreadsheet.cell(12, 2).setContent(division);
		cell(12, 2).setContent(division);
		
		setCell(13, 1, "1+3+(6-4)*((2+6)+2)/2");
		
		setCell(14, 1, "[13,1]+(3-2)");

	}

	private void setCell(int row, int col, String string) {

		if (isNumber(string)) {
			spreadsheet.cell(row, col).setContent(new Number(Float.parseFloat(string)));
		} else if (isExpression(string)) {
			spreadsheet.cell(row, col).setContent(new Group(string, spreadsheet));
		} else {
			spreadsheet.cell(row, col).setContent(new Text(string));

		}

	}

	
	// check if it is numberic value or string
	public boolean isNumber(String string) {
		if (string == null || string.isEmpty()) {
			return false;
		}
		int i = 0;
		int stringLength = string.length();
		if (string.charAt(0) == '-') {
			if (stringLength > 1) {
				i++;
			} else {
				return false;
			}
		}
		if (!Character.isDigit(string.charAt(i)) || !Character.isDigit(string.charAt(stringLength - 1))) {
			return false;
		}
		i++;
		stringLength--;
		if (i >= stringLength) {
			return true;
		}
		for (; i < stringLength; i++) {
			if (!Character.isDigit(string.charAt(i)) && string.charAt(i) != '.') {
				return false;
			}
		}
		return true;
	}

	public boolean isExpression(String string) {

		boolean formula = false;

		String[] str = null;
		if (string.contains("+") || string.contains("-") || string.contains("*") || string.contains("/")) {

			str = string.split("[,-\\[\\]+*/\\(\\)]");
			formula = true;
			
		}

		if (formula) {
			for (String s : str) {
				
				if (!isNumber(s)) {
					return false;
				}
				System.out.println(s);
			}
		}

		return formula;
	}
}