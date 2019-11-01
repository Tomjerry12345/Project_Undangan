package com.example.projectundangan.db;

import android.provider.BaseColumns;

public class DatabaseContract {

    static String TABLE_TAMU = "tabel_tamu";

    static final class DaftarTamu implements BaseColumns {

        static String NAMA = "nama";
        static String ALAMAT = "alamat";
    }

}
