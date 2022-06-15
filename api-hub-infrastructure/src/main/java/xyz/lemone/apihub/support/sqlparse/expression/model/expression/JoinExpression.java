package xyz.lemone.apihub.support.sqlparse.expression.model.expression;

import xyz.lemone.apihub.support.sqlparse.expression.model.ArithmeticOperator;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.BindDataListExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ObjectExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ObjectListExpressionData;
import xyz.lemone.apihub.support.sqlparse.context.BindData;
import xyz.lemone.apihub.support.sqlparse.context.Context;
import xyz.lemone.apihub.support.sqlparse.toolkit.ElCompute;

import java.util.ArrayList;
import java.util.List;

/**
 * JoinExpression.
 *
 * @author lemon
 */
public class JoinExpression extends BaseExpression {
    private static final long serialVersionUID = 1L;
    private List<ArithmeticOperator> arithmeticOperators;
    private List<BaseExpression> expressions;

    public JoinExpression(List<ArithmeticOperator> arithmeticOperators, List<BaseExpression> expressions) {
        this.arithmeticOperators = arithmeticOperators;
        this.expressions = expressions;
    }

    @Override
    public ExpressionData<?> compute(Context context) {
        if (expressions.size() == 1) {
            return expressions.get(0).compute(context);
        }
        List<Object> list = new ArrayList<Object>();
        for (int i = 0; i < expressions.size(); i++) {
            BaseExpression expression = expressions.get(i);
            ExpressionData<?> data = expression.execute(context);
            Object obj = null;
            if (data instanceof ObjectExpressionData) {
                ObjectExpressionData d = (ObjectExpressionData) data;
                obj = d.getData();
            } else if (data instanceof ObjectListExpressionData) {
                ObjectListExpressionData d = (ObjectListExpressionData) data;
                obj = d.getData();
            } else if (data instanceof BindDataListExpressionData) {
                BindDataListExpressionData dataList = (BindDataListExpressionData) data;
                List<BindData> bindList = dataList.getData();
                if (bindList.size() == 1) {
                    BindData bindData = bindList.get(0);
                    obj = bindData.getValue();
                } else {
                    StringBuilder sb = new StringBuilder();
                    for (BindData bd : bindList) {
                        if (sb.length() > 0) {
                            sb.append(",");
                        }
                        sb.append(bd.getValue());
                    }
                    obj = sb.toString();
                }
            }
            if (obj == null) {
                obj = "";
            }
            list.add(obj);
        }
        String str = null;
        for (int i = 0; i < list.size(); i++) {
            Object data = list.get(i);
            if (str == null) {
                if (data instanceof String) {
                    str = "\"" + data + "\"";
                } else {
                    str = "" + data + "";
                }
            } else {
                ArithmeticOperator op = arithmeticOperators.get(i - 1);
                if (data instanceof String) {
                    str += "" + op + "\"" + data + "\"";
                } else {
                    str += "" + op + "" + data + "";
                }
            }
        }
        Object obj = new ElCompute().doCompute(str);
        return new ObjectExpressionData(obj);
    }

    public List<BaseExpression> getExpressions() {
        return expressions;
    }
}
