/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashcard;

import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author parve
 */
public class CreateCardController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button homeButton;

    @FXML
    private Button exitButton;

    private AnchorPane scenePane;
    Stage stage;

    @FXML
    private Button nextButton;

    @FXML
    private Button saveButton;

    @FXML
    private TextField answerField;

    @FXML
    private TextField questionField;

    @FXML
    private Label question;

    @FXML
    private Label answer;

    FileChooser saveFIleChooser = new FileChooser();
    String store = "";

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    void exitAction(ActionEvent event) {

        try {

            FileWriter fileWriter = new FileWriter("card_1.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.write("");
            printWriter.flush();
            printWriter.close();
            stage = (Stage) exitButton.getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    

    }

    @FXML
    void homeaction(ActionEvent event) throws IOException {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FlashCard.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            Stage stageHome = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stageHome.setScene(scene);
            stageHome.setTitle("Flash Card");
            stageHome.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void saveAction(ActionEvent event) throws IOException {

        saveFIleChooser.setTitle("Saving option");
        File file = saveFIleChooser.showSaveDialog(stage);
        if (file != null) {
            saveSystem(file);
        }
    }

    @FXML
    void nextAction(ActionEvent event) {
        System.out.println("Next Action working");
    }

    @FXML
    void questionAction(ActionEvent event) {

        try {
            File tempFileSave = new File("card_1.txt");
            if (tempFileSave.createNewFile()) {

                Writer myWriter = new BufferedWriter(new FileWriter("card_1.txt", true));

                String questionString = questionField.getText();
                myWriter.append(questionString + "\n");
                questionField.setText("");
                myWriter.close();

            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @FXML
    void answerAction(ActionEvent event) {
        try {
            File tempFileSave = new File("card_1.txt");
            if (tempFileSave.createNewFile()) {

                Writer myWriter = new BufferedWriter(new FileWriter("card_1.txt", true));

                String answerString = answerField.getText();
                myWriter.append(answerString + "\n");
                questionField.setText("");
                myWriter.close();

            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void saveSystem(File file) throws IOException {

        try {
            FileInputStream inputStream = null;
            FileOutputStream outputStream = null;
            store = file.getAbsolutePath();
            File inputFile = new File("card_1.txt");
            File outputFile = new File(store);
            inputStream = new FileInputStream(inputFile);
            outputStream = new FileOutputStream(outputFile);
            byte[] buffer = new byte[1024];
            int len;

            while ((len = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, len);
            }

            inputStream.close();
            outputStream.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Invalid file type");
        }
       
    }
}
