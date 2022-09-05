package veiculo;
public class Locomotiva implements ParteTrem{
    private int id;
    private double maximaCapacidade;
    private int maximaQtdVagoes;
    private Trem tremAtual;

    public Locomotiva(int id, double maximaCapacidade, int maximaQtdVagoes){
        this.id = id;
        this.maximaCapacidade = maximaCapacidade;
        this.maximaQtdVagoes = maximaQtdVagoes;
        this.tremAtual = null;
    }

    public boolean atrelaAoTrem(Trem trem){
        if(this.tremAtual != null){
            return false;
        }
        this.tremAtual = trem;
        return true;
    }

    public void desatrelaDoTrem(){
        this.tremAtual = null;
    }

    public int getId() {
        return this.id;
    }

    public double getMaximaCapacidade() {
        return this.maximaCapacidade;
    }

    public int getMaximaQtdVagoes() {
        return this.maximaQtdVagoes;
    }

    @Override
    public String toString() {
        String str = "ID: " + this.id + "; Trem atual: ";
        if(this.tremAtual == null){
            str += "nenhum";
        }else{
            str += this.tremAtual.getId();
        }
        return str;
    }
}
