package com.jachs.registry;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import org.junit.Test;

/***
 * 
 * @author zhanchaohan
 *
 */
public class PreferencesTest {
    String[] keys = { "version", "initial", "creator" };
    String[] values = { "1.3", "ini.mp3", "799516423@qq.com" };
 
    // 把相应的值储存到变量中去
    @Test
    public void writeValue() {
        //HKEY_LOCAL_MACHINE\Software\JavaSoft\prefs下写入注册表值.
        Preferences pre = Preferences.systemRoot().node("/javaplayer");
        for (int i = 0; i < keys.length; i++) {
            pre.put(keys[i], values[i]);
        }
    }
 
    /***
     * 根据key获取value
     * 
     */
    @Test
    public void getValue() {
        Preferences pre = Preferences.systemRoot().node("/javaplayer");
        System.out.println(pre.get("version", "def"));
        System.out.println(pre.get("initial", "def"));
        System.out.println(pre.get("creator", "def"));
    }
 
    /***
     * 清除注册表
     * 
     * @throws BackingStoreException
     */
    @Test
    public void clearValue() throws BackingStoreException {
        Preferences pre = Preferences.systemRoot().node("/javaplayer");
        pre.clear();
    }
}
