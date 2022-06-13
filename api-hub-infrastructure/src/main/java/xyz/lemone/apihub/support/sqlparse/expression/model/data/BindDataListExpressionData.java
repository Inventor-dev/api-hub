package xyz.lemone.apihub.support.sqlparse.expression.model.data;

import java.util.List;

import xyz.lemone.apihub.ureport.build.BindData;

/**
 * BindDataListExpressionData.
 * @author lemon
 */
public class BindDataListExpressionData implements ExpressionData<List<BindData>>{

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
