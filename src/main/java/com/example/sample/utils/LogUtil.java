package com.example.sample.utils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class LogUtil {
    private static Logger logger = LoggerFactory.getLogger(LogUtil.class);

    public static void logResponse(HttpServletRequest request, HttpServletResponse response, String responseText){
        OffsetDateTime now = OffsetDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
        String logDialogue = String.format("at:%s  status:%s  path:%s  response_content:%s", formatter.format(now),
                response.getStatus(),
                request.getRequestURI(),
                responseText);
        logger.info(logDialogue);
    }
}
