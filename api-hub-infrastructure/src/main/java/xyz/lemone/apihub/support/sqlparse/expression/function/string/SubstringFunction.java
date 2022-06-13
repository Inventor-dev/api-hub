package xyz.lemone.apihub.support.sqlparse.expression.function.string;

import java.util.List;

import xyz.lemone.apihub.support.sqlparse.expression.function.Functions;
import xyz.lemone.apihub.ureport.Utils;
import xyz.lemone.apihub.ureport.build.Context;
import xyz.lemone.apihub.support.sqlparse.exception.ExpressionComputeException;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ObjectExpressionData;

/**
 * SubstringFunction.
 * @author lemon
 */
public class SubstringFunction extends StringFunction {

	@Override
	public Object execute(List<ExpressionData<?>> dataList, Context context) {
		String text=buildString(dataList);
		int start=0,end=text.length();
		if(dataList.size()>1){
			ExpressionData<?> exprData=dataList.get(1);
			start=buildPos(exprData);
		}
		if(dataList.size()==3){
			ExpressionData<?> exprData=dataList.get(2);
			end=buildPos(exprData);
		}
		return text.substring(start, end);
	}

	private int buildPos(ExpressionData<?> exprData) {
		if(exprData instanceof ObjectExpressionData){
			ObjectExpressionData objData=(ObjectExpressionData)exprData;
			Object obj=objData.getData();
			if(obj==null){
				throw new ExpressionComputeException("Function ["+name()+"] second parameter can not be null.");
			}
			return Utils.toBigDecimal(obj).intValue();
		}
		throw new ExpressionComputeException("Function ["+name()+"] position data is invalid : "+exprData);
	}

	@Override
	public String name() {
		return Functions.SUBSTRING;
	}
}
