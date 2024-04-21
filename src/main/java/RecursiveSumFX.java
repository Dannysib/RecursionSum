import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class RecursiveSumFX extends Application {

    private TextField[] numberFields;
    private Label resultLabel;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Recursive Sum Calculator");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(10);

        numberFields = new TextField[5];
        for (int i = 0; i < 5; i++) {
            Label label = new Label("Number " + (i + 1) + ":");
            TextField textField = new TextField();
            numberFields[i] = textField;

            grid.add(label, 0, i);
            grid.add(textField, 1, i);
        }

        Button calculateButton = new Button("Calculate Sum");
        calculateButton.setOnAction(e -> calculateSum());

        resultLabel = new Label();

        grid.add(calculateButton, 0, 5, 2, 1);
        grid.add(resultLabel, 0, 6, 2, 1);

        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calculateSum() {
        double[] numbers = new double[5];
        for (int i = 0; i < 5; i++) {
            try {
                numbers[i] = Double.parseDouble(numberFields[i].getText());
            } catch (NumberFormatException e) {
                resultLabel.setText("Please enter valid numbers.");
                return;
            }
        }

        double totalSum = sumRecursive(numbers, numbers.length - 1);
        resultLabel.setText("The sum of the numbers is: " + totalSum);
    }

    private double sumRecursive(double[] numbers, int index) {
        if (index == 0) {
            return numbers[index];
        } else {
            return numbers[index] + sumRecursive(numbers, index - 1);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
