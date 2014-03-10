package com.cbaeza.api.client;

/**
 * User: cbaeza
 * Since: 10.03.14
 */
public class Endpoints {

    public static String HOST = "http://localhost:8181";
    public static String APP = "/server-api/rest";

    public static String USERS = "/users/";
    public static String USER_AUTHENTICATE = "/users/authenticate/%s/%s";
    public static String USER_CREATE = "/users/create/%d/%d/%d";
    public static String USER_GET_INFORMATION = "/users/user/%d";

    public static String WISHLIST_GET_WISHLIST_BY_USER = "/wishlist/%d/%d";
}
