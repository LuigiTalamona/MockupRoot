package org.talamona.mockup.tipicalCases.classStatic;

import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@PrepareForTest(StaticClass.class)
public class StaticClassTest extends PowerMockTestCase{
  @Test
  public void testStaticCalculateName() {
	  String expected = "100";
	  
	  PowerMockito.mockStatic(StaticClass.class);
	  Mockito.when(StaticClass.calculateName(0)).thenReturn(expected);
	  
	  String actual = StaticClass.calculateName(0);
	  assertEquals(actual, expected);
	  
	  PowerMockito.verifyStatic(Mockito.times(1));
	  StaticClass.calculateName(0);
	  
	  
	  
  }
}
