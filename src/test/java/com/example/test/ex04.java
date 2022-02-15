package com.example.test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;


import org.junit.Test;



public class ex04 {

	@Test
    public void test() {
        // Google�g�b�v�y�[�W
        // "selenide"������
        open("https://www.google.co.jp/");
        $("input[type=text]").val("selenide").pressEnter();

        // �����y�[�W
        // Selenide�̌����y�[�W���N���b�N
        $(byText("Selenide: concise UI tests in Java")).click();

        // Selenide�����y�[�W
        // �uWhat is Selenide?�v�Ƃ������������邱�Ƃ��m�F
        $("body").shouldHave(text("What is Selenide?"));
    }

}
