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
 * 最大整数,即对浮点数向下取整.
 *
 * @author lemon
 */
public class FloorFunctionBase extends BaseMathFunction {

    @Override
    public Object execute(List<ExpressionData<?>> dataList, Context context) {
        BigDecimal data = buildBigDecimal(dataList);
        int pos = 0;
        if (dataList.size() == NumberUtils.INTEGER_TWO) {
            ExpressionData<?> exprData = dataList.get(NumberUtils.INTEGER_ONE);
            if (exprData instanceof ObjectExpressionData) {
                ObjectExpressionData objData = (ObjectExpressionData) exprData;
                Object obj = objData.getData();
                if (obj == null) {
                    throw new ExpressionComputeException("Floor Function second parameter can not be null.");
                }
                pos = ValueConvertHelper.toBigDecimal(obj).intValue();
            }
        }
        data.setScale(pos, BigDecimal.ROUND_FLOOR);
        return Math.floor(data.doubleValue());
    }

    @Override
    public String name() {
        return Functions.FLOOR;
    }
}
