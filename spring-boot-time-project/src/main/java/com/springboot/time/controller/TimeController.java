package com.springboot.time.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.time.exception.MyTimeException;
import com.springboot.time.sevice.ITimeService;

@RestController
@RequestMapping("/time")
public class TimeController {
   
   @Autowired
   ITimeService timeService;
   
   @GetMapping("/getTimeInWords/{hh}/{mm}")
   public String getTime(@PathVariable String hh,@PathVariable String mm) {
      int h = Integer.parseInt(hh);
      int m = Integer.parseInt(mm);
      if(h>23 || m>59 || hh.isEmpty() || mm.isEmpty()) {
         throw new MyTimeException(HttpStatus.BAD_REQUEST.value(),"Time : Hour between 0-23 range and Minute between 0-59");
      }
      return  timeService.getTimeToWords(h,m);
   }
   
   @ExceptionHandler(MyTimeException.class)
   void myTimeException(HttpServletResponse response, Throwable e) throws IOException {
      response.sendError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
   }

}
