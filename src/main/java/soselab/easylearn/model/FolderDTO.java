package soselab.easylearn.model;

import java.util.List;

/**
 * Created by bernie on 12/7/16.
 */
public class FolderDTO {
    private String id;
    private String name;
    private List<String> pack;

    public FolderDTO(String id, String name, List<String> pack) {
        this.id = id;
        this.name = name;
        this.pack = pack;
    }

    public FolderDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPack() {
        return pack;
    }

    public void setPack(List<String> pack) {
        this.pack = pack;
    }

    @Override
    public String toString() {
        return "FolderDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pack=" + pack +
                '}';
    }
}
