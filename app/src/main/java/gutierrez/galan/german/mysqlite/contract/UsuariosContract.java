package gutierrez.galan.german.mysqlite.contract;

import android.content.ContentValues;
import android.provider.BaseColumns;
import android.util.Log;

import java.io.Serializable;

import gutierrez.galan.german.mysqlite.dao.Rol;
import gutierrez.galan.german.mysqlite.dao.Usuario;

public class UsuariosContract implements Serializable
{
    public static final String TAG = "UsuariosContract";

    public static abstract class UsuarioEntry implements BaseColumns
    {
        public static final String TABLE_NAME = "TBL_USUARIO";
        public static final String USUARIO = "USUARIO";
        public static final String ROL = "ROL";

        public static final String getCreateTable( )
        {
            StringBuilder stringBuilder = new StringBuilder( );
            stringBuilder.append( "CREATE TABLE " );
            stringBuilder.append( TABLE_NAME );
            stringBuilder.append( "( " );
            stringBuilder.append( USUARIO );
            stringBuilder.append( " TEXT NOT NULL," );
            stringBuilder.append( ROL );
            stringBuilder.append( " TEXT NOT NULL," );
            stringBuilder.append( " UNIQUE (" );
            stringBuilder.append( USUARIO );
            stringBuilder.append( " ) )" );
            Log.d(TAG, stringBuilder.toString() );
            return stringBuilder.toString();
        }

        public static ContentValues toContentValues(Usuario usuario)
        {
            ContentValues values = new ContentValues();
            values.put(USUARIO, usuario.getUsuario() );
            values.put(ROL, usuario.getRol() );
            return values;
        }
    }

    public static abstract class RolEntry implements BaseColumns
    {
        public static final String TABLE_NAME = "TBL_ROL";
        public static final String ROL = "ROL";
        public static final String DESCRIPCION = "DESCRIPCION";

        public static final String getCreateTable( )
        {
            StringBuilder stringBuilder = new StringBuilder( );
            stringBuilder.append( "CREATE TABLE " );
            stringBuilder.append( TABLE_NAME );
            stringBuilder.append( "( " );
            stringBuilder.append( ROL );
            stringBuilder.append( " TEXT NOT NULL," );
            stringBuilder.append( DESCRIPCION );
            stringBuilder.append( " TEXT NOT NULL," );
            stringBuilder.append( " UNIQUE (" );
            stringBuilder.append( ROL );
            stringBuilder.append( " ) )" );
            Log.d(TAG, stringBuilder.toString() );
            return stringBuilder.toString();
        }

        public static ContentValues toContentValues(Rol rol)
        {
            ContentValues values = new ContentValues();
            values.put(ROL, rol.getRol() );
            values.put(DESCRIPCION, rol.getDescripcion() );
            return values;
        }
    }
}
