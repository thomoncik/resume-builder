package com.github.thomoncik.resumebuilder.repository;

import com.github.thomoncik.resumebuilder.model.User;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import static io.github.thomoncik.resumebuilder.jooq.tables.User.USER;

@Repository
@Transactional
public class JooqUserRepository implements UserRepository {
    private final DSLContext jooq;

    public JooqUserRepository(DSLContext dslContext) {
        this.jooq = dslContext;
    }

    @Override
    public User getUserByEmail(String email) {
        return jooq.selectFrom(USER).where(USER.EMAIL_NAME.eq(email)).fetchOne().map(r -> new User());
    }
}
