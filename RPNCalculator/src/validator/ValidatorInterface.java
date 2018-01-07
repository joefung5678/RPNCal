package validator;

import constant.ConstantEnum;

public interface ValidatorInterface {

	default void newDefaultMethod() {

		System.out.println("New default method is added in interface");

	}
	
	default boolean isEmpty(String str) {
//		System.out.println("Checking " + str + " with isEmpty()..");
		if(str != null && !str.trim().isEmpty()) {
			return false;
		}else {
			return true;	
		}
		
	}
	
	default boolean isNumeric (String str) {
//		System.out.println("Checking " + str + " with isNumeric()..");
		return str.matches("^[0-9]*$");
	}
	
	default boolean isMathOperator(String str) {
//		System.out.println("Checking " + str + " with isMathOperator()..");
		return str.matches("[-+*/]");
	}
	
	default boolean isStrMatch (String str, String targetStr) {
//		System.out.println("Checking " + str + " with isStrMatch()..");
		return str.equals(targetStr);
	}
	
	default boolean checkWithEnum(String str, ConstantEnum... value) {
//		System.out.println("Checking " + str + " with checkWithEnum()..");
	    try {
	    	
	    	return ConstantEnum.get().containsKey(str);
	    	
//	    	return !Arrays.asList(value).contains(ConstantEnum.getEnum(str).getConstant());
//	        return !Arrays.asList(value).contains(ConstantEnum.valueOf(str));
	    } catch (Exception e) {
	        return false;
	    }
	}
	
}
