package com.example.enkaapi;

import com.example.enkaapi.models.UserDetail;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class EnkaController {

    @PostMapping("/resolve/enka/{locale}")
    public ResponseEntity<UserDetail> resolveUserDetail(@Valid @RequestBody UserDetail userDetail, BindingResult bindingResult, @PathVariable String locale) {
        if (!bindingResult.getAllErrors().isEmpty()) {
            log.error("Validation Error path={} errors={}", "/resolve/enka/" + locale, bindingResult.getAllErrors().toString());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userDetail, HttpStatus.OK);
    }
}
