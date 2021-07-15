package org.apache.commons.exec.issues;

import static org.junit.Assert.assertFalse;

import java.io.File;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.Executor;
import org.apache.commons.exec.PumpStreamHandler;
import org.apache.commons.exec.TestUtil;
import org.junit.Test;

/**
 * Test the patch for EXEC-33 (https://issues.apache.org/jira/browse/EXEC-33)
 *
 * PumpStreamHandler hangs if System.in is redirect to process input stream .
 *
 * @version $Id: Exec33Test.java 1557130 2014-01-10 14:23:40Z britter $
 */
public class Exec33Test {

    private final Executor exec = new DefaultExecutor();
    private final File testDir = new File("src/test/scripts");
    private final File testScript = TestUtil.resolveScriptForOS(testDir + "/test");

    @Test
    public void testExec33() throws Exception {
        final CommandLine cl = new CommandLine(testScript);
        final PumpStreamHandler pumpStreamHandler = new PumpStreamHandler(System.out, System.err, System.in);
        final DefaultExecutor executor = new DefaultExecutor();
        executor.setStreamHandler(pumpStreamHandler);
        final int exitValue = executor.execute(cl);
        assertFalse(exec.isFailure(exitValue));
    }
}
