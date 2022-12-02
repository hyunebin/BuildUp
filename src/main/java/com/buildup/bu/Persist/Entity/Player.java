package com.buildup.bu.Persist.Entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Player extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String email;
    String teamName;
    @NotNull
    Integer height;
    @NotNull
    Integer weight;
    String sex;
    String mainPosition;
    String subPosition;

    @NotNull
    Integer shoot;
    @NotNull
    Integer speed;
    @NotNull
    Integer physical;
    @NotNull
    Integer pass;
    @NotNull
    Integer dribble;
    @NotNull
    Integer defend;
    String nickname;





}
