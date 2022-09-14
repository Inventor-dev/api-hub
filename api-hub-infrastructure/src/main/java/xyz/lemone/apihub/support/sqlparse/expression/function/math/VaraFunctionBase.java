package xyz.lemone.apihub.support.sqlparse.expression.function.math;

import xyz.lemone.apihub.support.sqlparse.context.Context;
import xyz.lemone.apihub.support.sqlparse.expression.function.Functions;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;

import java.math.BigDecimal;
import java.util.List;

/**
 * 求方差.
 *
 * @author lemon
 */
public class VaraFunctionBase extends BaseMathFunction {

    @Override
    public Object execute(List<ExpressionData<?>> dataList, Context context) {
        List<BigDecimal> list = buildDataList(dataList);
        BigDecimal total = new BigDecimal(0);
        for (BigDecimal bigData : list) {
            total = total.add(bigData);
        }
        int size = list.size();
        BigDecimal avg = total.divide(new BigDecimal(size), 8, BigDecimal.ROUND_HALF_UP);
        double sum = 0;
        for (BigDecimal bigData : list) {
            BigDecimal data = bigData.subtract(avg);
            sum += Math.pow(data.doubleValue(), 2);
        }
        BigDecimal result = new BigDecimal(sum);
        return result.divide(new BigDecimal(size), 8, BigDecimal.ROUND_HALF_UP);
    }

    @Override
    public String name() {
        return Functions.VARA;
    }
}
