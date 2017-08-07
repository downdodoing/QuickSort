package cn;

import java.util.StringTokenizer;

public class Calculate {
	public static int calculate(String expression) {

		// ���ڴ洢������
		GeneraStack<Integer> operandStack = new GeneraStack<>();
		// ���ڴ洢������
		GeneraStack<Character> opertorStack = new GeneraStack<>();
		StringTokenizer tokens = new StringTokenizer(expression, "()+-*/", true);

		// �ж��Ƿ��ȡ��token�е�����
		while (tokens.hasMoreTokens()) {
			String token = tokens.nextToken().trim();

			if (0 == token.length()) {
				continue;
			}
			char tokenStr = token.charAt(0);
			if (tokenStr == '+' || tokenStr == '-') {
				while (!opertorStack.isEmpty()
						&& (opertorStack.peek() == '+'
								|| opertorStack.peek() == '-'
								|| opertorStack.peek() == '/' || opertorStack
								.peek() == '*')) {
					processAnOperator(operandStack, opertorStack);
				}
				opertorStack.push(tokenStr);
			} else if (tokenStr == '*' || tokenStr == '/') {
				while (!opertorStack.isEmpty()
						&& (opertorStack.peek() == '/' || opertorStack.peek() == '*')) {
					processAnOperator(operandStack, opertorStack);
				}
				opertorStack.push(tokenStr);
			} else if (tokenStr == '(') {
				opertorStack.push('(');
			} else if (tokenStr == ')') {
				while (opertorStack.peek() != '(') {
					processAnOperator(operandStack, opertorStack);
				}
				opertorStack.pop();
			} else {
				operandStack.push(new Integer(token));
			}
		}
		while (!opertorStack.isEmpty()) {
			processAnOperator(operandStack, opertorStack);
		}
		return operandStack.pop();
	}

	public static void processAnOperator(GeneraStack<Integer> operandStack,
			GeneraStack<Character> opertorStack) {
		char op = opertorStack.pop();
		int op1 = operandStack.pop();
		int op2 = operandStack.pop();

		if ('+' == op) {
			operandStack.push(op2 + op1);
		} else if ('-' == op) {
			operandStack.push(op2 - op1);
		} else if ('*' == op) {
			operandStack.push(op2 * op1);
		} else {
			operandStack.push(op2 / op1);
		}
	}

	public static void main(String[] args) {
		System.out.println(calculate("( 1 + 2) * 3 + 4"));
	}
}
