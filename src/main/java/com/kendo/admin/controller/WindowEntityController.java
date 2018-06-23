package com.kendo.admin.controller;

import com.kendo.admin.bean.WindowEntity;
import com.kendo.admin.service.WindowEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author kendone
 */
@Controller
@RequestMapping("admin/window")
public class WindowEntityController  {

    @Autowired
    private WindowEntityService windowEntityService;

    @RequestMapping
    public String index() {
        return "admin/window";
    }


    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public @ResponseBody HashMap<String, Object> getWindows(@RequestParam("page") Integer page, @RequestParam("pageSize") Integer pageSize) {
        return windowEntityService.find(page,pageSize);
    }

    @RequestMapping("/treeview")
    public @ResponseBody List<WindowEntity> treeview(Long id) {
        return windowEntityService.findValidWindowByWindowId(id);
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public @ResponseBody HashMap<String,Object> createWindow(@RequestBody WindowEntity windowEntity){
        HashMap<String, Object> resultMap = new HashMap<>();
        WindowEntity entity = windowEntityService.add(windowEntity);
        List<WindowEntity> windowList = new ArrayList<>();
        entity.setCreateTime(new Date());
        windowList.add(entity);
        resultMap.put("items", windowList);
        return resultMap;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public @ResponseBody HashMap<String, Object> updateWindow(@RequestBody WindowEntity window) {
        HashMap<String, Object> resultMap = new HashMap<>();
        boolean flag = windowEntityService.update(window);
        if (flag) {
            List<WindowEntity> items = new ArrayList<>();
            items.add(window);
            resultMap.put("items", items);
        } else {
            resultMap.put("error", "更新失败");
        }
        return resultMap;
    }

    @RequestMapping(value = "/destroy", method = RequestMethod.DELETE)
    public void deleteWindow(@RequestBody WindowEntity windowEntity,HttpServletResponse response) {
        if (windowEntity.getId() == null) {
            throw new IllegalArgumentException("window id is required");
        }
        windowEntityService.delete(windowEntity);
        response.setStatus(HttpStatus.NO_CONTENT.value());
    }
}