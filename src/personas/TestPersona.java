/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personas;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import personas.dto.PersonaDTO;
import personas.jdbc.PersonaDao;
import personas.jdbc.PersonaDaoJDBC;

/**
 *
 * @author rperez
 */
public class TestPersona {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       PersonaDao personaDao = new PersonaDaoJDBC(null);
       PersonaDTO personaDTO = new PersonaDTO();
       personaDTO.setNombre("Raymond");
       personaDTO.setApellido("Rodriguez");
       
        try {
            //personaDao.insert(personaDTO);
            //personaDao.delete(new PersonaDTO(5));
            /*PersonaDTO personaDTO1 = new PersonaDTO();
            personaDTO1.setId(6);
            personaDTO1.setNombre("Ramon");
            personaDTO1.setApellido("P3r3z");
            personaDao.update(personaDTO1);*/
            
            List<PersonaDTO> personas = personaDao.select();
            for (PersonaDTO persona : personas) {
                System.out.println(persona.toString());
                System.out.println("--------------------------------");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
