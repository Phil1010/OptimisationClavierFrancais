package src;

import java.util.ArrayList;

public class ListeDispositionClavier {

    private final ArrayList<DispositionClavier> dispositions;

    public ListeDispositionClavier() {
        this.dispositions = new ArrayList<>();
    }


    public void ajouter(DispositionClavier dc){
        this.dispositions.add(dc);
    }

    public void supprimer(DispositionClavier dc){
        this.dispositions.remove(dc);
    }

    public ArrayList<DispositionClavier> getListe() {
        return this.dispositions;
    }

}
