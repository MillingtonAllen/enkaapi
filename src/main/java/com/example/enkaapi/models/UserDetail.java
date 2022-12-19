package com.example.enkaapi.models;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class UserDetail {
    @NotNull
    private PlayerInfo playerInfo;
    private List<AvatarInfo> avatarInfoList;
    private Integer ttl;
    private String uid;
}
