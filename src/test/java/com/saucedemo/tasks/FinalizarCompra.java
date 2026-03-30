package com.saucedemo.tasks;

import com.saucedemo.userinterfaces.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.Tasks;

public class FinalizarCompra implements Task {
    private final String nombre;
    private final String apellido;
    private final String zip;

    public FinalizarCompra(String nombre, String apellido, String zip) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.zip = zip;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(nombre).into(CheckoutPage.FIRST_NAME),
                Enter.theValue(apellido).into(CheckoutPage.LAST_NAME),
                Enter.theValue(zip).into(CheckoutPage.ZIP_CODE),
                Click.on(CheckoutPage.CONTINUE_BUTTON),
                Click.on(CheckoutPage.FINISH_BUTTON)
        );
    }

    public static FinalizarCompra conDatos(String nombre, String apellido, String zip) {
        return Tasks.instrumented(FinalizarCompra.class, nombre, apellido, zip);
    }
}
