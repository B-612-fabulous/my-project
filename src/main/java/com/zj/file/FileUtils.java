package com.zj.file;

import com.zj.config.common.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class FileUtils {

    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected HttpServletResponse response;
    private String FILE_DISK_PATH = "D:/upload/image/";

    @PostMapping("/upload")
    @ResponseBody
    public R upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return R.warning();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String fileName = file.getOriginalFilename();
        int position = fileName.lastIndexOf(".");
        String fileType = fileName.substring(position, fileName.length()); // 获得文件后缀
        String filePath= sdf.format(new Date());
        File dest = new File(FILE_DISK_PATH + filePath);
        if (!dest.exists()) {
            dest.mkdirs();
        }
        try {
            String newPath =  filePath+ "/" + UuidUtil.newGeneratId()+fileType;
            File saveFile = new File(FILE_DISK_PATH + newPath);
            file.transferTo(saveFile);
            return R.ok(newPath);
        } catch (IOException e) {
            R.error();
        }
        return R.error();
    }
    @GetMapping("/download/image")
    public void downloadImage(String filePath){
        try{
//            logger.info("=================下载图片,图片路径为" + filePath + "====================");
//            FileBO sysFile = fileCommonService.getFileByPath(filePath);
            // 新版文件的下载
//            if(null == sysFile){//新上传文件，尚未保存到数据库
//                FileBO newSysFile = new FileBO();
//                newSysFile.setFilePath(filePath);
//                String newFileName = filePath.substring(filePath.lastIndexOf("/") + 1);
//                newSysFile.setFileName(newFileName);
//                // fileDownLoad(newSysFile, response);
//                nioFileDownLoad(newSysFile, response);
//            }else{
//                // fileDownLoad(sysFile, response);
//
//            }
            nioFileDownLoad(filePath);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     * NIO模式下载文件
     * @Description 文件下载通用方法
     * @author ShiZi
     * @date 2019年9月12日
     * @throws IOException
     */
    private void nioFileDownLoad(String filePath) throws IOException{
        OutputStream os = null;
        try{
            String fileName = filePath.substring(filePath.lastIndexOf("/") + 1);;
            //获取文件信息
            String path = "";
            path = FILE_DISK_PATH + filePath;
            File file = new File(path);// 得到要下载的文件
            if(!file.exists()){//遍历第一个目录
                file = new File(path);
                if(!file.exists()){//遍历第二个目录
                    System.out.println("文件不存在");
                    return;
                }
            }
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            String nameSave = getStr(request, fileName);
            String str = null;
            str = "attachment;filename=\"" + nameSave + "\"";
            response.setHeader("Content-Disposition", str);

            // 取得输出流
            os = response.getOutputStream();
            FileInputStream fileInputStream = new FileInputStream(file);
            WritableByteChannel writableByteChannel = Channels.newChannel(os);
            FileChannel fileChannel = fileInputStream.getChannel();
            fileChannel.transferTo(0,fileChannel.size(),writableByteChannel);
            fileChannel.close();
            os.flush();
            writableByteChannel.close();

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if (os != null) {
                    os.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    private String getStr(HttpServletRequest request, String realFileName) throws Exception{
        String browName = null;
        String clientInfo = request.getHeader("User-agent");
        if(clientInfo != null && clientInfo.indexOf("MSIE") > 0){//
            // IE采用URLEncoder方式处理
            if(clientInfo.indexOf("MSIE 6") > 0 || clientInfo.indexOf("MSIE 5") > 0){// IE6，用GBK，此处实现由局限性
                browName = new String(realFileName.getBytes("GBK"), "ISO-8859-1");
            }else{// ie7+用URLEncoder方式
                browName = java.net.URLEncoder.encode(realFileName, "UTF-8");
            }
        }else if(clientInfo.toLowerCase().contains("edge") || clientInfo.toLowerCase().contains("trident")){ // win10 ie edge 浏览器 和其他系统的ie
            browName = URLEncoder.encode(realFileName, "UTF-8");
        }else{// 其他浏览器
            browName = new String(realFileName.getBytes("UTF-8"), "ISO-8859-1");
        }
        return browName;
    }
}
