
package com.slanf.wxsdk.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Song on 2016/11/28.
 * 基于HttpClient提供网络访问工具
 */
public final class NetUtil {
	private static Logger logger = LoggerFactory.getLogger(NetUtil.class);
	private static CloseableHttpClient httpClient = HttpClientBuilder.create().build();

	/**
	 * get请求获取String类型数据
	 * @param url 请求链接
	 * @return
	 */
	public static String get(String url){
		StringBuffer sb = new StringBuffer();
		HttpGet httpGet = new HttpGet(url);
		try {
			HttpResponse response = httpClient.execute(httpGet);           //1

			HttpEntity entity = response.getEntity();
			InputStreamReader reader = new InputStreamReader(entity.getContent(),"utf-8");
			char [] charbufer;
			while (0<reader.read(charbufer=new char[10])){
				sb.append(charbufer);
			}
		}catch (IOException e){//1
			e.printStackTrace();
		}finally {
			httpGet.releaseConnection();
		}
		return sb.toString();
	}

	/**
	 * post方式请求数据
	 * @param url 请求链接
	 * @param data post数据体
	 * @return
	 */
	public static String post(String url, Map<String,String> data){
		StringBuffer sb = new StringBuffer();
		HttpPost httpPost = new HttpPost(url);
		List<NameValuePair> valuePairs = new ArrayList<NameValuePair>();
		if(null != data) {
			for (String key : data.keySet()) {
				valuePairs.add(new BasicNameValuePair(key, data.get(key)));
			}
		}
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(valuePairs));
			HttpResponse response = httpClient.execute(httpPost);
			HttpEntity httpEntity = response.getEntity();
			BufferedInputStream bis = new BufferedInputStream(httpEntity.getContent());
			byte [] buffer;
			while (0<bis.read(buffer=new byte[128])){
				sb.append(new String(buffer,"utf-8"));
			}
		}catch (UnsupportedEncodingException e){//数据格式有误
			e.printStackTrace();
		}catch (IOException e){//请求出错
			e.printStackTrace();
		}finally {
			httpPost.releaseConnection();
		}
		return sb.toString();
	}

	/**
	 * 以POST方式发送xml请求
	 * @param url
	 * @param strData
	 * @return
	 * @throws IOException
	 */
	public static String post(String url, String strData) throws IOException{
		String result = null;
		HttpPost httpPost = new HttpPost(url);
		//得指明使用UTF-8编码，否则到API服务器XML的中文不能被成功识别
		StringEntity postEntity = new StringEntity(strData, "UTF-8");
		httpPost.addHeader("Content-Type", "text/xml");
		httpPost.setEntity(postEntity);
		try {
			HttpResponse response = httpClient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			result = EntityUtils.toString(entity, "UTF-8");
		} catch (ConnectionPoolTimeoutException e) {
			logger.error("http get throw ConnectionPoolTimeoutException(wait time out)");
		} catch (ConnectTimeoutException e) {
			logger.error("http get throw ConnectTimeoutException");
		} catch (SocketTimeoutException e) {
			logger.error("http get throw SocketTimeoutException");
		} catch (Exception e) {
			logger.error("http get throw Exception");
		} finally {
			httpPost.abort();
		}
		return result;
	}
}