package com.springboot.time.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.springboot.time.sevice.ITimeService;

@ExtendWith(MockitoExtension.class)
public class TimeControllerTest {

   @InjectMocks
   TimeController timeController;
   
   @Mock
   ITimeService timeService;
   
   private static final String HH = "5";
   
   private static final String MM = "55";
   
   private static final String STRING_VALUE = "String";
   
   @Test
   public void testGetTime() {
      when(timeService.getTimeToWords(Integer.parseInt(HH), Integer.parseInt(MM))).thenReturn(STRING_VALUE);
      assertEquals(timeController.getTime(HH,MM),STRING_VALUE);
      verify(timeService, times(1)).getTimeToWords(Integer.parseInt(HH), Integer.parseInt(MM));
   }

   private void assertEquals(String time, String stringValue) {
      // TODO Auto-generated method stub
      
   }
}
