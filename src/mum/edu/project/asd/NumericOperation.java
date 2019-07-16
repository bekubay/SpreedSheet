package mum.edu.project.asd;

public  class NumericOperation extends Content {

	@Override
	public String value() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String formula() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float data() {
		// TODO Auto-generated method stub
		return 0;
	}

	public float operate(char c, float a, float b) {

		if (c == '+') {
			return addOperatation(a, b);
		}
		return b;

	}

	private float addOperatation(float a, float b) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
