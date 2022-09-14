package xyz.lemone.apihub.support.sqlparse.expression.function;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
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
import java.util.Objects;

/**
 * JsonFunction.
 *
 * @author lemon
 */
public class JsonFunction implements Function {

    @Override
    public Object execute(List<ExpressionData<?>> dataList, Context context) {
        if (dataList.size() < NumberUtils.INTEGER_TWO) {
            return null;
        }
        String obj = buildData(dataList.get(NumberUtils.INTEGER_ZERO));
        String property = buildData(dataList.get(NumberUtils.INTEGER_ONE));

        if (Objects.isNull(obj) || StringUtils.isBlank(property) || obj.equals(StringUtils.EMPTY)) {
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
            if (CollectionUtils.isNotEmpty(list)) {
                Object data = list.get(NumberUtils.INTEGER_ZERO);
                if (Objects.nonNull(data)) {
                    obj = data.toString();
                }
            }
        } else if (exprData instanceof BindDataListExpressionData) {
            BindDataListExpressionData listData = (BindDataListExpressionData) exprData;
            List<BindData> list = listData.getData();
            if (CollectionUtils.isNotEmpty(list)) {
                Object data = list.get(NumberUtils.INTEGER_ZERO).getValue();
                if (Objects.nonNull(data)) {
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
