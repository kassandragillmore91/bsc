package com.bloomshoppingcomplex.Models.Request;

import java.util.Objects;

public class UpdateAccountRequest {
    private String userId;
    private String name;
    private String email;

    public UpdateAccountRequest() {}

    public UpdateAccountRequest(String userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    public UpdateAccountRequest(Builder builder) {
        this.userId = builder.userId;
        this.name = builder.name;
        this.email = builder.email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateAccountRequest that = (UpdateAccountRequest) o;
        return Objects.equals(getUserId(), that.getUserId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getEmail(), that.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getName(), getEmail());
    }

    @Override
    public String toString() {
        return "UpdateAccountRequest{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String userId;
        private String name;
        private String email;

        private Builder() {}

        public Builder withUserId(String userIdToUse) {
            this.userId = userIdToUse;
            return this;
        }

        public Builder withName(String nameToUse) {
            this.name = nameToUse;
            return this;
        }

        public Builder withEmail(String emailToUse) {
            this.email = emailToUse;
            return this;
        }

        public UpdateAccountRequest build() {
            return new UpdateAccountRequest(this);
        }
    }
}