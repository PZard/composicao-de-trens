package veiculo;
import java.util.ArrayList;

public class Trem {
    private int id;
    private ArrayList<Vagao> vagoes;
    private ArrayList<Locomotiva> locomotivas;
    private int maximaQtdVagoes;

    public Trem(int id, Locomotiva locomotiva){
        this.vagoes = new ArrayList<>();
        this.locomotivas = new ArrayList<>();
        this.id = id;
        this.engataLocomotiva(locomotiva);
    }

    public boolean engataVagao(Vagao vagao){
        if(this.maximaQtdVagoes <= this.vagoes.size() || this.getMaximaCapacidade() <= this.getCapacidadeAtual() + vagao.getMaximaCapacidade()){
            return false;
        }
        this.vagoes.add(vagao);
        return vagao.atrelaAoTrem(this);
    }

    public boolean engataLocomotiva(Locomotiva locomotiva){
        if(this.vagoes.size() > 0){
            return false;
        }
        this.locomotivas.add(locomotiva);
        this.setMaximaQtdVagoes();
        return locomotiva.atrelaAoTrem(this);
    }

    public Vagao desengataVagao(){
        if(this.vagoes.size() == 0){
            return null;
        }
        Vagao ultimoVagao = this.vagoes.remove(this.vagoes.size() - 1);
        ultimoVagao.desatrelaDoTrem();
        return ultimoVagao;
    }

    public Locomotiva desengataLocomotiva(){
        if(this.locomotivas.size() == 1){
            return null;
        }
        Locomotiva ultimaLocomotiva = this.locomotivas.remove(this.locomotivas.size() - 1);
        ultimaLocomotiva.desatrelaDoTrem();
        return ultimaLocomotiva;
    }

    public ParteTrem desengataUltimo(){
        if(this.vagoes.size() > 0){
            Vagao ultimoVagao = this.vagoes.remove(this.vagoes.size() - 1);
            ultimoVagao.desatrelaDoTrem();
            return ultimoVagao;
        }else if(this.locomotivas.size() > 1){
            Locomotiva ultimaLocomotiva = this.locomotivas.remove(this.locomotivas.size() - 1);
            ultimaLocomotiva.desatrelaDoTrem();
            return ultimaLocomotiva;
        }
        return null;
    }

    public int getId() {
        return this.id;
    }

    public int getQtdLocomotivas(){
        return this.locomotivas.size();
    }

    public int getQtdVagoes(){
        return this.vagoes.size();
    }

    public Vagao getVagao(int index){
        return this.vagoes.get(index);
    }

    public Locomotiva getLocomotiva(int index) {
        return this.locomotivas.get(index);
    }

    @Override
    public String toString() {
        String str = "ID: " + this.id + "; Nº de Vagões: " + this.getQtdVagoes() + "; Nº de Locomotivas: " + this.getQtdLocomotivas();
        return str;
    }

    private void setMaximaQtdVagoes(){
        int qtdVagoes = 0;
        for(Locomotiva locomotiva : this.locomotivas){
            qtdVagoes += locomotiva.getMaximaQtdVagoes();
        }
        this.maximaQtdVagoes = qtdVagoes - ((qtdVagoes / 10) * (this.locomotivas.size() - 1));
    }

    private double getMaximaCapacidade(){
        double peso = 0.0;
        for(Locomotiva locomotiva : this.locomotivas){
            peso += locomotiva.getMaximaCapacidade();
        }
        return peso;
    }

    private double getCapacidadeAtual(){
        double peso = 0.0;
        for(Vagao vagao : this.vagoes){
            peso += vagao.getMaximaCapacidade();
        }
        return peso;
    }
}
