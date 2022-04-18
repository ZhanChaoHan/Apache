package com.jachs.commons.base64;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.util.Base64;
import org.junit.Test;

/**
 * 
data:,文本数据</br>
data:text/plain,文本数据</br>
data:text/html,HTML代码</br>
data:text/html;base64,base64编码的HTML代码</br>
data:text/css,CSS代码</br>
data:text/css;base64,base64编码的CSS代码</br>
data:text/javascript,Javascript代码</br>
data:text/javascript;base64,base64编码的Javascript代码</br>
data:image/gif;base64,base64编码的gif图片数据</br>
data:image/png;base64,base64编码的png图片数据</br>
data:image/jpeg;base64,base64编码的jpeg图片数据</br>
data:image/x-icon;base64,base64编码的icon图片数据</br>

 * @author zhanchaohan
 * 
 */
public class Base64Demo {
	Base64 base=new Base64 ();
	
    @Test
    public void testEn() throws IOException {
        Writer fw=new FileWriter (Base64Demo.class.getResource ( "" ).getPath ()+File.separator+"as.html" );
//        byte []en= base.encode ( IOUtils.resourceToByteArray ("/files/image/testImage.jpg"));
        
        byte []en= base.encode ( IOUtils.toByteArray (new FileInputStream("D:/opt/upFiles\\6d35e179cd814e3299bd588ea7daed3f\\_BackgroundImage_.jpg")));
        System.out.println ( new String ( en ) );
        
        fw.write ( "<image src='data:image/jpeg;base64,"+new String ( en )+"'>" );
        fw.close ();
    }
    
