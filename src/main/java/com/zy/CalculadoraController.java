/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.zy;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author adm-yz
 */
public class CalculadoraController implements Initializable  {

    private double valor1 = 0;
    private String operacion = "";
    private Map<String, String> map;
    private boolean nextValor = true;
    private boolean finOperacion = false;
    @FXML
    private TextField preNumeros;
    private double memoria;

    @FXML
    private Button nine;
    @FXML
    private Button ce;

    @FXML
    private Button minus;

    @FXML
    private Button plusminus;

    @FXML
    private Button factorial;

    @FXML
    private Button seven;

    @FXML
    private Button back;

    @FXML
    private Button two;

    @FXML
    private Button three;

    @FXML
    private Button point;

    @FXML
    private Button eight;

    @FXML
    private Button zero;
   
    @FXML
    private TextField memory;

    @FXML
    private TextField numeros;

    @FXML
    private Button sqr;

    @FXML
    private Button four;

    @FXML
    private Button mc;

    @FXML
    private Button pow;

    @FXML
    private Button divide;

    @FXML
    private Button multiply;

    @FXML
    private Button five;

    @FXML
    private Button prime;

    @FXML
    private Button six;

    @FXML
    private Button mr;

    @FXML
    private Button ms;

    @FXML
    private Button one;

    @FXML
    private Button clear;

    @FXML
    private Button plus;

    @FXML
    private Button equal;

    @FXML
    private Button exit;

    @FXML
    private Button mplus;

    @FXML
    private Button percentage;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        Button botonPresionado = (Button) event.getSource();
        String textoBoton = botonPresionado.getId();

