package com.codeid.microservices.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import springfox.documentation.annotations.ApiIgnore;

@Controller
@ApiIgnore
public class CustomErrorController implements ErrorController {

  @RequestMapping("/error")
  public void handleError() {
    throw new RuntimeException("Path Not Found");
  }

  @Override
  public String getErrorPath() {
    return "/eror";
  }
}
