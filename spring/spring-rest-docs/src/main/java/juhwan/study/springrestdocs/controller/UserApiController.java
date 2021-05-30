package juhwan.study.springrestdocs.controller;

import juhwan.study.springrestdocs.model.Header;
import juhwan.study.springrestdocs.model.User;
import juhwan.study.springrestdocs.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    @PostMapping("")
    public Header<User> create(@RequestBody User requestUser){
        User user = userService.create(requestUser);
        if(user != null){
            return Header.OK(user);
        }
        return Header.ERROR();
    }

    @GetMapping("/{id}")
    public Header<User> read(@PathVariable(name = "id") Long id){
        User user = userService.read(id);
        if(user != null){
            return Header.OK(user);
        }
        return Header.ERROR();
    }

    @PutMapping("")
    public Header<User> update(@RequestBody User requestUser){
        User user = userService.update(requestUser);
        if(user != null){
            return Header.OK(user);
        }
        return Header.ERROR();
    }

    @DeleteMapping("/{id}")
    public Header<User> delete(@PathVariable(name = "id") Long id){
        boolean isDelete = userService.delete(id);
        if(isDelete){
            return Header.OK();
        }
        return Header.ERROR();
    }
}
