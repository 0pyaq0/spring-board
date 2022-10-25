package com.example.board.entitiy;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //columnDefinition = "varchar2(15 char)" 써보기
    @Column(nullable = false, length = 15, unique = true)
    private String username;

    @Column(length = 60)
    private String password;

    @Column(nullable = false, length = 15, unique = true)
    private String nickname;

    @Column(nullable = false, length = 64, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

}
