package com.example.blackbit.picassogallery;

import android.app.Application;
import android.content.Context;

import java.util.Arrays;
import java.util.List;

public class MyApplication extends Application {

    private static Context mContext;
    private static String COD_CLIENTE = "0";
    private static String COD_EMPRESA = "0";
    private static String COD_TBL_PRECO = "0";
    private static Double COD_LATITUDE = 0.0;
    private static Double COD_LONGITUDE = 0.0;
    private static String COD_PRODUTO = "0";
    private static String COD_DUPLICATA = "0";
    // Number of columns of Grid View
    public static final int NUM_OF_COLUMNS = 4;
    // Gridview image padding
    public static final int GRID_PADDING = 8; // in dp
    // SD card image directory
    public static String PHOTO_ALBUM = "";
    // supported file formats
    public static final List<String> FILE_EXTN = Arrays.asList("jpg", "jpeg", "png");
    public static int selectedImage;

    public static String getCOD_CLIENTE() {
        return COD_CLIENTE;
    }

    public static void setCOD_CLIENTE(String cod_cliente) {
        COD_CLIENTE = cod_cliente;
    }

    public static String getCOD_EMPRESA() {
        return COD_EMPRESA;
    }

    public static void setCOD_EMPRESA(String cod_empesa) {
        COD_EMPRESA = cod_empesa;
    }

    public static Double getCodLatitude() {
        return COD_LATITUDE;
    }

    public static void setCodLatitude(Double codLatitude) {
        COD_LATITUDE = codLatitude;
    }

    public static Double getCodLongitude() {
        return COD_LONGITUDE;
    }

    public static void setCodLongitude(Double codLongitude) {
        COD_LONGITUDE = codLongitude;
    }

    public static String getCodTblPreco() {
        return COD_TBL_PRECO;
    }

    public static void setCodTblPreco(String codTblPreco) {
        COD_TBL_PRECO = codTblPreco;
    }

    public static String getCodProduto() {
        return COD_PRODUTO;
    }

    public static void setCodProduto(String codProduto) {
        COD_PRODUTO = codProduto;
    }

    public static String getCodDuplicata() {
        return COD_DUPLICATA;
    }

    public static void setCodDuplicata(String codDuplicata) {
        COD_DUPLICATA = codDuplicata;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }


}
