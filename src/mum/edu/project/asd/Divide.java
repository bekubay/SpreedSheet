package mum.edu.project.asd;

import java.util.ArrayList;
import java.util.List;

public class Divide extends NumericOperation {

	private float quotient = 0.0f;
	private int counter = 0;
	List<Reference> ref = new ArrayList<Reference>();

	@Override
	public String value() {
		// TODO Auto-generated method stub
		return Float.toString(quotient);
	}

	@Override
	public String formula() {

		StringBuffer sBuffer = new StringBuffer("(");
		for (int i = 0; i < ref.size(); i++) {
			if (i != ref.size() - 1) {
				sBuffer.append(ref.get(i).formula() + "/");
			} else {
				sBuffer.append(ref.get(i).formula() + ")");

			}

		}

		return sBuffer.toString();
	}

	@Override
	public float data() {
		// TODO Auto-generated method stub
		return quotient;
	}

	public void divideContent(Content content) {

		if (content.data() != 0) {
			if (counter == 0) {
				quotient = content.data();
				counter++;
				ref.add((Reference) content);
			} else {
				quotient /= content.data();
				ref.add((Reference) (content));
			}

		}
	}

}
