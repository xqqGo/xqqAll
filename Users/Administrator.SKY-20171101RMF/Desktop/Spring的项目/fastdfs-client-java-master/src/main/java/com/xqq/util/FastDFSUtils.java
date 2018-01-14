package com.xqq.util;

import java.io.IOException;
import java.util.Arrays;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

public class FastDFSUtils {
	
	@Test
	public void testFileUpload() throws IOException, MyException {
		ClientGlobal.init("C:/Users/Administrator.SKY-20171101RMF/Desktop/Spring的项目/fastdfs-client-java-master/fdfs_client.conf");
		
		//2创建一个TrtackerClient对象
		TrackerClient trackerClient = new TrackerClient();
		//3.创建trackerServer 并且连接TrackerClient
		
		try {
			TrackerServer connection = trackerClient.getConnection();
			
			//创建StorageServer 引用
			StorageClient storageClient = new StorageClient(connection, null);
			
			//文件扩展名
			String[] string = storageClient.upload_file("C:/Users/Administrator.SKY-20171101RMF/Desktop/项目学习/图片/q.jpg", "jpg", null);
			
			StringBuffer buffer =new StringBuffer();
			
			//返回数组
			for (String string2 : string) {
				buffer.append("/").append(string2);
			}
			
			System.out.println(buffer.toString());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
		Long[] itemsId = {(long) 1,(long) 2,(long) 3,(long) 4,(long) 5};
		String string = Arrays.toString(itemsId);
		String split = string.replace("[", "");
		split = split.replace("]", "").trim();
		for (String string2 : split.split(",")) {
			System.out.println(string2.trim());
			
		}
	}

}
