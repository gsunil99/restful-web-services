package com.in28minutes.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserResource {
    @Autowired
    private UserDaoService userDaoService;

    @GetMapping(path="/users")
     public List<User> retriveAllUsers(){

            return userDaoService.findAll();
     }

    @GetMapping(path="/users/{id}")
    public EntityModel<User> retriveAllUserById(@PathVariable int id){

        User user = userDaoService.findOne(id);
        if(user==null)
            throw new UserNotFoundException("id "+id);
        EntityModel<User> model = EntityModel.of(user);

        WebMvcLinkBuilder linkToUsers = linkTo(methodOn(this.getClass()).retriveAllUsers());
        model.add(linkToUsers.withRel("all-users"));
        return model;
    }

    @DeleteMapping(path="/users/{id}")
    public void deleteUser(@PathVariable int id){

        User user = userDaoService.deleteById(id);
        if(user==null)
            throw new UserNotFoundException("id "+id);
    }
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        User savedUser =userDaoService.save(user);
        URI location =ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
