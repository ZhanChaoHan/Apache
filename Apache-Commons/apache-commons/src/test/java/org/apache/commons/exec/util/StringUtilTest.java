package org.apache.commons.exec.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * @version $Id: StringUtilTest.java 1557338 2014-01-11 10:34:22Z sebb $
 */
public class StringUtilTest {
    /**
     * Test no string substitution
     */
    @Test
    public void testNoStringSubstitution() throws Exception
    {
        final Map<String, String> vars = new HashMap<String, String>();
        vars.put("foo", "FOO");
        vars.put("bar", "BAR");

        assertEquals("This is a FOO & BAR test", StringUtils.stringSubstitution("This is a FOO & BAR test", vars, true).toString());
    }

    /**
     * Test a default string substitution, e.g. all placeholders
     * are expanded.
     */
    @Test
    public void testDefaultStringSubstitution() throws Exception 
    {
        final Map<String, String> vars = new HashMap<String, String>();
        vars.put("foo", "FOO");
        vars.put("bar", "BAR");

        assertEquals("This is a FOO & BAR test", StringUtils.stringSubstitution("This is a ${foo} & ${bar} test", vars, true).toString());
        assertEquals("This is a FOO & BAR test", StringUtils.stringSubstitution("This is a ${foo} & ${bar} test", vars, false).toString());
    }

    /**
     * Test an incomplete string substitution where not all placeholders
     * are expanded.
     */
    @Test
    public void testIncompleteSubstitution() throws Exception {

        final Map<String, String> vars = new HashMap<String, String>();
        vars.put("foo", "FOO");

        assertEquals("This is a FOO & ${bar} test",  StringUtils.stringSubstitution("This is a ${foo} & ${bar} test", vars, true).toString());

        try
        {
            StringUtils.stringSubstitution("This is a ${foo} & ${bar} test", vars, false).toString();
            fail();
        }
        catch (final RuntimeException e)
        {
            // nothing to do
        }
    }

    /**
     * Test a erroneous template.
     */
    @Test
    public void testErroneousTemplate() throws Exception
    {
        final Map<String, String> vars = new HashMap<String, String>();
        vars.put("foo", "FOO");

        assertEquals("This is a FOO & ${}} test",  StringUtils.stringSubstitution("This is a ${foo} & ${}} test", vars, true).toString());
    }
}