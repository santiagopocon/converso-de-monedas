import com.alura.challenge.modelo.ConexionApi;
import com.alura.challenge.modelo.Conversion;
import com.alura.challenge.modelo.Historico;
import com.alura.challenge.modelo.TipoDeCambio;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;
public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner teclado = new Scanner(System.in);
        String monedaOrigen;
        String monedaDestino = "USD";
        Double monto = 15.54;
        int opcion = 0;
        LocalDateTime fecha = LocalDateTime.now();

        System.out.println("""
                ----------------------------------------------------
                Bienvenidos al Conversor de Monedas
                Utilice codigos de moneda en formato ISO 4217
                ----------------------------------------------------          
                """);

        while (true){

            System.out.println("""
                    Ingrese la opcion que desea ejecutar:
                    1- Realizar conversion de monedas
                    2- Ver historico de conversiones
                    3- Salir
                    """);

            opcion = teclado.nextInt();

            switch (opcion){

                case 1:
                    System.out.println("Ingrese la moneda origen:");
                    monedaOrigen = teclado.next();
                    System.out.println("Ingrese la moneda destino:");
                    monedaDestino = teclado.next();
                    System.out.println("Ingrese el monto:");
                    monto = teclado.nextDouble();

                    Conversion prueba = new Conversion();

                    try {

                        Double resultadoconversion = prueba.conversionMoneda(monedaOrigen, monedaDestino, monto);

                        String montoFormato = String.format("%.4f", monto);
                        String resultadoConversionFormato = String.format("%.4f", resultadoconversion);

                        System.out.println("----------------------------------------------------");
                        System.out.println(monedaOrigen + " " + montoFormato + " equivale a " + monedaDestino + " " + resultadoConversionFormato);
                        System.out.println("----------------------------------------------------");

                        Historico bitacora = new Historico(fecha, monedaOrigen, monedaDestino, monto, resultadoconversion);
                        Historico.getBitacoraConsultas();

                    } catch (NullPointerException e){
                        System.out.println("""
                                _____________________________________________________________
                                Monedas incorrectas, intenta con una nuevas monedas por favor
                                _____________________________________________________________
                                """);
                    }

                    break;

                case 2:
                    System.out.println("________________________________________________________________________________________________________");
                    Historico.impresionBitacora();
                    System.out.println("________________________________________________________________________________________________________");
                    break;

                case 3:
                    System.out.println("""
                            ----------------------------------------------------
                            Finalizando el programa!
                            ----------------------------------------------------
                            """);
                    break;

                default:
                    System.out.println("""
                            ----------------------------------------------------
                            Opcion incorrecta
                            ----------------------------------------------------
                            """);
            }

            if (opcion == 3){
                break;
            }

        }
    }
}
