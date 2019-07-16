package mum.edu.project.asd;

public abstract class NumericOperation extends Content {

	public float template(char c, float a, float b) {

		return operate(a, b);

	}

	public abstract float operate(float a, float b);
}
