package mum.edu.project.asd;

import java.util.ArrayList;
import java.util.List;

public class Group extends NumericOperation{

	private float value;
	List<Content> ref = new ArrayList<Content>();
	
	
	@Override
	public String value() {
		// TODO Auto-generated method stub
		return Float.toString(value);
	}

	@Override
	public String formula() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float data() {
		// TODO Auto-generated method stub
		return value;
	}

	public void evaluate(Content content1, Content content2, String operation) {
		
		switch (operation) {
		case "+": 
			Add add = new Add();
			add.addContent(content1);
			add.addContent(content2);
			ref.add(content1);
			ref.add(content2);
			break;
		case "-":
			Subtract subtract = new Subtract();
			subtract.subContent(content1);
			subtract.subContent(content2);
			ref.add(content1);
			ref.add(content2);
			break;
		case "*":
			Multiply multiply = new Multiply();
			multiply.multContent(content1);
			multiply.multContent(content2);
			ref.add(content1);
			ref.add(content2);
			break;
		case "/":
			Division division = new Division();
			division.divideContent(content1);
			division.divideContent(content2);
			ref.add(content1);
			ref.add(content2);
			break;

		default: 
			System.out.println("Invalid Operation !!!!");
			break;
		}
	}
}
