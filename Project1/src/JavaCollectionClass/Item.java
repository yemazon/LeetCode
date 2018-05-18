package JavaCollectionClass;

public class Item {
    public String value;

    public Item(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Item item = (Item) obj;

        return value == null ? item.value == null : value.equals(item.value);
    }

    @Override public int hashCode() {
        return value == null ? 0 : value.hashCode();
    }
}
