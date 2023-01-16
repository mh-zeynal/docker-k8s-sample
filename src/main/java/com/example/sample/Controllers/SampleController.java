package com.example.sample.Controllers;

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
    public ResponseEntity<?> sendHelloResponse(@RequestParam(defaultValue = "") String name){
        return new ResponseEntity<>(generateTextResponse(name), HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/author")
    public ResponseEntity<?> sendAuthorName(){
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
