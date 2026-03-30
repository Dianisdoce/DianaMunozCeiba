package com.saucedemo.tasks;

import com.saucedemo.userinterfaces.InventarioPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.Tasks;

public class SeleccionarProducto implements Task {
    private final String nombreProducto;

    public SeleccionarProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(InventarioPage.BOTON_PRODUCTO.of(nombreProducto)),
                Click.on(InventarioPage.CARRITO),
                Click.on(InventarioPage.BOTON_CHECKOUT)
        );
    }

    public static SeleccionarProducto conNombre(String nombreProducto) {
        return Tasks.instrumented(SeleccionarProducto.class, nombreProducto);
    }
}
