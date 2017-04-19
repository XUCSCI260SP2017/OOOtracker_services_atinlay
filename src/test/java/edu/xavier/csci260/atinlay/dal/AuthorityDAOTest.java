package edu.xavier.csci260.atinlay.dal;

import edu.xavier.csci260.atinlay.domain.Authority;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * class ___ is a member of the OOOtracker_services project.
 * <p>
 * Created by Luke on 4/17/2017.
 */
@SuppressWarnings("ALL")
@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorityDAOTest {

    @Autowired
    private AuthorityDAO sut;

    private Authority AUTHORITY_EXPECTED = new Authority(
            "mcnameel@xavier.edu",
            "ROLE_HR");

    // Authority "Not In DataBase"
    private Authority NIDB_EXPECTED = new Authority(
            "not_in_database",
            "ROLE_EXPECTED");

    @Test
    public void getAuthorityByUsernameDotEquals() throws Exception {

        Authority AUTHORITY_ACTUAL = sut.getAuthorityByUsername("mcnameel@xavier.edu");

        assertTrue(AUTHORITY_EXPECTED.equals(AUTHORITY_ACTUAL));
    }

    @Test
    public void getAuthorityByUsernameToString() throws Exception {

        Authority AUTHORITY_ACTUAL = sut.getAuthorityByUsername("mcnameel@xavier.edu");

        assertEquals(AUTHORITY_EXPECTED.toString(), AUTHORITY_ACTUAL.toString());
    }

    @Test
    public void createAuthorityDotEquals() throws Exception {

        sut.createAuthority(NIDB_EXPECTED);

        Authority AUTHORITY_ACTUAL = sut.getAuthorityByUsername(NIDB_EXPECTED.getUsername());

        assertTrue(NIDB_EXPECTED.equals(AUTHORITY_ACTUAL));

        sut.removeUserFromAuthorities(NIDB_EXPECTED.getUsername());
    }

    @Test
    public void createAuthorityToString() throws Exception {

        sut.createAuthority(NIDB_EXPECTED);

        Authority AUTHORITY_ACTUAL = sut.getAuthorityByUsername(NIDB_EXPECTED.getUsername());

        assertEquals(NIDB_EXPECTED.toString(), AUTHORITY_ACTUAL.toString());

        sut.removeUserFromAuthorities(NIDB_EXPECTED.getUsername());
    }

    @Test
    public void removeAuthority() throws Exception {

        Boolean success = false;

        Authority DELETE_ME = new Authority("test", "test");

        sut.createAuthority(DELETE_ME);

        sut.removeAuthority(DELETE_ME);

        try {

            Authority ACTUAL = sut.getAuthorityByUsername("test");
        }
        catch (EmptyResultDataAccessException e) {

            success = true;
        }

        assertTrue(success);

    }

    @Test
    public void removeUserFromAuthorities() throws Exception {

        Boolean success = false;

        Authority DELETE_ME = new Authority("test", "test");

        sut.createAuthority(DELETE_ME);

        sut.removeUserFromAuthorities(DELETE_ME.getUsername());

        try {

            Authority ACTUAL = sut.getAuthorityByUsername("test");
        }
        catch (EmptyResultDataAccessException e) {

            success = true;
        }

        assertTrue(success);
    }
}