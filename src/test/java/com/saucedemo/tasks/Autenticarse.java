package com.saucedemo.tasks;

import com.saucedemo.userinterfaces.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.Tasks;

public class Autenticarse implements Task {

    private final String usuario;
    private final String clave;

    public Autenticarse(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(usuario).into(LoginPage.USER_FIELD),
                Enter.theValue(clave).into(LoginPage.PASSWORD_FIELD),
                Click.on(LoginPage.LOGIN_BUTTON)
        );
    }

    public static Autenticarse conCredenciales(String usuario, String clave) {
        return Tasks.instrumented(Autenticarse.class, usuario, clave);
    }
}
