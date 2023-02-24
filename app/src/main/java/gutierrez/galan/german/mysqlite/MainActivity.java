package gutierrez.galan.german.mysqlite;

import androidx.appcompat.app.AppCompatActivity;
import gutierrez.galan.german.mysqlite.dao.Rol;
import gutierrez.galan.german.mysqlite.dao.Usuario;
import gutierrez.galan.german.mysqlite.service.RolDBService;
import gutierrez.galan.german.mysqlite.service.UsuarioDBService;
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
        UsuarioDBService usuarioDBService = null;
        RolDBService rolDBService = null;
        Usuario usuario  = null;
        List<Usuario> usuarios = null;
        List<Rol> roles = null;
        StringBuilder stringBuilder = null;
        Rol rol = null;

        usuarioDBService = new UsuarioDBService( getBaseContext( ) );
        rolDBService = new RolDBService( getBaseContext( ) );
        usuario = new Usuario( );
        usuario.setUsuario( "GERDOC" + (int)(Math.random() * 1000 ) );
        usuario.setRol( "ADMIN" );
        if( !usuarioDBService.saveUsuario( usuario ) )
        {
            return;
        }
        Log.d(TAG, "onCreate: OK");
        usuarios = usuarioDBService.getUsuarios();
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
        rol = new Rol( );
        rol.setRol( "ADMIN" + (int)(Math.random() * 1000 ) );
        rol.setDescripcion( "ADMINISTRADOR" );
        if( !rolDBService.saveRol( rol ) )
        {
            return;
        }
        Log.d(TAG, "onCreate: Rol OK");

        roles = rolDBService.getRoles();
        if( roles == null || roles.size() == 0 )
        {
            return;
        }
        i = 1;
        for( Rol rol1 : roles)
        {
            stringBuilder = new StringBuilder( );
            stringBuilder.append( "\nRol.." );
            stringBuilder.append( i++ );
            stringBuilder.append( "]" );
            stringBuilder.append( rol1.getRol() );
            stringBuilder.append( "[\nDescripcion]" );
            stringBuilder.append( rol1.getDescripcion() );
            stringBuilder.append( "[\n" );
            Log.d(TAG, stringBuilder.toString());
        }




    }
}