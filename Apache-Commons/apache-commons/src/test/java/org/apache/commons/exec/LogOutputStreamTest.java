package org.apache.commons.exec;

import static org.junit.Assert.assertFalse;

import java.io.File;
import java.io.OutputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test the LogOutputStream.
 *
 * @version $Id: LogOutputStreamTest.java 1557265 2014-01-10 21:47:50Z ggregory $
 */
public class LogOutputStreamTest {

    private final Executor exec = new DefaultExecutor();
    private final File testDir = new File("src/test/scripts");
    private OutputStream systemOut;
    private final File environmentScript = TestUtil.resolveScriptForOS(testDir + "/environment");

    @BeforeClass
    public static void classSetUp() {
        // turn on debug mode and throw an exception for each encountered problem
        System.setProperty("org.apache.commons.exec.lenient", "false");
        System.setProperty("org.apache.commons.exec.debug", "true");
    }

    @Before
    public void setUp() throws Exception {
        this.systemOut = new SystemLogOutputStream(1);
        this.exec.setStreamHandler(new PumpStreamHandler(systemOut, systemOut));
    }

    @After
    public void tearDown() throws Exception {
        this.systemOut.close();
    }

    // ======================================================================
    // Start of regression tests
    // ======================================================================

    @Test
    public void testStdout() throws Exception {
        final CommandLine cl = new CommandLine(environmentScript);
        final int exitValue = exec.execute(cl);
        assertFalse(exec.isFailure(exitValue));
    }

    // ======================================================================
    // Helper classes
    // ======================================================================

    private class SystemLogOutputStream extends LogOutputStream {

        private SystemLogOutputStream(final int level) {
            super(level);
        }

        @Override
        protected void processLine(final String line, final int level) {
            System.out.println(line);
        }
    }

}
