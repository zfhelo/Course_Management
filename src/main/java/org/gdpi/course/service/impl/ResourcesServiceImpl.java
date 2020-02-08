package org.gdpi.course.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.gdpi.course.dao.CourseDao;
import org.gdpi.course.dao.ResourcesDao;
import org.gdpi.course.pojo.Course;
import org.gdpi.course.pojo.StudentResources;
import org.gdpi.course.pojo.TeacherResources;
import org.gdpi.course.service.ResourcesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service("resourcesService")
public class ResourcesServiceImpl implements ResourcesServices {

    @Autowired
    private ResourcesDao resourcesDao;
    @Autowired
    private CourseDao courseDao;

    @Override
    public void upload(MultipartFile file, TeacherResources teacherResources, HttpSession sessions) throws IOException {
        // 拿到文件名
        String filename = file.getOriginalFilename();
        // 获取一个随机字符串
        UUID uuid = UUID.randomUUID();
        String s = uuid.toString().split("-")[0];
        filename = s + "_"+ filename;
        // WEB-INF/files/教师id/课程id/
        String path = sessions.getServletContext().getRealPath("WEB-INF/files/" + teacherResources.getTid() + "/" + teacherResources.getCid());
        File parent = new File(path);
        // 不存在
        if (!parent.exists()) {
            parent.mkdirs();
        }
        // 保存
        file.transferTo(new File(parent, filename));
        teacherResources.setPath("WEB-INF/files/" + teacherResources.getTid() + "/" + teacherResources.getCid()+"/"+filename);
        teacherResources.setSize((int)file.getSize() / 1024);

        // 保存数据到数据库
        resourcesDao.saveTeacherFile(teacherResources);
    }

    /**
     * 学生上传文件
     * @param file
     * @param studentResources
     * @param sessions
     * @throws IOException
     */
    @Override
    public void upload(MultipartFile file, StudentResources studentResources, HttpSession sessions) throws IOException {
        // 拿到文件名
        String filename = file.getOriginalFilename();
        // 获取一个随机字符串
        UUID uuid = UUID.randomUUID();
        String s = uuid.toString().split("-")[0];
        filename = s + "_"+ filename;
        // WEB-INF/files/教师id/课程id/
        Course course = courseDao.findById(studentResources.getCid());
        String path = sessions.getServletContext().getRealPath("WEB-INF/files/" + course.getTid() + "/" + studentResources.getCid());
        File parent = new File(path);
        // 不存在
        if (!parent.exists()) {
            parent.mkdirs();
        }
        // 保存
        file.transferTo(new File(parent, filename));
        studentResources.setPath("WEB-INF/files/" + course.getTid() + "/" + studentResources.getCid()+"/"+filename);
        studentResources.setSize((int)file.getSize() / 1024);

        // 保存数据到数据库
        resourcesDao.saveStudentFile(studentResources);
    }

    @Override
    public String downloadTeaResources(Integer id, Integer cid) {
        TeacherResources teaById = resourcesDao.findTeaById(id);
        return teaById.getPath();
    }

    @Override
    public String downloadStuResources(Integer id, Integer cid) {
        StudentResources stuById = resourcesDao.findStuById(id);
        return stuById.getPath();
    }

    @Override
    public void deleteStuResources(Integer id, Integer cid, HttpSession session) {
        StudentResources stuById = resourcesDao.findStuById(id);
        if (stuById == null) {
            return;
        }
        String path = session.getServletContext().getRealPath("/");
        path = path + stuById.getPath();
        new File(path).delete();
        resourcesDao.deleteStuResources(id, cid);
    }

    @Override
    public void deleteTeaResources(Integer id, Integer cid, HttpSession session) {
        TeacherResources teaById = resourcesDao.findTeaById(id);
        if (teaById == null) {
            return;
        }
        String path = session.getServletContext().getRealPath("/");
        path = path + teaById.getPath();
        new File(path).delete();
        resourcesDao.deleteTeaResources(id, cid);
    }

    @Override
    public PageInfo<TeacherResources> findPage(int page, int pageSize, int cid) {
        Page<Object> objects = PageHelper.startPage(page, pageSize);
        List<TeacherResources> teacherAll = resourcesDao.findTeacherAll(cid);
        return new PageInfo<TeacherResources>(teacherAll, 5);
    }

    @Override
    public PageInfo<StudentResources> findPageStu(int page, int pageSize, int cid) {
        Page<Object> objects = PageHelper.startPage(page, pageSize);
        List<StudentResources> all = resourcesDao.findStudentAll(cid);
        return new PageInfo<StudentResources>(all, 5);
    }
}
