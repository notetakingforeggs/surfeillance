//package com.northcoders.surfeillance.model;
//
//
//import java.util.Collection;
//import java.util.List;
//
//public class UserModel implements Authentication {
//
//    private UserRecord userRecord;
//
//    public UserModel(UserRecord userRecord) {
//        this.userRecord = userRecord;
//
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return List.of();
//    }
//
//    @Override
//    public Object getCredentials() {
//        return null;
//    }
//
//    @Override
//    public Object getDetails() {
//        return null;
//    }
//
//    @Override
//    public Object getPrincipal() {
//        return null;
//    }
//
//    @Override
//    public boolean isAuthenticated() {
//        return false;
//    }
//
//    @Override
//    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
//
//    }
//
//    @Override
//    public String getName() {
//        return userRecord.getDisplayName();
//    }
//}
