/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pengolahannilai;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author
 */
public class FXML_inputMahasiswaController implements Initializable {

    @FXML
    private TextField txtnpm;
    private TextField txtnama;
    @FXML
    private TextField txtprodi;
    @FXML
    private Button btnbatal;
    @FXML
    private Button btnkeluar;

    public static DBMahasiswa dtmahasiswa = new DBMahasiswa();
    boolean editdata = false;
    @FXML
    private TextField txtnamamahasiswa;
    @FXML
    private Button btnsave;

    /**
     * Method untuk eksekusi data Mahasiswa
     */
    public void execute(MahasiswaModel m) {
        if (!m.getNPM().isEmpty()) {
            editdata = true;
            txtnpm.setText(m.getNPM());
            txtnama.setText(m.getNama_Mahasiswa());
            txtprodi.setText(m.getProdi());
            txtnpm.setEditable(false);
            txtnama.requestFocus();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private void simpanclick(ActionEvent event) {
        MahasiswaModel m = new MahasiswaModel();
        m.setNPM(txtnpm.getText());
        m.setNama_Mahasiswa(txtnama.getText());
        m.setProdi(txtprodi.getText());
        FXML_menuController.dtmahasiswa.setMahasiswaModel(m);
        if (editdata) {
            if (FXML_menuController.dtmahasiswa.update()) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Data berhasil diubah", ButtonType.OK);
                a.showAndWait();
                txtnpm.setEditable(true);
                batalclick(event);
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Data gagal diubah", ButtonType.OK);
                a.showAndWait();
            }
        } else if (FXML_menuController.dtmahasiswa.validasi(m.getNPM()) <= 0) {
            if (FXML_menuController.dtmahasiswa.insert()) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Data berhasil disimpan", ButtonType.OK);
                a.showAndWait();
                batalclick(event);
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Data gagal disimpan", ButtonType.OK);
                a.showAndWait();
            }
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data sudah tersedia", ButtonType.OK);
            a.showAndWait();
            txtnpm.requestFocus();
        }
    }

    @FXML
    private void batalclick(ActionEvent event) {
        txtnpm.setText("");
        txtnama.setText("");
        txtprodi.setText("");
        txtnpm.requestFocus();
    }

    @FXML
    private void keluarclick(ActionEvent event) {
        btnkeluar.getScene().getWindow().hide();
    }

    @FXML
    private void saveclick(ActionEvent event) {
    }
}