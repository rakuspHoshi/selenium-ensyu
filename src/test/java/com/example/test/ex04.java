package com.example.test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;


import org.junit.Test;



public class ex04 {

	@Test
    public void test() {
        // Googleトップページ
        // "selenide"を検索
        open("https://www.google.co.jp/");
        $("input[type=text]").val("selenide").pressEnter();

        // 検索ページ
        // Selenideの公式ページをクリック
        $(byText("Selenide: concise UI tests in Java")).click();

        // Selenide公式ページ
        // 「What is Selenide?」という文言があることを確認
        $("body").shouldHave(text("What is Selenide?"));
    }

}
