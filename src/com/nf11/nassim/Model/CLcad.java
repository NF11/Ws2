package com.nf11.nassim.Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CLcad {

    private String connectionUrl;
    private String login;
    private String psw;
    private Connection con;
    private Statement stmt;
    private ResultSet rs;


    public String getConnectionUrl() {
        return connectionUrl;
    }

    public void setConnectionUrl(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public Connection getCon() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(this.connectionUrl,this.login,this.psw);
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public Statement getStmt() {
        return stmt;
    }

    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public CLcad() throws SQLException, ClassNotFoundException {
        this.connectionUrl = "jdbc:mysql://localhost/javaprojet";
        this.login = "root";
        this.psw = "";
        this.stmt = getCon().createStatement();
    }

    public ResultSet m_getRows (String select) throws SQLException, ClassNotFoundException {

        return getStmt().executeQuery(select);
    }

    public int m_actionRows(String sql) throws SQLException {

        return getStmt().executeUpdate(sql);
    }
}
