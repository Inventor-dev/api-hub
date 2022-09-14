package xyz.lemone.apihub.support.sqlparse.expression.function.math;

import xyz.lemone.apihub.support.sqlparse.context.Context;
import xyz.lemone.apihub.support.sqlparse.expression.function.Functions;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;

import java.math.BigDecimal;
import java.util.List;

/**
 * AbsFunction.
 *
 * @author lemon
 */
public class AbsFunctionBase extends BaseMathFunction {

    @Override
    public Object execute(List<ExpressionData<?>> dataList, Context context) {
        BigDecimal data = buildBigDecimal(dataList);
        return Math.abs(data.doubleValue());
    }

    @Override
    public String name() {
        return Functions.ABS;
    }
}
