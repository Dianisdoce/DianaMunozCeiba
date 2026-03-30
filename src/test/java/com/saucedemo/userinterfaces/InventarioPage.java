package com.saucedemo.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class InventarioPage {
    public static final Target BOTON_PRODUCTO = Target.the("botón para agregar producto")
            .locatedBy("//div[text()='{0}']/ancestor::div[@class='inventory_item_description']//button");

    public static final Target CARRITO = Target.the("botón del carrito")
            .located(By.xpath("//a[contains(@class, 'shopping_cart_link')]"));

    public static final Target BOTON_CHECKOUT = Target.the("botón de checkout")
            .located(By.xpath("//button[contains(@id, 'checkout') or text()='Checkout']"));
}
