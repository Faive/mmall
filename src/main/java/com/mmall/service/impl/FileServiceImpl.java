package com.mmall.service.impl;

import com.google.common.collect.Lists;
import com.mmall.service.IFileService;
import com.mmall.util.FTPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author YH
 */

@Service("iFileService")
public class FileServiceImpl implements IFileService {

    Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    @Override
    public String upload(MultipartFile file, String path){
        String fileName = file.getOriginalFilename();
        String fileExtensionFileName = fileName.substring(fileName.lastIndexOf(".")+1);
        String uploadFileName = UUID.randomUUID().toString() + "." + fileExtensionFileName;

        logger.info("开始上传文件，文件名：{}，上传路径：{}，新文件名：{}",fileName,path,uploadFileName);
        File fileDir = new File(path);
        if(!fileDir.exists()){
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }
        File targetFile = new File(path, uploadFileName);
        try {
            file.transferTo(targetFile);
            //文件已经上传成功
            // target  上传至FTP服务器
            FTPUtil.uploadFile(Lists.newArrayList(targetFile));
            //删除upload下的文件
            targetFile.delete();
        } catch (IOException e) {
            logger.error("文件上传异常", e);
            return null;
        }


        return targetFile.getName();
    }
}
