package com.ilonw.api.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class WeChatWithdrawUtils {
    private byte[] certData;

    public  InputStream getCertStream() {
        ByteArrayInputStream certBis;
        certBis = new ByteArrayInputStream(this.certData);
        return certBis;
    }

    public WeChatWithdrawUtils() throws Exception{
    	File file = new File("src/main/resources/certificate/apiclient_cert.p12");
    	//File file = new File("/usr/local/certificate/apiclient_cert.p12");
        InputStream certStream = new FileInputStream(file);
        certStream.read(this.certData);
        this.certData = new byte[(int) file.length()];
        certStream.close();
    }
}
