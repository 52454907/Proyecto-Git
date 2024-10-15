package com.tuyweb.proyectorsm;

import java.sql.*; //importo todas las clases del paquete java

import java.util.logging.Level;
import java.util.logging.Logger;

public class ProyectoRSM {
    public static void main(String[] args) {
        
        try {
            Class.forName("com.mysql.cj.jdbc.driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProyectoRSM.class.getName()).log(Level.SEVERE, null, ex);
        }
        // creo las variables
        String usuario= "root";
        String password= "";  
        String url= "jdbc:mysql://localhost:3307/proyectorsm";
        Connection conexion;//donde  guardo la conexion a la base de datos
        Statement statement;
        ResultSet rs;
          
            try {
                conexion=DriverManager.getConnection(url,usuario, password);
                statement= conexion.createStatement();
                rs=statement.executeQuery("SELECT * FROM jugadores");
                System.out.println("antes de while"); 
                   // Aqui Visualizo los datos que tiene inicialmente la tabla
                 while (rs.next()){
                     System.out. println("Id: " + rs.getInt("Id") + "   Jugador: "+ rs.getString("Nombres"));
            
            }
                 statement.execute("INSERT INTO jugadores (Identificacion, Nombres, Apellidos, Fecha_Nacimiento, Telefono,Correo_Electronico, Id_Entrenador, Id_equipo, Id_padres, Posicion) VALUES ('1067634078', 'sergio', 'arrieta', '2024-10-01', '3186910566', 'em_cueto@hotmail.com',1, 1, 1, 'volante primera')");
                 rs=statement.executeQuery("SELECT * FROM jugadores");
              System.out.println("Despues de insertar");
              // Aqui Visualizo los datos que tiene  la tabla despues de hacer el insert
                 while (rs.next()){
                     System.out. println("Id: " + rs.getInt("Id") + "   Jugador: "+ rs.getString("Nombres"));
            
            }
                              statement.executeUpdate ("Update jugadores SET Nombres='aotro nombre', Telefono='3014861324' where Id=5 ");
             rs=statement.executeQuery("SELECT * FROM jugadores");
              System.out.println("Despues de actualizar");
              // Visualizo los datos que tiene  la tabla despues de hacer el update
                 while (rs.next()){
                     System.out. println("Id: " + rs.getInt("Id") + "   Jugador: "+ rs.getString("Nombres")+ "   Apellidos" + rs.getString("Apellidos"));
            }
                  statement.executeUpdate ("DELETE FROM jugadores   where Id=4");
             rs=statement.executeQuery("SELECT * FROM jugadores");
              System.out.println("Despues de eliminar");
              // Visualizo los datos que tiene  la tabla despues de eliminar un registro
              while (rs.next()){
                     System.out. println("Id: " + rs.getInt("Id") + "   Jugador: "+ rs.getString("Nombres")+ "   Apellidos" + rs.getString("Apellidos"));
            }
            } catch (SQLException ex) {
                Logger.getLogger(ProyectoRSM.class.getName()).log(Level.SEVERE, null, ex);
            }
    
            
    }
}
