package main;

import java.util.Stack;
import constant.ConstantEnum;

	
public class Calculator {

	private Stack<Double> valuesStack = new Stack<Double>();
	private Stack<Order> orderStack = new Stack<Order>();
	private int currentIndex = 0;

    public Stack<Double> getValuesStack() {
        return this.valuesStack;
    }
	public void calucate(String str, boolean isUndo) throws Exception{
		currentIndex = 0;
		String[] strList = str.split("\\s+");
		for(String single : strList) {
			currentIndex ++;
			process(single, isUndo);

		}

	}

	private void process(String str, boolean isUndo) throws Exception {
		
		Double value = tryParseDouble(str);
		
		if (value == null) {

			// check if there is an empty stack
			if (valuesStack.isEmpty()) {
				throw new Exception("Empty Stack");
			}

			// searching for the operator
			ConstantEnum constant = ConstantEnum.getEnum(str);

			// Clear up every thing -> next input
			if(constant == ConstantEnum.CLEAR) {
				valuesStack.clear();
				orderStack.clear();
				return;
			}

			// undo calculation the last instruction
			if (constant == ConstantEnum.UNDO) {
				if (orderStack.isEmpty()) {
					throw new Exception("no operations to undo");
				}

				Order lastOrder = orderStack.pop();
				if (lastOrder == null) {
					valuesStack.pop();
				} else {
					calucate(lastOrder.getReverseInstruction(), true); //TODO
				}
				return;
			}

			// Check the operation param 
			if (constant.getOrderNum() > valuesStack.size()) {
				throw new Exception(String.format("operator %s (position: %d): insufficient parameters", str, currentIndex));
			}

			// Start to calculate
			Double firstOperand = valuesStack.pop();
			Double secondOperand = (constant.getOrderNum() > 1) ? valuesStack.pop() : null;
			// calculate
			Double result = constant.calculate(firstOperand, secondOperand);

			if (result != null) {
				valuesStack.push(result);
				if (!isUndo) {
					orderStack.push(new Order(ConstantEnum.getEnum(str), firstOperand));
				}
			}

		} else {
			// it's a digit
			valuesStack.push(Double.parseDouble(str));
			if (!isUndo) {
				orderStack.push(null);
			}
		}
	}

	private Double tryParseDouble(String str) {
		try {
			return Double.parseDouble(str);
		} catch (NumberFormatException e) {
			return null;
//			throw new NumberFormatException ("Fail to convert to Double ->" + str);
			
		}
	}
}
