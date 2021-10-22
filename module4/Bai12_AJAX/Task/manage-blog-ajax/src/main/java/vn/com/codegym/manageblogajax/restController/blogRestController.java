package vn.com.codegym.manageblogajax.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import vn.com.codegym.manageblogajax.bean.Blog;
import vn.com.codegym.manageblogajax.service.BlogService;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class blogRestController {
    @Autowired
    BlogService blogService;

    @RequestMapping(value = "/loadmore",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Blog> getblogs(@RequestParam("exits") int id) {
        List<Blog> blogs = blogService.findTop1(id);
        return blogs;
    }
}
