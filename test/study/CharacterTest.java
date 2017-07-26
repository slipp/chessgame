package study;

import static org.junit.Assert.*;

import org.junit.Test;

public class CharacterTest {
    @Test
    public void isWhitespace() throws Exception {
        assertTrue(Character.isWhitespace('\n'));
        assertTrue(Character.isWhitespace('\t'));
        assertTrue(Character.isWhitespace(' '));
    }
    
    @Test
    public void testName() throws Exception {
        assertFalse(Character.isJavaIdentifierStart('^'));
        assertFalse(Character.isJavaIdentifierStart('1'));
        assertFalse(Character.isJavaIdentifierStart('-'));
        assertTrue(Character.isJavaIdentifierStart('_'));
        assertTrue(Character.isJavaIdentifierStart('a'));
        assertFalse(Character.isJavaIdentifierPart('^'));
        assertFalse(Character.isJavaIdentifierPart('*'));
        assertFalse(Character.isJavaIdentifierPart('-'));
        assertTrue(Character.isJavaIdentifierPart('1'));
        assertTrue(Character.isJavaIdentifierPart('_'));
    }
}
