package deposito;

import java.util.ArrayList;

import veiculo.Locomotiva;
import veiculo.Trem;

public class PatioTrem{
    private ArrayList<Trem> trens;

    public PatioTrem(){
        this.trens = new ArrayList<>();
    }

    public Trem encontraTrem(int id){
        for (Trem trem : trens) {
            if(trem.getId() != id){
                continue;
            }
            return trem;
        }
        return null;
    }

    public void adicionaTrem(Trem trem){
        this.trens.add(trem);
    }

    public void adicionaTrem(int id, Locomotiva locomotiva){
        if(locomotiva == null || id < 0){
            return;
        }
        Trem trem = new Trem(id, locomotiva);
        this.trens.add(trem);
    }

    public Trem removeTrem(int id){
        Trem trem = this.encontraTrem(id);
        this.trens.remove(trem);
        return trem;
    }

    public ArrayList<Trem> listaTrens(){
        return this.trens;
    }
}