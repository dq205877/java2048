public class Tile {
    int id;

    public Tile(int id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    void merge(Tile tile) {
        if (id == 0 && tile.id > 0) {
            this.id = tile.id;
            tile.id = 0;
        } else if (this.id > 0 && this.id == tile.id) {
            this.id *= 2;
            tile.id = 0;
        }
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
