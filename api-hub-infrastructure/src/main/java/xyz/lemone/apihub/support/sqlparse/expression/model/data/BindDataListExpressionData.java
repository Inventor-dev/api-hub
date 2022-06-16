package xyz.lemone.apihub.support.sqlparse.expression.model.data;

import xyz.lemone.apihub.support.sqlparse.context.BindData;

import java.util.List;

/**
 * BindDataListExpressionData.
 *
 * @author lemon
 */
public class BindDataListExpressionData implements ExpressionData<List<BindData>> {

    /**
     * list.
     */
    private List<BindData> list;

    public BindDataListExpressionData(List<BindData> list) {
        this.list = list;
    }

    @Override
    public List<BindData> getData() {
        return list;
    }
}
