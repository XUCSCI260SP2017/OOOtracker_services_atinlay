package edu.xavier.csci260.atinlay.dal;


import edu.xavier.csci260.atinlay.domain.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 Allows managing {@link Admin} instances using the Spring functionality to have this class act as the java version of
 * our SQL database
 *
 * @author Luke on 4/3/2017.
 */
public interface AdminRepository extends CrudRepository<Admin, Long> {

    Admin findByEmail(@Param("email") String email);
}
