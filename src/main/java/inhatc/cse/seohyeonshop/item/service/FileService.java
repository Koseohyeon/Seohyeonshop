package inhatc.cse.seohyeonshop.item.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@Service
@Slf4j
public class FileService {

    public String uploadFile(String uploadPath, String originalFileName,
                             byte[] fileData) throws IOException {

        UUID uuid = UUID.randomUUID(); //랜덤으로 id 생성해줌
        String ext = originalFileName.substring(originalFileName.lastIndexOf("."), originalFileName.length());
        System.out.println("==============" + ext);
        String savedFileName = uuid.toString() + ext;
        String fileUploadFullUrl= uploadPath + "/"+ savedFileName;

        FileOutputStream fos = new FileOutputStream(fileUploadFullUrl);
        fos.write(fileData);
        fos.close();

        return "";
    }

    public void deleteFile(String filepath){
        File deleteFile=new File(filepath);
        if(deleteFile.exists()){
            deleteFile.delete();
           log.info("파일이 삭제되었습니다.");
        }else{
            log.info("해당 파일이 존재하지 않습니다.");
        }
    }

}
