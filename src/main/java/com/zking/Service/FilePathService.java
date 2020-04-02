package com.zking.Service;

import com.zking.entity.VideoEntity;
import com.zking.repository.VideoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class FilePathService {
    @Autowired
    private VideoDao videoDao;
    //允许上传的格式
    private static final String[] VIDEO_TYPE = new String[]{".mp4", ".flv",".mpeg", ".avi"};
    //将视频上传到static目录下指定文件夹
    private static String path = "F://bishe//LoginRegister//src//main//resources//static//videos//";
    public String Upload(@RequestParam("file") MultipartFile file) {
        //判断上传视频是否为空
        if (file.isEmpty()) {
            return "请选择视频上传";
        }
        if(!file.isEmpty()) {
            //判断上传视频格式是否符合要求
            boolean isLegal = false;
            for (String type : VIDEO_TYPE) {
                if (StringUtils.endsWithIgnoreCase(file.getOriginalFilename(),
                        type)) {
                    isLegal = true;
                    break;
                }
            }
            if (!isLegal) {
                isLegal = false;
                return "上传文件类型错误，支持类型：MP4,flv,avi,mpeg";
            }
            // 获取文件名称,包含后缀
            String fileName = file.getOriginalFilename();
            try {
                // 该方法是对文件写入的封装，在util类中，导入该包即可使用，后面会给出方法
                FileUtil.fileupload(file.getBytes(), path, fileName);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                //e.printStackTrace();
                System.out.println(e.getMessage()+"文件写入异常");
            }
            // 接着创建对应的实体类，将以下路径进行添加，然后通过数据库操作方法写入
            VideoEntity biaopath = new VideoEntity();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            biaopath.setPath("http://localhost:8081/videos/"+fileName);
            biaopath.setMovie_name(fileName);
            biaopath.setUpDate(df.format(new Date()));
            videoDao.save(biaopath);
        }
        return "视频上传成功";

    }
}
