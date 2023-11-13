module se.iths.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.internal.le;

    opens se.iths.tictactoe to javafx.fxml;
    exports se.iths.tictactoe;
}