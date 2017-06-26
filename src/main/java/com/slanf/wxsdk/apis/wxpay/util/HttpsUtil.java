package com.slanf.wxsdk.apis.wxpay.util;

import com.slanf.wxsdk.apis.wxpay.config.Configure;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;

/**
 * Created by Song on 2017/3/22.
 */
public class HttpsUtil {

    private CloseableHttpClient httpClient;
    public HttpsUtil() throws Exception{
        init();
    }

    public void init() throws Exception{
        KeyStore keyStore  = KeyStore.getInstance("PKCS12");
        FileInputStream instream = new FileInputStream(new File(HttpsUtil.class.getResource(Configure.CERT_PATH).getPath()));
        try {
            keyStore.load(instream, Configure.getMchid().toCharArray());
        } finally {
            instream.close();
        }

        // Trust own CA and all self-signed certs
        SSLContext sslcontext = SSLContexts.custom()
                .loadKeyMaterial(keyStore, Configure.getMchid().toCharArray())
                .build();
        // Allow TLSv1 protocol only
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                sslcontext,
                new String[] { "TLSv1" },
                null,
                SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
        httpClient = HttpClients.custom()
                .setSSLSocketFactory(sslsf)
                .build();
    }

    /**
     * 以POST方式发送xml请求
     * @param url
     * @param xmlObj
     * @return
     * @throws IOException
     */
    public String xmlPost(String url, String xmlObj) throws IOException{
        String result = null;
        HttpPost httpPost = new HttpPost(url);
        //得指明使用UTF-8编码，否则到API服务器XML的中文不能被成功识别
        StringEntity postEntity = new StringEntity(xmlObj, "UTF-8");
        httpPost.addHeader("Content-Type", "text/xml");
        httpPost.setEntity(postEntity);
        try {
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity, "UTF-8");
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            httpPost.abort();
        }
        return result;
    }


}
