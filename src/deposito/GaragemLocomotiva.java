package deposito;

import java.util.ArrayList;
import veiculo.Locomotiva;

public class GaragemLocomotiva{
    private ArrayList<Locomotiva> locomotivas;

    public GaragemLocomotiva(){
        this.locomotivas = new ArrayList<>();
    }

    public void adicionaLocomotiva(int id, double maximaCapacidade, int maximaQtdVagoes){
        this.locomotivas.add(new Locomotiva(id, maximaCapacidade, maximaQtdVagoes));
    }

    public void adicionaLocomotiva(Locomotiva locomotiva){
        this.locomotivas.add(locomotiva);
    }

    public Locomotiva removeLocomotiva(){
        int lastIndex = this.locomotivas.size() - 1;
        Locomotiva locomotiva = this.locomotivas.get(lastIndex);
        this.locomotivas.remove(lastIndex);
        return locomotiva;
    }

    public ArrayList<String> listaLocomotivas(){
        ArrayList<String> locomotivasString = new ArrayList<>();
        for (Locomotiva locomotiva : this.locomotivas) {
            locomotivasString.add(locomotiva.toString());
        }
        return locomotivasString;
    }
}
