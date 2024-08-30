package com.tinqinacademy.bff.api.mapping;

public class URLMapping {
    //hotel
    public static final String CHECK_ROOM_AVAILABILITY = "/api/hotel/rooms";
    public static final String GET_ROOM_BY_ID = "/api/hotel/{roomId}";
    public static final String UNBOOK_ROOM_BY_ID = "/api/hotel/{bookingId}";
    public static final String SYSTEM_ROOM_BY_ID = "/system/room/{roomId}";
    public static final String REGISTER = "/system/register";
    public static final String POST_ROOM = "/system/room";

    //comment
    private static final String repeatedPart = "comment";
    public static final String EDIT_A_COMMENT = "/hotel/"+repeatedPart+"/{commentId}";
    public static final String DELETE_A_COMMENT = "/system/"+repeatedPart+"/{commentId}";
    public static final String EDIT_A_COMMENT_BY_ADMIN = "/system/"+repeatedPart+"/{commentId}";
    public static final String LEAVE_A_COMMENT = "/hotel/{roomId}/"+repeatedPart+"";
    public static final String GET_ALL_COMMENTS = "/hotel/{roomId}/"+repeatedPart+"";
}
