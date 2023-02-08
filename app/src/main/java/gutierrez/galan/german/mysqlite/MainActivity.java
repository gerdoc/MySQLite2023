package gutierrez.galan.german.mysqlite;

import androidx.appcompat.app.AppCompatActivity;
import gutierrez.galan.german.mysqlite.dao.Usuario;
import gutierrez.galan.german.mysqlite.service.UsuariosDBService;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity
{
    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UsuariosDBService usuariosDBService = null;
        Usuario usuario  = null;
        List<Usuario> usuarios = null;
        StringBuilder stringBuilder = null;
        usuariosDBService = new UsuariosDBService( getBaseContext( ) );
        usuario = new Usuario( );
        usuario.setUsuario( "GERDOC" + (int)(Math.random() * 1000 ) );
        usuario.setRol( "ADMIN" );
        if( !usuariosDBService.saveUsuario( usuario ) )
        {
            return;
        }
        Log.d(TAG, "onCreate: OK");
        usuarios = usuariosDBService.getUsuarios();
        if( usuarios == null || usuarios.size() == 0 )
        {
            return;
        }
        int i = 1;
        for( Usuario usuario1 : usuarios)
        {
            stringBuilder = new StringBuilder( );
            stringBuilder.append( "\nusuario.." );
            stringBuilder.append( i++ );
            stringBuilder.append( "]" );
            stringBuilder.append( usuario1.getUsuario() );
            stringBuilder.append( "[\nrol]" );
            stringBuilder.append( usuario1.getRol() );
            stringBuilder.append( "[\n" );
            Log.d(TAG, stringBuilder.toString());
        }



    }
}