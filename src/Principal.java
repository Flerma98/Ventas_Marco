
import Tablas.Abono;
import Tablas.Clientes;
import Tablas.Distribuidores;
import Tablas.Venta;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fernando Alberto
 */
public class Principal {

    static ArrayList<Clientes> ArrayClientes = new ArrayList<Clientes>();
    static ArrayList<Distribuidores> ArrayDistribuidores = new ArrayList<Distribuidores>();
    static ArrayList<Venta> ArrayVentas = new ArrayList<Venta>();
    static ArrayList<Abono> ArrayAbono = new ArrayList<Abono>();
    
    final static String Carpeta_Base_dedatos= "Base de datos";
    final static String Archivo_Base_datos= Carpeta_Base_dedatos + "\\Datos.db";
    
    
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        File directorio=new File(Carpeta_Base_dedatos); 
        directorio.mkdir();
        
        File Basedatos = new File(Archivo_Base_datos);
        
        if(!Basedatos.exists()){
            Basedatos.createNewFile();
            Class.forName("org.sqlite.JDBC");
            Connection conn= DriverManager.getConnection("jdbc:sqlite:" + Archivo_Base_datos);
            //Crear Tabla Clientes
            String tablaClientes= "create table Clientes(ID varchar NOT NULL, Nombres varchar NOT NULL, Apellido_Paterno varchar NOT NULL, Apellido_Materno varchar NOT NULL, Telefono varchar NOT NULL, Correo varchar NOT NULL, Fecha_Nacimiento varchar NOT NULL, Ciudad varchar NOT NULL, Estado varchar NOT NULL, Estatus varchar NOT NULL, Sexo varchar NOT NULL, Persona_Referencia varchar NOT NULL, Direccion_Referencia varchar NOT NULL, Fecha_Nacimiento_Referencia varchar NOT NULL);";
            PreparedStatement ps_Tabla_Clientes= conn.prepareStatement(tablaClientes);
            ps_Tabla_Clientes.executeUpdate();
            //Crear Tabla Distribuidores
            String tablaDistribuidores= "create table Distribuidores(ID varchar NOT NULL, Nombres varchar NOT NULL, Apellido_Paterno varchar NOT NULL, Apellido_Materno varchar NOT NULL, Telefono varchar NOT NULL, Correo varchar NOT NULL, Direccion varchar NOT NULL, Ciudad varchar NOT NULL, Estado varchar NOT NULL, Estatus varchar NOT NULL, Sexo varchar NOT NULL);";
            PreparedStatement ps_Tabla_Distribuidores= conn.prepareStatement(tablaDistribuidores);
            ps_Tabla_Distribuidores.executeUpdate();
            //Crear Tabla Ventas
            String tablaVentas= "create table Ventas(ID_Venta varchar NOT NULL, ID_Cliente varchar NOT NULL, ID_Distribuidor varchar NOT NULL, Numero_Quincensa varchar NOT NULL, Fecha varchar NOT NULL, Numero_Vale varchar NOT NULL, Valor_Vale varchar NOT NULL);";
            PreparedStatement ps_Tabla_Ventas= conn.prepareStatement(tablaVentas);
            ps_Tabla_Ventas.executeUpdate();
            //Crear Tabla Abonos
            String tablaAbonos= "create table Abonos(ID_Pago varchar NOT NULL, ID_Cliente varchar NOT NULL, ID_Distribuidor varchar NOT NULL, Cantidad varchar NOT NULL, Fecha varchar NOT NULL);";
            PreparedStatement ps_Tabla_Abonos= conn.prepareStatement(tablaAbonos);
            ps_Tabla_Abonos.executeUpdate();
            conn.close();
        }
        