    @Test
    public void testDe() throws IOException {
        String enStr="/9j/4AAQSkZJRgABAQAAAQABAAD/4QBkRXhpZgAATU0AKgAAAAgABYdpAAQAAAABAAAASgESAAQA\r\n" + 
                "AAABAAAAAAEBAAMAAAABAfQAAAEyAAIAAAABAAAAAAEAAAMAAAABAfQAAAAAAAAAAZIIAAQAAAAB\r\n" + 
                "AAAAAAAAAAD/2wBDABsSFBcUERsXFhceHBsgKEIrKCUlKFE6PTBCYFVlZF9VXVtqeJmBanGQc1td\r\n" + 
                "hbWGkJ6jq62rZ4C8ybqmx5moq6T/2wBDARweHigjKE4rK06kbl1upKSkpKSkpKSkpKSkpKSkpKSk\r\n" + 
                "pKSkpKSkpKSkpKSkpKSkpKSkpKSkpKSkpKSkpKSkpKT/wAARCADGAMYDASIAAhEBAxEB/8QAGgAB\r\n" + 
                "AAMBAQEAAAAAAAAAAAAAAAMEBQIBBv/EAD8QAAEEAQMCAgUJBAoDAAAAAAEAAgMEEQUSMSFBE1EU\r\n" + 
                "ImFxkQYVIzJCUoGh0SVyscEzNDVDYmNzguHwU7Lx/8QAFwEBAQEBAAAAAAAAAAAAAAAAAAIDAf/E\r\n" + 
                "ABgRAQADAQAAAAAAAAAAAAAAAAABAhEx/9oADAMBAAIRAxEAPwD6VERAREQEREBERAREQEREBERA\r\n" + 
                "RFWsahVrnbLM0O+6Op+AQWUWf88QkAx17MgPdsRwvRq0AAMkViIeb4iAEF9FHBYhsN3QyNePMFSI\r\n" + 
                "CIiAiIgIiICIiAiIgIiICIiAiIgIiICp3dQjrObExplmd0EbOfx8kv2ZGFtesAbEnBPDR3cV3TpR\r\n" + 
                "1Wk/Xkd1fI7lxQVfQ7dvrcnMbP8AxRHA/E91br0q9doEUTW4746/FRWdREDi1teV+O4GB8VJSt+k\r\n" + 
                "tJMZZjsTlBZQgEYPBUFm3DVZvldgeQ5VVmuae7++Lf3mkIJJ9Mie4ywF1eY/bj6Z944K4r3ZY5hW\r\n" + 
                "vNayQ/Ukb9V/6FWobdef+imY72Apbqx2oHRvHPUHu0+YQTIqWl2HyskhmOZoHbX+3yP4q6gIiICI\r\n" + 
                "iAiIgIiICIiAiIgIqM2ogymCpGZ5Rzg4a33lR+hXbIBs3XR/4IBgfHlBpZC5e8NY5xPRoJKqfNVZ\r\n" + 
                "zdsniSfvyOP81ydFoEYEAb7WkhBxo7XTCS9IDvnOWg/ZaOAtIrNbQs1ABRtHYOI5vWaPceQpI9QM\r\n" + 
                "cjYbkZhkccNdnLHe4oOLr7omAiZE5hPBaSfjwrFeuWHc/bu/wjCTTS+M2KGPOfrPPDQoJtWr1xiX\r\n" + 
                "xAfazCCS1p0VqQPkLunbKz5orFN3qafWkZno4u64/FTt16hL6olex37hKt1bEknSSNwB6tfjGR7R\r\n" + 
                "2QVqo3ua9+ntjcftsc1wWmERBnTj0fWIZR0bYaY3e8dQtFZ+uDbSEw6GGRrwfxV9rg5oI4KD1ERA\r\n" + 
                "REQEREBERAREQOFm2JZL1l1SB5jjjP0sg5/dHtU+p2TXqnw+sryGRjzcV5TrtpVGxg5PLj5nugmr\r\n" + 
                "wRVoxHCwNaOwUuVmXLboyAzcHHgFVRqlkHa5oBQbuQvcrJbYmOHvbgeaj+eWsfhzSUG0uJ4Y54zH\r\n" + 
                "IwOaRggqhHqjZBlsbldhl8VucYQZfpNjTZDUkaZmuaTXd3JH2SqLb1y20iy0MwegNYuWzrFU2aTt\r\n" + 
                "hxLGd7D5ELlti3LWjmrNjkD2g4PTBQZQvz1OrY4ntHOK7mFblC025WbKGlueQVU/a0ztrmwRM79y\r\n" + 
                "tGJhZGGk5I74QdoiIKesDOl2P3CrMAxCwHnaFT1w402Qd3FrR+JCvNGAAg9REQEREBERAREQEREG\r\n" + 
                "bIBa1lrT1ZWZu/3Hj8lfKo0B+0L5Jyd7R+G1X0FO1UbO4OLckcFcMoAnL1Jdvw0y0SE5dwACUh1G\r\n" + 
                "rPgRzBxPYc/BBKYWbAzGQFn29K8Q7mdFYv3/AEUMbHGZZHnAZnGVaqzx2oGzRHLXD4exBlVtNnjb\r\n" + 
                "tc8rVrxmNgDjkqRByg6IyMFUNFGyq+IcRSvYPdlX1n6Njbaxx6Q9BoIiICIqNq+RL6NVZ4tg8/dZ\r\n" + 
                "7SUHFw+lahBVb1bE7xZMdscD4rRVajTFWM5cZJXndI88uKsoCIiAiIgIiICIiAiIgzqoMer3GH7b\r\n" + 
                "WPHwwtBZ2pD0a1Dfx6jPUkx90/oVoNIc0OaQQRkEIM24XnW6zYWje1hLyTgFpOFas6fWtD6WIbuz\r\n" + 
                "h0cPxVPUHE6rVD3tgYz1hKftHu3K1WuBHQgoM+DS3x2o5ZbLpWxAiNrgMjPme6jqSMp6nage4Rsk\r\n" + 
                "IfGD0BPfC1VFYrQ2o9kzGvb5FBJygCzhp9qA4rX5AzsyRocB+K9LdXZnDq0vlkFqC/I9scZe44a0\r\n" + 
                "ZJVLRmOFQyOGHTPMnx4VW6zVbUHgurwhpILsScjyU4l1MN2tpQtGMDMvH5INJFTrR3zKH2ZYg0fY\r\n" + 
                "jaev4lXEGZq7pRJXb4ro68jtkhbjPXjr2V2rVhqRCOFm1o+JXOoVxaqSREZJHT2HsvNNselUo5T9\r\n" + 
                "bGHDyI5QWUREBERAREQEREBERAJARQ26zLUJjkzg9cg4IKyZK9ykciaZ0Q+012fiDlBtSsbJG5j2\r\n" + 
                "hzXDBB7qho2RHOwSF8UcpZHnsAoYJpp2bI743HtJGM/kVNVrXKkDYmPgcG9y0jKC9LDHMwslYHtP\r\n" + 
                "IIVJ2j1s/RGWH/TkIXe7UB/d1z/vd+i8rXJnXpK07GNc1ocNpJyg4OmzjGzUbIHtIP8AJe+h3YvW\r\n" + 
                "hvF7vuytBB+HC0EQZzdQnh6XarmD78frt/UKzBeq2P6Kdjj5Z6/BWMLCFCr87TQ2Y9xlG+NxJHvC\r\n" + 
                "DdByiofNMbW4hs2IvLbISB8V56HfY3Eeobv34gUGgizvD1YZxPWd72EfzWgzdtG7G7vhB6s/Tz4V\r\n" + 
                "y5W7B4kaPY4fqtBZwGzXz0GJK/b2H/lBooiICIiAiIgIiICIiAhGURBkahVjm1CCCECNzsvkc37v\r\n" + 
                "8OV2ad+EfQWw4eTx/wDV3SIm1K3Nj6hETT7ufzWijsTjHkt6pWYXSwMc0cuGP1UWnWX29W8V7A13\r\n" + 
                "hlpx71tTRNlj2O4yD09hysjT65g1WRrjkhpP8FM7rWs1tWd62giBFTEVXUKnpUGGHbKw7o3eTgrL\r\n" + 
                "wSwgHB8/JZWi6i6w015yfGbnDj9oZwgu6fa9KrBzhtkblsjfJw5VlZlkHT7gst/q8p2zf4T2ctME\r\n" + 
                "EZByEBERAVCfprdbHeJ/8Qr6oWBnWqnsjef4IL6IiAiIgIiICIiAiIgLxx2tJPYL1RW3FtWVw5DC\r\n" + 
                "fyQVNDGaPjEDdK9zyfeVoKrpTdum1h/lt/grSAq4rYu+OMdW4Pt4VhENEREDlYdeo6SGfwTtnr2H\r\n" + 
                "mM/nj3FbizasrYLeoNd0AcJOvkR/wgnrTR6hTIeznLZGHse4VWGaxpsYryV5rDGkhskfX1e2QoNI\r\n" + 
                "1GIO2uD99iQuLseq0ngZ9ynm1hoEzRG9jQSxsxGWh3tQXKl6G3uDNzXt+sx4w4fgrKzdHrh0TL0j\r\n" + 
                "5HzyswS/sPILSQFn2P7bq/6b1oLPsH9t1R/lP/kg0EREBERAREQEREBERAQgOBBGQeQUVa5qFek6\r\n" + 
                "MWHlniHAOCQgsNa1jQ1oAA6ADsvV41zXtDmkFpGQR3XqAiLl0jGuDXPaCeATyg6RVdQvx6fX8aVr\r\n" + 
                "nNyB6oXsN+vLUZaMgZE4dC/ogsqs6lE6y+c5Lns2Ob2I9ysNc17Q5pBaRkEdwvUFV+nwOqiuxvht\r\n" + 
                "aQ5pbyCO66qU461YQD1wM5Lu+Tld2rMVSB00xLWN5IBOEq2YrcDZoXbmO4OMIJWgNADQABwAiIgK\r\n" + 
                "tJWc/UIrO8bWMLdvvXE2p14bzKchcJXgFvTp1U8tqvCcSzxsPk5wCCVFn2dboQRlwnbIRw1nUlWa\r\n" + 
                "NyK9XE8W7aenUYQToiICIiAiIgIiIC+X+WMn0taPyDnfHH6L6GxV8d2fSJoxjiN2AvjvlA0M1J0T\r\n" + 
                "JJJBGACXu3HPP80H2NMCOnAwkerG0fkp1jaRBp16kyUV2bx0eCScFbLQGtDQMADAQeOcGtJJwByv\r\n" + 
                "nYB8864bA/q9fG0+ZHH59VqaxBbs1fAq7RvOHuccYCxfk5C6Y3Kr5ZGMaR1jdjrkoLfyhZc+bHme\r\n" + 
                "WEsDh6rGEHnzysnTmy6l4NR8pbVh9ZwJA7nhT6q2vJajoV5pHvc8B8kkpcB7FoT09H02GJk8PiyO\r\n" + 
                "6Du53twg24mtZE1rMBgGBjjC9fuLTsIDu2RkLmBrGQMbGzYwDo3GMLmw1xbuEzog0ZJAH80Gbrzb\r\n" + 
                "A0icySRFmBkNYQT1HfKj0CCWTSIS2zJG3LvVaG+Z7kKIubqekWp3Pn2MDtoc8YOBnOAAvPk+2odM\r\n" + 
                "abMjWu3Ho6Ujp7soN2ABg2eKZCOdxyV7NKIWbix7vYxuSq9StRY90tVse49C5pyfirZOASg+TfZN\r\n" + 
                "v5SiZsEhEX2MAOGB+q0tJunUn2ZX1Yvoz6h29Tz0J+Cy45m1IL1mUllqwCGMcMHa48/98lp6LQtQ\r\n" + 
                "aezZYbF4nrkeHk9fbnyQZ0TX/KDUnCVwihi6+GOQF9TDHHDG2KMBrWjAaOwXymgV3TajZZ48kZaD\r\n" + 
                "kxkAnqvoYdLrxTifMsko+2+QkoLqIiAiIgIiICIiCpqd+PT6rpX9XcNb94rF0HTn2p5L9xuQ/O0O\r\n" + 
                "H1s8n3Lal0ytNY8eZrpXjjechvuHCtgADA4QfIy+P8ntTLowXV5OAe48veF9RTtw3IGzQu3NPxHs\r\n" + 
                "K7mhinYWSsa9p7OGVxWqQVGubXibGHHJAQTFfIaRFasWL0daVsRc7DnHOQMnhfXnhUNO0qOhNPK2\r\n" + 
                "Rz3THJzwOuUHz+qaeylqFKvXcWudjMh53buVusoV6Ifdnc+eZjS4yPOT08h2U97Ta94sMzXbmfVc\r\n" + 
                "04IXDtKhkbtmmsTM+6+Q4Qd6Zfj1GsZo2OaA4tIPn/0qtr1t0VYVoQXT2PUaBzjutGGGOBgZExrG\r\n" + 
                "jgNGAvPAi8bxtgMmMbsdQEGJLpNunp7mVJy8OYRJC7qCSOu3yXXyYlhbVNV+G2GvJLXDBW6qtrTq\r\n" + 
                "lt26aIF44eDg/EILWAh4VWGiyEgtmsHHZ0pIVpBiX6L9W1ARvBjqwDG4cucfJX6ENuu10ViVszB9\r\n" + 
                "R/DseRVxRWYG2IjG5z254cw4I9xQfO/Jr+2bnud/7L6dZ2l6PHp0skjZHSOeMZd2WigIiICIiAiI\r\n" + 
                "gIiICIiAiIgIiICIiAiIgIiICIiAiIgIiICIiAiIg//Z\r\n" + 
                "\r\n";
        OutputStream os=new FileOutputStream(Base64Demo.class.getResource ( "" ).getPath ()+File.separator+"as.jpg");
        
        
        os.write (  base.decode ( enStr.getBytes ()));
        os.close ();
    }
}
