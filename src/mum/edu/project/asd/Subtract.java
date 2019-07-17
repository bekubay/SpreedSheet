package mum.edu.project.asd;

import java.util.ArrayList;
import java.util.List;

public class Subtract extends ArthemeticOperations {

	private float subResult = 0.0f;
	private int counter = 0;

	@Override
	public String value() {
		// TODO Auto-generated method stub
		return Float.toString(subResult);
	}

	@Override
	public String formula() {
		StringBuffer sBuffer = new StringBuffer("(");
		// int count = 0;
		for (int i = 0; i < ref.size(); i++) {
			if (i != ref.size() - 1) {
				sBuffer.append(ref.get(i).formula() + "-");
			} else {
				sBuffer.append(ref.get(i).formula() + ")");

			}

		}

		return sBuffer.toString();
	}

	@Override
	public float data() {
		// TODO Auto-generated method stub
		return subResult;
	}

	public void subContent(Content content) {

		if (counter == 0) {
			subResult += content.data();
			ref.add(content);
			counter++;
		} else {
			subResult -= content.data();

			ref.add(content);

		}
	}

	@Override
	public float evaluate(float a, float b) {
		// TODO Auto-generated method stub
		return a - b;
	}
}
