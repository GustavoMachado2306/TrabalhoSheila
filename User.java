import java.util.List;
import java.util.UUID;

public class User {
    private UUID id;
    private String nome;
    private List<NavigationEvent> navigationHistory;

    public User(UUID id, String nome, List<NavigationEvent> navigationHistory) {
        this.id = id;
        this.nome = nome;
        this.navigationHistory = navigationHistory;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public List<NavigationEvent> getNavigationHistory() { return navigationHistory; }
    public void setNavigationHistory(List<NavigationEvent> navigationHistory) {
        this.navigationHistory = navigationHistory;
    }
} 