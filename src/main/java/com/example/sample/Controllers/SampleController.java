package com.example.sample.Controllers;

import com.example.sample.utils.LogUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SampleController {
    private final String camelCaseRegex;
    private final String authorName;

    public SampleController() {
        this.authorName = "Mohammad-Hossein Zeynalzadeh";
        this.camelCaseRegex = "(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])";
    }

    @ResponseBody
    @GetMapping("/hello")
    public ResponseEntity<?> sendHelloResponse(@RequestParam(defaultValue = "") String name,
                                               HttpServletRequest request,
                                               HttpServletResponse response){
        String responseText = generateTextResponse(name);
        LogUtil.logResponse(request, response, responseText);
        return new ResponseEntity<>(responseText, HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/author")
    public ResponseEntity<?> sendAuthorName(HttpServletRequest request,
                                            HttpServletResponse response){
        LogUtil.logResponse(request, response, getAuthorName());
        return new ResponseEntity<>(getAuthorName(), HttpStatus.OK);
    }

    public String getAuthorName() {
        return authorName;
    }

    private String generateTextResponse(String nameQueryParam){
        if (nameQueryParam == null || nameQueryParam.isEmpty())
            return "Hello Stranger";
        String[] splitByCamelCase = nameQueryParam.split(camelCaseRegex);
        return "Hello " + String.join(" ", splitByCamelCase);
    }
}
