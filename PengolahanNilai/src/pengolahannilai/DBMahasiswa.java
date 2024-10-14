/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pengolahannilai;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Amalia Fauhanisa
 */
public class DBMahasiswa {
     private MahasiswaModel dt = new MahasiswaModel();    

    // Getter untuk MahasiswaModel
    public MahasiswaModel getMahasiswaModel() { 
        return dt;
    }

    // Setter untuk MahasiswaModel
    public void setMahasiswaModel(MahasiswaModel m) { 
        dt = m;
    }    

    // Method untuk memuat data mahasiswa
    public ObservableList<MahasiswaModel> Load() {
        try {   
            ObservableList<MahasiswaModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi(); 
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("SELECT NPM, Nama_Mahasiswa, Prodi FROM mahasiswa"); // Query yang sudah disesuaikan
            while (rs.next()) {
                MahasiswaModel m = new MahasiswaModel();
                m.setNPM(rs.getString("NPM")); 
                m.setNama_Mahasiswa(rs.getString("Nama_Mahasiswa"));
                m.setProdi(rs.getString("Prodi"));
                TableData.add(m);
            }
            con.tutupKoneksi();
            return TableData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method validasi untuk memastikan data mahasiswa berdasarkan NPM
    public int validasi(String npm) {
        int val = 0;
        try {  
            Koneksi con = new Koneksi();     
            con.bukaKoneksi();   
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("SELECT count(*) as jml FROM mahasiswa WHERE NPM = '" + npm + "'"); 
            while (rs.next()) {   
                val = rs.getInt("jml");            
            }
            con.tutupKoneksi();
        } catch (SQLException e) {            
            e.printStackTrace();        
        }
        return val;
    }        

    // Method untuk insert data mahasiswa
    public boolean insert() {
        boolean berhasil = false;    
        Koneksi con = new Koneksi();
        try {         
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement("INSERT INTO mahasiswa (NPM, Nama_Mahasiswa, Prodi) VALUES (?,?,?)");
            con.preparedStatement.setString(1, getMahasiswaModel().getNPM());
            con.preparedStatement.setString(2, getMahasiswaModel().getNama_Mahasiswa());
            con.preparedStatement.setString(3, getMahasiswaModel().getProdi());
            con.preparedStatement.executeUpdate();
            berhasil = true;
        } catch (Exception e) {            
            e.printStackTrace();            
            berhasil = false;
        } finally {            
            con.tutupKoneksi();            
            return berhasil;        
        }
    }

    // Method untuk delete data mahasiswa berdasarkan NPM
    public boolean delete(String npm) {
        boolean berhasil = false;
        Koneksi con = new Koneksi();
        try {
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement("DELETE FROM mahasiswa WHERE NPM = ?");
            con.preparedStatement.setString(1, npm);
            con.preparedStatement.executeUpdate();
            berhasil = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.tutupKoneksi();
            return berhasil;
        }
    }

    // Method untuk update data mahasiswa
    public boolean update() {
        boolean berhasil = false;
        Koneksi con = new Koneksi();
        try {
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement(
                    "UPDATE mahasiswa SET Nama_Mahasiswa = ?, Prodi = ? WHERE NPM = ?");
            con.preparedStatement.setString(1, getMahasiswaModel().getNama_Mahasiswa());
            con.preparedStatement.setString(2, getMahasiswaModel().getProdi());
            con.preparedStatement.setString(3, getMahasiswaModel().getNPM());
            con.preparedStatement.executeUpdate();
            berhasil = true;
        } catch (Exception e) {
            e.printStackTrace();
            berhasil = false;
        } finally {
            con.tutupKoneksi();
            return berhasil;
        }
    }
}