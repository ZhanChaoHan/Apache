package org.apache.commons.exec.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.exec.environment.EnvironmentUtils;
import org.junit.Test;

/**
 * @version $Id: MapUtilTest.java 1564600 2014-02-05 01:17:47Z ggregory $
 */
public class MapUtilTest {
    /**
     * Test copying of map
     */
    @Test
    public void testCopyMap() throws Exception {

        final HashMap<String, String> procEnvironment = new HashMap<String, String>();
        procEnvironment.put("JAVA_HOME", "/usr/opt/java");

        final Map<String, String> result = MapUtils.copy(procEnvironment);
        assertTrue(result.size() == 1);
        assertTrue(procEnvironment.size() == 1);
        assertEquals("/usr/opt/java", result.get("JAVA_HOME"));

        result.remove("JAVA_HOME");
        assertTrue(result.size() == 0);
        assertTrue(procEnvironment.size() == 1);
    }

    /**
     * Test merging of maps
     */
    @Test
    public void testMergeMap() throws Exception {

        final Map<String, String> procEnvironment = EnvironmentUtils.getProcEnvironment();
        final HashMap<String, String> applicationEnvironment = new HashMap<String, String>();

        applicationEnvironment.put("appMainClass", "foo.bar.Main");
        final Map<String, String> result = MapUtils.merge(procEnvironment, applicationEnvironment);
        assertTrue(procEnvironment.size() + applicationEnvironment.size() == result.size());
        assertEquals("foo.bar.Main", result.get("appMainClass"));
    }

    /**
     * Test prefixing of map
     */
    @Test
    public void testPrefixMap() throws Exception {

        final HashMap<String, String> procEnvironment = new HashMap<String, String>();
        procEnvironment.put("JAVA_HOME", "/usr/opt/java");

        final Map<String, String> result =
          MapUtils.prefix(procEnvironment, "env");
        assertTrue(procEnvironment.size() == result.size());
        assertEquals("/usr/opt/java", result.get("env.JAVA_HOME"));
    }
}