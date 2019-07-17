package mum.edu.project.asd;

import java.util.ArrayList;
import java.util.List;

public abstract class ArthemeticOperations extends Content {
	List<Content> ref = new ArrayList<Content>();

	public float template(char c, float a, float b) {

		return evaluate(a, b);

	}

	public abstract float evaluate(float a, float b);
}
