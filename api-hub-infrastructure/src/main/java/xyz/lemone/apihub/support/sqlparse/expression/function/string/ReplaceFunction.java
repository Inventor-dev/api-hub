package xyz.lemone.apihub.support.sqlparse.expression.function.string;

import java.util.List;

import xyz.lemone.apihub.support.sqlparse.expression.function.Functions;
import xyz.lemone.apihub.support.sqlparse.context.Context;
import xyz.lemone.apihub.support.sqlparse.exception.ExpressionComputeException;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ObjectExpressionData;

/**
 * ReplaceFunction.
 * @author lemon
 */
public class ReplaceFunction extends StringFunction {

	@Override
	public Object execute(List<ExpressionData<?>> dataList, Context context) {
		if(dataList.size()!=3){
			throw new ExpressionComputeException("Function ["+name()+"] need three parameters.");
		}
		String text=buildString(dataList);
		String targetText=null,replaceText=null;
		ExpressionData<?> exprData=dataList.get(1);
		if(exprData instanceof ObjectExpressionData){
			ObjectExpressionData objData=(ObjectExpressionData)exprData;
			Object obj=objData.getData();
			if(obj==null){
				throw new ExpressionComputeException("Function ["+name()+"] parameter can not be null.");
			}
			targetText=obj.toString();
		}
		exprData=dataList.get(2);
		replaceText=buildStart(exprData);
		return text.replaceAll(targetText, replaceText);
	}

	private String buildStart(ExpressionData<?> exprData) {
		if(exprData instanceof ObjectExpressionData){
			ObjectExpressionData objData=(ObjectExpressionData)exprData;
			Object obj=objData.getData();
			if(obj==null){
				throw new ExpressionComputeException("Function ["+name()+"] parameter can not be null.");
			}
			return obj.toString();
		}
		throw new ExpressionComputeException("Function ["+name()+"] start position data is invalid : "+exprData);
	}

	@Override
	public String name() {
		return Functions.REPLACE;
	}

}
