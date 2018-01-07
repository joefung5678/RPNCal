package validatorImp;

import constant.ConstantEnum;
import validator.ValidatorInterface;

public class ValidatorImp implements ValidatorInterface{

	public void validateInputString(String str) throws Exception{

		ValidatorImp validator = new ValidatorImp();
		if(validator.isEmpty(str)) {
			throw new Exception ("Empty");
		}else {

			// check numeric first
			if(validator.isNumeric(str)) {
				
			}else {
				// not numeric 
				// maybe math operator
				if(!validator.isMathOperator(str) && !validator.checkWithEnum(str, ConstantEnum.values())) {
					throw new Exception (" Not Valid");
				}
			}

		}
		
	}



}
