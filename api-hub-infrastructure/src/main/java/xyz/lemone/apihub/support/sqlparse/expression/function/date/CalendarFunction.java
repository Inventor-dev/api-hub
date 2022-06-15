package xyz.lemone.apihub.support.sqlparse.expression.function.date;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import xyz.lemone.apihub.support.sqlparse.toolkit.ValueConvertHelper;
import xyz.lemone.apihub.support.sqlparse.exception.ExpressionComputeException;
import xyz.lemone.apihub.support.sqlparse.expression.function.Function;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ObjectExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ObjectListExpressionData;

/**
 * CalendarFunction.
 * @author lemon
 */
public abstract class CalendarFunction implements Function {
	protected Calendar buildCalendar(List<ExpressionData<?>> dataList) {
		Date date=new Date();
		if(dataList!=null && dataList.size()>0){
			ExpressionData<?> data=dataList.get(0);
			if(data instanceof ObjectListExpressionData){
				ObjectListExpressionData listData=(ObjectListExpressionData)data;
				List<?> list=listData.getData();
				if(list==null || list.size()!=1){
					throw new ExpressionComputeException("Function [day] first parameter need a data of Date.");
				}
				Object obj=list.get(0);
				if(obj==null){
					throw new ExpressionComputeException("Function [day] first parameter can not be null.");
				}
				date= ValueConvertHelper.toDate(obj);
			}else if(data instanceof ObjectExpressionData){
				ObjectExpressionData objData=(ObjectExpressionData)data;
				Object obj=objData.getData();
				if(obj==null){
					throw new ExpressionComputeException("Function [day] first parameter can not be null.");
				}
				date= ValueConvertHelper.toDate(obj);
			}else{
				throw new ExpressionComputeException("Function [day] first parameter need a data of Date.");
			}
		}
		Calendar c=Calendar.getInstance();
		c.setTime(date);
		return c;
	}
}
