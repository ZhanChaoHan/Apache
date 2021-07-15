package org.apache.commons.codec.digest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CryptTest {

    @Test
    public void testCrypt() {
        assertNotNull(new Crypt()); // just for Test Coverage
    }

    @Test
    public void testDefaultCryptVariant() {
        // If salt is null or completely omitted, a random "$6$" is used.
        assertTrue(Crypt.crypt("secret").startsWith("$6$"));
        assertTrue(Crypt.crypt("secret", null).startsWith("$6$"));
    }

    @Test
    public void testCryptWithBytes() {
        final byte[] keyBytes = new byte[] { 'b', 'y', 't', 'e' };
        final String hash = Crypt.crypt(keyBytes);
        assertEquals(hash, Crypt.crypt("byte", hash));
    }

    /**
     * An empty string as salt is invalid.
     *
     * The C and Perl implementations return an empty string, PHP threads it
     * as NULL. Our implementation should throw an Exception as any resulting
     * hash would not be verifyable with other implementations of crypt().
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCryptWithEmptySalt() {
        Crypt.crypt("secret", "");
    }

}
