package xyz.lemone.apihub.support.sqlparse.expression.function.string;

import xyz.lemone.apihub.support.sqlparse.context.Context;
import xyz.lemone.apihub.support.sqlparse.expression.function.Functions;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;

import java.util.List;

/**
 * LowerFunction.
 *
 * @author lemon
 */
public class LowerFunction extends StringFunction {

    @Override
    public Object execute(List<ExpressionData<?>> dataList, Context context) {
        String text = buildString(dataList);
        return text.toLowerCase();
    }

    @Override
    public String name() {
        return Functions.LOWER;
    }
}
