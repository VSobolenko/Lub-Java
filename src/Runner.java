import by.gsu.asoilab.*;

public class Runner {
    public static void main(String args[]){
        Material steel = new Material("steel", 7.7f);
        Subject wire = new Subject("wire",steel, 0.03f);
        System.out.println(wire.toString());

        wire.setMaterial(new Material("copper", 8.5f));
        System.out.println(wire.getMass());

        wire.setMaterial(steel);
        System.out.println(wire.toString());
    }
}
