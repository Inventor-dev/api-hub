package xyz.lemone.apihub.support.sqlparse.expression.function.math;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import xyz.lemone.apihub.support.sqlparse.toolkit.ValueConvertHelper;
import xyz.lemone.apihub.support.sqlparse.context.BindData;
import xyz.lemone.apihub.support.sqlparse.exception.ExpressionComputeException;
import xyz.lemone.apihub.support.sqlparse.expression.function.Function;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.BindDataListExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ObjectExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ObjectListExpressionData;

/**
 * MathFunction.
 */
public abstract class MathFunction implements Function {
	protected List<BigDecimal> buildDataList(List<ExpressionData<?>> dataList){
		if(dataList==null || dataList.size()==0){
			throw new ExpressionComputeException("Function ["+name()+"] need a lot of data parameter.");
		}
		List<BigDecimal> list= new ArrayList<>();
		for(ExpressionData<?> data:dataList){
			if(data instanceof ObjectListExpressionData){
				ObjectListExpressionData objList=(ObjectListExpressionData)data;
				for(Object obj:objList.getData()){
					BigDecimal bigData= ValueConvertHelper.toBigDecimal(obj);
					if(bigData!=null){
						list.add(bigData);						
					}
				}
			}else if(data instanceof ObjectExpressionData){
				ObjectExpressionData objData=(ObjectExpressionData)data;
				BigDecimal bigData= ValueConvertHelper.toBigDecimal(objData.getData());
				if(bigData!=null){
					list.add(bigData);
				}
			}else if(data instanceof BindDataListExpressionData){
				BindDataListExpressionData bindDataListData=(BindDataListExpressionData)data;
				for(BindData bindData:bindDataListData.getData()){
					BigDecimal bigData= ValueConvertHelper.toBigDecimal(bindData.getValue());
					if(bigData!=null){
						list.add(bigData);
					}
				}
			}
		}
		return list;
	}
	
	protected BigDecimal buildBigDecimal(List<ExpressionData<?>> dataList) {
		if(dataList==null || dataList.size()==0){
			throw new ExpressionComputeException("Function ["+name()+"] need a data of number parameter.");
		}
		BigDecimal number=null;
		ExpressionData<?> data=dataList.get(0);
		if(data instanceof ObjectListExpressionData){
			ObjectListExpressionData listData=(ObjectListExpressionData)data;
			List<?> list=listData.getData();
			if(list==null || list.size()!=1){
				throw new ExpressionComputeException("Function ["+name()+"] need a data of number parameter.");
			}
			Object obj=list.get(0);
			if(obj==null){
				throw new ExpressionComputeException("Function ["+name()+"] parameter can not be null.");
			}
			number= ValueConvertHelper.toBigDecimal(obj);
		}else if(data instanceof ObjectExpressionData){
			ObjectExpressionData objData=(ObjectExpressionData)data;
			Object obj=objData.getData();
			if(obj==null){
				throw new ExpressionComputeException("Function ["+name()+"] parameter can not be null.");
			}
			number= ValueConvertHelper.toBigDecimal(obj);
		}else{
			throw new ExpressionComputeException("Function ["+name()+"] need a data of number parameter.");
		}
		return number;
	}
}
