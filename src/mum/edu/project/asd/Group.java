package mum.edu.project.asd;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Group extends NumericOperation {

	private float value;

	List<NumericOperation> mOperations = new ArrayList<NumericOperation>();
	List<String> myDataList = new ArrayList<String>();

	public List<NumericOperation> getNumericOperation() {
		return mOperations;
	}

	public Group(String string) {
		this.value = evaluate(string);
	}

	public Group() {

	}

	@Override
	public String value() {
		// TODO Auto-generated method stub
		return Float.toString(value);
	}

	@Override
	public String formula() {
		// TODO Auto-generated method stub

		StringBuffer sBuffer = new StringBuffer("[");
		for (String string : myDataList) {
			sBuffer.append(string);
		}
		sBuffer.append("] --> ");

		for (int i = 0; i < (myDataList.size() - 1) / 2; i++) {
			sBuffer.append("(");
		}
		
		int count = 0;
		sBuffer.append(myDataList.get(0));

		for (int i = 1; i < myDataList.size(); i++) {
			sBuffer.append(myDataList.get(i));
			count++;
			if (count >= 2) {
				count = 0;

				sBuffer.append(")");
			}
		}

		return sBuffer.toString();
	}

	@Override
	public float data() {
		// TODO Auto-generated method stub
		return value;
	}

	public float evaluate(String expression) {

		char[] tokens = expression.toCharArray();

		for (Character character : tokens) {

		}
		// Stack for numbers: 'values'
		Stack<Float> values = new Stack<Float>();

		// Stack for Operators: 'ops'
		Stack<Character> ops = new Stack<Character>();

		for (int i = 0; i < tokens.length; i++) {
			// Current token is a whitespace, skip it
			if (tokens[i] == ' ')
				continue;

			if (tokens[i] >= '0' && tokens[i] <= '9') {
				StringBuilder sb = new StringBuilder();
				sb.append(tokens[i]);
				// There may be more than one digits in number
				while (i + 1 < tokens.length && tokens[i + 1] >= '0' && tokens[i + 1] <= '9') {
					sb.append(tokens[++i]);
				}
				values.push(Float.parseFloat(sb.toString()));
				myDataList.add(sb.toString());
			}

			else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
				// While top of 'ops' has same or greater precedence to current
				// token, which is an operator. Apply operator on top of 'ops'
				// to top two elements in values stack
				while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
					values.push(calculate(ops.pop(), values.pop(), values.pop()));

				// Push current token to 'ops'.
				ops.push(tokens[i]);
				myDataList.add(tokens[i] + "");
			}
		}

		// Entire expression has been parsed at this point, apply remaining
		// ops to remaining values
		while (!ops.empty())
			values.push(calculate(ops.pop(), values.pop(), values.pop()));

		// Top of 'values' contains result, return it
		return values.pop();
	}

	// Returns true if 'op2' has higher or same precedence as 'op1',
	// otherwise returns false.
	public static boolean hasPrecedence(char op1, char op2) {

		if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
			return false;
		else
			return true;
	}

	// A utility method to apply an operator 'op' on operands 'a'
	// and 'b'. Return the result.

	public float calculate(char op, float b, float a) {

		switch (op) {
		case '+':
			NumericOperation add = new Add();
			mOperations.add(add);
			return add.operate(a, b);
		case '-':
			NumericOperation sub = new Subtract();
			mOperations.add(sub);
			return sub.operate(a, b);
		case '*':
			NumericOperation multi = new Multiply();
			mOperations.add(multi);
			return multi.operate(a, b);
		case '/':
			NumericOperation div = new Division();
			mOperations.add(div);
			return div.operate(a, b);
		}
		return 0;
	}

	@Override
	public float operate(float a, float b) {
		// TODO Auto-generated method stub
		return 0;
	}

}
