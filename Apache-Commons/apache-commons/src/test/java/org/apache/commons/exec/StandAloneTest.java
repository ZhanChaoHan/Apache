package org.apache.commons.exec;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Placeholder for mailing list question - provided a minimal test case
 * to answer the question as sel-contained regression test.
 *
 * @version $Id: StandAloneTest.java 1556900 2014-01-09 17:54:51Z britter $
 */
public class StandAloneTest {

    @BeforeClass
    public static void classSetUp() {
        System.setProperty("org.apache.commons.exec.lenient", "false");
        System.setProperty("org.apache.commons.exec.debug", "true");
    }

    @Test
    public void testMe() throws Exception {
        if (OS.isFamilyUnix()) {
            final File testScript = TestUtil.resolveScriptForOS("./src/test/scripts/standalone");
            final Executor exec = new DefaultExecutor();
            exec.setStreamHandler(new PumpStreamHandler());
            final CommandLine cl = new CommandLine(testScript);
            exec.execute(cl);
            assertTrue(new File("./target/mybackup.gz").exists());
        }
    }
}
