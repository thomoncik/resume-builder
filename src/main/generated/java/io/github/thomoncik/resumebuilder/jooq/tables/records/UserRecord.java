/*
 * This file is generated by jOOQ.
 */
package io.github.thomoncik.resumebuilder.jooq.tables.records;


import io.github.thomoncik.resumebuilder.jooq.tables.User;

import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserRecord extends TableRecordImpl<UserRecord> implements Record3<UUID, String, String> {

    private static final long serialVersionUID = -1125001351;

    /**
     * Setter for <code>RESUME_BUILDER.USER.ID</code>.
     */
    public void setId(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>RESUME_BUILDER.USER.ID</code>.
     */
    public UUID getId() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>RESUME_BUILDER.USER.USERNAME</code>.
     */
    public void setUsername(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>RESUME_BUILDER.USER.USERNAME</code>.
     */
    public String getUsername() {
        return (String) get(1);
    }

    /**
     * Setter for <code>RESUME_BUILDER.USER.PASSWORD</code>.
     */
    public void setPassword(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>RESUME_BUILDER.USER.PASSWORD</code>.
     */
    public String getPassword() {
        return (String) get(2);
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<UUID, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<UUID, String, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return User.USER.ID;
    }

    @Override
    public Field<String> field2() {
        return User.USER.USERNAME;
    }

    @Override
    public Field<String> field3() {
        return User.USER.PASSWORD;
    }

    @Override
    public UUID component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getUsername();
    }

    @Override
    public String component3() {
        return getPassword();
    }

    @Override
    public UUID value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getUsername();
    }

    @Override
    public String value3() {
        return getPassword();
    }

    @Override
    public UserRecord value1(UUID value) {
        setId(value);
        return this;
    }

    @Override
    public UserRecord value2(String value) {
        setUsername(value);
        return this;
    }

    @Override
    public UserRecord value3(String value) {
        setPassword(value);
        return this;
    }

    @Override
    public UserRecord values(UUID value1, String value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UserRecord
     */
    public UserRecord() {
        super(User.USER);
    }

    /**
     * Create a detached, initialised UserRecord
     */
    public UserRecord(UUID id, String username, String password) {
        super(User.USER);

        set(0, id);
        set(1, username);
        set(2, password);
    }
}