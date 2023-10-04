package AuctionAPI.controller;

import AuctionAPI.dto.UserDto;
import AuctionAPI.model.UserModel;
import AuctionAPI.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("")
    public ResponseEntity<UserModel> save(@RequestBody UserDto user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserModel>> listAll() {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.listAll());
    }
}
