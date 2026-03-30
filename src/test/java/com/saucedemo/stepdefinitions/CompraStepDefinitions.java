package com.saucedemo.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class CompraStepDefinitions {

    @Managed
    WebDriver driver;

    @Given("que el usuario abre la página de SauceDemo")
    public void queElUsuarioAbreLaPaginaDeSauceDemo() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("el usuario ingresa sus credenciales")
    public void elUsuarioIngresaSusCredenciales(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        driver.findElement(By.xpath("//input[contains(@id, 'user-name')]")).sendKeys(data.get(0).get("username"));
        driver.findElement(By.xpath("//input[contains(@name, 'password')]")).sendKeys(data.get(0).get("password"));
        driver.findElement(By.xpath("//input[@type='submit' or contains(@id, 'login')]")).click();
    }

    @When("agrega el producto {string} al carrito")
    public void agregaElProductoAlCarrito(String producto) {
        String xpathProducto = "//div[text()='" + producto + "']/ancestor::div[@class='inventory_item_description']//button";
        driver.findElement(By.xpath(xpathProducto)).click();
        driver.findElement(By.xpath("//a[contains(@class, 'shopping_cart_link')]")).click();
        driver.findElement(By.xpath("//button[contains(@id, 'checkout') or text()='Checkout']")).click();
    }

    @When("completa el proceso de checkout con sus datos de contacto")
    public void completaElProcesoDeCheckoutConSusDatosDeContacto(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        driver.findElement(By.xpath("//input[contains(@id, 'first-name')]")).sendKeys(data.get(0).get("firstName"));
        driver.findElement(By.xpath("//input[contains(@name, 'lastName')]")).sendKeys(data.get(0).get("lastName"));
        driver.findElement(By.xpath("//input[starts-with(@id, 'postal')]")).sendKeys(data.get(0).get("zipCode"));
        driver.findElement(By.xpath("//input[@type='submit' or @id='continue']")).click();
        driver.findElement(By.xpath("//button[contains(@id, 'finish') or text()='Finish']")).click();
    }

    @Then("debe ver el mensaje de confirmación {string}")
    public void debeVerElMensajeDeConfirmacion(String mensajeEsperado) {
        String mensajeReal = driver.findElement(By.xpath("//h2[contains(@class, 'complete-header')]")).getText();
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
        assert mensajeReal.equals(mensajeEsperado);
    }
}