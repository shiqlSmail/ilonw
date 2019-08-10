package com.server.tools.result;

import com.server.tools.date.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SetAPIResultUtil {
    public static void setFail(APIBaseResult result) {
        result.setRespCode(ReturnCode.FAIL);
        result.setRespMessage(ReturnCode.MSG_FAIL);
        result.setTimes(DateUtil.getDateTime(new Date()));
    }


    public static void setSuccess(APIBaseResult result) {
        result.setRespCode(ReturnCode.SUCCESS);
        result.setRespMessage(ReturnCode.MSG_SUCCESS);
        result.setTimes(DateUtil.getDateTime(new Date()));
    }
}
