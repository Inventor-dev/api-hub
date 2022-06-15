package xyz.lemone.apihub.support.sqlparse.expression.function.math;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang.math.RandomUtils;

import xyz.lemone.apihub.support.sqlparse.expression.function.Functions;
import xyz.lemone.apihub.support.sqlparse.context.Context;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;

/**
 * 随机数.
 * @author lemon
 */
public class RandomFunction extends MathFunction {
	@Override
	public Object execute(List<ExpressionData<?>> dataList, Context context) {
		int feed=0;
		if(dataList.size()>0){
			BigDecimal data=buildBigDecimal(dataList);
			feed=data.intValue();
		}
		if(feed==0){
			return Math.random();
		}
		return RandomUtils.nextInt(feed);
	}

	@Override
	public String name() {
		return Functions.RANDOM;
	}
}
