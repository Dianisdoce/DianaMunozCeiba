package com.saucedemo.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {
    public static final Target USER_FIELD = Target.the("campo nombre de usuario")
            .located(By.xpath("//input[contains(@id, 'user-name')]"));

    public static final Target PASSWORD_FIELD = Target.the("campo contraseña")
            .located(By.xpath("//input[contains(@name, 'password')]"));

    public static final Target LOGIN_BUTTON = Target.the("botón de inicio de sesión")
            .located(By.xpath("//input[@type='submit' or contains(@id, 'login')]"));
}
