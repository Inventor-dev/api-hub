package xyz.lemone.apihub.support.sqlparse.expression.function.string;

import org.apache.commons.lang3.math.NumberUtils;
import xyz.lemone.apihub.support.sqlparse.context.Context;
import xyz.lemone.apihub.support.sqlparse.exception.ExpressionComputeException;
import xyz.lemone.apihub.support.sqlparse.expression.function.Functions;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ObjectExpressionData;

import java.util.List;

/**
 * ReplaceFunction.
 *
 * @author lemon
 */
public class ReplaceFunction extends StringFunction {

    private static final Integer PARAM_SIZE = 3;

    @Override
    public Object execute(List<ExpressionData<?>> dataList, Context context) {
        if (dataList.size() != PARAM_SIZE) {
            throw new ExpressionComputeException("Function [" + name() + "] need three parameters.");
        }
        final String text = buildString(dataList);
        String targetText = null;
        String replaceText;
        ExpressionData<?> exprData = dataList.get(NumberUtils.INTEGER_ONE);
        if (exprData instanceof ObjectExpressionData) {
            ObjectExpressionData objData = (ObjectExpressionData) exprData;
            Object obj = objData.getData();
            if (obj == null) {
                throw new ExpressionComputeException("Function [" + name() + "] parameter can not be null.");
            }
            targetText = obj.toString();
        }
        exprData = dataList.get(NumberUtils.INTEGER_TWO);
        replaceText = buildStart(exprData);
        return text.replaceAll(targetText, replaceText);
    }

    private String buildStart(ExpressionData<?> exprData) {
        if (exprData instanceof ObjectExpressionData) {
            ObjectExpressionData objData = (ObjectExpressionData) exprData;
            Object obj = objData.getData();
            if (obj == null) {
                throw new ExpressionComputeException("Function [" + name() + "] parameter can not be null.");
            }
            return obj.toString();
        }
        throw new ExpressionComputeException("Function [" + name() + "] start position data is invalid : " + exprData);
    }

    @Override
    public String name() {
        return Functions.REPLACE;
    }

}
