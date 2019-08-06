package com.ilonw.file.Service;

import com.ilonw.server.bo.TableFileBO;

public interface FileService {

    String saveFile(TableFileBO tableFile);

    void updateFile(String context,String Identification);

    public void testthread();
}
