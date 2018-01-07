package constant;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.HashMap;
import java.util.Map;


public enum ConstantEnum {
	ADD("+", "-", 2){
        public Double calculate(Double firstOperand, Double secondOperand) throws Exception {
            return secondOperand + firstOperand;
        }
	},
	
	SUBSTRACT("-", "+", 2){
        public Double calculate(Double firstOperand, Double secondOperand) throws Exception {
            return secondOperand - firstOperand;
        }
	},

	MULTI("*", "/", 2){
        public Double calculate(Double firstOperand, Double secondOperand) throws Exception {
            return secondOperand * firstOperand;
        }
		
	},
	
	DIVIDE("/", "*", 2){
        public Double calculate(Double firstOperand, Double secondOperand) throws Exception {
        	if(firstOperand == 0) {
        		throw new Exception ("Cannot divided by 0");
        	}else {
        		return secondOperand / firstOperand;	
        	}
        }
		
	},
	
	SQUARE("sqrt", "pow", 1){
        public Double calculate(Double firstOperand, Double secondOperand) throws Exception {
            return sqrt(firstOperand);
        }
	},
	
    POWER("pow", "sqrt", 1) {
        public Double calculate(Double firstOperand, Double secondOperand) throws Exception {
            return pow(firstOperand, 2.0);
        }
    },
	
	UNDO("undo", null, 0 ){
    	public Double calculate(Double firstOperand, Double secondOperand) throws Exception {
    		throw new Exception();
    	}
	},
	
	CLEAR("clear", null, 0){
		public Double calculate(Double firstOperand, Double secondOperand) throws Exception {
			throw new Exception();
		}
	};
	
	private String constant;
	private String constantOpp;
	private int orderNum;
	private static final Map<String, ConstantEnum> map = new HashMap<String, ConstantEnum>();
	public abstract Double calculate(Double firstOperand, Double secondOperand) throws Exception;

	ConstantEnum(String constant, String constantOpp, int orderNum) {
		this.constant = constant;
		this.constantOpp = constantOpp;
		this.orderNum = orderNum;
	}
	static {
		for(ConstantEnum constant: values()) {
			map.put(constant.getConstant(), constant);
		}
	}
	public String getConstant() {
		return constant;
	}

	public String getConstantOpp() {
		return constantOpp;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public static ConstantEnum getEnum(String str) {
		// TODO Auto-generated method stub
		return map.get(str);
	}
	public static Map<String, ConstantEnum> get() {
		return map;
	}
	
	
	
}
