package xyz.lemone.apihub.support.sqlparse.expression.function;

import xyz.lemone.apihub.ureport.build.Context;
import xyz.lemone.apihub.ureport.expression.model.data.ExpressionData;
import xyz.lemone.apihub.ureport.model.Cell;

import java.util.List;

/**
 * ParameterIsEmptyFunction.
 *
 * @author lemon
 */
public class ParameterIsEmptyFunction extends ParameterFunction {
    @Override
    public Object execute(List<ExpressionData<?>> dataList, Context context, Cell currentCell) {
        Object obj = super.execute(dataList, context, currentCell);
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
