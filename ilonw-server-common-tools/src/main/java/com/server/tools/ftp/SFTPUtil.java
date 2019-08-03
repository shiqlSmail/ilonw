package com.server.tools.ftp;

import java.io.ByteArrayInputStream;  
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.UnsupportedEncodingException;  
import java.util.Properties;  
import java.util.Vector;

import org.apache.poi.util.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;  
  
import com.jcraft.jsch.Channel;  
import com.jcraft.jsch.ChannelSftp;  
import com.jcraft.jsch.JSch;  
import com.jcraft.jsch.JSchException;  
import com.jcraft.jsch.Session;  
import com.jcraft.jsch.SftpException;

public class SFTPUtil {
	 private transient Logger log = LoggerFactory.getLogger(this.getClass());  
     
	    private ChannelSftp sftp;  
	    private Session session;  
	    private String username;
	    private String password;
	    private String privateKey;
	    private String host;
	    private int port;
	        
	    
	    public SFTPUtil(String username, String password, String host, int port) {
	        this.username = username;  
	        this.password = password;  
	        this.host = host;  
	        this.port = port;  
	    }  
	    
	    public SFTPUtil(String username, String host, int port, String privateKey) {
	        this.username = username;  
	        this.host = host;  
	        this.port = port;  
	        this.privateKey = privateKey;  
	    }  
	    
	    public SFTPUtil(){}  
	    
	    public void login(){
	        try {  
	            JSch jsch = new JSch();  
	            if (privateKey != null) {  
	                jsch.addIdentity(privateKey);// ����˽Կ  
	                log.info("sftp connect,path of private key file��{}" , privateKey);  
	            }  
	            log.info("sftp connect by host:{} username:{}",host,username);  
	    
	            session = jsch.getSession(username, host, port);  
	            log.info("Session is build");  
	            if (password != null) {  
	                session.setPassword(password);    
	            }  
	            Properties config = new Properties();  
	            config.put("StrictHostKeyChecking", "no");  
	                
	            session.setConfig(config);  
	            session.connect();  
	            log.info("Session is connected");  
	              
	            Channel channel = session.openChannel("sftp");  
	            channel.connect();  
	            log.info("channel is connected");  
	    
	            sftp = (ChannelSftp) channel;  
	            log.info(String.format("sftp server host:[%s] port:[%s] is connect successfull", host, port));  
	        } catch (JSchException e) {  
	            log.error("Cannot connect to specified sftp server : {}:{} \n Exception message is: {}", new Object[]{host, port, e.getMessage()});    
	        }  
	    }    
	    
	    public void logout(){
	        if (sftp != null) {  
	            if (sftp.isConnected()) {  
	                sftp.disconnect();  
	                log.info("sftp is closed already");  
	            }  
	        }  
	        if (session != null) {  
	            if (session.isConnected()) {  
	                session.disconnect();  
	                log.info("sshSession is closed already");  
	            }  
	        }  
	    }  
	    
	    public void upload(String directory, String sftpFileName, InputStream input) throws SftpException{
	        try {    
	            sftp.cd(directory);  
	        } catch (SftpException e) {  
	            log.warn("directory is not exist");  
	            sftp.mkdir(directory);  
	            sftp.cd(directory);  
	        }  
	        sftp.put(input, sftpFileName);  
	        log.info("file:{} is upload successful" , sftpFileName);  
	    }  
	    
	    public void upload(String directory, String uploadFile) throws FileNotFoundException, SftpException{
	        File file = new File(uploadFile);  
	        upload(directory, file.getName(), new FileInputStream(file));  
	    }  
	    
	    public void upload(String directory, String sftpFileName, byte[] byteArr) throws SftpException{
	        upload(directory, sftpFileName, new ByteArrayInputStream(byteArr));  
	    }  
	    
	    public void upload(String directory, String sftpFileName, String dataStr, String charsetName) throws UnsupportedEncodingException, SftpException{
	        upload(directory, sftpFileName, new ByteArrayInputStream(dataStr.getBytes(charsetName)));    
	    }  

	    public void download(String directory, String downloadFile, String saveFile) throws SftpException, FileNotFoundException{
	        if (directory != null && !"".equals(directory)) {  
	            sftp.cd(directory);  
	        }  
	        File file = new File(saveFile);  
	        sftp.get(downloadFile, new FileOutputStream(file));  
	        log.info("file:{} is download successful" , downloadFile);  
	    }

	    public byte[] download(String directory, String downloadFile) throws SftpException, IOException{
	        if (directory != null && !"".equals(directory)) {  
	            sftp.cd(directory);  
	        }  
	        InputStream is = sftp.get(downloadFile);  
	          
	        byte[] fileData = IOUtils.toByteArray(is);
	          
	        log.info("file:{} is download successful" , downloadFile);  
	        return fileData;  
	    }  
	    
	    public void delete(String directory, String deleteFile) throws SftpException{
	        sftp.cd(directory);  
	        sftp.rm(deleteFile);  
	    }  

	    public Vector<?> listFiles(String directory) throws SftpException {
	        return sftp.ls(directory);  
	    }  
	      
	    public static void main(String[] args) throws SftpException, IOException {  
	        SFTPUtil sftp = new SFTPUtil("root", "ilonw!QAZ@WSX", "192.168.0.102", 22);  
	        sftp.login();  
	        File file = new File("G:\\workspace\\eclipsework\\work\\ilonw-file\\src\\main\\webapp\\ilonw-file-20180110\\b6878e8f-2fb3-4227-8fa5-a7018e81e3bc01.jpg");  
	        InputStream is = new FileInputStream(file);  
	          
	        sftp.upload("/java", "123456.jpg", is);  
	        sftp.logout();  
	    }  
}
