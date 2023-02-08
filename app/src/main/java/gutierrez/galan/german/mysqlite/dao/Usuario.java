package gutierrez.galan.german.mysqlite.dao;

import java.io.Serializable;

public class Usuario implements Serializable
{
    private String usuario;
    private String rol;

    public Usuario()
    {
    }

    public Usuario(String usuario, String rol)
    {
        this.usuario = usuario;
        this.rol = rol;
    }

    public String getUsuario()
    {
        return usuario;
    }

    public void setUsuario(String usuario)
    {
        this.usuario = usuario;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
