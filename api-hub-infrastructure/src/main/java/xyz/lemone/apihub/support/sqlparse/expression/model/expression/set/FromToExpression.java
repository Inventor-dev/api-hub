package xyz.lemone.apihub.support.sqlparse.expression.model.expression.set;

import xyz.lemone.apihub.support.sqlparse.exception.ExpressionComputeException;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ObjectExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ObjectListExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.BaseExpression;
import xyz.lemone.apihub.support.sqlparse.toolkit.ValueConvertHelper;
import xyz.lemone.apihub.support.sqlparse.context.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * FromToExpression.
 *
 * @author lemon
 */
public class FromToExpression extends BaseExpression {
    private static final long serialVersionUID = 1L;

    private BaseExpression fromExpression;

    private BaseExpression toExpression;

    public FromToExpression(BaseExpression fromExpression, BaseExpression toExpression) {
        this.fromExpression = fromExpression;
        this.toExpression = toExpression;
    }

    @Override
    public ExpressionData<?> compute(Context context) {
        Object fromData = fromExpression.execute(context);
        Object toData = toExpression.execute(context);
        int from = convertFloatData(fromData), to = convertFloatData(toData);
        List<Integer> list = new ArrayList<Integer>();
        for (int i = from; i <= to; i++) {
            list.add(i);
        }
        return new ObjectListExpressionData(list);
    }

    private int convertFloatData(Object data) {
        if (data instanceof ObjectExpressionData) {
            Object obj = ((ObjectExpressionData) data).getData();
            return ValueConvertHelper.toBigDecimal(obj).intValue();
        } else {
            throw new ExpressionComputeException("Can not convert [" + data + "] to integer.");
        }
    }
}
