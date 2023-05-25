package EmployeeManagementSystem.shared;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {

    public static void showAlert(String text)  {
        Stage popUpWindow = new Stage();

        popUpWindow.initModality(Modality.WINDOW_MODAL);
        popUpWindow.setTitle("Error");
        popUpWindow.setMinWidth(300);
        popUpWindow.setMinHeight(100);

        Label label = new Label();
        label.setText(text);

        Button close = new Button("Close");
        close.setOnAction(e -> popUpWindow.close());

        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(label, close);
        vBox.setAlignment(Pos.BASELINE_CENTER);

        Scene scene = new Scene(vBox);
       popUpWindow.setScene(scene);
        popUpWindow.showAndWait();
    }
}
