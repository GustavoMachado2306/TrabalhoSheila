import java.util.UUID;

public class Product {
    private UUID id;
    private String nome;
    private String category;
    private double rating;

    public Product(UUID id, String nome, String category, double rating) {
        this.id = id;
        this.nome = nome;
        this.category = category;
        this.rating = rating;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }
} 