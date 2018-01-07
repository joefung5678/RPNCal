package main;

import constant.ConstantEnum;

public class Order {

	ConstantEnum constant; 
	Double value;
	
	public Order(ConstantEnum constant, Double value) {
		super();
		this.constant = constant;
		this.value = value;
	}
	
    public String getReverseInstruction() throws Exception {
        if (constant.getOrderNum() < 1) {
        	throw new Exception(String.format("invalid operation for operator %s", constant.getConstant()));
        }else {
            return (constant.getOrderNum() < 2) ? String.format("%s", constant.getConstantOpp()) : String.format("%f %s %f", value, constant.getConstantOpp(), value);        	
        }

    }
}
