package cn.e3mall.fastfds.test;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import cn.e3mall.common.utils.FastDFSClient;

public class TestFastFDS {

	@Test
	public void testUpload() throws Exception {
		// 2、加载配置文件，全路径。不支持classpath形式路径
		ClientGlobal.init("D:/e3mall/e3mall-web/src/main/resources/conf/client.conf");
		// 3、创建一个TrackerClient对象。直接new
		TrackerClient trackerClient = new TrackerClient();
		// 4、使用TrackerClient获得一个TrackerServer对象。
		TrackerServer trackerServer = trackerClient.getConnection();
		// 5、创建一个StorageClient对象。需要两个参数，一个是TrackerServer对象，一个是StorageServer对象（可以为null）
		StorageServer storageServer = null;
		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
		// 6、使用StorageClient对象上传文件。
		// 参数1：文件路径及文件名。 参数2：文件的扩展名，不带"."。 参数3：元数据，可以为null
		String[] strings = storageClient.upload_file("C:/Users/MAXIAO/Downloads/v2-b65d1a705d58648b6cf296bd7a3782bb_r.jpg", "jpg", null);
		for (String string : strings) {
			System.out.println(string);
		}
	}
	
	@Test
	public void testFastDFSClientUtils () throws Exception {
		FastDFSClient fastDFSClient = new FastDFSClient("classpath:conf/client.conf");
		String string = fastDFSClient.uploadFile("C:/Users/MAXIAO/Pictures/Saved Pictures/e224d93a529dc448746f38e7cc6918f5abfd1b2a2cbe2d34b7a5f323702aaafa.jpg");
		System.out.println(string);
	}

}
