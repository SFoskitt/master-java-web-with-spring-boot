package net.stephanietech.module_8_rest_api.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    private UserDaoService service;

    public UserResource(UserDaoService service){
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }

    @GetMapping("/users/{userId}")
    public User retriveOneUser(@PathVariable Integer userId){
        User user = service.findOne(userId);

        if (user == null)
            throw new UserNotFoundException("userId: " + userId);

        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User newUser = service.addOne(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{userId}")
                .buildAndExpand(newUser.getUserId())
                .toUri();
        return ResponseEntity.created(location).build();  // adds response code 201 for "created"
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable Integer userId){
        service.deleteUserById(userId);
    }
}
