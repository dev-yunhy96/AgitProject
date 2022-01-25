package com.ssafy.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTeam is a Querydsl query type for Team
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTeam extends EntityPathBase<Team> {

    private static final long serialVersionUID = 846499103L;

    public static final QTeam team = new QTeam("team");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final ListPath<Article, QArticle> articles = this.<Article, QArticle>createList("articles", Article.class, QArticle.class, PathInits.DIRECT2);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final ListPath<Image, QImage> images = this.<Image, QImage>createList("images", Image.class, QImage.class, PathInits.DIRECT2);

    public final StringPath teamBoss = createString("teamBoss");

    public final DateTimePath<java.time.LocalDateTime> teamCdate = createDateTime("teamCdate", java.time.LocalDateTime.class);

    public final StringPath teamDescription = createString("teamDescription");

    public final NumberPath<Integer> teamMember = createNumber("teamMember", Integer.class);

    public final StringPath teamName = createString("teamName");

    public final StringPath teamPassword = createString("teamPassword");

    public final StringPath teamPicture = createString("teamPicture");

    public QTeam(String variable) {
        super(Team.class, forVariable(variable));
    }

    public QTeam(Path<? extends Team> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTeam(PathMetadata metadata) {
        super(Team.class, metadata);
    }

}

