package com.cloud;

import java.io.IOException;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Demo {
	

	public static void main(String[] args) throws Exception {
		String encrypt = Encrypt("王东");
		System.out.println(encrypt);
//		String str = "48788bd607526f61f93476fa448e9578065fea48dfc4731665307bb8b7877ce8";
		String decrypt = Decrypt(encrypt);
		System.out.println(decrypt);
	}
	
	/**加密
	 * @return
	 * @throws Exception
	 */
	public static String Encrypt(String encrypt) throws Exception {
		CloseableHttpClient client = HttpClients.createDefault();
        // 发送post请求
        HttpPost post = new HttpPost("http://localhost:1002/encrypt");

        // 设置请求的参数，对20180323进行加密，编码格式为UTF-8
        StringEntity entity = new StringEntity(encrypt, Consts.UTF_8);
        post.setEntity(entity);

        HttpResponse response = client.execute(post);
        return EntityUtils.toString(response.getEntity());
	}
	
	public static String Decrypt(String decrypt) throws Exception {
	        CloseableHttpClient client = HttpClients.createDefault();
	        // 发送post请求
	        HttpPost post = new HttpPost("http://localhost:1002/decrypt");

	        HttpEntity entity = new StringEntity(decrypt, Consts.UTF_8);
	        post.setEntity(entity);

	        HttpResponse response = client.execute(post);
	        return EntityUtils.toString(response.getEntity());
	}

}
