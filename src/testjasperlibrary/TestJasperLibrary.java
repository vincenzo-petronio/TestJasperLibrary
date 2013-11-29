/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testjasperlibrary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Applicazione di test per generare report principalmente in formato PDF, con
 * dati proveniente da diverse sorgenti, tipicamente un DB. La libreria
 * utilizzata per la conversione è JasperReports.
 *
 * @author vincenzo.petronio 'AT' gmail.com
 * @version 1.0.0.0
 * @since JDK 1.4
 * @since JRE 1.3
 * @see <a
 * href="http://sourceforge.net/projects/jasperreports/files/jasperreports/">JasperReports</a>
 * @see <a
 * href="http://mvnrepository.com/artifact/com.lowagie/itext/2.1.7">iText
 * 2.1.7</a>
 */
public class TestJasperLibrary {

    /**
     * Entry-Point
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("\n\n########### REPORT ###########");
        System.out.println("Digita il tipo di Report da compilare: DB, EMPTY, XML, JSON, POJOS, MAP");

        BufferedReader brInput = new BufferedReader(new InputStreamReader(System.in));
        String s;

        try {
            s = brInput.readLine();
            System.out.println("[ARGS] \t" + s.toUpperCase());

            if (s.length() > 1) {
                JasperHelper jh = JasperHelper.getJasperHelper();
                switch (s.toUpperCase()) {
                    case "DB":
                        jh.CompilaReport(JasperHelper.DataSourceType.DB);
                        break;
                    case "EMPTY":
                        jh.CompilaReport(JasperHelper.DataSourceType.EMPTY);
                        break;
                    case "XML":
                        jh.CompilaReport(JasperHelper.DataSourceType.XML);
                        break;
                    case "JSON":
                        jh.CompilaReport(JasperHelper.DataSourceType.JSON);
                        break;
                    case "POJOS":
                        jh.CompilaReport(JasperHelper.DataSourceType.POJOS);
                        break;
                    case "MAP":
                        jh.CompilaReport(JasperHelper.DataSourceType.MAP);
                        break;
                }
            }
        } catch (IOException ioe) {
            System.err.println("IOEXCEPTION!!! \n" + ioe.toString());
        }
    }
}
