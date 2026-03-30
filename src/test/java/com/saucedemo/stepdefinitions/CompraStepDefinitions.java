package com.saucedemo.stepdefinitions;

import com.saucedemo.questions.ElMensaje;
import com.saucedemo.tasks.Autenticarse;
import com.saucedemo.tasks.FinalizarCompra;
import com.saucedemo.tasks.SeleccionarProducto;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CompraStepDefinitions {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("que el usuario abre la página de SauceDemo")
    public void queElUsuarioAbreLaPaginaDeSauceDemo() {
        theActorCalled("Diana").attemptsTo(
                Open.url("https://www.saucedemo.com/")
        );
    }

    @When("el usuario ingresa sus credenciales")
    public void elUsuarioIngresaSusCredenciales(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        theActorInTheSpotlight().attemptsTo(
                Autenticarse.conCredenciales(data.get(0).get("username"), data.get(0).get("password"))
        );
    }

    @When("agrega el producto {string} al carrito")
    public void agregaElProductoAlCarrito(String producto) {
        theActorInTheSpotlight().attemptsTo(
                SeleccionarProducto.conNombre(producto)
        );
    }

    @When("completa el proceso de checkout con sus datos de contacto")
    public void completaElProcesoDeCheckoutConSusDatosDeContacto(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        theActorInTheSpotlight().attemptsTo(
                FinalizarCompra.conDatos(
                        data.get(0).get("firstName"),
                        data.get(0).get("lastName"),
                        data.get(0).get("zipCode")
                )
        );
    }

    @Then("debe ver el mensaje de confirmación {string}")
    public void debeVerElMensajeDeConfirmacion(String mensajeEsperado) {
        theActorInTheSpotlight().should(
                net.serenitybdd.screenplay.GivenWhenThen.seeThat(
                        ElMensaje.deConfirmacion(),
                        org.hamcrest.Matchers.equalTo(mensajeEsperado)
                )
        );
    }
}