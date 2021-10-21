package com.timegate.vportal.common.utils;

import lombok.extern.slf4j.Slf4j;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Save exception log use log4j
 *
 * @author Admin
 * @since 2021.08.13
 */
@Slf4j
public class MessageLogger {
    private DateFormat dateFormat;// = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    //private org.slf4j.Logger logger;// = LoggerFactory.getLogger(MessageLogger.class);

    public MessageLogger(){
        dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //logger = LoggerFactory.getLogger(MessageLogger.class);
    }

    /**
     * Save Error log(Date, Class nmae, Method nmae, Exception type, Exception line, log message) use Logger class
     *
     * @since 2021.08.04
     * @param object
     * @param exceptionType
     * @param message
     * @param lineNumber
     */
    public void errorLog(Object object, String exceptionType, String message, int lineNumber) {
        String logString = "[Date:" + dateFormat.format(new Date()) + "] "
                + "[Class Name: "+ object.getClass().getEnclosingClass().getName() +"] "
                + "[Method Name: "+ object.getClass().getEnclosingMethod().getName() +"] "
                + "[Exception Type: "+ exceptionType +"] "
                + "[Exception Line: "+ lineNumber +"] "
                + "[Exception Message: "+ message +"]";
        log.error(logString);
    }

    /**
     * Save Error log(Date, Class nmae, Method nmae, Exception type, Exception line, log message) use Logger class
     *
     * @since 2021.08.04
     * @param object
     * @param e
     */
    public void errorLog(Object object, Exception e) {
        String logString = "[Date:" + dateFormat.format(new Date()) + "] "
                + "[Class Name: "+ object.getClass().getEnclosingClass().getName() +"] "
                + "[Method Name: "+ object.getClass().getEnclosingMethod().getName() +"] "
                + "[Exception Type: "+ e.getClass().getName() +"] "
                + "[Exception Line: "+ e.getStackTrace()[0].getLineNumber() +"] "
                + "[Exception Message: "+ e.getMessage() +"]";
        log.error(logString);
    }


    /**
     * Save Error log(Date, Class nmae, Method nmae, Exception type, Exception line, log message) use Logger class
     *
     * @since 2021.08.04
     * @param object
     * @param message
     */
    public void errorLog(Object object, String message) {
        String logString = "[Date:" + dateFormat.format(new Date()) + "] "
                + "[Class Name: "+ object.getClass().getEnclosingClass().getName() +"] "
                + "[Method Name: "+ object.getClass().getEnclosingMethod().getName() +"] "
                + "[Exception Message: "+ message +"]";
        log.error(logString);
    }


    /**
     * Save info log(Date, Class nmae, Method nmae, Log message) use Logger class
     *
     * @since 2021.08.04
     * @param object
     * @param message
     */
    public void infoLog(Object object, String message) {
        String logString = "[Date:" + dateFormat.format(new Date()) + "] "
                + "[Class Name: "+ object.getClass().getEnclosingClass().getName() +"] "
                + "[Method Name: "+ object.getClass().getEnclosingMethod().getName() +"] "
                + "[Info Message: "+ message +"]";
        log.info(logString);
    }

    /**
     * Save debug log(Date, Class nmae, Method nmae, Log message) use Logger class
     *
     * @since 2021.08.04
     * @param object
     * @param message
     */
    public void debugLog(Object object, String message) {
        String logString = "[Date:" + dateFormat.format(new Date()) + "] "
                + "[Class Name: "+ object.getClass().getEnclosingClass().getName() +"] "
                + "[Method Name: "+ object.getClass().getEnclosingMethod().getName() +"] "
                + "[Debug Message: "+ message +"]";
        log.debug(logString);
    }
}
