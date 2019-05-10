package Tablas;

public class Clientes {
    private String ID;
    private String Nombre;
    private String Apellido_Paterno;
    private String Apellido_Materno;
    private String Telefono;
    private String Correo;
    private String Fecha_Nacimiento;
    private String Ciudad;
    private String Estado;
    private String Estatus;
    private String Sexo;
    private String Referencia;
    private String Direccion_Referencia;
    private String Fecha_Nacimiento_Referencia;

    public Clientes() {
    }

    public Clientes(String ID, String Nombre, String Apellido_Paterno, String Apellido_Materno, String Telefono, String Correo, String Fecha_Nacimiento, String Ciudad, String Estado, String Estatus, String Sexo, String Referencia, String Direccion_Referencia, String Fecha_Nacimiento_Referencia) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Apellido_Paterno = Apellido_Paterno;
        this.Apellido_Materno = Apellido_Materno;
        this.Telefono = Telefono;
        this.Correo = Correo;
        this.Fecha_Nacimiento = Fecha_Nacimiento;
        this.Ciudad = Ciudad;
        this.Estado = Estado;
        this.Estatus = Estatus;
        this.Sexo = Sexo;
        this.Referencia = Referencia;
        this.Direccion_Referencia = Direccion_Referencia;
        this.Fecha_Nacimiento_Referencia = Fecha_Nacimiento_Referencia;
    }

    

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido_Paterno() {
        return Apellido_Paterno;
    }

    public void setApellido_Paterno(String Apellido_Paterno) {
        this.Apellido_Paterno = Apellido_Paterno;
    }

    public String getApellido_Materno() {
        return Apellido_Materno;
    }

    public void setApellido_Materno(String Apellido_Materno) {
        this.Apellido_Materno = Apellido_Materno;
    }
    
    

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getFecha_Nacimiento() {
        return Fecha_Nacimiento;
    }

    public void setFecha_Nacimiento(String fecha_Nacimiento) {
        Fecha_Nacimiento = fecha_Nacimiento;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String ciudad) {
        Ciudad = ciudad;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getEstatus() {
        return Estatus;
    }

    public void setEstatus(String estatus) {
        Estatus = estatus;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String sexo) {
        Sexo = sexo;
    }

    public String getReferencia() {
        return Referencia;
    }

    public void setReferencia(String referencia) {
        Referencia = referencia;
    }

    public String getDireccion_Referencia() {
        return Direccion_Referencia;
    }

    public void setDireccion_Referencia(String direccion_Referencia) {
        Direccion_Referencia = direccion_Referencia;
    }

    public String getFecha_Nacimiento_Referencia() {
        return Fecha_Nacimiento_Referencia;
    }

    public void setFecha_Nacimiento_Referencia(String fecha_Nacimiento_Referencia) {
        Fecha_Nacimiento_Referencia = fecha_Nacimiento_Referencia;
    }
}

