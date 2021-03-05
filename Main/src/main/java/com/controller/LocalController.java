package com.controller;

import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/local")
@Controller
@EnableAsync
public class LocalController {
//    @Autowired
//    private JedisCluster jedis;

    @Autowired
    private StudentService studentService;

    @RequestMapping("/test")
    @ResponseBody
    //@Action(name="注解式拦截-----")
    public String test(@RequestBody String name) {
//        RedisTemplate redisTemplate = new RedisTemplate();
//        redisTemplate
//                .opsForValue()
//                .set("12306", "6", 1, TimeUnit.SECONDS);
        //jedis.psetex("12306", 30000L, "1");
        return "test777----"+name;
    }

    @RequestMapping("/uploadFile")
    @ResponseBody
    public String uploadFile(@RequestParam("file") MultipartFile file) throws Exception{
        String path = "/tmp/"+file.getOriginalFilename();
        File dest = new File(path);
        file.transferTo(dest);

        return path;
    }

    @RequestMapping("/async")
    @ResponseBody
    public void async() throws Exception {
        studentService.asyncMethod(1);
        studentService.asyncMethod(2);

    }

    @RequestMapping(value = "/downPdf", method = RequestMethod.POST)
    @ResponseBody
    public String exportPdf(HttpServletResponse response) throws UnsupportedEncodingException {
        // 1.指定解析器
        System.setProperty("javax.xml.parsers.DocumentBuilderFactory",
                "com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl");
        String filename = "tt.pdf";
        String path = "/Users/mac/IdeaProjects/LocalTest/Main/src/main/java/com/controller";
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment;fileName="
                + URLEncoder.encode(filename, "UTF-8"));
        OutputStream os = null;
        PdfStamper ps = null;
        PdfReader reader = null;
        try {
            os = response.getOutputStream();
            // 2 读入pdf表单
            reader = new PdfReader(path + "/" + filename);
            // 3 根据表单生成一个新的pdf
            ps = new PdfStamper(reader, os);
            // 4 获取pdf表单
            AcroFields form = ps.getAcroFields();
            // 5给表单添加中文字体 这里采用系统字体。不设置的话，中文可能无法显示
//            BaseFont bf = BaseFont.createFont("C:/WINDOWS/Fonts/SIMSUN.TTC,1",
//                    BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
//            form.addSubstitutionFont(bf);
            BaseFont bf = BaseFont.createFont(
                    BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED); // 这个字体不显示中文

            form.addSubstitutionFont(bf);
            // 6查询数据================================================
            Map<String, String> data = new HashMap<String, String>();
            data.put("n1", "wzj");
            data.put("s1", "男");
            data.put("a1", "18");
            data.put("n2", "lj");
            data.put("s2", "女");
            data.put("a2", "16");
            // 7遍历data 给pdf表单表格赋值
            for (String key : data.keySet()) {
                form.setField(key, data.get(key).toString());
            }
            ps.setFormFlattening(true);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                reader.close();
                os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
