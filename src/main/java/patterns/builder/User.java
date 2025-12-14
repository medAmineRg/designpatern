package patterns.builder;

public class User {
    private String name;
    private int age;
    private String email;
    private boolean active;

    private User(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.email = builder.email;
        this.active = builder.active;
    }

    static class Builder {
        private String name;
        private int age;
        private String email;
        private boolean active;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder active(boolean active) {
            this.active = active;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    public static void main(String[] args) {
        User user = new User.Builder()
                .name("John Doe")
                .age(30)
                .email("rguig.medamine@gmail.com")
                .active(true)
                .build();
        System.out.println("User created: " + user.name + ", Age: " + user.age + ", Email: " + user.email + ", Active: "
                + user.active);
    }
}
