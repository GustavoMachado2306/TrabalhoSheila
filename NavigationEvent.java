import java.util.Date;
import java.util.UUID;

public class NavigationEvent {
    private UUID id;
    private UUID userId;
    private UUID productId;
    private Date accessDate;

    public NavigationEvent(UUID id, UUID userId, UUID productId, Date accessDate) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.accessDate = accessDate;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public UUID getUserId() { return userId; }
    public void setUserId(UUID userId) { this.userId = userId; }

    public UUID getProductId() { return productId; }
    public void setProductId(UUID productId) { this.productId = productId; }

    public Date getAccessDate() { return accessDate; }
    public void setAccessDate(Date accessDate) { this.accessDate = accessDate; }
} 