        IniciarSesion conector= new IniciarSesion();
        conector.setVisible(true);
        conector.setTitle("Iniciar Sesión");
        
    }
    
    public static void EscribirCliente(String ID, String Nombre, String Apellido_Paterno, String Apellido_Materno, String Telefono, String Correo, String Fecha_Nacimiento, String Ciudad, String Estado, String Estatus, String Sexo, String Referencia, String Direccion_Referencia, String Fecha_Nacimiento_Referencia) throws ClassNotFoundException, SQLException{
        Class.forName("org.sqlite.JDBC");
        Connection conn= DriverManager.getConnection("jdbc:sqlite:" + Archivo_Base_datos);
        String insersionSQL= "insert into Clientes values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps= conn.prepareStatement(insersionSQL);
        ps.setString(1, ID);
        ps.setString(2, Nombre);
        ps.setString(3, Apellido_Paterno);
        ps.setString(4, Apellido_Materno);
        ps.setString(5, Telefono);
        ps.setString(6, Correo);
        ps.setString(7, Fecha_Nacimiento);
        ps.setString(8, Ciudad);
        ps.setString(9, Estado);
        ps.setString(10, Estatus);
        ps.setString(11, Sexo);
        ps.setString(12, Referencia);
        ps.setString(13, Direccion_Referencia);
        ps.setString(14, Fecha_Nacimiento_Referencia);
        ps.executeUpdate();
        conn.close();
    }
    
    public static void EscribirDistribuidor(String ID, String Nombre, String Apellido_Paterno, String Apellido_Materno, String Telefono, String Correo, String Direccion, String Ciudad, String Estado, String Estatus, String Sexo) throws ClassNotFoundException, SQLException{
        Class.forName("org.sqlite.JDBC");
        Connection conn= DriverManager.getConnection("jdbc:sqlite:" + Archivo_Base_datos);
        String insersionSQL= "insert into Distribuidores values(?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps= conn.prepareStatement(insersionSQL);
        ps.setString(1, ID);
        ps.setString(2, Nombre);
        ps.setString(3, Apellido_Paterno);
        ps.setString(4, Apellido_Materno);
        ps.setString(5, Telefono);
        ps.setString(6, Correo);
        ps.setString(7, Direccion);
        ps.setString(8, Ciudad);
        ps.setString(9, Estado);
        ps.setString(10, Estatus);
        ps.setString(11, Sexo);
        ps.executeUpdate();
        conn.close();
    }
    
    public static void LeerCliente() throws ClassNotFoundException, SQLException{
        ArrayClientes.clear();
        Class.forName("org.sqlite.JDBC");
        Connection conn= DriverManager.getConnection("jdbc:sqlite:" + Archivo_Base_datos);
        Statement stat= conn.createStatement();
        ResultSet rs= stat.executeQuery("select * from Clientes;");
        while(rs.next()){
            ArrayClientes.add(new Clientes(rs.getString("ID"), rs.getString("Nombres"), rs.getString("Apellido_Paterno"), rs.getString("Apellido_Materno"), rs.getString("Telefono"), rs.getString("Correo"), rs.getString("Fecha_Nacimiento"), rs.getString("Ciudad"), rs.getString("Estado"), rs.getString("Estatus"), rs.getString("Sexo"), rs.getString("Persona_Referencia"), rs.getString("Direccion_Referencia"), rs.getString("Fecha_Nacimiento_Referencia")));
        }
    }
    
    public static void LeerDistribuidor() throws ClassNotFoundException, SQLException{
        ArrayDistribuidores.clear();
        Class.forName("org.sqlite.JDBC");
        Connection conn= DriverManager.getConnection("jdbc:sqlite:" + Archivo_Base_datos);
        Statement stat= conn.createStatement();
        ResultSet rs= stat.executeQuery("select * from Distribuidores;");
        while(rs.next()){
            ArrayDistribuidores.add(new Distribuidores(rs.getString("ID"), rs.getString("Nombres"), rs.getString("Apellido_Paterno"), rs.getString("Apellido_Materno"), rs.getString("Telefono"), rs.getString("Correo"), rs.getString("Direccion"), rs.getString("Ciudad"), rs.getString("Estado"), rs.getString("Estatus"), rs.getString("Sexo")));
        }
    }
    
    public static void LeerTodo() throws ClassNotFoundException, SQLException {
        LeerCliente();
        LeerDistribuidor();
    }
    
    public static void EliminarCliente(String ID) throws ClassNotFoundException, SQLException{
        Class.forName("org.sqlite.JDBC");
        Connection conn= DriverManager.getConnection("jdbc:sqlite:" + Archivo_Base_datos);
        String insersionSQL= "delete from Clientes where ID = ? ;";
        PreparedStatement ps= conn.prepareStatement(insersionSQL);
        ps.setString(1, ID);
        ps.executeUpdate();
        conn.close();
    }
    
    public static void EliminarDistribuidor(String ID) throws ClassNotFoundException, SQLException{
        Class.forName("org.sqlite.JDBC");
        Connection conn= DriverManager.getConnection("jdbc:sqlite:" + Archivo_Base_datos);
        String insersionSQL= "delete from Distribuidores where ID = ? ;";
        PreparedStatement ps= conn.prepareStatement(insersionSQL);
        ps.setString(1, ID);
        ps.executeUpdate();
        conn.close();
    }
    
    public static void EditarCliente(String ID, String Nombre, String Apellido_Paterno, String Apellido_Materno, String Telefono, String Correo, String Referencia, String Direccion_Referencia, String Fecha_Nacimiento_Referencia) throws ClassNotFoundException, SQLException{
        Class.forName("org.sqlite.JDBC");
        Connection conn= DriverManager.getConnection("jdbc:sqlite:" + Archivo_Base_datos);
        String insersionSQL= "UPDATE Clientes SET Nombres = '" + Nombre + "' , Apellido_Paterno = '" + Apellido_Paterno + "' , Apellido_Materno = '" + Apellido_Materno + "' , Telefono = '" + Telefono + "' , Correo = '" + Correo + "' , Persona_Referencia = '" + Referencia + "' , Direccion_Referencia = '" + Direccion_Referencia + "' , Fecha_Nacimiento_Referencia = '" + Fecha_Nacimiento_Referencia + "'  WHERE ID = '" + ID + "' ;";
        PreparedStatement ps= conn.prepareStatement(insersionSQL);
        ps.executeUpdate();
        conn.close();
    }
    
     public static void EditarDistribuidor(String ID, String Nombre, String Apellido_Paterno, String Apellido_Materno, String Telefono, String Correo, String Dirección) throws ClassNotFoundException, SQLException{
        Class.forName("org.sqlite.JDBC");
        Connection conn= DriverManager.getConnection("jdbc:sqlite:" + Archivo_Base_datos);
        String insersionSQL= "UPDATE Distribuidores SET Nombres = '" + Nombre + "' , Apellido_Paterno = '" + Apellido_Paterno + "' , Apellido_Materno = '" + Apellido_Materno + "' , Telefono = '" + Telefono + "' , Correo = '" + Correo + "' , Direccion = '" + Dirección + "' WHERE ID = '" + ID + "' ;";
        PreparedStatement ps= conn.prepareStatement(insersionSQL);
        ps.executeUpdate();
        conn.close();
    }
    
    
}
