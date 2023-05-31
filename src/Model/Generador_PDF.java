package Model;

import Controller.Controller;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.Array;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Generador_PDF {

    Controller controlador = new Controller();

    /*Metodo en construcción*/
    public Boolean generar_pdf(JTable tabla) {

        try {
            Document document = new Document();
            String destino = "src/recursos/planning.pdf";
            PdfWriter.getInstance(document, new FileOutputStream(destino));
            document.open();

            Paragraph header = new Paragraph("Verdansk Fitness");
            header.setAlignment(Element.ALIGN_CENTER);
            document.add(header);
            document.add(new Chunk("\n"));  document.add(new Chunk("\n"));

            Phrase p = new Phrase("Planning de dieta y rutina de ejercicios para " + controlador.getCliente_sesion_actual().getNombre() + " " + controlador.getCliente_sesion_actual().getApellido());
            document.add(p);
            document.add(new Chunk("\n"));

            Phrase p2 = new Phrase("Dieta de " + controlador.getCliente_sesion_actual().getTipo_dieta() + " y nivel de experiencia en el gimnasio: " + controlador.getCliente_sesion_actual().getExperiencia());
            document.add(p2);
            document.add(new Chunk("\n"));
            document.add(new Chunk("\n"));

            Paragraph p3 = new Paragraph("Dieta");
            p3.setAlignment(Element.ALIGN_CENTER);
            document.add(p3);
            document.add(new Chunk("\n"));

            //Configuramos la tabla que se va a mostrar en el PDF con la tabla recibida por parametros, que es la mostrada en las vistas//
            PdfPTable pdfPTable = new PdfPTable(tabla.getColumnCount());

            // Agregar encabezados de columna a la tabla PDF
            for (int i = 0; i < tabla.getColumnCount(); i++) {
                pdfPTable.addCell(tabla.getColumnName(i));
            }

            // Agregar filas y celdas de datos a la tabla PDF
            for (int rows = 0; rows < tabla.getRowCount(); rows++) {
                for (int cols = 0; cols < tabla.getColumnCount(); cols++) {
                    pdfPTable.addCell(tabla.getModel().getValueAt(rows, cols).toString());
                }
            }

            // Agregar la tabla al documento
            document.add(pdfPTable);
            document.add(new Chunk("\n"));

            Paragraph p4 = new Paragraph("Rutina de ejercicios");
            p4.setAlignment(Element.ALIGN_CENTER);
            document.add(p4);
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
