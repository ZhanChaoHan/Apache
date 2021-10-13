package jachs.commons.httpclient;


import org.junit.Test;

import com.jachs.httpclient.HttpClientUtill;

/**
 * @author zhanchaohan
 * @see jachs.commons.Application  start server
 */
public class HttpClientTest {
	private HttpClientUtill httpClientUtill=new HttpClientUtill();
	
    @Test
    public void testPost() {
        String url = "http://localhost:8080/test/posta?pam1=ccc&pam2=dadawd";
        String param = "{\"aaa\":\"bbbbbbb\"}";
        String result=httpClientUtill.sendPost ( url, param );
        System.out.println(result);
    }
    @Test
    public void testGet() {
        String urlParam = "http://localhost:8080/test/geta?pam1=ccc&pam2=dadawd";
        String result=httpClientUtill.sendGet ( urlParam );
        System.out.println(result);
    }
    @Test
    public void test3() {
        String urlParam = "http://localhost:8080/human";
        String result=httpClientUtill.sendGet ( urlParam );
        System.out.println(result);
    }
    @Test
    public void test4() {
        String urlParam = "http://localhost:8080/listhuman";
        String result=httpClientUtill.sendGet ( urlParam );
        System.out.println(result);
    }
}