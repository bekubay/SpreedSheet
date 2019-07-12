package mum.edu.project.asd;

public class Reference extends Content{

	private Cell cell ;
	public Reference(Cell cell) {
		//super(cell);		
		this.cell = cell;
	}

	@Override
	public String value() {
		// TODO Auto-generated method stub
		return Float.toString(cell.data());
	}

	@Override
	public String formula() {
		// TODO Auto-generated method stub
		return cell.getCoordinates();
	}

	@Override
	public float data() {
		// TODO Auto-generated method stub
		return (cell.data());
	}

}
