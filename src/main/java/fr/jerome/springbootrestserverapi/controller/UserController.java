package fr.jerome.springbootrestserverapi.controller;

import fr.jerome.springbootrestserverapi.model.User;
import fr.jerome.springbootrestserverapi.service.RoleService;
import fr.jerome.springbootrestserverapi.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
/*
Annotation @CrossOrigin
permet de favoriser une communication distante entre le client et le serveur, quand le serveur et le client sont
déployés sur deux serveurs distincts, permet d'éviter les problèmes de réseau
 */
@RequestMapping("/user/*")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    /*
    Adresse: http://localhost:8080/user/users
     */
    @GetMapping(value = "/users")
    public ResponseEntity<Collection<User>> getAllUsers(){
        Collection<User> users = userService.getAllUsers();
        logger.info("liste des utilisateurs : " + users.toString());
        return new ResponseEntity<>(users, HttpStatus.FOUND);
    }
}
