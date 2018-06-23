package com.kendo.admin.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kendo.admin.bean.ButtonEntity;
import com.kendo.admin.service.ButtonEntityService;
import com.kendo.api.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kendone
 */
@Controller
@RequestMapping("admin/button")
public class ButtonEntityController {

    @Autowired
    private ButtonEntityService buttonEntityService;
    @Autowired
    private ApiService apiService;
    @Autowired
    private ObjectMapper mapper;

    @RequestMapping
    public ModelAndView index() throws JsonProcessingException {
        ModelAndView mav = new ModelAndView();
        mav.addObject("yesNo", mapper.writeValueAsString(apiService.findValidDictByType("YES_NO")));
        mav.addObject("showHide", mapper.writeValueAsString(apiService.findValidDictByType("SHOW_HIDE")));
        mav.setViewName("admin/button");
        return mav;
    }

    @RequestMapping(value = "read", method = RequestMethod.GET, produces = {"application/json"})
    public @ResponseBody Map<String, Object> getButtonsForWindow(@RequestParam("windowId") Long windowId) {
        if (windowId == null) {
            throw new IllegalArgumentException("window id cannot be null");
        }
        return buttonEntityService.findButtonByWindowId(windowId);
    }

    @RequestMapping(value = "create", method = RequestMethod.POST, produces = {"application/json"})
    public @ResponseBody HashMap<String, Object> createButton(@RequestBody ButtonEntity buttonEntity) {
        HashMap<String, Object> resultMap = new HashMap<>();
        ButtonEntity entity = buttonEntityService.add(buttonEntity);
        List<ButtonEntity> buttonList = new ArrayList<>();
        buttonList.add(entity);
        resultMap.put("items", buttonList);
        return resultMap;
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT, produces = {"application/json"})
    public @ResponseBody HashMap<String, Object> updateButton(@RequestBody ButtonEntity button) {
        HashMap<String, Object> resultMap = new HashMap<>();
        boolean flag = buttonEntityService.update(button);
        if (flag) {
            List<ButtonEntity> items = new ArrayList<>();
            items.add(button);
            resultMap.put("items", items);
        } else {
            resultMap.put("error", "更新失败");
        }
        return resultMap;
    }

    @RequestMapping(value = "destroy", method = RequestMethod.DELETE)
    public void deleteButton(@RequestBody ButtonEntity buttonEntity,HttpServletResponse response) {
        if (buttonEntity.getId() == null) {
            throw new IllegalArgumentException("button id is required");
        }
        buttonEntityService.delete(buttonEntity);
        response.setStatus(HttpStatus.NO_CONTENT.value());
    }
}
