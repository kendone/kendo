package com.kendo.admin.controller;

import com.kendo.admin.bean.PostEntity;
import com.kendo.admin.service.PostEntityService;
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
@RequestMapping("/admin/post")
public class PostEntityController {

    @Autowired
    private PostEntityService postEntityService;

    @RequestMapping
    public String index() {
        return "admin/post";
    }

    @GetMapping("/read")
    public @ResponseBody HashMap<String, Object> findAllPosts(
            @RequestParam("page") Integer page,
            @RequestParam("pageSize") Integer pageSize) {

        return postEntityService.findAll(page, pageSize);
    }

    @PostMapping("/create")
    public @ResponseBody HashMap<String, Object> createPost(@RequestBody PostEntity entity) {
        HashMap<String, Object> resultMap = new HashMap<>();
        PostEntity newEntity = postEntityService.add(entity);
        newEntity.setCreateTime(new Date());
        List<PostEntity> items = new ArrayList<>();
        items.add(newEntity);
        resultMap.put("items", items);
        return resultMap;
    }

    @PutMapping("/update")
    public @ResponseBody HashMap<String, Object> updatePost(@RequestBody PostEntity post) {
        HashMap<String, Object> resultMap = new HashMap<>();
        boolean updated = postEntityService.update(post);
        if (updated) {
            List<PostEntity> items = new ArrayList<>();
            items.add(post);
            resultMap.put("items", items);
        } else {
            resultMap.put("error", "error");
        }
        return resultMap;
    }

    @DeleteMapping("/destroy")
    public void destroyPost(@RequestBody PostEntity entity, HttpServletResponse response) {
        postEntityService.delete(entity);
        response.setStatus(HttpStatus.NO_CONTENT.value());
    }
}
