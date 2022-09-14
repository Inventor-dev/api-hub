package xyz.lemone.apihub.support.sqlparse.expression.function.math;

import org.apache.commons.lang3.math.NumberUtils;
import xyz.lemone.apihub.support.sqlparse.context.Context;
import xyz.lemone.apihub.support.sqlparse.exception.ExpressionComputeException;
import xyz.lemone.apihub.support.sqlparse.expression.function.Functions;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ObjectExpressionData;
import xyz.lemone.apihub.support.sqlparse.toolkit.ValueConvertHelper;

import java.math.BigDecimal;
import java.util.List;

/**
 * CeilFunction.
 *
 * @author lemon
 */
public class CeilFunctionBase extends BaseMathFunction {

    @Override
    public Object execute(List<ExpressionData<?>> dataList, Context context) {
        BigDecimal data = buildBigDecimal(dataList);
        int pos = NumberUtils.INTEGER_ZERO;
        if (dataList.size() == NumberUtils.INTEGER_TWO) {
            ExpressionData<?> exprData = dataList.get(NumberUtils.INTEGER_ONE);
            if (exprData instanceof ObjectExpressionData) {
                ObjectExpressionData objData = (ObjectExpressionData) exprData;
                Object obj = objData.getData();
                if (obj == null) {
                    throw new ExpressionComputeException("Ceil Function second parameter can not be null.");
                }
                pos = ValueConvertHelper.toBigDecimal(obj).intValue();
            }
        }
        data.setScale(pos, BigDecimal.ROUND_CEILING);
        return Math.ceil(data.doubleValue());
    }

    @Override
    public String name() {
        return Functions.CEIL;
    }
}
