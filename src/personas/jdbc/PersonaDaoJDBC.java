/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personas.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import personas.dto.PersonaDTO;

/**
 *
 * @author rperez
 */
public class PersonaDaoJDBC implements PersonaDao {
    
    private Connection connection;
    private final String SQL_INSERT = "INSERT INTO persona(nombre_persona, apellido_persona) VALUES(?,?)";
    private final String SQL_UPDATE = "UPDATE persona SET nombre_persona = ?, apellido_persona = ? WHERE id_persona = ?";
    private final String SQL_DELETE = "DELETE FROM persona WHERE id_persona = ?";
    private final String SQL_SELECT = "SELECT id_persona, nombre_persona, apellido_persona FROM persona ORDER BY id_persona";
    
    public PersonaDaoJDBC(){
        
    }
    
    public PersonaDaoJDBC(Connection connection){
        this.connection = connection;
    }
    
    @Override
    public int insert(PersonaDTO persona) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        int rows  = 0;
        try{
            connection = (this.connection != null) ? this.connection : Conexion.getConnection();
            preparedStatement = connection.prepareStatement(SQL_INSERT);
            preparedStatement.setString(1, persona.getNombre());
            preparedStatement.setString(2,persona.getApellido());
            rows = preparedStatement.executeUpdate();
        }finally{
            Conexion.close(preparedStatement);
            if(this.connection == null){
                Conexion.close(connection);
            }
        }
        return rows;
    }

    @Override
    public int update(PersonaDTO persona) throws SQLException {
       Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rows = 0;
        try{
            connection = (this.connection != null) ? this.connection : Conexion.getConnection();
            preparedStatement = connection.prepareStatement(SQL_UPDATE);
            preparedStatement.setString(1, persona.getNombre());
            preparedStatement.setString(2, persona.getApellido());
            preparedStatement.setInt(3, persona.getId());
            rows = preparedStatement.executeUpdate();
        }finally{
            Conexion.close(preparedStatement);
            if(this.connection == null){
                Conexion.close(connection);
            }
        }
        return rows;
    }

    @Override
    public int delete(PersonaDTO persona) throws SQLException {
         Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rows = 0;
        try{
            connection = (this.connection != null) ? this.connection : Conexion.getConnection();
            preparedStatement = connection.prepareStatement(SQL_DELETE);
            preparedStatement.setInt(1, persona.getId());
            rows = preparedStatement.executeUpdate();
        }finally{
          Conexion.close(preparedStatement);
          if(this.connection == null){
            Conexion.close(connection);
          }
        }
        return rows;
    }

    @Override
    public List<PersonaDTO> select() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        PersonaDTO persona = null;
        List<PersonaDTO> personas = new ArrayList<>();
        try{
            connection = (this.connection != null) ? this.connection : Conexion.getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT);
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                int id = resultSet.getInt("id_persona");
                String nombre = resultSet.getString("nombre_persona");
                String apellido = resultSet.getString("apellido_persona");
                persona = new PersonaDTO();
                persona.setId(id);
                persona.setNombre(nombre);
                persona.setApellido(apellido);
                personas.add(persona);
            }
        }finally{
            Conexion.close(resultSet);
            Conexion.close(preparedStatement);
            if(this.connection == null){
                Conexion.close(connection);
            }
        }
        return personas;
    }
    
}
