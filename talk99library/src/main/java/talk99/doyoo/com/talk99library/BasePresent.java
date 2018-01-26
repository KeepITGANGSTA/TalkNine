package talk99.doyoo.com.talk99library;

/**
 * Created by 李英杰 on 2017/11/20.
 * Description：
 */

public class BasePresent<V> {
    public V view;

    public BasePresent(V view) {
        this.view = view;
    }

    public void destory(){
        this.view=null;
    }

}
