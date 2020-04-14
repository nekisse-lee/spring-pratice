package com.myspring.pro28.ex01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.*;

@Controller
public class FileUploadController {
    private static final String CURR_IMAGE_REPO_PATH =
            "/Users/nekisse/Documents/intellij_workspace/spring-pratice/pro28/spring/image_repo";

    @RequestMapping(value = "/form")
    public String form() {
        return "uploadForm";
    }


    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ModelAndView upload(MultipartHttpServletRequest multipartRequest, HttpServletResponse response)
            throws Exception {
        multipartRequest.setCharacterEncoding("utf-8");
        Map map = new HashMap();
        Enumeration enu = multipartRequest.getParameterNames();
        while (enu.hasMoreElements()) {
            String name = (String) enu.nextElement();
            String value = multipartRequest.getParameter(name);
            //System.out.println(name+", "+value);
            map.put(name, value);
        }

        List fileList = fileProcess(multipartRequest);
        map.put("fileList", fileList);
        ModelAndView mav = new ModelAndView();
        mav.addObject("map", map);
        mav.setViewName("result");


        Set set = map.entrySet();
        for (Object o : set) {
            System.out.println("파일이름 : " + o.toString());
        }


        return mav;
    }

    /*private List<String> fileProcess(MultipartHttpServletRequest multipartRequest) throws Exception {
        List<String> fileList = new ArrayList<String>();
        Iterator<String> fileNames = multipartRequest.getFileNames();
        while (fileNames.hasNext()) {
            String fileName = fileNames.next();
            MultipartFile mFile = multipartRequest.getFile(fileName);
            String originalFileName = mFile.getOriginalFilename();
            fileList.add(originalFileName);
            File file = new File(CURR_IMAGE_REPO_PATH + "/" + fileName);
            if (mFile.getSize() != 0) { //File Null Check
                if (!file.exists()) { //경로상에 파일이 존재하지 않을 경우
                    if (file.getParentFile().mkdirs()) { //경로에 해당하는 디렉토리들을 생성
                        file.createNewFile(); //이후 파일 생성
                    }
                }
                mFile.transferTo(new File(CURR_IMAGE_REPO_PATH + "/" + originalFileName)); //임시로 저장된 multipartFile을 실제 파일로 전송
            }
        }
        return fileList;
    }*/

    private List<String> fileProcess(MultipartHttpServletRequest multipartRequest) throws Exception {
        List<String> fileList = new ArrayList<String>();
        List<MultipartFile> fList = multipartRequest.getFiles("file");
        for (MultipartFile mFile : fList) {
            String originalFilename = mFile.getOriginalFilename();
            fileList.add(originalFilename);
            File file = new File(CURR_IMAGE_REPO_PATH + "/" + originalFilename);
            if (mFile.getSize() != 0) {
                if (!file.exists()) {
                    if (file.getParentFile().mkdirs()) {
                        file.createNewFile();
                    }
                }
                mFile.transferTo(new File(CURR_IMAGE_REPO_PATH + "/" + originalFilename));
            }

        }
        return fileList;
    }
}
