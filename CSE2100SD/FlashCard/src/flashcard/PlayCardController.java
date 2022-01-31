/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashcard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JFileChooser;

/**
 * FXML Controller class
 *
 * @author parve
 */
public class PlayCardController implements Initializable {

    @FXML
    private AnchorPane scenePane;
    @FXML
    private Button exitButton;
    @FXML
    private Button createButton;
    @FXML
    private Button homeButton;

    @FXML
    private Button fileButton;

    @FXML
    private TextField textField;

    @FXML
    private Button nextButton;

    @FXML
    private Button showButton;

    Stage stage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void exitAction(ActionEvent event) {
        try {
            stage = (Stage) exitButton.getScene().getWindow();
            stage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void createAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("createCard.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Create Flash Card");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void homeAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FlashCard.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Flash Card");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void fileAction(ActionEvent event) {

        System.out.println("File Action working");
        
        JFileChooser fileChooser = new JFileChooser();
         //File file = fileChooser.getSelectedFile();
         
         //File file = fileChooser.showOpenDialog(stage);
        /*
            int option = fileChooser.showSaveDialog(scenePane);
            if(option == JFileChooser.APPROVE_OPTION){
               File file = fileChooser.getSelectedFile();
               textField.setText("File Saved as: " + file.getName());
            }else{
               textField.setText("Save command canceled");
            }*/

    }

    @FXML
    void nextAction(ActionEvent event) {
        System.out.println("Action working");
    }

    public int questionNo = 0;

    @FXML
    void showAction(ActionEvent event) throws IOException {
        //System.out.println("Action working");

        File file = new File("card_1.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;

        int i = 0;
        while ((st = br.readLine()) != null) {
            if (questionNo == i) {
                textField.setText(st);
                questionNo++;
                break;

            }
            i++;
        }

    }

    @FXML
    void textAction(ActionEvent event) {
        System.out.println("Action working");
    }

}
