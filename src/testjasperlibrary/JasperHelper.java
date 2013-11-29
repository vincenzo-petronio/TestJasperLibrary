/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testjasperlibrary;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 * Fornisce una serie di metodi utili alla generazione di Report attraverso la
 * libreria JasperReports.
 */
public class JasperHelper {

    private static JasperHelper jasperHelper;
    private Map<String, Object> params = null;
    private JasperReport jasperReport;
    private JasperPrint jasperPrint;
    private Connection conn;

    /**
     * Singleton Costruttore
     */
    private JasperHelper() {
        params = new HashMap<String, Object>();
    }

    /**
     * Tipo di JRDataSource da utilizzare, a seconda del Report da generare.
     */
    public enum DataSourceType {

        DB, EMPTY, XML, JSON, POJOS, MAP
    };

    /**
     * Restituisce l'istanza della classe JasperHelper. Singleton.
     *
     * @return JasperHelper
     */
    public static JasperHelper getJasperHelper() {
        if (jasperHelper == null) {
            jasperHelper = new JasperHelper();
            System.out.println("[JASPERHELPER] \t" + "Singleton creato!");
        }
        return jasperHelper;
    }

    /**
     * Genera il report a seconda del tipo di DataSource richiesta.
     *
     * @param dst enum DataSourceType
     */
    public void CompilaReport(DataSourceType dst) {
        try {
            switch (dst) {
                case DB: {
                    DbHelper dbHelper = new DbHelper();
                    conn = dbHelper.getConnection();
                    jasperReport = JasperCompileManager.compileReport(
                            Constants.PATH_TEMPLATE_CASE_02);
                    jasperPrint = JasperFillManager.fillReport(
                            jasperReport, params, conn);
                    JasperExportManager.exportReportToHtmlFile(
                            jasperPrint, Constants.PATH_RESULT_HTML_CASE_02);
                    JasperExportManager.exportReportToPdfFile(
                            jasperPrint, Constants.PATH_RESULT_PDF_CASE_02);
                    conn.close();
                }
                break;
                case EMPTY: {
                    jasperReport = JasperCompileManager.compileReport(
                            Constants.PATH_TEMPLATE_CASE_01);
                    jasperPrint = JasperFillManager.fillReport(
                            jasperReport, params, new JREmptyDataSource());
                    JasperExportManager.exportReportToHtmlFile(
                            jasperPrint, Constants.PATH_RESULT_HTML_CASE_01);
                    JasperExportManager.exportReportToPdfFile(
                            jasperPrint, Constants.PATH_RESULT_PDF_CASE_01);
                }
                break;
                case JSON:
                    break;
                case MAP:
                    break;
                case POJOS:
                    break;
                case XML:
                    break;
                default:
                    break;
            }
        } catch (JRException jre) {
            System.err.println("[JASPERHELPER] \t" + "JREXCEPTION!!!\n" + jre.toString());
        } catch (SQLException sqle) {
            System.err.println("[JASPERHELPER] \t" + "SQLEXCEPTION!!!\n" + sqle.toString());
        }

    }
}
