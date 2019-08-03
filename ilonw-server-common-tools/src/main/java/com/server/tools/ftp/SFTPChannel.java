package com.server.tools.ftp;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class SFTPChannel {
    //获取ip地址
    @Value("${FTP_ADDRESS}")
    private String FTP_ADDRESS;
    //端口号
    @Value("${FTP_PORT}")
    private Integer FTP_PORT;
    //用户名
    @Value("${FTP_USERNAME}")
    private String FTP_USERNAME;
    //密码
    @Value("${FTP_PASSWORD}")
    private String FTP_PASSWORD;

    Session session = null;
    Channel channel = null;

    private static final Logger LOG = Logger.getLogger(SFTPChannel.class.getName());

    public ChannelSftp getChannel(int timeout) throws JSchException {
        JSch jsch = new JSch(); // 创建JSch对象
        session = jsch.getSession(FTP_USERNAME, FTP_ADDRESS, FTP_PORT); // 根据用户名，主机ip，端口获取一个Session对象
        LOG.debug("Session created.");
        if (FTP_PASSWORD != null) {
            session.setPassword(FTP_PASSWORD); // 设置密码
        }
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config); // 为Session对象设置properties
        session.setTimeout(timeout); // 设置timeout时间
        session.connect(); // 通过Session建立链接
        LOG.debug("Session connected.");

        LOG.debug("Opening Channel.");
        channel = session.openChannel("sftp"); // 打开SFTP通道
        channel.connect(); // 建立SFTP通道的连接
        LOG.debug("Connected successfully to ftpHost = " + FTP_ADDRESS + ",as ftpUserName = " + FTP_USERNAME
                + ", returning: " + channel);
        return (ChannelSftp) channel;
    }

    public void closeChannel() throws Exception {
        if (channel != null) {
            channel.disconnect();
        }
        if (session != null) {
            session.disconnect();
        }
    }
}
