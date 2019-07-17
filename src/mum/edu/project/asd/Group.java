package mum.edu.project.asd;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Group extends ArthemeticOperations {

	private float value;

	List<ArthemeticOperations> operations = new ArrayList<ArthemeticOperations>();
	List<String> elementStrings = new ArrayList<String>();

	public List<ArthemeticOperations> getNumericOperation() {
		return operations;
	}

	public Group(String st, SpreadSheet spreadsheet) {
		this.value = analyze(st, spreadsheet);
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

		StringBuffer sb = new StringBuffer("[");
		for (String string : elementStrings) {
			sb.append(string);
		}
		sb.append("] --> ");

		for (int i = 0; i < (elementStrings.size() - 1) / 2; i++) {
			sb.append("(");
		}

		int count = 0;
		sb.append(elementStrings.get(0));

		for (int i = 1; i < elementStrings.size(); i++) {
			sb.append(elementStrings.get(i));
			count++;
			if (count >= 2) {
				count = 0;
				sb.append(")");
			}
		}

		return sb.toString();
	}

	@Override
	public float data() {
		// TODO Auto-generated method stub
		return value;
	}

	public float analyze(String exp, SpreadSheet spreadSheet) {

		char[] chars = exp.toCharArray();

		// Stack to store number
		Stack<Float> values = new Stack<Float>();

		// Stack to store operations
		Stack<Character> operations = new Stack<Character>();

		for (int i = 0; i < chars.length; i++) {

			if (chars[i] == ' ')
				continue;

			if (chars[i] == '[') {

				int indexClose = exp.indexOf(']', i);
				String cell = exp.substring(i + 1, indexClose);

				String[] cellCoordinate = cell.split(",");
				int row = Integer.parseInt(cellCoordinate[0]);
				int col = Integer.parseInt(cellCoordinate[1]);
				Cell ref = spreadSheet.cell(row, col);

				if (ref.value() == null || ref.value().trim().isEmpty()) {
					values.push(0f);
				} else {
					values.push(Float.parseFloat(ref.value()));
				}
				elementStrings.add("[" + cell + "]");

				i = indexClose;

			}

			if (chars[i] >= '0' && chars[i] <= '9') {
				StringBuilder sb = new StringBuilder();
				sb.append(chars[i]);
				// There may be more than one digits in number
				while (i + 1 < chars.length && chars[i + 1] >= '0' && chars[i + 1] <= '9') {
					sb.append(chars[++i]);
				}
				values.push(Float.parseFloat(sb.toString()));
				elementStrings.add(sb.toString());
			}

			else if (chars[i] == '(')
				operations.push(chars[i]);

			else if (chars[i] == ')') {
				while (operations.peek() != '(')
					values.push(calculate(operations.pop(), values.pop(), values.pop()));
				operations.pop();
			}

			else if (chars[i] == '+' || chars[i] == '-' || chars[i] == '*' || chars[i] == '/') {

				while (!operations.empty() && hasPrecedence(chars[i], operations.peek()))
					values.push(calculate(operations.pop(), values.pop(), values.pop()));

				operations.push(chars[i]);
				elementStrings.add(chars[i] + "");
			}
		}

		while (!operations.empty())
			values.push(calculate(operations.pop(), values.pop(), values.pop()));

		return values.pop();
	}

	public static boolean hasPrecedence(char op1, char op2) {

		if (op2 == '(' || op2 == ')')
			return false;
		if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
			return false;
		else
			return true;
	}

	public float calculate(char op, float b, float a) {

		switch (op) {
		case '+':
			ArthemeticOperations add = new Add();
			operations.add(add);
			return add.evaluate(a, b);
		case '-':
			ArthemeticOperations sub = new Subtract();
			operations.add(sub);
			return sub.evaluate(a, b);
		case '*':
			ArthemeticOperations multi = new Multiply();
			operations.add(multi);
			return multi.evaluate(a, b);
		case '/':
			ArthemeticOperations div = new Division();
			operations.add(div);
			return div.evaluate(a, b);
		}
		return 0;
	}

	@Override
	public float evaluate(float a, float b) {
		// TODO Auto-generated method stub
		return 0;
	}
}
