package cn.e3mall.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.e3mall.common.utils.FastDFSClient;
import cn.e3mall.common.utils.JsonUtils;

@Controller
@RequestMapping("/pic")
public class PictureController {

	@Value("${image.server.url}")
	private String imgServerPrefix;

	/*
	@RequestMapping("/upload")
	@ResponseBody
	public Map<String, Object> picUpload(MultipartFile uploadFile) {
		String fileName = uploadFile.getOriginalFilename();
		Map<String, Object> map = new HashMap<>();
		try {
			FastDFSClient fastDFSClient = new FastDFSClient("classpath:conf/client.conf");
			String filePath = fastDFSClient.uploadFile(uploadFile.getBytes(),
					fileName.substring(fileName.lastIndexOf(".") + 1));
			String path = imgServerPrefix + filePath;
			map.put("error", 0);
			map.put("url", path);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("error", 1);
			map.put("message", "文件上传失败");
		}
		return map;
	}
	*/
	
	@RequestMapping(value="/upload",produces=MediaType.TEXT_PLAIN_VALUE + ";charset=utf-8")
	@ResponseBody
	public String picUpload(MultipartFile uploadFile) {
		String fileName = uploadFile.getOriginalFilename();
		Map<String, Object> map = new HashMap<>();
		try {
			FastDFSClient fastDFSClient = new FastDFSClient("classpath:conf/client.conf");
			String filePath = fastDFSClient.uploadFile(uploadFile.getBytes(),
					fileName.substring(fileName.lastIndexOf(".") + 1));
			String path = imgServerPrefix + filePath;
			map.put("error", 0);
			map.put("url", path);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("error", 1);
			map.put("message", "文件上传失败");
		}
		// 使用jackson将map转为string
		return JsonUtils.objectToJson(map);
	}
}
