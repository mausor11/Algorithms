package HashTables;

import HashTables.services.Element;

public class DirectAddressTable {
    public Element direct_address_search(Element[] T, int key) {
        return T[key];
    }
    public void direct_address_insert(Element[] T, Element element) {
        T[element.key] = element;
    }
    public void direct_address_delete(Element[] T, Element element) {
        T[element.key] = null;
    }
}
