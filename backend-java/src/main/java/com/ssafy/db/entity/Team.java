package com.ssafy.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "team", uniqueConstraints = {@UniqueConstraint(
        name = "TEAM_ID_UNIQUE", columnNames = {"teamName"}
)})
@EntityListeners(AuditingEntityListener.class)
@DynamicUpdate
public class Team extends BaseEntity{
    @Column(columnDefinition="varchar(100)")
    String teamName; //팀명
    String teamPassword; //인증코드
    @CreatedDate
    LocalDateTime teamCdate; //생성일
    String teamDescription; //한줄소개
    String teamPicture; // 팀 썸네일
    int teamMember; //인원수
    String teamBoss; //팀장 이름

    public Team(){}

    @OneToMany(mappedBy = "team")
    private List<Article> articles = new ArrayList<>();

    // 관계 메서드
    private void addArticle(Article article){
        this.articles.add(article);
        // 현재 article의 team FK 값이 this가 아니면 다시 세팅
        if (article.getTeam() != this) {
            article.setTeam(this);
        }
    }


    @Builder
    public Team(Long id, String teamName, String teamPassword, String teamDescription, String teamPicture, int teamMember, String teamBoss){
        this.id = id;
        this.teamName = teamName;
        this.teamPassword = teamPassword;
        this.teamDescription = teamDescription;
        this.teamPicture = teamPicture;
        this.teamMember = teamMember;
        this.teamBoss = teamBoss;
    }

}