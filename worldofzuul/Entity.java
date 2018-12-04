package worldofzuul;

// All items, players and NPC's derive from this entity class.
public class Entity {

    private String name;
    private String description;
    private int entityID;

    public Entity() {

    }

    public Entity(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setEntityID(int entityID) {
        this.entityID = entityID;
    }

    public int getEntityID() {
        return this.entityID;
    }

}
