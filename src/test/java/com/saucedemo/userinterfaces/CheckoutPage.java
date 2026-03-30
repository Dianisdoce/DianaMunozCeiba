package com.saucedemo.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutPage {
    public static final Target FIRST_NAME = Target.the("nombre")
            .located(By.xpath("//input[contains(@id, 'first-name')]"));
    public static final Target LAST_NAME = Target.the("apellido")
            .located(By.xpath("//input[contains(@name, 'lastName')]"));
    public static final Target ZIP_CODE = Target.the("código postal")
            .located(By.xpath("//input[starts-with(@id, 'postal')]"));
    public static final Target CONTINUE_BUTTON = Target.the("botón continuar")
            .located(By.xpath("//input[@type='submit' or @id='continue']"));
    public static final Target FINISH_BUTTON = Target.the("botón finalizar")
            .located(By.xpath("//button[contains(@id, 'finish') or text()='Finish']"));
    public static final Target MENSAJE_CONFIRMACION = Target.the("mensaje de confirmación")
            .located(By.xpath("//h2[contains(@class, 'complete-header')]"));
}
