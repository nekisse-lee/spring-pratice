package com.myspring.pro30.common.file;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

@Controller
public class FileDownloadController {

    private static final String ARTICLE_IMAGE_REPO =
            "/Users/nekisse/Documents/intellij_workspace/spring-pratice/pro30/article_image";

    @RequestMapping("/download.do")
    protected void download(@RequestParam("imageFileName") String imageFileName,
                            @RequestParam("articleNO") String articleNO,
                            HttpServletResponse response) throws Exception {

        OutputStream out = response.getOutputStream();
        String downFile = ARTICLE_IMAGE_REPO + "/" + articleNO + "/" + imageFileName;
        File file = new File(downFile);
        response.setCharacterEncoding("utf-8");
        response.setHeader("Cache-Control", "no-cache");
        response.addHeader("Content-disposition", "attachment; fileName=" + imageFileName);
        FileInputStream in = new FileInputStream(file);
        try {
            byte[] buffer = new byte[1024 * 8];
            while (true) {
                int count = in.read(buffer);
                if (count == -1)
                    break;
                out.write(buffer, 0, count);
            }
        } finally {
            in.close();
            out.close();
        }

    }

}
