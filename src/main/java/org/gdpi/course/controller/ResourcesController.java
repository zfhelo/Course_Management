package org.gdpi.course.controller;

import com.github.pagehelper.PageInfo;
import org.gdpi.course.pojo.Student;
import org.gdpi.course.pojo.StudentResources;
import org.gdpi.course.pojo.Teacher;
import org.gdpi.course.pojo.TeacherResources;
import org.gdpi.course.service.ResourcesServices;
import org.gdpi.course.utils.ExceptionMessage;
import org.gdpi.course.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

@Controller
public class ResourcesController {

    @Autowired
    private ResourcesServices resourcesServices;
    /**
     * 上传文件
     * @param file 文件
     * @param teacherResources
     * @param teacher 上传教师
     * @param id 对应课程
     * @return
     */
    @RequestMapping("/teacher/upload")
    @ResponseBody
    public ResponseMessage upload(MultipartFile file,
                                  TeacherResources teacherResources,
                                  @SessionAttribute("TEACHER") Teacher teacher,
                                  @SessionAttribute("CURRENT_COURSE") Integer id,
                                  HttpSession sessions) throws IOException {
        teacherResources.setTid(teacher.getId());
        teacherResources.setCid(id);
        resourcesServices.upload(file, teacherResources, sessions);
        return ResponseMessage.success();
    }

    /**
     * 上传文件
     * @param file 文件
     * @param studentResources
     * @param student 上传学生
     * @param id 对应课程
     * @return
     */
    @RequestMapping("/student/upload")
    @ResponseBody
    public ResponseMessage upload(MultipartFile file,
                                  StudentResources studentResources,
                                  @SessionAttribute("STUDENT") Student student,
                                  @SessionAttribute("CURRENT_COURSE") Integer id,
                                  HttpSession sessions) throws IOException {
        studentResources.setSid(student.getId());
        studentResources.setCid(id);
        resourcesServices.upload(file, studentResources, sessions);
        return ResponseMessage.success();
    }


    /**
     * 分页查找
     * @param cid
     * @param page
     * @param pageSize
     * @return
     */
    @PostMapping("/{identity}/findPage")
    @ResponseBody
    public PageInfo findPage(@SessionAttribute("CURRENT_COURSE") Integer cid,
                                               @RequestParam Integer page,
                                               @Value("${pageSize}") Integer pageSize,
                                               @PathVariable("identity") String identity) {
        if ("teacher".equals(identity)) {
            return resourcesServices.findPage(page, pageSize, cid);
        }
        if ("student".equals(identity)) {
            // 问题  java.lang.IllegalStateException: 当前响应已经调用了方法getOutputStream()
            return resourcesServices.findPageStu(page, pageSize, cid);
        }
        return new PageInfo();
    }

    /**
     * 教师删除资源
     * @param id
     * @param cid
     * @param session
     * @param teacher
     * @param identity
     * @return
     */
    @PostMapping("/{identity}/deleteResources")
    @ResponseBody
    public ResponseMessage deleteResources(@RequestParam Integer id,
                                           @SessionAttribute("CURRENT_COURSE") Integer cid,
                                           HttpSession session,
                                           @SessionAttribute("TEACHER") Teacher teacher,
                                           @PathVariable("identity") String identity) {
        if ("teacher".equals(identity)) {
            resourcesServices.deleteTeaResources(id, cid, session);
        } else if ("student".equals(identity)) {
            try {
                resourcesServices.deleteStuResources(id, cid, session);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ResponseMessage.success();
    }

    @GetMapping("/teacher/download")
    public void download(@RequestParam Integer id,
                         @SessionAttribute("CURRENT_COURSE") Integer cid,
                         HttpServletResponse response,
                         HttpSession session) throws Exception {
        String ProjectPath = session.getServletContext().getRealPath("/");
        String path = resourcesServices.downloadTeaResources(id, cid);
        path = ProjectPath + path;
        File file = new File(path);
        // 文件不存在
        if (!file.exists()) {
            throw new ExceptionMessage("资源已被删除");
        }
        int lastIndexOf = path.lastIndexOf('/');
        String filename = path.substring(lastIndexOf);
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition","attachment;filename*=utf-8'zh_cn'"+ URLEncoder.encode(filename,"utf-8"));
        BufferedInputStream bfs = new BufferedInputStream(new FileInputStream(file));
        byte[] b = new byte[8192];
        ServletOutputStream outputStream = response.getOutputStream();
        int count = bfs.read(b);
        while (count != -1) {
            outputStream.write(b, 0 , count);
            count = bfs.read(b);
        }
        bfs.close();
    }
}
