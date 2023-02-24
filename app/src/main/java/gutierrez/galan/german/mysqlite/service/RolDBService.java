package gutierrez.galan.german.mysqlite.service;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import gutierrez.galan.german.mysqlite.contract.UsuariosContract;
import gutierrez.galan.german.mysqlite.dao.Rol;
import gutierrez.galan.german.mysqlite.dao.Usuario;

public class RolDBService extends UsuariosDBService
{
    public RolDBService(Context context)
    {
        super(context);
    }

    public boolean saveRol(Rol rol)
    {
        long resultado = 0;
        SQLiteDatabase sqLiteDatabase = null;
        if( rol == null )
        {
            return false;
        }
        sqLiteDatabase = getWritableDatabase();
        resultado = sqLiteDatabase.insert(UsuariosContract.RolEntry.TABLE_NAME,null,UsuariosContract.RolEntry.toContentValues(rol));
        return resultado > 0;
    }

    public List<Rol> getRoles( )
    {
        SQLiteDatabase sqLiteDatabase = null;
        Cursor cursor = null;
        List<Rol>roles = null;
        Rol rol = null;

        sqLiteDatabase = getReadableDatabase();
        cursor = sqLiteDatabase.query(UsuariosContract.RolEntry.TABLE_NAME,null,null, null, null, null, UsuariosContract.RolEntry.ROL );
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
        roles = new ArrayList<Rol>( );
        for( int i = 0; i < cursor.getCount(); i++)
        {
            rol = new Rol( );
            rol.setRol( cursor.getString( 0 ) );
            rol.setDescripcion( cursor.getString( 1 ) );
            roles.add( rol );
            cursor.moveToNext( );
        }
        return roles;
    }
}
