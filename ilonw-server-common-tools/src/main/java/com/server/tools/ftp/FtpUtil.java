package com.server.tools.ftp;

import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.OutputStream;  

import org.apache.commons.net.ftp.FTP;  
import org.apache.commons.net.ftp.FTPClient;  
import org.apache.commons.net.ftp.FTPFile;  
import org.apache.commons.net.ftp.FTPReply;  

public class FtpUtil {

  public static boolean uploadFile(String host, int port, String username, String password, String basePath,
          String filePath, String filename, InputStream input) {  
      boolean result = false;  
      FTPClient ftp = new FTPClient();  
      try {  
          int reply;  
          ftp.connect(host, port);
          ftp.enterLocalPassiveMode();
          ftp.login(username, password);
          reply = ftp.getReplyCode();  
          if (!FTPReply.isPositiveCompletion(reply)) {  
              ftp.disconnect();  
              return result;  
          }  
          if (!ftp.changeWorkingDirectory(basePath+filePath)) {
              String[] dirs = filePath.split("/");
              String tempPath = basePath;  
              for (String dir : dirs) {  
                  if (null == dir || "".equals(dir)) continue;  
                  tempPath += "/" + dir;  
                  if (!ftp.changeWorkingDirectory(tempPath)) {  
                      if (!ftp.makeDirectory(tempPath)) {  
                          return result;  
                      } else {  
                          ftp.changeWorkingDirectory(tempPath);  
                      }  
                  }  
              }  
          }  
          ftp.setFileType(FTP.BINARY_FILE_TYPE);
          if (!ftp.storeFile(filename, input)) {
              return result;  
          }  
          input.close();  
          ftp.logout();  
          result = true;  
      } catch (IOException e) {  
          e.printStackTrace();  
      } finally {  
          if (ftp.isConnected()) {  
              try {  
                  ftp.disconnect();  
              } catch (IOException ioe) {  
              }  
          }  
      }  
      return result;  
  }  
    
  public static boolean downloadFile(String host, int port, String username, String password, String remotePath,
          String fileName, String localPath) {  
      boolean result = false;  
      FTPClient ftp = new FTPClient();  
      try {  
          int reply;  
          ftp.connect(host, port);  
          ftp.login(username, password);
          reply = ftp.getReplyCode();  
          if (!FTPReply.isPositiveCompletion(reply)) {  
              ftp.disconnect();  
              return result;  
          }  
          ftp.changeWorkingDirectory(remotePath);
          FTPFile[] fs = ftp.listFiles();  
          for (FTPFile ff : fs) {  
              if (ff.getName().equals(fileName)) {  
                  File localFile = new File(localPath + "/" + ff.getName());  

                  OutputStream is = new FileOutputStream(localFile);  
                  ftp.retrieveFile(ff.getName(), is);  
                  is.close();  
              }  
          }  

          ftp.logout();  
          result = true;  
      } catch (IOException e) {  
          e.printStackTrace();  
      } finally {  
          if (ftp.isConnected()) {  
              try {  
                  ftp.disconnect();  
              } catch (IOException ioe) {  
              }  
          }  
      }  
      return result;  
  }  
    
  public static void main(String[] args) {  
      try {    
          FileInputStream in=new FileInputStream(new File("G:\\workspace\\eclipsework\\work\\ilonw-file\\src\\main\\webapp\\ilonw-file-20180110\\00e616c3-e7e8-486b-8f2a-655c9b552e8a1_140224140643_4.png"));    
          boolean flag = uploadFile("192.168.52.27", 21, "shiql", "shiql", "/","/upload", "1234567.jpg", in);    
          System.out.println(flag);    
      } catch (FileNotFoundException e) {    
          e.printStackTrace();    
      }    
  }  
}  