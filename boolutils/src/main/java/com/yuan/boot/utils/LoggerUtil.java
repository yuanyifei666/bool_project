package com.yuan.boot.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 统一设置打印日志的工具类
 */
public class LoggerUtil {
    private static Logger logger;

    /**
     * 根据传入的类型返回logger对象
     * @param target 目标类的类型
     * @return
     */
    public  static Logger getLogger(Class target){
       logger = LoggerFactory.getLogger(target);
       return logger;
    }


}
