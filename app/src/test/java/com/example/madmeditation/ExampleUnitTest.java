package com.example.madmeditation;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.madmeditation.ui.login.LoginFragment;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
    @Test
    public  void validateEmail_isCorrect(){
        boolean result = LoginActivity.validateEmail("iiiiii@mail.com");
        assertTrue(result);
    }
    @Test
    public  void validateEmail_isUncorrectable(){
        boolean result = LoginActivity.validateEmail("iiiiiimail.com");
        assertFalse(result);
    }
    @Test
    public  void validatePassword_isisCorrect(){
        boolean result = LoginActivity.validatePassword("iasfasfa");
        assertTrue(result);
    }
    @Test
    public  void validatePassword_isUncorrectable(){
        boolean result = LoginActivity.validatePassword("");
        assertFalse(result);
    }
}