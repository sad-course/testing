import org.example.Identifier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IdentifierTest {
    private Identifier identifier;

    @BeforeEach
    public void setUp() {
        identifier = new Identifier();
    }

    @Test
    @DisplayName("Test empty string")
    public void testIdentifierEmpty() {
        String identifierString = "";
        assertFalse(identifier.validateIdentifier(identifierString));
    }

    @Test
    @DisplayName("Test define one character which is a digit")
    public void testIdentifierStartedWithDigitMinLength(){
        String identifierString = "0";
        assertFalse(identifier.validateIdentifier(identifierString));
    }

    @Test
    @DisplayName("Test define one character which is a letter")
    public void testIdentifierStartedWithLetterMinLength(){
        String identifierString = "O";
        assertTrue(identifier.validateIdentifier(identifierString));
    }

    @Test
    @DisplayName("Test define digits and letters at maximum length")
    public void testIdentifierWithOnlyLettersMaxLength(){
        String identifierString = "olala2";
        assertTrue(identifier.validateIdentifier(identifierString));
    }

    @Test
    @DisplayName("Test define digits and letters exceeding length ")
    public void testIdentifierWithLettersAndDigitsExceedingLength(){
        String identifierString = "o123456";
        assertFalse(identifier.validateIdentifier(identifierString));
    }


    @Test
    @DisplayName("Test  with special characters")
    public void testIdentifierWithLettersAndDigitsUntilMaxLength(){
        String identifierString = "olala!";
        assertFalse(identifier.validateIdentifier(identifierString));
    }
}
