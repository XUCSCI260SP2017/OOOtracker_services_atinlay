package edu.xavier.csci260.atinlay;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.FormLoginRequestBuilder;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrlPattern;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SuppressWarnings("ALL")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:testSchema.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:data.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:tearDown.sql")
})
public class ApplicationTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void loginWithValidUserThenAuthenticatedWithRoleManager() throws Exception {
        FormLoginRequestBuilder login = formLogin()
                .user("manager")
                .password("password");

        mockMvc
                .perform(login)
                .andExpect(authenticated()
                        .withUsername("manager")
                        .withRoles("MANAGER"));
    }

    @Test
    public void loginWithValidUserThenAuthenticatedWithRoleHR() throws Exception {
        FormLoginRequestBuilder login = formLogin()
                .user("hr")
                .password("password");

        mockMvc
                .perform(login)
                .andExpect(authenticated()
                        .withUsername("hr")
                        .withRoles("HR"));
    }

    @Test
    public void loginWithValidUserThenAuthenticatedWithRoleWorker() throws Exception {
        FormLoginRequestBuilder login = formLogin()
                .user("worker")
                .password("password");

        mockMvc
                .perform(login)
                .andExpect(authenticated()
                        .withUsername("worker")
                        .withRoles("WORKER"));
    }

    @WithMockUser(roles = "HR")
    @Test
    public void requestPageForbidden() throws Exception {

        mockMvc.perform(get("/manager/forTesting"))
                .andExpect(status()
                    .isForbidden());
    }

    @WithMockUser(roles = "MANAGER")
    @Test
    public void requestPageWithRole() throws Exception {

        mockMvc.perform(get("/manager/forTesting"))
                .andExpect(status()
                    .isOk());
    }

    @Test
    public void loginWithInvalidUserThenUnauthenticated() throws Exception {
        FormLoginRequestBuilder login = formLogin()
                .user("invalid")
                .password("invalidpassword");

        mockMvc.perform(login)
                .andExpect(unauthenticated());
    }

    @Test
    public void accessUnsecuredResourceThenOk() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }

    @Test
    public void accessSecuredResourceUnauthenticatedThenRedirectsToLogin() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrlPattern("**/login"));
    }

    @Test
    @WithMockUser
    public void accessSecuredResourceAuthenticatedThenOk() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk());
    }
}
