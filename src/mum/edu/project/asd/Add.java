package mum.edu.project.asd;

import java.util.ArrayList;
import java.util.List;

public class Add extends NumericOperation {

	private float addNumber = 0.0f;
	List<Content> ref = new ArrayList<Content>();

	@Override
	public String value() {
		// TODO Auto-generated method stub
		return Float.toString(addNumber);
	}

	// get the reference of the added cells
	@Override
	public String formula() {
		// TODO Auto-generated method stub

		StringBuffer sBuffer = new StringBuffer("(");
		int count = 0;
		for (int i = 0; i < ref.size(); i++) {
			if (i != ref.size() - 1) {
				sBuffer.append(ref.get(i).formula() + "+");
			} else {
				sBuffer.append(ref.get(i).formula() + ")");

			}

		}

		return sBuffer.toString();
	}

	@Override
	public float data() {
		// TODO Auto-generated method stub
		return addNumber;
	}

	public void addContent(Content content) {

		addNumber += content.data();
		ref.add(content);

	}
	
	public float addOperatation(float a, float b) {
		 
		return a+b;
	}
}
