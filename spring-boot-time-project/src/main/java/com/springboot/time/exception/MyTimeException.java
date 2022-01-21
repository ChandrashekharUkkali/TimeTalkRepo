package com.springboot.time.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class MyTimeException extends RuntimeException {
   
   /**
    * 
    */
   private static final long serialVersionUID = 1L;
   
   private String message;
   
   private Throwable cause;
   
   private HttpStatus httpStatus;
   
   private int status;

   public MyTimeException() {
      super();
   }

   public MyTimeException(String message) {
      super(message);
      this.message = message;
   }
   
   public MyTimeException(int status,String message) {
      super(message);
      this.status = status;
      this.message = message;
   }

   public MyTimeException(String message, Throwable cause) {
      super(message, cause);
      this.message = message;
      this.cause = cause;
   }

   public MyTimeException(Throwable cause) {
      super(cause);
      this.cause = cause;
   }
   
   public MyTimeException(HttpStatus httpStatus, String message, Exception cause) {
      super(message, cause);
      this.message = message;
      this.cause = cause;
      this.httpStatus = httpStatus;
   }
   
}
