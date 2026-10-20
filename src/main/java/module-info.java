module ipap.dbexemple {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens ipap.dbexemple to javafx.fxml;
    exports ipap.dbexemple;
}