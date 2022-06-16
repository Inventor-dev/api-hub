package xyz.lemone.apihub.support.sqlparse.context;

import java.io.Serializable;
import java.util.List;

/**
 * BindData.
 * @author lemon
 */
public class BindData implements Serializable {

    private Object value;

    private Object label;

    private List<Object> dataList;

    public BindData(Object value) {
        this.value = value;
    }

    public BindData(Object value, List<Object> dataList) {
        this.value = value;
        this.dataList = dataList;
    }

    public BindData(Object value, Object label, List<Object> dataList) {
        this.value = value;
        this.label = label;
        this.dataList = dataList;
    }

    public Object getValue() {
        return value;
    }

    public List<Object> getDataList() {
        return dataList;
    }

    public Object getLabel() {
        return label;
    }

}
