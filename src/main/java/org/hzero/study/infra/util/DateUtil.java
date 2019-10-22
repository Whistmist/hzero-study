package org.hzero.study.infra.util;

import io.choerodon.core.exception.CommonException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * <p>
 * -- 日期转换
 * </p>
 *
 * @Author: heng.huang@hand-china.com 2019-08-28
 */
public class DateUtil {


    /**
     * 拼接 月 日
     *
     * @param month 月份
     * @param day 天数
     * @return
     * @throws ParseException 时间转换异常
     */
    public static String getMonthAndDay(long month, long day) {
        SimpleDateFormat format = new SimpleDateFormat("MM-dd");
        Date currdate = null;
        try {
            currdate = format.parse(month +"-"+day);
        } catch (ParseException e) {
            throw new CommonException(" Time transition anomaly ");
        }
        Calendar ca = Calendar.getInstance();
        ca.setTime(currdate);
        ca.add(Calendar.DATE, 1);
        return ca.get(Calendar.MONTH)+1 +"-"+ca.get(Calendar.DATE);
    }

    /**
     * 拼接 年 月 日
     *
     * @param year
     * @param month
     * @param date
     * @return
     * @throws ParseException
     */
    public static Date getTime(long year,long month, long date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return format.parse(year+"-"+month +"-"+date);
        } catch (ParseException e) {
            throw new CommonException(" Time transition anomaly ");
        }
    }
}
