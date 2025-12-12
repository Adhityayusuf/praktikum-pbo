/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author M.Adhitya Yusuf
 */
public class Mobil extends Kendaraan {

    @Override
    public String getInfoSpesifik() {
        return "Kapasitas: 4 Orang";
    }
    
    // Override method hitung jika Mobil ada pajak tambahan misalnya
    @Override
    public double hitungTotalBayar(int lamaSewa) {
        double total = super.hitungTotalBayar(lamaSewa);
        return total + 5000; // Misal biaya asuransi mobil
    }
}