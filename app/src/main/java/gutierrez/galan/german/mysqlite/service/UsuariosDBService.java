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

public class UsuariosDBService extends SQLiteOpenHelper
{
    public static final String TAG = "UsuariosDBService";
    public static final int DATABASE_VERSION = 1;
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
    }

    public boolean saveUsuario(Usuario usuario)
    {
        long resultado = 0;
        SQLiteDatabase sqLiteDatabase = null;
        if( usuario == null )
        {
            return false;
        }
        sqLiteDatabase = getWritableDatabase();
        resultado = sqLiteDatabase.insert(UsuariosContract.UsuarioEntry.TABLE_NAME,null,UsuariosContract.UsuarioEntry.toContentValues(usuario));
        return resultado > 0;
    }

    public List<Usuario> getUsuarios( )
    {
        SQLiteDatabase sqLiteDatabase = null;
        Cursor cursor = null;
        List<Usuario>usuarios = null;
        Usuario usuario = null;

        sqLiteDatabase = getReadableDatabase();
        cursor = sqLiteDatabase.query(UsuariosContract.UsuarioEntry.TABLE_NAME,null,null, null, null, null, UsuariosContract.UsuarioEntry.USUARIO );
        if( cursor == null )
        {
            return null;
        }
        if( cursor.getCount() < 1)
        {
            return null;
        }
        if( !cursor.moveToFirst() )
        {
            return null;
        }
        Log.d(TAG, "" + cursor.getCount());
        usuarios = new ArrayList<Usuario>( );
        for( int i = 0; i < cursor.getCount(); i++)
        {
            usuario = new Usuario( );
            usuario.setUsuario( cursor.getString( 0 ) );
            usuario.setRol( cursor.getString( 1 ) );
            usuarios.add( usuario );
            cursor.moveToNext( );
        }
        return usuarios;
    }
}
