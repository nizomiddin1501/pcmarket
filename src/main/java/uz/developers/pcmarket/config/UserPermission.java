package uz.developers.pcmarket.config;

public enum UserPermission {


    ATTACHMENT_READ_ALL("attachment:readAll"),
    ATTACHMENT_READ_ONE("attachment:readOne"),
    ATTACHMENT_ADD("attachment:add"),
    ATTACHMENT_EDIT("attachment:edit"),
    ATTACHMENT_DELETE("attachment:delete"),

    CATEGORY_READ_ALL("category:readAll"),
    CATEGORY_READ_ONE("category:readOne"),
    CATEGORY_ADD("category:add"),
    CATEGORY_EDIT("category:edit"),
    CATEGORY_DELETE("category:delete"),

    PRODUCT_READ_ALL("product:readAll"),
    PRODUCT_READ_ONE("product:readOne"),
    PRODUCT_ADD("product:add"),
    PRODUCT_EDIT("product:edit"),
    PRODUCT_DELETE("product:delete"),

    TEST_READ_ALL("test:readAll"),
    TEST_READ_ONE("test:readOne"),
    TEST_ADD("test:add"),
    TEST_EDIT("test:edit"),
    TEST_DELETE("test:delete"),

    USER_READ_ALL("user:readAll"),
    USER_READ_ONE("user:readOne"),
    USER_ADD("user:add"),
    USER_EDIT("user:edit"),
    USER_DELETE("user:delete");


    private final String permission;

    UserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
