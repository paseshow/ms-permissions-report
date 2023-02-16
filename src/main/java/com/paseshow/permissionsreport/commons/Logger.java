package com.paseshow.permissionsreport.commons;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

public class Logger {
    public static void LogInfo(String className, String method, String util) {
        if(util.equals(Utils.LOG_INIT)) {
            System.out.printf("------------------------------------------------\n");
            System.out.printf("%s-%s: %s\n", className, method, util);
        } else
            System.out.printf("%s-%s: %s\n", className, method, util);
    }

    public static void LogInfoPathParam(String key, String param) {
        System.out.printf("PathParams- %s:%s\n", key, param);
    }

    public static void LogInfoRequest(String key, Object body) {
        System.out.printf("Body request- %s:%s\n", key, body);
    }

    public static void LogInfo(String data) {
        System.out.printf("Info: %s\n", data);
    }

    public static void LogError(String className, String method, String error){
        System.out.printf("%s-%s:%s %s\n", className, Utils.LOG_END_EX, method, error);
    }

    public static void LoggerResponseEntity(ResponseEntity responseEntity, HttpMethod method){
        Logger.LogInfo("METHOD :".concat(method.name()) + " - STATUS: " + responseEntity.getStatusCode());
    }

    public static void LoggerResponseEntityError(Throwable throwable, HttpMethod method){
        Logger.LogInfo("METHOD :".concat(method.name()) + " - ERROR: " + throwable.getMessage());
    }
}
