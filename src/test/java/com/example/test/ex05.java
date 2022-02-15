package com.example.test;

import static com.codeborne.selenide.Selenide.*;

import java.util.List;

import static com.codeborne.selenide.Selectors.*;


import org.junit.Test;
import com.codeborne.selenide.SelenideElement;

public class ex05 {

	@Test
    public void test() {

		try {
			open("http://www.e-procurement.metro.tokyo.lg.jp/index.jsp");
			Thread.sleep(1000);
			
			$(byText("OK")).click();
			Thread.sleep(1000);
			
			$(byText("入札情報サービス")).click();
			Thread.sleep(1000);
			
			switchTo().window(1);
			$("#topMenuBtn03").click();
			Thread.sleep(1000);
			
			$(byName("StartDateYY")).val("4");
			$(byName("StartDateMM")).val("2");
			$(byName("StartDateDD")).val("15");
			$(byName("EndDateYY")).val("4");
			$(byName("EndDateMM")).val("3");
			$(byName("EndDateDD")).val("15");
			Thread.sleep(1000);
			
			$(byText("検索")).click();
			Thread.sleep(3000);
			
			SelenideElement table = $(".list-data").find("tbody");
			List<SelenideElement> element = table.$$("tr");
			 
			 int tr = table.$$("tr").size();
			 for(int i = 1; i <= tr; i++) {
				  List<String> tdlist = element.get(i).$$("td:nth-of-type(-n+3)").texts();
				  for(int j = 0; j <=2; j++) {
					  if(j == 2) {
						  System.out.print(tdlist.get(j));
						  continue;
					  }
					  System.out.print(tdlist.get(j) + ",");
				  }
				  System.out.println();
	            }
				
				Thread.sleep(2000);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
    }

}
