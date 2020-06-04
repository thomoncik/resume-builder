/*
 * This file is generated by jOOQ.
 */
package io.github.thomoncik.resumebuilder.jooq.tables.records;


import io.github.thomoncik.resumebuilder.jooq.tables.UserRole;

import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserRoleRecord extends UpdatableRecordImpl<UserRoleRecord> implements Record2<UUID, UUID> {

    private static final long serialVersionUID = 1379204368;

    /**
     * Setter for <code>RESUME_BUILDER.USER_ROLE.USER_ID</code>.
     */
    public void setUserId(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>RESUME_BUILDER.USER_ROLE.USER_ID</code>.
     */
    public UUID getUserId() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>RESUME_BUILDER.USER_ROLE.ROLE_ID</code>.
     */
    public void setRoleId(UUID value) {
        set(1, value);
    }

    /**
     * Getter for <code>RESUME_BUILDER.USER_ROLE.ROLE_ID</code>.
     */
    public UUID getRoleId() {
        return (UUID) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record2<UUID, UUID> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<UUID, UUID> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<UUID, UUID> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return UserRole.USER_ROLE.USER_ID;
    }

    @Override
    public Field<UUID> field2() {
        return UserRole.USER_ROLE.ROLE_ID;
    }

    @Override
    public UUID component1() {
        return getUserId();
    }

    @Override
    public UUID component2() {
        return getRoleId();
    }

    @Override
    public UUID value1() {
        return getUserId();
    }

    @Override
    public UUID value2() {
        return getRoleId();
    }

    @Override
    public UserRoleRecord value1(UUID value) {
        setUserId(value);
        return this;
    }

    @Override
    public UserRoleRecord value2(UUID value) {
        setRoleId(value);
        return this;
    }

    @Override
    public UserRoleRecord values(UUID value1, UUID value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UserRoleRecord
     */
    public UserRoleRecord() {
        super(UserRole.USER_ROLE);
    }

    /**
     * Create a detached, initialised UserRoleRecord
     */
    public UserRoleRecord(UUID userId, UUID roleId) {
        super(UserRole.USER_ROLE);

        set(0, userId);
        set(1, roleId);
    }
}