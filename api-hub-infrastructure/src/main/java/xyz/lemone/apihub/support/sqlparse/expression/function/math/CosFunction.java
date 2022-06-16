package xyz.lemone.apihub.support.sqlparse.expression.function.math;

import xyz.lemone.apihub.support.sqlparse.context.Context;
import xyz.lemone.apihub.support.sqlparse.expression.function.Functions;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;

import java.math.BigDecimal;
import java.util.List;

/**
 * 余弦.
 *
 * @author lemon
 */
public class CosFunction extends MathFunction {

    @Override
    public Object execute(List<ExpressionData<?>> dataList, Context context) {
        BigDecimal data = buildBigDecimal(dataList);
        return Math.cos(data.doubleValue());
    }

    @Override
    public String name() {
        return Functions.COS;
    }
}
