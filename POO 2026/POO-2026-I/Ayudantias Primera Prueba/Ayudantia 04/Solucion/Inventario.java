public class Inventario {
	
	private Item[] slots;
    
    public Inventario(){
        slots = new Item[36];
    }
    
    public void mostrarInventario(){
        for(int i = 0; i < slots.length; i++) {
            if(slots[i] != null){
                System.out.println("Slot " + i + ": " + slots[i]);
            }else{
                System.out.println("Slot " + i + ": vacío");
            }
        }
    }

    public void agregarItem(Item item){
        for(int i = 0; i < slots.length; i++){
            if(slots[i] == null){
                slots[i] = item;
                return;
            }
        }
        
        System.out.println("Inventario lleno.");
    }
    
    public Item getItem(int slot){
        return slots[slot];
    }

    public void eliminarItem(int slot){
        slots[slot] = null;
    }

}
