/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pengolahannilai;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Amalia Fauhanisa
 */
public class FXML_menuController implements Initializable {

    @FXML
    private MenuItem mnumahasiswa;
    @FXML
    private MenuItem mnumatkul;
    @FXML
    private MenuItem mnudosen;
    @FXML
    private MenuItem mnupengolahannilai;
    @FXML
    private MenuItem mnudisplaymahasiswa;
    @FXML
    private MenuItem mnudisplaymatkul;
    @FXML
    private MenuItem mnudisplaydosen;
    @FXML
    private MenuItem mnudisplaypengolahannilai;
    @FXML
    private MenuItem mnukeluar;
    @FXML
    private AnchorPane mainAnchorPane;

    // Deklarasi model yang digunakan
    public static DBMahasiswa dtmahasiswa = new DBMahasiswa();
    public static DBNilai dtnilai = new DBNilai();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void mastermahasiswaclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_InputMahasiswa.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setScene(scene);
            stg.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void mastermatkulclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_InputMatkul.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void masterdosenclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_InputDosen.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void masterpengolahannilaiclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_PengolahanNilai.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void displaymahasiswaclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_DisplayMahasiswa.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setScene(scene);
            stg.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void displaymatkulclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_DisplayMatkul.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setScene(scene);
            stg.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void displaydosenclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_DisplayDosen.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setScene(scene);
            stg.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void displaypengolahannilaiclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_DisplayPengolahanNilai.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setScene(scene);
            stg.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void keluarclick(ActionEvent event) {
        System.exit(0);
    }
}