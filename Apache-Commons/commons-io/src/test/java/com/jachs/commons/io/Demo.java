package com.jachs.commons.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;
import org.junit.Test;

/***
 * @author zhanchaohan
 */
public class Demo {
    
    @Test
    public void testBuffer() throws IOException {
        BufferedInputStream bis=IOUtils.buffer ( new FileInputStream ( Demo.class.getResource ( "/files/myFile.txt" ).getPath () ) );
        BufferedOutputStream bos=IOUtils.buffer ( new FileOutputStream ( Demo.class.getResource ( "/files" ).getPath ()+File.separator+"copyFile.txt") );
//        IOUtils.buffer ( new FileReader ( "" ) );
//        IOUtils.buffer ( new FileWriter ( "" ) );
        //给定缓冲区大小
        BufferedInputStream bisL=IOUtils.buffer ( new FileInputStream ( Demo.class.getResource ( "/files/myFile.txt" ).getPath () ) , 1024 );
        BufferedOutputStream bosO=IOUtils.buffer ( new FileOutputStream ( Demo.class.getResource ( "/files" ).getPath ()+File.separator+"copyFile.txt") ,1024 );
        
        IOUtils.copy ( bis, bos );//测试copy文件
        IOUtils.closeQuietly ( bis );
        IOUtils.closeQuietly ( bos );
        
//        IOUtils.copy ( bisL, bosO );//测试copy文件,加buff
//        IOUtils.closeQuietly ( bisL );
//        IOUtils.closeQuietly ( bosO );
    }
    //
    @Test
    public void testContent() throws FileNotFoundException, IOException {
      //判断二个文件是否是一个数据源
      Boolean equle= IOUtils.contentEquals ( new FileInputStream ( Demo.class.getResource ( "/files/myFile.txt" ).getPath ()), new FileInputStream ( Demo.class.getResource ( "/files" ).getPath ()+File.separator+"copyFile.txt" ) );
      System.out.println ( equle );
      Boolean equleT= IOUtils.contentEquals ( new FileInputStream ( Demo.class.getResource ( "/files/myFile.txt" ).getPath ()), new FileInputStream ( Demo.class.getResource ( "/files/myFile.txt" ).getPath ()) );
      System.out.println ( equleT );
    }
    @Test
    public void testCopy() throws FileNotFoundException, IOException {
        /*
        //文件大小212M
        long stime=System.currentTimeMillis ();
        IOUtils.copy ( new FileInputStream ( "e:\\hbase-2.2.1-bin.tar.gz" ), new FileOutputStream ( "e:\\hbase.gz" ) );
        long etime=System.currentTimeMillis ();
        System.out.println ( etime-stime );//耗时:7707
        
        long Hstime=System.currentTimeMillis ();
        IOUtils.copyLarge ( new FileInputStream ( "e:\\hbase-2.2.1-bin.tar.gz" ), new FileOutputStream ( "e:\\Hhbase.gz" ) );
        long Hetime=System.currentTimeMillis ();
        System.out.println ( Hetime-Hstime );//耗时:22884
        */
        
        //文件大小2.42GB,这我就看不懂了。。。
        long stime=System.currentTimeMillis ();
        IOUtils.copy ( new FileInputStream ( "e:\\AAAA.rar" ), new FileOutputStream ( "e:\\a.rar" ) );
        long etime=System.currentTimeMillis ();
        System.out.println ( etime-stime );//耗时:71325
        
        long Hstime=System.currentTimeMillis ();
        IOUtils.copyLarge ( new FileInputStream ( "e:\\AAAA.rar" ), new FileOutputStream ( "e:\\aa.rar" ) );
        long Hetime=System.currentTimeMillis ();
        System.out.println ( Hetime-Hstime );//耗时:80906
    }
    /****
     * 读取字符对象迭代器
     * @Title testLineIterator
     * @author zhanchaohan
     * @date 2020年07月07日 10:31
     * @version V1.0
     * @throws FileNotFoundException
     * @throws IOException 
     * @since V1.0
     */
    @Test
    public void testLineIterator() throws FileNotFoundException, IOException {
//        LineIterator li=IOUtils.lineIterator ( new FileReader ( Demo.class.getResource ( "/files/myFile.txt" ).getPath ()) );
//      while(li.hasNext ()) {
//          System.out.println ( li.nextLine () );
//      }
      //指定编码
      LineIterator liE=IOUtils.lineIterator ( new FileInputStream ( Demo.class.getResource ( "/files/myFile.txt" ).getPath () ), "UTF-8" );
      while(liE.hasNext ()) {
          System.out.println ( liE.nextLine () );
      }
    }
}
