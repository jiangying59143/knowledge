package com.my.svn;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class SvnExport {

	public static void main(String[] args) {
		try {
				
			   BufferedReader br = cmdRun("svn log http://120.27.216.15/svn/SourceCode/branches/dev");

			   Map<String, SVNVersion> map = getLogList(br);
			   
			   for(String key : map.keySet()) {
				   if(Integer.parseInt(key) > 1350 && !"chunxu".equals(map.get(key).getName())
						   && !"wanghao".equals(map.get(key).getName())) {
//					   if(!"jiangying".equals(map.get(key).getName())) {
//						   continue;
//					   }
					   String path = "D:/svn_export_diff_version/" + key+"_"+map.get(key).getName();
					   mkdir(path);
					  
					   
					   System.out.println(key + "+");
					   System.out.println("--" + map.get(key).getName());
					   System.out.println("--" + map.get(key).getRemarks());
					   String log = exportSpeciVersion(Integer.parseInt(key), path);
					   
					   writeRemarks(path, map.get(key).getRemarks() + "\n" + log);
				   }
			   }
			   
			} catch (IOException e) {
				e.printStackTrace();
			} 

	}
	
	public static Map<String, SVNVersion> getLogList(BufferedReader br) throws IOException{
	   String msg = null;
	   int i=0;
	   Map<String, SVNVersion> map = new HashMap<String, SVNVersion>();
	   String version = "";
	   while ((msg = br.readLine()) != null) {
		   if(!"------------------------------------------------------------------------".equals(msg)) {
			   i++;
		   }else {
			   i=0;
		   }
		   if(i==1) {
			   String[] ss=msg.split("\\|");
			   version = ss[0].substring(1).trim();
			   map.put(version, new SVNVersion(version, ss[1].trim(), null));
		   }
		   if(i==3) {
			   map.put(version, map.get(version).setRemarks(msg.trim()));
		   }
		   if(i>3) {
			   SVNVersion svnVersion = map.get(version);
			   map.put(version, svnVersion.setRemarks(svnVersion.getRemarks() + "\n" + msg.trim()));
		   }
	   }
	   return map;
	}
	
	public static String exportSpeciVersion(int version,String path) throws IOException {
		String msg = null;
		String cmdstr = "svn diff --summarize -r" 
				+ (version-1) +":" + version + " http://120.27.216.15/svn/SourceCode/branches/dev";
		BufferedReader br = cmdRun(cmdstr);
		String returnLog = "";
		while ((msg = br.readLine()) != null) {
			String[] ss = msg.split("       ");
			String actionOfSingleFile = ss[0].trim();
			String urlOfSingleFile = ss[1].trim();
			String localPath = path + urlOfSingleFile
					.substring(urlOfSingleFile.indexOf("/SourceCode"),
							urlOfSingleFile.lastIndexOf("/"));
			if("D".equals(actionOfSingleFile)) {
				exportSingleFile((version-1), urlOfSingleFile, localPath);
			}else {
				exportSingleFile(version, urlOfSingleFile, localPath);
			}
			System.out.println(msg + "          finish");
			returnLog =returnLog+msg+"\n";
		}
		return returnLog;
	}
	
	public static void exportSingleFile(int version, String url,String path) throws IOException {
		mkdir(path);
		if(!new File(path + "/" + url.substring(url.lastIndexOf("/"))).exists()) {
			String cmdstr = "svn export -r" + version
					+ " " + url + " " + path;
			cmdRun(cmdstr);
		}
	}
	
	public static BufferedReader cmdRun(String commond) throws IOException {
		Process pro1 = Runtime.getRuntime().exec(commond);
		BufferedReader br1 = new BufferedReader(new InputStreamReader(pro1.getInputStream()));
		return br1;
	}
	
	public static void mkdir(String path) {
		File file = new File(path);
		if(!(file.exists() && file.isDirectory())){
			file.mkdirs();
		}
	}
	
	public static void writeRemarks(String path, String remarks) throws IOException {
		FileWriter fw = new FileWriter(path + "/remark.txt");
		fw.write(remarks);
		fw.close();
	}

}
