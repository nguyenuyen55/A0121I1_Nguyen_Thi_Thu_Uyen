package codegym.restController;

import codegym.bean.Blog;
import codegym.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Transactional
@RequestMapping("/api/blog")
public class BlogRestController {
    @Autowired
    BlogRepository blogRepository;
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Blog>> getList(){
        List<Blog> blogs = new ArrayList<>();
        blogRepository.findAll().forEach(blogs::add);
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
}
