package xyz.lemone.apihub.support.sqlparse.expression.model.data;

/**
 * ObjectExpressionData.
 * @author lemon
 */
public class ObjectExpressionData<D> implements ExpressionData<D> {

    /**
     * data.
     */
    private D data;

    public ObjectExpressionData(D data) {
		this.data=data;
	}

	@Override
	public D getData() {
		return data;
	}

}
