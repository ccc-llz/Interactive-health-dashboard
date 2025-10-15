package com.cs79_1.interactive_dashboard.DTO.Avatar;

public class AvatarResponseDTO {
    private Long id;
    private String avatarUrl;

    public AvatarResponseDTO(Long id, String avatarUrl) {
        this.id = id;
        this.avatarUrl = avatarUrl;
    }

    public Long getId() {
        return id;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
