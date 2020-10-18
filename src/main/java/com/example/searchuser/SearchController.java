package com.example.searchuser;

import com.example.searchuser.Model.Nyhed;
import com.example.searchuser.Model.User;
import com.example.searchuser.service.Nyheder;
import com.example.searchuser.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {
    private UserService userService = new UserService();

    @PostMapping("api/search")
    public ResponseEntity<Result> getSearchResult(@RequestBody AJAXrequest req){
        System.out.println("api/search kaldet med " + req.username);
        Result result = new Result();
        userService.addUser(req.username);

        List<User> usersFound = userService.findUsers(req.username);
        result.setUserList(usersFound);
        result.setMessage("antal brugere fundet: " + usersFound.size());
        return ResponseEntity.ok(result);
    }


    @PostMapping("api/opretuser")
    public ResponseEntity<User> opretUser(@RequestBody User user){// tilføj parameter
        System.out.println("api/user kaldet med1 " );
        userService.addUser(user.username);

        return ResponseEntity.ok(user);
    }

}