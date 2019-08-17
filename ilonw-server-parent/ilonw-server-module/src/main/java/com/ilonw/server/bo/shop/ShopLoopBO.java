package com.ilonw.server.bo.shop;

import java.io.Serializable;

public class ShopLoopBO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String loopId;

    private String loopName;

    private String loopPic;

    private String loopStatus;

    private String loopCreatetime;

    private String loopUpdatetime;

    private Integer loopIndex;

    public String getLoopId() {
        return loopId;
    }

    public void setLoopId(String loopId) {
        this.loopId = loopId;
    }

    public String getLoopName() {
        return loopName;
    }

    public void setLoopName(String loopName) {
        this.loopName = loopName;
    }

    public String getLoopPic() {
        return loopPic;
    }

    public void setLoopPic(String loopPic) {
        this.loopPic = loopPic;
    }

    public String getLoopStatus() {
        return loopStatus;
    }

    public void setLoopStatus(String loopStatus) {
        this.loopStatus = loopStatus;
    }

    public String getLoopCreatetime() {
        return loopCreatetime;
    }

    public void setLoopCreatetime(String loopCreatetime) {
        this.loopCreatetime = loopCreatetime;
    }

    public String getLoopUpdatetime() {
        return loopUpdatetime;
    }

    public void setLoopUpdatetime(String loopUpdatetime) {
        this.loopUpdatetime = loopUpdatetime;
    }

    public Integer getLoopIndex() {
        return loopIndex;
    }

    public void setLoopIndex(Integer loopIndex) {
        this.loopIndex = loopIndex;
    }
}