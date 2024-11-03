public class ItemNotFoundException extends Exception {
    @Override
    public String getLocalizedMessage() {
        return "Item not Found in inventory";
    }
}
