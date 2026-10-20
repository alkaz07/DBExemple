module ipap.dbexemple {
    requires javafx.controls;
    requires javafx.fxml;


    opens ipap.dbexemple to javafx.fxml;
    exports ipap.dbexemple;
}