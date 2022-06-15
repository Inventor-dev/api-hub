package xyz.lemone.apihub.support.sqlparse.expression.function.string;

import java.util.List;

import xyz.lemone.apihub.support.sqlparse.expression.function.Functions;
import xyz.lemone.apihub.support.sqlparse.toolkit.ValueConvertHelper;
import xyz.lemone.apihub.support.sqlparse.context.Context;
import xyz.lemone.apihub.support.sqlparse.exception.ExpressionComputeException;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ObjectExpressionData;

/**
 * IndexOfFunction.
 * @author lemon
 */
public class IndexOfFunction extends StringFunction {

	@Override
	public Object execute(List<ExpressionData<?>> dataList, Context context) {
		String text=buildString(dataList);
		String targetText=null;
		if(dataList.size()>1){
			ExpressionData<?> exprData=dataList.get(1);
			if(exprData instanceof ObjectExpressionData){
				ObjectExpressionData objData=(ObjectExpressionData)exprData;
				Object obj=objData.getData();
				if(obj==null){
					throw new ExpressionComputeException("Function ["+name()+"] parameter can not be null.");
				}
				targetText=obj.toString();
			}
		}
		int start=0;
		if(dataList.size()==3){
			ExpressionData<?> exprData=dataList.get(2);
			start=buildStart(exprData);
		}
		return text.indexOf(targetText, start);
	}

	private int buildStart(ExpressionData<?> exprData) {
		if(exprData instanceof ObjectExpressionData){
			ObjectExpressionData objData=(ObjectExpressionData)exprData;
			Object obj=objData.getData();
			if(obj==null){
				throw new ExpressionComputeException("Function ["+name()+"] parameter can not be null.");
			}
			return ValueConvertHelper.toBigDecimal(obj).intValue();
		}
		throw new ExpressionComputeException("Function ["+name()+"] start position data is invalid : "+exprData);
	}

	@Override
	public String name() {
		return Functions.INDEX_OF;
	}

}
