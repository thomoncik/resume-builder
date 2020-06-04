package com.github.thomoncik.resumebuilder.repository;

import com.github.thomoncik.resumebuilder.model.User;
import io.github.thomoncik.resumebuilder.jooq.tables.records.UserRecord;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

import static io.github.thomoncik.resumebuilder.jooq.tables.User.USER;

@Repository
@Transactional
public class JooqUserRepository implements UserRepository {
    private final DSLContext jooq;

    public JooqUserRepository(DSLContext dslContext) {
        this.jooq = dslContext;
    }

    @Override
    public User findByUsername(String username) {
        Set<UUID> roles = Set.of();
//                new HashSet<>(jooq
//                        .selectFrom(USER_ROLE.innerJoin(ROLE).on(USER_ROLE.ROLE_ID.eq(ROLE.ID)))
//                        .where(USER_ROLE.USER_ID.eq(UUID.randomUUID()))
//                        .fetch(ROLE.ID));

//        return null;
        UserRecord userRecord = jooq.selectFrom(USER).where(USER.USERNAME.eq(username)).fetchOneInto(UserRecord.class);
        System.out.println("Get " + username + " " + userRecord);
        return userRecord == null ? null : userFromRecord(userRecord, roles);
    }

    private static User userFromRecord(UserRecord record, Set<UUID> roles) {
        return new User(
                record.getId(),
                record.getUsername(),
                record.getFirstName(),
                record.getLastName(),
                record.getEmail(),
                record.getPassword(),
                roles
        );
    }

    @Transactional
    @Override
    public User save(User userEntry) {
        jooq.insertInto(USER)
                .set(createRecord(userEntry))
                .execute();
        return findByUsername(userEntry.getUsername());
    }

    private UserRecord createRecord(User userEntry) {
        UserRecord record = new UserRecord();
        record.setId(UUID.randomUUID());
        record.setUsername(userEntry.getUsername());
        record.setFirstName(userEntry.getFirstName());
        record.setLastName(userEntry.getLastName());
        record.setEmail(userEntry.getEmail());
        record.setPassword(userEntry.getPassword());
        return record;
    }
}
