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

            document.close();

            System.out.println("Se ha creado el documento PDF");
            return true;
        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(Generador_PDF.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
