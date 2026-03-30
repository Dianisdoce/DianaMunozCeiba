Feature: Compra de artículos en SauceDemo

  @regresion
  Scenario: Confirmación de compra exitosa para un usuario estándar
    Given que el usuario abre la página de SauceDemo
    When el usuario ingresa sus credenciales
      | username      | password     |
      | standard_user | secret_sauce |
    And agrega el producto "Sauce Labs Backpack" al carrito
    And completa el proceso de checkout con sus datos de contacto
      | firstName | lastName | zipCode |
      | Diana     | Munoz    | 05001   |
    Then debe ver el mensaje de confirmación "Thank you for your order!"