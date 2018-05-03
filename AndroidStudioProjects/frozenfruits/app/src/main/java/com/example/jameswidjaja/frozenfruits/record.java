package com.example.jameswidjaja.frozenfruits;

public class record {
    private String nama, barang, harga_satu,kuantitas;

    public record() {
    }

    public record(String nama, String barang, String harga_satu, String kuantitas) {
        this.nama = nama;
        this.barang = barang;
        this.harga_satu = harga_satu;
        this.kuantitas=kuantitas;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String name) {
        this.nama = name;
    }

    public String getHarga_satu() {
        return harga_satu;
    }

    public void setHarga_satu(String harga_satu) {
        this.harga_satu = harga_satu;
    }

    public String getBarang() {
        return barang;
    }

    public void setBarang(String barang) {
        this.barang = barang;
    }

    public String getKuantitas() {
        return kuantitas;
    }

    public void setKuantitas(String kantitas) {
        this.kuantitas = kuantitas;
    }
}