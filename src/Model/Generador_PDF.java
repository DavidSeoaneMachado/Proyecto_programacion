package Model;

import Controller.Controller;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

//Clase que gestiona la generación de un PDF con la rutina del cliente//
public class Generador_PDF {

    Controller controlador = new Controller();

    /**
     * Método que genera el PDF y plasma la información del planning del cliente
     * @return un booleano confirmando o no el éxito
     */
    public Boolean generar_pdf(JTable tabla1, JTable tabla2) {

        try {
            Document document = new Document();
            String destino = "src/recursos/planning.pdf";
            PdfWriter.getInstance(document, new FileOutputStream(destino));
            document.open();

            Paragraph header = new Paragraph("-||- Verdansk Fitness -||-");
            header.setAlignment(Element.ALIGN_CENTER);
            document.add(header);
            document.add(new Chunk("\n"));  document.add(new Chunk("\n"));

            Phrase p = new Phrase("Planning de dieta y rutina de ejercicios para " + controlador.getCliente_sesion_actual().getNombre() + " " + controlador.getCliente_sesion_actual().getApellido() + ".");
            document.add(p);
            document.add(new Chunk("\n"));

            Phrase p2 = new Phrase("Dieta de " + controlador.getCliente_sesion_actual().getTipo_dieta() + " y nivel de experiencia en el gimnasio: " + controlador.getCliente_sesion_actual().getExperiencia()+ ".");
            document.add(p2);
            document.add(new Chunk("\n"));
            document.add(new Chunk("\n"));

            Paragraph p3 = new Paragraph("|| Dieta. ||");
            p3.setAlignment(Element.ALIGN_CENTER);
            document.add(p3);
            document.add(new Chunk("\n"));

            //Configuramos la tabla que se va a mostrar en el PDF con la tabla recibida por parametros, que es la mostrada en las vistas//
            PdfPTable pdfPTable = new PdfPTable(tabla1.getColumnCount());

            // Agregar encabezados de columna a la tabla PDF
            for (int i = 0; i < tabla1.getColumnCount(); i++) {
                pdfPTable.addCell(tabla1.getColumnName(i));
            }

            // Agregar filas y celdas de datos a la tabla PDF
            for (int rows = 0; rows < tabla1.getRowCount(); rows++) {
                for (int cols = 0; cols < tabla1.getColumnCount(); cols++) {
                    pdfPTable.addCell(tabla1.getModel().getValueAt(rows, cols).toString());
                }
            }

            // Agregar la tabla al documento
            document.add(pdfPTable);
            document.add(new Chunk("\n"));

            if (controlador.getCliente_sesion_actual().getTipo_dieta().equals("Mantenimiento")){
                Phrase tip1 = new Phrase("-En el desayuno tienes mas libertad. Gestionalo como mejor veas dependiendo de la hora y sin pasarse.");
                document.add(tip1);
                document.add(new Chunk("\n"));
                Phrase tip2 = new Phrase("-En el almuerzo aproximadamente 200-300g de proteína y entre 100-150 de los hidratos acompañantes.");
                document.add(tip2);
                document.add(new Chunk("\n"));
                Phrase tip3 = new Phrase("-En la merienda lo estipulado. Si tienes mas hambre puedes añadir un par de tortitas de arroz o otra fruta.");
                document.add(tip3);
                document.add(new Chunk("\n"));
                Phrase tip4 = new Phrase("-En la cena aproximadamente 200-300g de proteína y sobre 100 de los hidratos acompañantes.");
                document.add(tip4);
                document.add(new Chunk("\n"));
            } else if (controlador.getCliente_sesion_actual().getTipo_dieta().equals("Deficit calórico (perder peso)")) {
                Phrase tip1 = new Phrase("-En el desayuno lo estipulado. Gestionalo como mejor veas y añade extras como tortitas de arroz si tienes hambre.");
                document.add(tip1);
                document.add(new Chunk("\n"));
                Phrase tip2 = new Phrase("-En el almuerzo aproximadamente 200g de proteína y 100g de los hidratos acompañantes.)");
                document.add(tip2);
                document.add(new Chunk("\n"));
                Phrase tip3 = new Phrase("-En la merienda lo estipulado. Si tienes mas hambre puedes añadir un par de tortitas de arroz o otra fruta.");
                document.add(tip3);
                document.add(new Chunk("\n"));
                Phrase tip4 = new Phrase("-En la cena aproximadamente 200g de proteína y sobre 100 (si puedes algo menos) de los hidratos acompañantes.");
                document.add(tip4);
                document.add(new Chunk("\n"));
            } else if (controlador.getCliente_sesion_actual().getTipo_dieta().equals("Superhabit calórico (ganar peso)")) {
                Phrase tip1 = new Phrase("-En el desayuno tienes mas libertad para cargar. Gestionalo como mejor veas dependiendo de la hora y teniendo en cuanta que el resto de comidas también va a ser potentes.");
                document.add(tip1);
                document.add(new Chunk("\n"));
                Phrase tip2 = new Phrase("-En el almuerzo aproximadamente 300-400g de proteína y 200g de los hidratos acompañantes. ");
                document.add(tip2);
                document.add(new Chunk("\n"));
                Phrase tip3 = new Phrase("-En la merienda lo estipulado. Si es antes o inmediatamente después del entrenamiento puedes cargar más.");
                document.add(tip3);
                document.add(new Chunk("\n"));
                Phrase tip4 = new Phrase("-En la cena aproximadamente 300-350g de proteína y sobre 150-200 (según como te veas) de los hidratos acompañantes.");
                document.add(tip4);
                document.add(new Chunk("\n"));
            }

            document.add(new Chunk("\n"));
            Paragraph p4 = new Paragraph("|| Rutina de ejercicios. ||");
            p4.setAlignment(Element.ALIGN_CENTER);
            document.add(p4);
            document.add(new Chunk("\n"));

            //Configuramos la tabla que se va a mostrar en el PDF con la tabla recibida por parametros, que es la mostrada en las vistas//
            PdfPTable pdfPTable2 = new PdfPTable(tabla2.getColumnCount());

            // Agregar encabezados de columna a la tabla PDF
            for (int i = 0; i < tabla2.getColumnCount(); i++) {
                pdfPTable2.addCell(tabla2.getColumnName(i));
            }

            // Agregar filas y celdas de datos a la tabla PDF
            for (int rows = 0; rows < tabla2.getRowCount(); rows++) {
                for (int cols = 0; cols < tabla2.getColumnCount(); cols++) {
                    pdfPTable2.addCell(tabla2.getModel().getValueAt(rows, cols).toString());
                }
            }

            // Agregar la tabla al documento
            document.add(pdfPTable2);
            document.add(new Chunk("\n"));


            if (controlador.getCliente_sesion_actual().getTipo_dieta().equals("Mantenimiento")){
                Phrase tip1 = new Phrase("-Prioriza la técnica del ejercicio a la cantidad de peso que puedas tirar pero intentando progresar cada 1-2 semanas en esta última.");
                document.add(tip1);
                document.add(new Chunk("\n"));
                Phrase tip2 = new Phrase("-Salvo en los ultimos 2 ejercicios no vas a ir al fallo. Vas a tirar mas o menos un 70-80% del maximo que podrias.");
                document.add(tip2);
                document.add(new Chunk("\n"));
                Phrase tip3 = new Phrase("-Busca que los descansos entre series sean de 2-3 minutos. Dependiendo de tu nivel de fatiga.");
                document.add(tip3);
                document.add(new Chunk("\n"));
                Phrase tip4 = new Phrase("-Vas a hacer 4 series da cada ejercicio.");
                document.add(tip4);
                document.add(new Chunk("\n"));
            } else if (controlador.getCliente_sesion_actual().getTipo_dieta().equals("Deficit calórico (perder peso)")) {
                Phrase tip1 = new Phrase("-Prioriza la técnica del ejercicio a la cantidad de peso que puedas tirar. Si te ves capaz sube los pesos, pero no es nuestra prioridad.");
                document.add(tip1);
                document.add(new Chunk("\n"));
                Phrase tip2 = new Phrase("-Vas a ir al fallo en cada ejercicio pero priorizando un numero de repeticiones alto y no menor del indicado (siempre con un peso medianamente exigente.)");
                document.add(tip2);
                document.add(new Chunk("\n"));
                Phrase tip3 = new Phrase("-Busca que los descansos entre series sean de 1-1'5 o como mucho 2 minutos.");
                document.add(tip3);
                document.add(new Chunk("\n"));
                Phrase tip4 = new Phrase("-Vas a hacer 5 series da cada ejercicio.");
                document.add(tip4);
                document.add(new Chunk("\n"));
            } else if (controlador.getCliente_sesion_actual().getTipo_dieta().equals("Superhabit calórico (ganar peso)")) {
                Phrase tip1 = new Phrase("-Prioriza la técnica del ejercicio a la cantidad de peso que puedas tirar. Una vez que tengas dominado el ejercicio con cierto peso busca progresar.");
                document.add(tip1);
                document.add(new Chunk("\n"));
                Phrase tip2 = new Phrase("-Vas a ir al fallo en cada ejercicio pero priorizando subir las cargas de peso. Estarás mas cerca de tirar menos repeticiones de las inidcadas por defecto que de tirar más. ");
                document.add(tip2);
                document.add(new Chunk("\n"));
                Phrase tip3 = new Phrase("-Busca que los descansos entre series sean de 3-4 o hasta 5 minutos. Buscamos que estes 100% preparado para cada serie, por lo que la recuperación es esencial.");
                document.add(tip3);
                document.add(new Chunk("\n"));
                Phrase tip4 = new Phrase("-Vas a hacer 4-5 series da cada ejercicio.");
                document.add(tip4);
                document.add(new Chunk("\n"));
            }

            document.close();

            System.out.println("Se ha creado el documento PDF");
            return true;
        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(Generador_PDF.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
