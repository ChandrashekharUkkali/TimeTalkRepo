package com.springboot.time.sevice;

import java.time.LocalTime;

import org.springframework.stereotype.Service;

import com.springboot.time.exception.MyTimeException;

@Service
public class TimeServiceImpl implements ITimeService{

   @Override
   public String getTimeToWords(int h, int m) throws MyTimeException{
      String[] words = new String[] { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
            "nineteen", "twenty", "twenty one", "twenty two", "twenty three", "twenty four", "twenty five",
            "twenty six", "twenty seven", "twenty eight", "twenty nine","thirty",
            "thirty one", "thirty two", "thirty three", "thirty four", "thirty five",
            "thirty six", "thirty seven", "thirty eight", "thirty nine", "fourty",
            "fourty one", "fourty two", "fourty three", "fourty four", "fourty five",
            "fourty six", "fourty seven", "fourty eight", "fourty nine","fifty",
            "fifty one", "fifty two", "fifty three", "fifty four", "fifty five",
            "fifty six", "fifty seven", "fifty eight", "fifty nine"};
      
      LocalTime time2 = LocalTime.of(h, m);
      if(time2.getHour()>=12) {
         int hh = (time2.getHour()%12);
         return hh+":"+m+" PM---->"+" : MidDay : "+words[hh]+" hour "+words[m]+" miutes\n";
      }else {
         return h+":"+m+" AM----->"+" : MidNight : "+words[h]+" hour "+ words[m]+" miutes\n";
      }
   }

}
