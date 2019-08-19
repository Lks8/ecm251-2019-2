package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        GridPane root = new GridPane();
//        root.setAlignment(Pos.CENTER);
//        root.setHgap(16.0);
//        root.setVgap(16.0);
//
//        Label label = new Label();
//        label.setText("MOUSSE DE CHOCOLATE:\n" +
//                "INGREDIENTES\n" +
//                "2 latas de creme de leite\n" +
//                "1 lata de leite condensado\n" +
//                "1 pacote de gelatina em pó sem sabor\n" +
//                "8 colheres ou a seu gosto de chocolate em pó, achocolatado ou outro de sua preferência, fica bom com qualquer um\n" +
//                "\n" +
//                "MODO DE PREPARO\n" +
//                "Coloque no liquidificador o creme de leite, o leite condensado e o chocolate em pó.\n" +
//                "\n" +
//                "Bata por aproximadamente 2 minutos.\n" +
//                "\n" +
//                "Derreta a gelatina conforme instruções da embalagem e acrescente a mistura, bata por 30 segundos só pra misturar.\n" +
//                "\n" +
//                "Coloque em um recipiente e cubra e leve à geladeira até endurecer.");
//        label.setTextFill(Color.DARKRED);
//        label.setFont(Font.font("Comic Sans", 70.0));
//
//        root.getChildren().add(label);

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 700, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
