package ipap.dbexemple;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
    private void testConnection(){
        String url = "jdbc:sqlserver://;serverName="+tHost.getText()+";databaseName="+tDBName.getText()+";encrypt=true;trustServerCertificate=true";
        String user= tUser.getText();
        String password = tPassword.getText();
        System.out.println("Тестируем соединение с "+url);

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Соединение установлено");
            labelMessage.setText("ОК");
        } catch (SQLException e) {
            System.out.println("Ошибка");
            System.out.println(e.getMessage());
            labelMessage.setText("Ошибка: "+e.getMessage());
        }
    }

}
