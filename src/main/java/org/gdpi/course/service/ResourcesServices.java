package org.gdpi.course.service;

import com.github.pagehelper.PageInfo;
import org.gdpi.course.pojo.StudentResources;
import org.gdpi.course.pojo.TeacherResources;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;

public interface ResourcesServices {
    /**
     * 文件上传
     * @param file
     * @param teacherResources
     * @param sessions
     */
    void upload(MultipartFile file, TeacherResources teacherResources, HttpSession sessions) throws IOException;

    /**
     * 文件上传
     * @param file
     * @param studentResources
     * @param sessions
     */
    void upload(MultipartFile file, StudentResources studentResources, HttpSession sessions) throws IOException;


    /**
     * 分页查找
     * @param page
     * @param size
     * @return
     */
    PageInfo<TeacherResources> findPage(int page, int size, int cid);

    PageInfo<StudentResources> findPageStu(int page, int pageSize, int cid);

    /**
     * 删除
     * @param id
     * @param cid
     */
    void deleteTeaResources(Integer id, Integer cid, HttpSession session);

    void deleteStuResources(Integer id, Integer cid, HttpSession session);

    /**
     * 下载教师资源
     * @param id
     * @param cid
     * @return
     */
    String downloadTeaResources(Integer id, Integer cid);

    /**
     * 下载学生资源
     * @param id
     * @param cid
     * @return
     */
    String downloadStuResources(Integer id, Integer cid);
}
