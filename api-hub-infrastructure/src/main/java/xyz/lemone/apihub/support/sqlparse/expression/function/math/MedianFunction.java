package xyz.lemone.apihub.support.sqlparse.expression.function.math;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import xyz.lemone.apihub.support.sqlparse.expression.function.Functions;
import xyz.lemone.apihub.support.sqlparse.context.Context;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;

/**
 * 求中位数.
 * @author lemon
 */
public class MedianFunction extends MathFunction {

	@Override
	public Object execute(List<ExpressionData<?>> dataList, Context context) {
		List<BigDecimal> list=buildDataList(dataList);
		int size=list.size();
		if(size==1){
			return list.get(0);
		}else if(size==2){
			BigDecimal data=list.get(0).add(list.get(1));
			return data.divide(new BigDecimal(2),8,BigDecimal.ROUND_HALF_UP);
		}
		Collections.sort(list);
		int mode=size % 2;
		if(mode==0){
			int half = size / 2;
			int start=half-1;
			BigDecimal data=list.get(start).add(list.get(half));
			return data.divide(new BigDecimal(2),8,BigDecimal.ROUND_HALF_UP);
		}else{
			int half=size / 2;
			return list.get(half);
		}
	}
	
	@Override
	public String name() {
		return Functions.MEDIAN;
	}
}
