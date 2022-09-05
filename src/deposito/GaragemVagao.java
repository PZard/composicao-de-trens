package deposito;

import java.util.ArrayList;
import veiculo.Vagao;

public class GaragemVagao{
    private ArrayList<Vagao> vagoes;

    public GaragemVagao(){
        this.vagoes = new ArrayList<>();
    }

    public void adicionaVagao(int id, double maximaCapacidade){
        this.vagoes.add(new Vagao(id, maximaCapacidade));
    }

    public void adicionaVagao(Vagao vagao){
        this.vagoes.add(vagao);
    }

    public Vagao removeVagao(){
        int lastIndex = this.vagoes.size() - 1;
        Vagao locomotiva = this.vagoes.get(lastIndex);
        this.vagoes.remove(lastIndex);
        return locomotiva;
    }

    public ArrayList<String> listaVagoes(){
        ArrayList<String> vagoesString = new ArrayList<>();
        for (Vagao vagao : this.vagoes) {
            vagoesString.add(vagao.toString());
        }
        return vagoesString;
    }
}
