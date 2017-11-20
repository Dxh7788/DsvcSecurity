package com.dsvc.blk.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpServletResponse response;
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String home(){
		return "success";
	}
	@RequestMapping(value="/downloadFile",method=RequestMethod.GET)
	public void downloadFile(){
		BufferedInputStream bis=null;
		ZipOutputStream zs = null;
		try {
			response.setContentType("application/zip");
			response.setHeader("Content-Disposition", "attachment;fileName=" + new String("123".getBytes("utf-8"),"utf-8"));
			OutputStream os = response.getOutputStream();
			File f = new File("H:\\at\\tt.zip");
			if (f.exists()) {
				bis = new BufferedInputStream(new FileInputStream(f));
				zs= new ZipOutputStream(os);
			}
			byte[] buffer = new byte[1024];
			int i= bis.read(buffer);
			while(i!=-1){
				zs.write(buffer, 0, i);
				i= bis.read(buffer);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(bis!=null){
				try {
					bis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (zs!=null) {
				try {
					zs.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
