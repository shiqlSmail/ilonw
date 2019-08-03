package com.server.tools.result;

import com.server.tools.date.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SetAPIResultUtil {
    public static void setFail(APIBaseResult result) {
        result.setErrorCode(ReturnCode.FAIL);
        result.setMessage(ReturnCode.MSG_FAIL);
        result.setTimes(DateUtil.getDateTime(new Date()));
    }


    public static void setSuccess(APIBaseResult result) {
        result.setMessage(ReturnCode.MSG_SUCCESS);
        result.setErrorCode(ReturnCode.SUCCESS);
        result.setTimes(DateUtil.getDateTime(new Date()));
    }
}
