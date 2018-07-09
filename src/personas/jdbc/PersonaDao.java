/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personas.jdbc;

import java.sql.SQLException;
import java.util.List;
import personas.dto.PersonaDTO;

/**
 *
 * @author rperez
 */
public interface PersonaDao {
        
    public int insert (PersonaDTO persona) throws SQLException;
    
    public int update(PersonaDTO persona) throws SQLException;
    
    public int delete(PersonaDTO persona) throws SQLException;
    
    public List<PersonaDTO> select() throws SQLException;
}
