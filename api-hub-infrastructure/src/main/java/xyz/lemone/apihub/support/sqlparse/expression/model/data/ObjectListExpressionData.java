package xyz.lemone.apihub.support.sqlparse.expression.model.data;

import java.util.List;

/**
 * ObjectListExpressionData.
 * @author lemon
 */
public class ObjectListExpressionData implements ExpressionData<List<?>> {

    /**
     * list.
     */
    private List<?> list;

    public ObjectListExpressionData(List<?> list) {
		this.list=list;
	}

	@Override
	public List<?> getData() {
		return list;
	}

}
