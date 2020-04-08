package com.csdj;



import com.csdj.common.name;
import com.csdj.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    //获取用户信息列表
    @RequestMapping(value = "select")
    @ResponseBody
    public Map<String,Object> selectByFy12(HttpSession session, @RequestParam(required=false,defaultValue="1") int page,
                                           @RequestParam(required=false) int limit) {
        // 使用Pagehelper传入当前页数和页面显示条数会自动为我们的select语句加上limit查询
        // 从他的下一条sql开始分页
        PageHelper.startPage(page, limit);
        List<name> users  = userService.getAllUser();// 这是我们的sql
        // 使用pageInfo包装查询
        PageInfo<name> rolePageInfo = new PageInfo<>(users);//
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",rolePageInfo.getTotal());
        map.put("data",rolePageInfo.getList());
        return map;
    }
    @RequestMapping("show")
    public ModelAndView ab(ModelAndView mode ){
        mode.setViewName("fye");
        return  mode;
    }

    @RequestMapping("showd")
    @ResponseBody
    public List<name> ab(  ){
        return  userService.getAllUser();
    }

}
