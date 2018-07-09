package com.kendo.admin.controller;

import com.kendo.admin.bean.DictEntity;
import com.kendo.admin.service.DictEntityService;
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
@RequestMapping("admin/dict")
public class DictEntityController {

    @Autowired
    private DictEntityService dictEntityService;

    @RequestMapping
    public String index() {
        return "admin/dict";
    }

    @GetMapping("/read")
    public @ResponseBody HashMap<String, Object> getDicts(Integer page, Integer pageSize) {
        return dictEntityService.findPage(page, pageSize);
    }

    @PostMapping("/create")
    public @ResponseBody HashMap<String, Object> createDict(@RequestBody DictEntity dictEntity) {
        HashMap<String, Object> resultMap = new HashMap<>();
        DictEntity entity = dictEntityService.add(dictEntity);
        entity.setCreateTime(new Date());
        List<DictEntity> items = new ArrayList<>();
        items.add(entity);
        resultMap.put("items", items);
        return resultMap;
    }

    @PutMapping("/update")
    public @ResponseBody HashMap<String, Object> updateDict(@RequestBody DictEntity dict) {
        HashMap<String, Object> resultMap = new HashMap<>();
        boolean flag = dictEntityService.update(dict);
        if (flag) {
            List<DictEntity> items = new ArrayList<>();
            items.add(dict);
            resultMap.put("items",items);
        } else {
            resultMap.put("error","更新失败");
        }
        return resultMap;
    }

    @DeleteMapping("/destroy")
    public void destroyDict(@RequestBody DictEntity dictEntity, HttpServletResponse response) {
        if (dictEntity.getId() == null) {
            throw new IllegalArgumentException("dict entity id is required");
        }
        dictEntityService.delete(dictEntity);
        response.setStatus(HttpStatus.NO_CONTENT.value());
    }
}
