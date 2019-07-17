package mum.edu.project.asd;

import java.util.ArrayList;
import java.util.List;

public class Add extends ArthemeticOperations {

	private float addNumber = 0.0f;

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

	@Override
	public float evaluate(float a, float b) {
		// TODO Auto-generated method stub
		return a + b;
	}
}
