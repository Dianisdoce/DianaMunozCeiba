package com.saucedemo.questions;

import com.saucedemo.userinterfaces.CheckoutPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ElMensaje {
    public static Question<String> deConfirmacion() {
        return actor -> Text.of(CheckoutPage.MENSAJE_CONFIRMACION)
                .answeredBy(actor);
    }
}
