
package Modelo;
import java.util.Date;

public class Paciente {
    
    int PacIdentificacion;
    String PacNombre;
    String PacApellido;
    Date PacFechaNacimiento;
    String PacSexo;
    String PacPassword;

    public int getPacIdentificacion() {
        return PacIdentificacion;
    }

    public void setPacIdentificacion(int PacIdentificacion) {
        this.PacIdentificacion = PacIdentificacion;
    }

    public String getPacNombre() {
        return PacNombre;
    }

    public void setPacNombre(String PacNombre) {
        this.PacNombre = PacNombre;
    }

    public String getPacApellido() {
        return PacApellido;
    }

    public void setPacApellido(String PacApellido) {
        this.PacApellido = PacApellido;
    }

    public Date getPacFechaNacimiento() {
        return PacFechaNacimiento;
    }

    public String getPacSexo() {
        return PacSexo;
    }

    public void setPacSexo(String PacSexo) {
        this.PacSexo = PacSexo;
    }

    public String getPacPassword() {
        return PacPassword;
    }

    public void setPacPassword(String PacPassword) {
        this.PacPassword = PacPassword;
    }
    
    
    
    
    
    
}
