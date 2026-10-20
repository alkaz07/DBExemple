package ipap.dbexemple;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.*;

public class HelloController {

    @FXML
    private TextField tDBName;

    @FXML
    private TextField tHost;

    @FXML
    private PasswordField tPassword;

    @FXML
    private TextField tPort;

    @FXML
    private TextField tUser;

    @FXML
    private Label labelMessage;

    @FXML
    private TextArea areaBooks;

    @FXML
    private void testConnection(){
//        String url = "jdbc:sqlserver://;serverName="+tHost.getText()+";databaseName="+tDBName.getText()+";encrypt=true;trustServerCertificate=true";
//        String user= tUser.getText();
//        String password = tPassword.getText();
//        System.out.println("Тестируем соединение с "+url);

        try (Connection connection = getConnection()) {
            System.out.println("Соединение установлено");
            labelMessage.setText("ОК");
        } catch (SQLException e) {
            System.out.println("Ошибка");
            System.out.println(e.getMessage());
            labelMessage.setText("Ошибка: "+e.getMessage());
        }
    }

    public Connection getConnection() throws SQLException {
        String url = "jdbc:sqlserver://;serverName="+tHost.getText()+";databaseName="+tDBName.getText()+";encrypt=true;trustServerCertificate=true";
        String user= tUser.getText();
        String password = tPassword.getText();
        return DriverManager.getConnection(url, user,password);
    }

    @FXML
    private void loadBooks(){
        areaBooks.clear();
        try(Connection con = getConnection()){
            String q = "select * from Book";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(q);
            while (resultSet.next()){
                int isbn = resultSet.getInt("isbn");
                String name = resultSet.getString("Title");
                int y = resultSet.getInt("year");
                areaBooks.appendText("\n"+isbn+"\t\t\t"+name+"\t\t\t"+y);
            }

        } catch (SQLException e) {
            areaBooks.setText("Ничего невышло");
            areaBooks.appendText("\n"+e.getMessage());
        }

    }
}
