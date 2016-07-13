package bean;

import java.util.List;

/**
 * Created by jumpbox on 16/5/3.
 */
public class BaseListResult<T> {

    public String response;
    public List<T> data;
    public String desc;
}
