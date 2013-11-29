/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testjasperlibrary;

/**
 * Hard-Coded Constants
 */
public class Constants {

    // DB
    public static final String DB_JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_HOSTNAME_PORT = "localhost:3306";
    private static final String DB_DATABASE = "testreports";
    private static final String DB_PROPERTY_USER_PSW = "?user=root&password=";
    public static final String DB_SQL_URL
            = "jdbc:mysql://"
            + DB_HOSTNAME_PORT + "/"
            + DB_DATABASE
            + DB_PROPERTY_USER_PSW;

    // LOCAL PATH
    public static final String PATH_REPORT_TEMPLATES = "./Report/Templates/";
    public static final String PATH_REPORT_RESULTS = "./Report/Results/";
    // TEMPLATES
    public static final String PATH_TEMPLATE_CASE_01 = PATH_REPORT_TEMPLATES
            + "HelloReportWorld.jrxml";
    public static final String PATH_TEMPLATE_CASE_02 = PATH_REPORT_TEMPLATES
            + "TableFromDB.jrxml";
    // REPORTS
    public static final String PATH_RESULT_HTML_CASE_01 = PATH_REPORT_RESULTS
            + "HelloReportWorld.html";
    public static final String PATH_RESULT_HTML_CASE_02 = PATH_REPORT_RESULTS
            + "TableFromDB.html";
    public static final String PATH_RESULT_PDF_CASE_01 = PATH_REPORT_RESULTS
            + "HelloReportWorld.pdf";
    public static final String PATH_RESULT_PDF_CASE_02 = PATH_REPORT_RESULTS
            + "TableFromDB.pdf";
}
