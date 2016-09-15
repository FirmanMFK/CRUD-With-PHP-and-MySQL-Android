package com.firman.tugas;

/**
 * Created by Firmanz on 8/5/2016.
 */
public class Config {

    //Link ke Database
    public static final String URL_ADD="http://192.168.56.2/crudandro/addEmp.php";
    public static final String URL_GET_ALL = "http://192.168.56.2/crudandro/getAllEmp.php";
    public static final String URL_GET_EMP = "http://192.168.56.2/crudandro/getEmp.php?id=";
    public static final String URL_UPDATE_EMP = "http://192.168.56.2/crudandro/updateEmp.php";
    public static final String URL_DELETE_EMP = "http://192.168.56.2/crudandro/deleteEmp.php?id=";
    public static final String URL_SELECT_EMP = "http://192.168.56.2/crudandro/selectEmp.php?id=";

    public static final String URL_ADD_USERS="http://192.168.56.2/crudandro/users/addUsers.php";
    public static final String URL_GET_ALL_USERS = "http://192.168.56.2/crudandro/users/getAllUsers.php";
    public static final String URL_GET_USERS = "http://192.168.56.2/crudandro/users/getUsers.php?id=";
    public static final String URL_UPDATE_USERS = "http://192.168.56.2/crudandro/users/updateUsers.php";
    public static final String URL_DELETE_USERS = "http://192.168.56.2/crudandro/users/deleteUsers.php?id=";

    //Key yang akan digunakan untuk mengirim permintaan
    public static final String KEY_EMP_ID = "id";
    public static final String KEY_EMP_NAME = "nama_barang";
    public static final String KEY_EMP_DESG = "harga_barang";
    public static final String KEY_EMP_SAL = "jenis_barang";
    public static final String KEY_EMP_USERNAME = "username";
    public static final String KEY_EMP_PASSWORD = "password";

    //Key yang akan digunakan untuk mengirim permintaan ke PHP Script
    public static final String KEY_EMP_ID_USERS = "id";
    public static final String KEY_EMP_NAME_USERS = "name";
    public static final String KEY_EMP_USERNAME_USERS = "username";
    public static final String KEY_EMP_PASSWORD_USERS = "password";

    //JSON Tags
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_ID = "id";
    public static final String TAG_NAME = "nama_barang";
    public static final String TAG_DESG = "harga_barang";
    public static final String TAG_SAL = "jenis_barang";

    //JSON Tags
    public static final String TAG_JSON_ARRAY_USERS="result";
    public static final String TAG_ID_USERS = "id";
    public static final String TAG_NAME_USERS = "name";
    public static final String TAG_USERNAME_USERS = "username";
    public static final String TAG_PASSWORD_USERS = "password";

    //id karyawan untuk lulus dengan maksud
    public static final String EMP_ID = "emp_id";
    public static final String USERS_ID = "login_id";

}
