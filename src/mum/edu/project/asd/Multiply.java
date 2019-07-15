package mum.edu.project.asd;

import java.util.ArrayList;
import java.util.List;

public class Multiply extends NumericOperation {

	private float products = 1.0f;
	List<Content> ref = new ArrayList<Content>();

	public List<Content> getRef() {
		return ref;
	}

	@Override
	public String value() {
		// TODO Auto-generated method stub
		return Float.toString(products);
	}

	@Override
	public String formula() {
		// TODO Auto-generated method stub

		StringBuffer sBuffer = new StringBuffer("(");
		for (int i = 0; i < ref.size(); i++) {
			if (i != ref.size() - 1) {
				sBuffer.append(ref.get(i).formula() + "*");
			} else {
				sBuffer.append(ref.get(i).formula() + ")");

			}

		}

		return sBuffer.toString();
	}

	@Override
	public float data() {
		// TODO Auto-generated method stub
		return products;
	}

	public void multContent(Content content) {

		products *= content.data();

		ref.add(content);
	}

}