        switch (textoBoton) {
            case "one":
            case "two":
            case "three":
            case "four":
            case "five":
            case "six":
            case "seven":
            case "eight":
            case "nine":
            case "zero":
            case "point":
                if (nextValor) {
                    numeros.clear();
                    nextValor = false;
                    if (finOperacion) {
                        preNumeros.clear();
                        finOperacion = false;
                    }
                }

                numeros.appendText(map.get(textoBoton));
                break;

            case "back":
                String text=numeros.getText();
                if(text.length()!=0){
                    numeros.setText(text.substring(0, text.length()-1));
                }else{
                    numeros.setText("0");
                    nextValor=true;
                }

                break;
            case "plus":
                operacion("+");
                break;
            case "minus":
                operacion("-");
                break;
            case "multiply":
                operacion("x");
                break;
            case "divide":
                operacion("/");
                break;
            case "pow":
                operacion("^");
                break;
            case "sqr":
                numeros.appendText("");
                break;
            case "factorial":
                valor1 = Double.parseDouble(numeros.getText());
                calcularFactorial(valor1);
                break;
            case "prime":
                valor1 = Double.parseDouble(numeros.getText());
                if (esPrime(valor1)) {
                    mostrarAlerta("Es Primo", valor1 + " es un número primo.");
                } else {
                    mostrarAlerta("No es Primo", valor1 + " no es un número primo.");
                }
                ;
            case "square":

                calcularCuadrado();
                break;
            case "equal":
                realizarOperacion(numeros.getText());
                break;
            case "clear":
                numeros.setText("0");
                preNumeros.setText("");
                operacion = "";
                valor1 = 0;
                nextValor = true;
                break;
            case "ce":
                numeros.setText("0");
                nextValor = true;
                break;
            case "percentage":
                calcularPorcentaje();
                break;

            case "plusminus":
                String textoActual = numeros.getText();
                if (!textoActual.isEmpty() && !textoActual.equals("0")) {
                    double numeroActual = Double.parseDouble(textoActual);
                    numeroActual *= -1; // Cambiar el signo
                    numeros.setText(String.valueOf(numeroActual));
                }
                break;
            case "exit":
                System.exit(0);
                break;
            case "mr":
            // Retrieve the value from memory and set it in the TextField
            numeros.setText(String.valueOf(memoria));
            nextValor = true;
            break;
        case "ms":
            // Store the current value in the TextField to memory
            memoria = Double.parseDouble(numeros.getText());
            memory.setText(String.valueOf(memoria));
            nextValor=true;
            break;
        case "mc":
            // Clear the value in memory
            memoria = 0;
            memory.setText(String.valueOf(memoria));
            nextValor=true;
            break;
        case "mplus":
            // Add the current value to memory
            if(!numeros.getText().isEmpty()){
                memoria += Double.parseDouble(numeros.getText());
                memory.setText(String.valueOf(memoria));
                nextValor=true;
            }
            
            break;
        case "msubtract":
            // Subtract the current value from memory
            if(!numeros.getText().isEmpty()){
                memoria -= Double.parseDouble(numeros.getText());
                memory.setText(String.valueOf(memoria));
                nextValor=true;
            }
            
            break;
            default:
                break;
        }
    }

    private void realizarOperacion(String texto) {
        double valor2 = Double.parseDouble(texto);
        double resultado = 0;
        preNumeros.setText(valor1+ " "+ operacion+" " + valor2 + " = ");
        switch (operacion) {
            case "+":
                resultado = valor1 + valor2;
                break;
            case "-":
                resultado = valor1 - valor2;
                break;
            case "x":
                resultado = valor1 * valor2;
                break;
            case "/":
                if (valor2 != 0) {
                    resultado = valor1 / valor2;
                    preNumeros.appendText(" " + valor2 + " = ");
                } else {
                    // Manejar la división por cero según tus necesidades
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Error: División por cero");
                    alert.showAndWait();
                    return;
                }
                break;
            case "^":
                resultado = Math.pow(valor1, valor2);
                break;
            // Puedes agregar más casos para otras operaciones según sea necesario
            default:
                preNumeros.setText("");
                return;
        }

        // Formatear el resultado si es un número entero
        if (resultado % 1 == 0) {
            int resultadoEntero = (int) resultado;
            numeros.setText(String.valueOf(resultadoEntero));
        } else {
            numeros.setText(String.valueOf(resultado));
        }

        nextValor = true;
        finOperacion = true;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        // TODO
        map = new HashMap<>();

        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");
        map.put("point", ".");
    }

    public void calcularFactorial(double n) {
        // Verificar si el número es no negativo
        if (n < 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("The factorial is not defined for negative numbers");
            alert.showAndWait();
        }
        
        if (n != (int) n) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("El factorial no soporta números con decimales");
        alert.showAndWait();
        return; // Salir del método si hay un error
    }
        preNumeros.setText("f(" + n + ")");

        // Inicializar el resultado como 1
        long resultado = 1;

        // Calcular el factorial utilizando un bucle
        for (int i = 1; i <= n; i++) {
            resultado *= i;
            if (resultado < 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("The result of the factorial is too large to be represented with the data type long");
            alert.showAndWait();
            return; // Salir del método si hay un error
        }
        }
        numeros.setText(String.valueOf(resultado));
        valor1 = resultado;

    }

    private void operacion(String operacion) {

        if(!this.operacion.isEmpty()){
            realizarOperacion(numeros.getText());
        }
        this.operacion = operacion;

        valor1 = Double.parseDouble(numeros.getText());

        preNumeros.setText(String.valueOf(valor1) + " " + operacion);

        finOperacion = false;
        nextValor = true;
    }

    private boolean esPrime(double numero) {
        if (numero <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);

        alert.showAndWait();
    }

    private void calcularCuadrado() {
        if (!numeros.getText().isEmpty()) {
            double numeroActual = Double.parseDouble(numeros.getText());
            double resultado = Math.sqrt(numeroActual);
            numeros.setText(String.valueOf(resultado));
            preNumeros.setText("sqrt(" + numeroActual + ")");
            valor1 = resultado;
            finOperacion = true;
            nextValor = true;
        }
    }

    private void calcularPorcentaje() {
        if (!numeros.getText().isEmpty()) {
            double numeroActual = Double.parseDouble(numeros.getText());
            double resultado = numeroActual * 0.01;
            numeros.setText(String.valueOf(resultado));
            preNumeros.setText(numeroActual + "%");
            valor1 = resultado;
            finOperacion = true;
            nextValor = true;
        }
    }


}
