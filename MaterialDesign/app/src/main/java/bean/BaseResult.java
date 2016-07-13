package bean;

/**
 * Created by jumpbox on 16/5/3.
 */
public class BaseResult<T> {

    public String response;
    public String desc;
    public T data;

    @Override
    public String toString() {
        return response+desc+data;
    }
}
