package xyz.lemone.apihub.support.sqlparse.expression.function;

import org.codehaus.jackson.map.ObjectMapper;
import xyz.lemone.apihub.support.sqlparse.context.BindData;
import xyz.lemone.apihub.support.sqlparse.context.Context;
import xyz.lemone.apihub.support.sqlparse.exception.ConvertException;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.BindDataListExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ObjectExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ObjectListExpressionData;
import xyz.lemone.apihub.support.sqlparse.toolkit.ValueConvertHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JsonFunction.
 *
 * @author lemon
 */
public class JsonFunction implements Function {

    @Override
    public Object execute(List<ExpressionData<?>> dataList, Context context) {
        if (dataList.size() != 2) {
            return null;
        }
        String obj = buildData(dataList.get(0));
        String property = buildData(dataList.get(1));

        if (obj == null || property == null || obj.equals("") || property.equals("")) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            Map<?, ?> map = mapper.readValue(obj, HashMap.class);
            return ValueConvertHelper.getProperty(map, property);
        } catch (Exception ex) {
            throw new ConvertException(ex);
        }
    }

    private String buildData(ExpressionData<?> exprData) {
        String obj = null;
        if (exprData instanceof ObjectExpressionData) {
            ObjectExpressionData objData = (ObjectExpressionData) exprData;
            Object data = objData.getData();
            if (data != null) {
                obj = data.toString();
            }
        } else if (exprData instanceof ObjectListExpressionData) {
            ObjectListExpressionData listData = (ObjectListExpressionData) exprData;
            List<?> list = listData.getData();
            if (list.size() == 1) {
                Object data = list.get(0);
                if (data != null) {
                    obj = data.toString();
                }
            }
        } else if (exprData instanceof BindDataListExpressionData) {
            BindDataListExpressionData listData = (BindDataListExpressionData) exprData;
            List<BindData> list = listData.getData();
            if (list.size() == 1) {
                Object data = list.get(0).getValue();
                if (data != null) {
                    obj = data.toString();
                }
            }
        }
        return obj;
    }

    @Override
    public String name() {
        return Functions.JSON;
    }
}
