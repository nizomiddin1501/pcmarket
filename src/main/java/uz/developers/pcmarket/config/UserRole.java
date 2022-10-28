package uz.developers.pcmarket.config;

import com.google.common.collect.Sets;

import java.util.Set;

import static uz.developers.pcmarket.config.UserPermission.*;

public enum UserRole {

    OPERATOR(Sets.newHashSet(TEST_ADD,  ATTACHMENT_READ_ALL,ATTACHMENT_READ_ONE,ATTACHMENT_ADD,
            CATEGORY_READ_ALL,CATEGORY_READ_ONE,CATEGORY_ADD,
            PRODUCT_READ_ALL,PRODUCT_READ_ONE,PRODUCT_ADD,
            TEST_READ_ALL,TEST_READ_ONE,
            USER_READ_ALL,USER_READ_ONE,USER_ADD)),

    MODERATOR(Sets.newHashSet(ATTACHMENT_READ_ALL,ATTACHMENT_READ_ONE,ATTACHMENT_ADD,ATTACHMENT_EDIT,
            CATEGORY_READ_ALL,CATEGORY_READ_ONE,CATEGORY_ADD,CATEGORY_EDIT,
            PRODUCT_READ_ALL,PRODUCT_READ_ONE,PRODUCT_ADD,PRODUCT_EDIT,
            TEST_READ_ALL,TEST_READ_ONE,TEST_ADD,TEST_EDIT,
            USER_READ_ALL,USER_READ_ONE,USER_ADD,USER_EDIT)),

    SUPER_ADMIN(Sets.newHashSet(ATTACHMENT_READ_ALL,ATTACHMENT_READ_ONE,ATTACHMENT_ADD,ATTACHMENT_EDIT,ATTACHMENT_DELETE,
            CATEGORY_READ_ALL,CATEGORY_READ_ONE,CATEGORY_ADD,CATEGORY_EDIT,CATEGORY_DELETE,
            PRODUCT_READ_ALL,PRODUCT_READ_ONE,PRODUCT_ADD,PRODUCT_EDIT,PRODUCT_DELETE,
            TEST_READ_ALL,TEST_READ_ONE,TEST_ADD,TEST_EDIT,TEST_DELETE,
            USER_READ_ALL,USER_READ_ONE,USER_ADD,USER_EDIT,USER_DELETE));

    private final Set<UserPermission> permissions;

    UserRole(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermission> getPermissions() {
        return permissions;
    }
}
