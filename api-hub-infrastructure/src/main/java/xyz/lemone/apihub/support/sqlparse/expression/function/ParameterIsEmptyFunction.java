package xyz.lemone.apihub.support.sqlparse.expression.function;

import xyz.lemone.apihub.support.sqlparse.context.Context;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;

import java.util.List;

/**
 * ParameterIsEmptyFunction.
 *
 * @author lemon
 */
public class ParameterIsEmptyFunction extends ParameterFunction {
    @Override
    public Object execute(List<ExpressionData<?>> dataList, Context context) {
        Object obj = super.execute(dataList, context);
        if (obj == null || obj.toString().trim().equals("")) {
            return true;
        }
        return false;
    }

    @Override
    public String name() {
        return Functions.PARAMETER_IS_EMPTY_FUNCTION;
    }
}
