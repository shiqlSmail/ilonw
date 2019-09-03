package com.ilonw.api.base;

import com.ilonw.server.Eunms.UserEunms;
import org.apache.poi.ss.formula.functions.T;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseService {
    public static Map<String, Object> getSuccessMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("resCode", UserEunms.SUCCESS.getResCode());
        map.put("resMsg", UserEunms.SUCCESS.getResMsg());
        return map;
    }

    public static Map<String, Object> getSuccessMapObject(Object obj) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("resCode", UserEunms.SUCCESS.getResCode());
        map.put("resMsg", UserEunms.SUCCESS.getResMsg());
        map.put("resData", obj);
        return map;
    }

    public static Map<String, Object> getFailMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("resCode", UserEunms.FAIL.getResCode());
        map.put("resMsg", UserEunms.FAIL.getResMsg());
        return map;
    }
}
