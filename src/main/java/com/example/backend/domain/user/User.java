package com.example.backend.domain.user;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long socialId;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    private String name;

    public User(final Long socialId, final SocialType socialType, final String name) {
        this.socialId = socialId;
        this.socialType = socialType;
        this.name = name;
    }

    public static User of(final Long socialId, final SocialType socialType, final String name) {
        return new User(socialId, socialType, name);
    }
}
