package AuctionAPI.controller;

import AuctionAPI.dto.UserDto;
import AuctionAPI.model.AuctionModel;
import AuctionAPI.model.UserModel;
import AuctionAPI.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("")
    public ResponseEntity<UserModel> save(@RequestBody UserDto user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    @DeleteMapping("")
    public ResponseEntity<Void> delete(@RequestParam UUID id) {
        userService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserModel>> listAll() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.listAll());
    }
}
