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
    @DisplayName("Test without starts with letter")
    public void testIdentifierNotStartedWithLetter(){
        assertFalse(identifier.validateIdentifier("0i"));
    }

    @Test
    @DisplayName("Test exceeding the length ")
    public void testIdentifierStartedWithLetterExceedingLength(){
        assertFalse(identifier.validateIdentifier("Oiiiiii"));
    }

    @Test
    @DisplayName("Test define one character which is a digit")
    public void testIdentifierStartedWithDigitMinLength(){
        assertFalse(identifier.validateIdentifier("0"));
    }

    @Test
    @DisplayName("Test define one character which is a letter")
    public void testIdentifierStartedWithLetterMinLength(){
        assertTrue(identifier.validateIdentifier("O"));
    }

    @Test
    @DisplayName("Test only letters at maximum length")
    public void testIdentifierWithOnlyLettersMaxLength(){
        assertTrue(identifier.validateIdentifier("olalal"));
    }

    @Test
    @DisplayName("Test start with letter and set digit until maximum length")
    public void testIdentifierWithLettersAndDigitsUntilMaxLength(){
        assertTrue(identifier.validateIdentifier("o12345"));
    }
}
