package gutierrez.galan.german.mysqlite.service;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import gutierrez.galan.german.mysqlite.contract.UsuariosContract;
import gutierrez.galan.german.mysqlite.dao.Usuario;

public abstract class UsuariosDBService extends SQLiteOpenHelper
{
    public static final String TAG = "UsuariosDBService";
    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "Usuarios.db";

    public UsuariosDBService(Context context)
    {
        super(context , DATABASE_NAME , null , DATABASE_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        if( sqLiteDatabase == null )
        {
            return;
        }
        sqLiteDatabase.execSQL(UsuariosContract.UsuarioEntry.getCreateTable());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase , int oldVersion , int newVersion )
    {
        if( sqLiteDatabase == null )
        {
            return;
        }
        sqLiteDatabase.execSQL(UsuariosContract.RolEntry.getCreateTable());
    }


}
