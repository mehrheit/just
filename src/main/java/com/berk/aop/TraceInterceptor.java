package com.berk.aop;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.springframework.aop.interceptor.CustomizableTraceInterceptor;
import org.apache.log4j.Logger;


/**
 * User: Oleg
 * Date: 09.12.13
 */
public class TraceInterceptor extends CustomizableTraceInterceptor {
    protected static Logger logger4J = Logger.getLogger("aop");

    @Override
    protected void writeToLog(Log logger, String message, Throwable ex) {
        if (ex != null) {
            logger4J.debug(message, ex);
        } else {
            logger4J.debug(message);
        }
    }

    @Override
    protected boolean isInterceptorEnabled(MethodInvocation invocation, Log logger) {
        return true;
    }
}
