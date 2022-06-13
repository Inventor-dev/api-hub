package xyz.lemone.apihub.support.sqlparse.expression.function.math;

import java.math.BigDecimal;
import java.util.List;

import xyz.lemone.apihub.support.sqlparse.expression.function.Functions;
import xyz.lemone.apihub.ureport.build.Context;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;

/**
 * 求标准差
 * @author lemon
 */
public class StdevpFunction extends MathFunction {

	@Override
	public Object execute(List<ExpressionData<?>> dataList, Context context) {
		List<BigDecimal> list=buildDataList(dataList);
		BigDecimal total=new BigDecimal(0);
		for(BigDecimal bigData:list){
			total=total.add(bigData);
		}
		int size=list.size();
		BigDecimal avg=total.divide(new BigDecimal(size),8,BigDecimal.ROUND_HALF_UP);
		double sum=0;
		for(BigDecimal bigData:list){
			BigDecimal data=bigData.subtract(avg);
			sum+=Math.pow(data.doubleValue(), 2);
		}
		BigDecimal result=new BigDecimal(sum);
		result=result.divide(new BigDecimal(size),8,BigDecimal.ROUND_HALF_UP);
		return Math.sqrt(result.doubleValue());
	}
	
	
	@Override
	public String name() {
		return Functions.STDEVP;
	}
}
