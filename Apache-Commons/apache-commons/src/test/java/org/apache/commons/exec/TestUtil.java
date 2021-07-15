package org.apache.commons.exec;

import java.io.File;

import junit.framework.AssertionFailedError;

/**
 * @version $Id: TestUtil.java 1557263 2014-01-10 21:18:09Z ggregory $
 */
public final class TestUtil {

    private TestUtil() {
    }

    public static File resolveScriptForOS(final String script) {
        if (OS.isFamilyWindows()) {
            return new File(script + ".bat");
        } else if (OS.isFamilyUnix()) {
            return new File(script + ".sh");
        } else if (OS.isFamilyOpenVms()) {
            return new File(script + ".dcl");
        } else {
            throw new AssertionFailedError("Test not supported for this OS");
        }
    }
    
    /**
     * Get success and fail return codes used by the test scripts
     * @return int array[2] = {ok, success}
     */
    public static int[] getTestScriptCodesForOS() {
        if (OS.isFamilyWindows()) {
            return new int[]{0,1};
        } else if (OS.isFamilyUnix()) {
            return new int[]{0,1};
        } else if (OS.isFamilyOpenVms()) {
            return new int[]{1,2};
        } else {
            throw new AssertionFailedError("Test not supported for this OS");
        }
    }

}
