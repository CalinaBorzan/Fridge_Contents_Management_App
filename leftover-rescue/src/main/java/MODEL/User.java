package MODEL;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_table") // Specify the table name in the database
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Corresponds to the 'id' column in the table

    @Column(nullable = false, length = 255)
    private String username; // Corresponds to the 'username' column in the table

    @Column(nullable = false, length = 255)
    private String password; // Corresponds to the 'password' column in the table

    @Column(nullable = false, length = 255)
    private String email; // Corresponds to the 'email' column in the table

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt; // Corresponds to the 'created_at' column in the table

    // Constructors
    public User() {
        // Default constructor
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.createdAt = LocalDateTime.now(); // Automatically set the creation time
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
