package lottery.beans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 * Created by Remco on 14-11-2015.
 */
@ManagedBean(name = "tempBean")
@ApplicationScoped
public class TempBean {

    private String time;

    public TempBean(){
        time = "2015-11-18 13:10:10 GMT+01:00";
    }

    public String test(){
        return "winners";
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
